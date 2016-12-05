package ar.edu.ub.pcsw.remisoft.controlador.main;

import ar.edu.ub.pcsw.remisoft.modelo.interfaces.ITemporizable;
import ar.edu.ub.pcsw.remisoft.tests.CTestPerformance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CSelectSQL extends CDataBase implements ITemporizable {

    private static FileHandler archivoLog;
    private static final Logger logger = Logger.getLogger(CSelectSQL.class.getName());

    private static void setArchivoLog() {
        try {
            CSelectSQL.archivoLog = new FileHandler("RemiSoft1.0-" + CSelectSQL.class.getName() + "-log.%u.%g.txt",
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

    public String[] selectRecursoAuto(String atributo, int disponible) {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        String sql = atributo.equalsIgnoreCase("Patente") ? "SELECT Patente FROM " + ETablas.VEHICULO +
                " where disponible = '" + disponible + "' order by Patente asc" : "SELECT " +
                atributo + " FROM " + ETablas.VEHICULO + " where disponible = '" + disponible + "' order by Patente asc";
        String[] registros = getRegistrosTabla(sql, atributo, testPerformance, getNombreMetodo());
        logger.exiting(getClass().getName(), getNombreMetodo());
        return registros;
    }

    public String[] selectRecursoEmpleado(String atributo, int disponible, int tipoEmpleado) {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        String sql = " ";
        if (disponible == 1) {
            sql = "SELECT " + atributo + " FROM " + ETablas.EMPLEADO + " where disponible = " +
                    disponible + " and tipoEmpleado = " + tipoEmpleado + " order by Dni asc";
        }
        else if (disponible == 0) {
            sql = "SELECT " + atributo + " FROM " + ETablas.EMPLEADO + " where disponible = " +
                    disponible + " and tipoEmpleado = " + tipoEmpleado + " order by Dni asc";
        }
        else {
            if ((horaMax() > 6) && (horaMax() < 15)) {
                sql = "SELECT " + atributo + " FROM " + ETablas.EMPLEADO + " where fechaBaja is null and tipoEmpleado = " +
                        tipoEmpleado + " and turno = '6-15' order by Dni asc";
            }
            else if ((horaMax() >= 15) && (horaMax() < 24)) {
                sql = "SELECT " + atributo + " FROM " + ETablas.EMPLEADO + " where fechaBaja is null and tipoEmpleado = " +
                        tipoEmpleado + " and turno = '15-24' order by Dni asc";
            }
        }
        String[] registros = getRegistrosTabla(sql, atributo, testPerformance, getNombreMetodo());
        logger.exiting(getClass().getName(), getNombreMetodo());
        return registros;
    }

    public String[] selectRecursoParaBaja(String atributo, String identificacion) {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        String sql = " ";
        if (atributo.equalsIgnoreCase("Dni")) {
            sql = (identificacion.equals(" ")) ?
                    "SELECT " + atributo + " FROM " + ETablas.EMPLEADO +
                    " where fechaBaja is null order by " + atributo + " asc" :
                    "SELECT Numero FROM " + ETablas.VIAJE + " where dni = '" + identificacion +
                            "' and cancelado is null and Numero not in (Select idViaje From " +
                            ETablas.RENDICION + ") order by Numero asc";
        }
        else if (atributo.equalsIgnoreCase("identificacion")) {
            sql = "SELECT " + atributo + " FROM " + ETablas.CLIENTE + " where fechaBaja is null order by " +
                    atributo + " asc";
        }
        else if (atributo.equalsIgnoreCase("Patente")){
            sql = "SELECT " + atributo + " FROM " + ETablas.VEHICULO + " where fechaBaja is null order by " +
                    atributo + " asc";
        }
        else if (atributo.equalsIgnoreCase("Numero")) {
            sql = "SELECT " + atributo + " FROM " + ETablas.VIAJE + " where identificacion = '" + identificacion +
                    "' and cancelado is null and " + atributo + " not in (Select idViaje From " + ETablas.RENDICION +
                    ") order by " + atributo + " asc";
        }
        String[] registros = getRegistrosTabla(sql, atributo, testPerformance, getNombreMetodo());
        logger.exiting(getClass().getName(), getNombreMetodo());
        return registros;
    }

    public String selectRecurso(String recurso, String identificacion, String atributo, String negacion, int numero) {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        String sql = " ";
        if (recurso.equalsIgnoreCase("empleado")) {
            sql = "SELECT " + atributo + " FROM " + ETablas.EMPLEADO + " where dni = '" + identificacion + "'";
        }
        else if (recurso.equalsIgnoreCase("cliente")) {
            sql = "SELECT " + atributo + " FROM " + ETablas.CLIENTE + " where identificacion = '" + identificacion + "'";
        }
        else if (recurso.equalsIgnoreCase("viaje")) {
            if ((numero > 3) && (! identificacion.isEmpty())) {
                sql = "SELECT " + atributo + " FROM " + ETablas.VIAJE + " where identificacion = '" + identificacion +
                        "' and cancelado is " + negacion + " null and Numero not in (Select idViaje From " +
                        ETablas.RENDICION + ") order by Numero asc";
            }
            else if ((numero > 0) && (! identificacion.isEmpty())) {
                sql = "SELECT " + atributo + " FROM " + ETablas.VIAJE + " where dni = '" + identificacion +
                        "' and cancelado is " + negacion + " null and Numero not in (Select idViaje From " +
                        ETablas.RENDICION + ") order by Numero asc";
            }
            else if (identificacion.isEmpty()) {
                sql = "SELECT " + atributo + " FROM " + ETablas.VIAJE + " where Numero = " + numero;
            }
        }
        else if (recurso.equalsIgnoreCase("auto")){
            sql = "SELECT " + atributo + " FROM " + ETablas.VEHICULO + " where patente = '" + identificacion + "'";
        }
        String result = getAtributoTabla(sql, atributo, testPerformance, getNombreMetodo());
        logger.exiting(getClass().getName(), getNombreMetodo());
        return result;
    }

    public HashMap<String, Integer> selectViajesPorAutoOChoferReportes(String atributo) {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        String sql = "select " + atributo + ", count(patente) as count from " + ETablas.VIAJE +
                " inner join " + ETablas.RENDICION + " on Numero = IdViaje group by " + atributo;
        HashMap<String, Integer> hashMap = getHashMap(sql, atributo, testPerformance, getNombreMetodo());
        logger.exiting(getClass().getName(), getNombreMetodo());
        return hashMap;
    }

    public HashMap<String, Integer> selectTodosAutosReportes() {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        String atributo = "Patente";
        String sql = "select " + atributo + ", count(Patente) as count from " + ETablas.VEHICULO +
                " where fechaBaja is null group by Patente";
        HashMap<String, Integer> hashMap = getHashMap(sql, atributo, testPerformance, getNombreMetodo());
        logger.exiting(getClass().getName(), getNombreMetodo());
        return hashMap;
    }

    public HashMap<String, Integer> selectTodosAutosDisponiblesNoDisponiblesReportes(String numero) {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        String atributo = "Patente";
        String sql = "select " + atributo + ", count(Patente) as count from " + ETablas.VEHICULO +
                " where disponible = " + numero + " and fechaBaja is null group by Patente";
        HashMap<String, Integer> hashMap = getHashMap(sql, atributo, testPerformance, getNombreMetodo());
        logger.exiting(getClass().getName(), getNombreMetodo());
        return hashMap;
    }

    public HashMap<String, Integer> selectTotalClientesReportes() {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        String sql = "select Identificacion, nombreORazonSocial, count(Identificacion) as count from " +
                ETablas.CLIENTE + " where fechaBaja is null group by Identificacion";
        HashMap<String, Integer> hashMap = new HashMap<>();
        try (ResultSet rs = getResultSet(sql)) {
            while (rs.next()) {
                hashMap.put(rs.getString("Identificacion") + " - " +
                        rs.getString("nombreORazonSocial"), rs.getInt("count"));
            }
            return hashMap;
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
        return null;
    }

    public HashMap<String, Integer> selectAntiguedadClientesReportes() {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        String sql = "select Identificacion, fechaAlta, count(Identificacion) as count from " + ETablas.CLIENTE +
                " where fechaBaja is null group by Identificacion";
        HashMap<String, Integer> hashMap = new HashMap<>();
        try (ResultSet rs = getResultSet(sql)) {
            while (rs.next()) {
                hashMap.put(rs.getString("Identificacion" ) + " - " + rs.getString("fechaAlta"), rs.getInt("count"));
            }
            return hashMap;
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
        return null;
    }

    public String selectCantidadFilasRendicion() {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        String sql = "SELECT count() as cont from " + ETablas.RENDICION + "";
        try (ResultSet rs = getResultSet(sql)) {
            while (rs.next()) {
                return Integer.toString(rs.getInt("cont") + 1);
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
        return null;
    }

    private String getAtributoTabla(String sql, String atributo, CTestPerformance testPerformance,
                                    String nombreMetodo) {
        try (ResultSet rs = getResultSet(sql)) {
            while (rs.next()) {
                return rs.getString(atributo);
            }
        }
        catch (SQLException e) {
            logger.addHandler(getArchivoLog());
            logger.log(Level.SEVERE, SQLException.class.getName(), e.getMessage());
        }
        if (testPerformance.setPerformanceTestResult() > getLimiteMaximo()) {
            logger.addHandler(getArchivoLog());
            logger.log(Level.INFO, testPerformance.getPerformanceTestResult(nombreMetodo));
        }
        return null;
    }

    private String[] getRegistrosTabla(String sql, String atributo,
                                       CTestPerformance testPerformance, String nombreMetodo) {
        ArrayList<String> result = new ArrayList<String>();
        try (ResultSet rs = getResultSet(sql)) {
                result.add(" ");
                while (rs.next()) {
                    result.add(rs.getString(atributo));
                }
                String[] resultString = new String[result.size()];
                return result.toArray(resultString);
        }
        catch (SQLException e) {
            logger.addHandler(getArchivoLog());
            logger.log(Level.SEVERE, SQLException.class.getName(), e.getMessage());
        }
        if (testPerformance.setPerformanceTestResult() > getLimiteMaximo()) {
            logger.addHandler(getArchivoLog());
            logger.log(Level.INFO, testPerformance.getPerformanceTestResult(nombreMetodo));
        }
        return null;
    }

    private HashMap<String, Integer> getHashMap(String sql, String atributo, CTestPerformance testPerformance,
                                                String nombreMetodo) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        try (ResultSet rs = getResultSet(sql)) {
            while (rs.next()) {
                hashMap.put(rs.getString(atributo), rs.getInt("count"));
            }
            return hashMap;
        }
        catch (SQLException e) {
            logger.addHandler(getArchivoLog());
            logger.log(Level.SEVERE, SQLException.class.getName(), e.getMessage());
        }
        if (testPerformance.setPerformanceTestResult() > getLimiteMaximo()) {
            logger.addHandler(getArchivoLog());
            logger.log(Level.INFO, testPerformance.getPerformanceTestResult(nombreMetodo));
        }
        return null;
    }

    private ResultSet getResultSet(String sql) throws SQLException {
        Connection conn = super.connect();
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }

    private int horaMax() {
        return Integer.parseInt(setHoraString(Calendar.getInstance()).substring(0,2));
    }

    @Override
    public String setFechaYHora() {
        return null;
    }

    @Override
    public String setFechaString(Calendar fecha) {
        return null;
    }

}