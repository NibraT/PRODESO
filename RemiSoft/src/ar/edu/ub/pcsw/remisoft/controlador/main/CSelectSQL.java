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

public class CSelectSQL extends CDataBase implements ITemporizable{

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

    public String[] selectAutoDisponibles(int disponible) {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        String sql = "SELECT Patente FROM Vehiculo where disponible = " + disponible;
        ArrayList<String> result = new ArrayList<String>();
        result.add(" ");
        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                result.add(rs.getString("Patente"));
            }
            String[] resultString = new String[result.size()];
            resultString = result.toArray(resultString);
            return resultString;
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

    public String[] selectAutoDisponiblesReportes() {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        String sql = "SELECT Patente, marca, modelo FROM Vehiculo where disponible = 1";
        ArrayList<String> result = new ArrayList<String>();
        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                result.add(rs.getString("Patente") + " - " + rs.getString("marca") + " - " + rs.getString("modelo"));
            }
            String[] resultString = new String[result.size()];
            resultString = result.toArray(resultString);
            return resultString;
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

    public String selectAutoDeViaje(int numero) {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        String sql = "SELECT patente FROM Viaje where Numero = " + numero;
        String result;
        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                result = rs.getString("patente");
                return result;
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

    public String[] selectAutoParaBaja() {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        String sql = "SELECT Patente FROM Vehiculo where fechaBaja is null";
        ArrayList<String> result = new ArrayList<String>();
        result.add(" ");
        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                result.add(rs.getString("Patente"));
            }
            String[] resultString = new String[result.size()];
            resultString = result.toArray(resultString);
            return resultString;
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

    public String[] selectAtributoAuto(String atributo) {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        String sql = "SELECT distinct " + atributo + " FROM Vehiculo where disponible = 1";
        ArrayList<String> result = new ArrayList<String>();
        result.add(" ");
        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                result.add(rs.getString(atributo));
            }
            String[] resultString = new String[result.size()];
            resultString = result.toArray(resultString);
            return resultString;
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

    public String[] selectEmpleadoDisponibles(int disponible, int tipoEmpleado) {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        String sql = "SELECT Dni FROM Empleado where disponible = " + disponible + " and tipoEmpleado = " +
                tipoEmpleado;
        ArrayList<String> result = new ArrayList<String>();
        result.add(" ");
        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                result.add(rs.getString("Dni"));
            }
            String[] resultString = new String[result.size()];
            resultString = result.toArray(resultString);
            return resultString;
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

    public String[] selectNombreEmpleadoParaBaja() {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        String sql = "SELECT nombre FROM Empleado where fechaBaja is null";
        ArrayList<String> result = new ArrayList<String>();
        result.add(" ");
        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                result.add(rs.getString("nombre"));
            }
            String[] resultString = new String[result.size()];
            resultString = result.toArray(resultString);
            return resultString;
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

    public String[] selectApellidoEmpleadoParaBaja() {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        String sql = "SELECT apellido FROM Empleado where fechaBaja is null";
        ArrayList<String> result = new ArrayList<String>();
        result.add(" ");
        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                result.add(rs.getString("apellido"));
            }
            String[] resultString = new String[result.size()];
            resultString = result.toArray(resultString);
            return resultString;
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

    public String[] selectDniEmpleadoParaBaja() {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        String sql = "SELECT Dni FROM Empleado where fechaBaja is null";
        ArrayList<String> result = new ArrayList<String>();
        result.add(" ");
        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                result.add(rs.getString("Dni"));
            }
            String[] resultString = new String[result.size()];
            resultString = result.toArray(resultString);
            return resultString;
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

    public String[] selectViajesNumero(String identificacion) {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        String sql = "SELECT Numero FROM Viaje where identificacion = " + identificacion +
                " order by Numero desc limit 1";
        ArrayList<String> result = new ArrayList<String>();
        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                result.add(rs.getString("Numero"));
            }
            String[] resultString = new String[result.size()];
            resultString = result.toArray(resultString);
            return resultString;
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

    public HashMap<String, Integer> selectViajesPorAutoReportes() {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        String sql = "select patente, count(patente) as count from Viaje inner join Rendicion on Numero = IdViaje group by patente";
        HashMap<String, Integer> hashMap = new HashMap<>();
        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                hashMap.put(rs.getString("patente"), rs.getInt("count"));
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

    public HashMap<String, Integer> selectViajesPorChoferReportes() {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        String sql = "select dni, count(patente) as count from Viaje inner join Rendicion on Numero = IdViaje group by dni";
        HashMap<String, Integer> hashMap = new HashMap<>();
        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                hashMap.put(rs.getString("dni"), rs.getInt("count"));
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

    public HashMap<String, Integer> selectTodosAutosReportes() {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        String sql = "select Patente, count(Patente) as count from Vehiculo where fechaBaja is null group by Patente";
        HashMap<String, Integer> hashMap = new HashMap<>();
        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                hashMap.put(rs.getString("Patente"), rs.getInt("count"));
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

    public HashMap<String, Integer> selectTodosAutosDisponiblesReportes() {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        String sql = "select Patente, count(Patente) as count from Vehiculo where disponible = 1 and fechaBaja is nul group by Patente";
        HashMap<String, Integer> hashMap = new HashMap<>();
        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                hashMap.put(rs.getString("Patente"), rs.getInt("count"));
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

    public HashMap<String, Integer> selectTodosAutosNoDisponiblesReportes() {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        String sql = "select Patente, count(Patente) as count from Vehiculo where disponible = 0 and fechaBaja is null group by Patente";
        HashMap<String, Integer> hashMap = new HashMap<>();
        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                hashMap.put(rs.getString("Patente"), rs.getInt("count"));
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

    public HashMap<String, Integer> selectTotalClientesReportes() {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        String sql = "select Identificacion, nombreORazonSocial, count(Identificacion) as count from Cliente where fechaBaja is null group by Identificacion";
        HashMap<String, Integer> hashMap = new HashMap<>();
        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                hashMap.put(rs.getString("Identificacion") + " - " + rs.getString("nombreORazonSocial"), rs.getInt("count"));
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
        String sql = "select Identificacion, fechaAlta, count(Identificacion) as count from Cliente where fechaBaja is null group by Identificacion";
        HashMap<String, Integer> hashMap = new HashMap<>();
        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
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

    public String[] selectViajesChofer(String identificacion) {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        String sql = "SELECT Numero, dni FROM Viaje where identificacion = " + identificacion +
                " order by Numero desc limit 1";
        ArrayList<String> result = new ArrayList<String>();
        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                result.add(rs.getString("dni"));
            }
            String[] resultString = new String[result.size()];
            resultString = result.toArray(resultString);
            return resultString;
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

    public String[] selectViajesAuto(String identificacion) {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        String sql = "SELECT Numero, patente FROM Viaje where identificacion = " + identificacion +
                " order by Numero desc limit 1";
        ArrayList<String> result = new ArrayList<String>();
        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                result.add(rs.getString("patente"));
            }
            String[] resultString = new String[result.size()];
            resultString = result.toArray(resultString);
            return resultString;
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

    public String[] selectViajesFecha(String identificacion) {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        String sql = "SELECT Numero, fecha FROM Viaje where identificacion = " + identificacion +
                " order by Numero desc limit 1";
        ArrayList<String> result = new ArrayList<String>();
        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                result.add(rs.getString("fecha"));
            }
            String[] resultString = new String[result.size()];
            resultString = result.toArray(resultString);
            return resultString;
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

    public String[] selectViajesHora(String identificacion) {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        String sql = "SELECT Numero, horaInicio FROM Viaje where identificacion = " + identificacion +
                " order by Numero desc limit 1";
        ArrayList<String> result = new ArrayList<String>();
        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                result.add(rs.getString("horaInicio"));
            }
            String[] resultString = new String[result.size()];
            resultString = result.toArray(resultString);
            return resultString;
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

    public String[] selectViajesOrigen(String identificacion) {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        String sql = "SELECT Numero, origen FROM Viaje where identificacion = " + identificacion +
                " order by Numero desc limit 1";
        ArrayList<String> result = new ArrayList<String>();
        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                result.add(rs.getString("origen"));
            }
            String[] resultString = new String[result.size()];
            resultString = result.toArray(resultString);
            return resultString;
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

    public String[] selectViajesDestino(String identificacion) {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        String sql = "SELECT Numero, destino FROM Viaje where identificacion = " + identificacion +
                " order by Numero desc limit 1";
        ArrayList<String> result = new ArrayList<String>();
        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                result.add(rs.getString("destino"));
            }
            String[] resultString = new String[result.size()];
            resultString = result.toArray(resultString);
            return resultString;
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

    public String[] selectCliente(String identificacion) {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        String sql = "SELECT Numero, Identificacion FROM Cliente where Identificacion = " + identificacion +
                " order by Numero desc limit 1";
        ArrayList<String> result = new ArrayList<String>();
        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                result.add(rs.getString("Identificacion"));
            }
            String[] resultString = new String[result.size()];
            resultString = result.toArray(resultString);
            return resultString;
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
        String sql = "SELECT count() as cont from Rendicion";
        ArrayList<String> result = new ArrayList<String>();
        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
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

    public String selectCostoTestigoViaje(String viaje) {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        String sql = "SELECT Numero, horaInicio FROM Viaje where Numero = " + viaje + " order by Numero desc limit 1";
        ArrayList<String> result = new ArrayList<String>();
        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
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

    public void verArray(String[] a){
        for (String i : a) {
            System.out.println(i);
        }
    }

    public static void main (String[] args){
        CSelectSQL s = new CSelectSQL();
        //s.selectAutoParaBaja();
        //s.verArray(s.selectAutoDisponiblesReportes());
        //System.out.println(s.selectAutoDeViaje(2));
    }

    @Override
    public Calendar calcularTiempo() {
        return null;
    }

    @Override
    public String setFechaYHora() {
        return null;
    }

    @Override
    public Calendar setFechaCalendar(String fecha) {
        return null;
    }

    @Override
    public Calendar setHoraCalendar(String hora) {
        return null;
    }

    @Override
    public String setFechaString(Calendar fecha) {
        return null;
    }

    @Override
    public String setHoraString(Calendar hora) {
        return null;
    }

}
