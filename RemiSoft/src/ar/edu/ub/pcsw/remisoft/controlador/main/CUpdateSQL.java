package ar.edu.ub.pcsw.remisoft.controlador.main;

import ar.edu.ub.pcsw.remisoft.modelo.interfaces.ITemporizable;
import ar.edu.ub.pcsw.remisoft.tests.CTestPerformance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CUpdateSQL extends CDataBase implements ITemporizable {

    private static FileHandler archivoLog;
    private static final Logger logger = Logger.getLogger(CUpdateSQL.class.getName());

    private static void setArchivoLog() {
        try {
            CUpdateSQL.archivoLog = new FileHandler("RemiSoft1.0-" + CUpdateSQL.class.getName() + "-log.%u.%g.txt",
                    1024 * 1024, 10);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static FileHandler getArchivoLog() {
        setArchivoLog();
        return archivoLog;
    }

    public void updateTabla(ETablas tabla, String atributo1, String atributo2, String registro, int numero) {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        String sql = tabla.equals(ETablas.VIAJE) ? "UPDATE " + tabla +
                " SET " + atributo1 + " = ?, " + atributo2 + " = ? WHERE Numero = ?" : "UPDATE " + tabla + " SET " +
                atributo1 + " = ? WHERE " + atributo2 + " = ?";
        try (PreparedStatement pstmt = getPreparedStatement(sql)) {
            if (atributo1.equals("cancelado")) {
                pstmt.setInt(1, 1);
                pstmt.setString(2, registro);
                pstmt.setInt(3, numero);
                pstmt.executeUpdate();
            }
            else if (atributo1.equals("disponible")) {
                pstmt.setInt(1, numero);
                pstmt.setString(2, registro);
                pstmt.executeUpdate();
            }
            else if (atributo1.equals("fechaBaja")) {
                pstmt.setString(1, setFechaString(Calendar.getInstance()));
                pstmt.setString(2, registro);
                pstmt.executeUpdate();
            }
        }
        catch (SQLException e) {
            logger.addHandler(getArchivoLog());
            logger.log(Level.SEVERE, SQLException.class.getName(), e.getMessage());
        }
        if (testPerformance.setPerformanceTestResult() > getLimiteMaximo()) {
            logger.addHandler(getArchivoLog());
            logger.log(Level.INFO, testPerformance.getPerformanceTestResult(getNombreMetodo()));
        }
        logger.exiting(getClass().getName(), getNombreMetodo());
    }

    private PreparedStatement getPreparedStatement(String sql) throws SQLException {
        Connection conn = super.connect();
        return conn.prepareStatement(sql);
    }

    @Override
    public String setFechaYHora() {
        return null;
    }

}