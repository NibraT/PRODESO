package ar.edu.ub.pcsw.remisoft.controlador.main;

import ar.edu.ub.pcsw.remisoft.tests.CTestPerformance;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CDataBase {

    public static ArrayList<String> listaTablas;
    public ArrayList<String> listadoTablas;
    private String nombreMetodo;
    private static FileHandler archivoLog;
    private static final Logger logger = Logger.getLogger(CDataBase.class.getName());
    private static final int LIMITE_MAXIMO = 1;

    /*
    Constructor
     */
    protected CDataBase() {
        this.setListadoTablas();
        CDataBase.setListaTablas(this.getListadoTablas());
    }

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

    public ArrayList<String> selectTablas() {
        setNombreMetodo(new Object() {
        }.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        String sql = "SELECT name FROM sqlite_master where type='table' ORDER BY name";
        ArrayList<String> result = new ArrayList<String>();
        try {
            Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                result.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            logger.addHandler(getArchivoLog());
            logger.log(Level.SEVERE, SQLException.class.getName(), e.getMessage());
            System.out.print(e.getMessage());
        }
        if (testPerformance.setPerformanceTestResult() > getLimiteMaximo()) {
            logger.addHandler(getArchivoLog());
            logger.log(Level.INFO, testPerformance.getPerformanceTestResult(getNombreMetodo()));
        }
        logger.exiting(getClass().getName(), getNombreMetodo());
        return result;
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

    public static ArrayList<String> getListaTablas() { return listaTablas; }

    public static void setListaTablas(ArrayList<String> listaTablas) { CDataBase.listaTablas = listaTablas; }

    public void setListadoTablas() { this.listadoTablas = selectTablas(); }

    public ArrayList<String> getListadoTablas() { return this.listadoTablas; }

}