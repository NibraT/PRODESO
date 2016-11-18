package ar.edu.ub.pcsw.remisoft.controlador.main;

import ar.edu.ub.pcsw.remisoft.tests.CTestPerformance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class CDataBase {

    private String nombreMetodo;
    private static FileHandler archivoLog;
    private static final Logger logger = Logger.getLogger(CDataBase.class.getName());
    private static final int LIMITE_MAXIMO = 1;

    private static void setArchivoLog() {
        try {
            CDataBase.archivoLog = new FileHandler("RemiSoft1.0-" + CDataBase.class.getName() + "-log.%u.%g.txt",
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

    public Connection connect() {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:src/BaseDatos/RemiSoftDB");
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
        return conn;
    }

    public static int getLimiteMaximo() {
        return LIMITE_MAXIMO;
    }

    public String getNombreMetodo() {
        return this.nombreMetodo;
    }

    public void setNombreMetodo(String nombreMetodo) {
        this.nombreMetodo = nombreMetodo;
    }

}