package ar.edu.ub.pcsw.remisoft.controlador.main;

import ar.edu.ub.pcsw.remisoft.tests.CTestPerformance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class CDataBase {

    public static ArrayList<String> listaTablas;
    public ArrayList<String> listadoTablas;
    private String nombreMetodo;
    private static FileHandler archivoLog;
    private static final int LIMITE_MAXIMO = 1;
    private static final Logger logger = Logger.getLogger(CDataBase.class.getName());
    private static final String dbPath = "RemiSoft/src/BaseDatos/RemiSoftDB";

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
            conn = DriverManager.getConnection("jdbc:sqlite:" + getDbPath());
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

    private ArrayList<String> selectTablas() {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        CTestPerformance testPerformance = CTestPerformance.getInstance();
        testPerformance.startPerformanceTest();
        ArrayList<String> result = new ArrayList<String>();
        try {
            Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT name FROM sqlite_master where type='table' ORDER BY name");
            while (rs.next()) {
                result.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            logger.addHandler(getArchivoLog());
            logger.log(Level.SEVERE, SQLException.class.getName(), e.getMessage());
        }
        if (testPerformance.setPerformanceTestResult() > getLimiteMaximo()) {
            logger.addHandler(getArchivoLog());
            logger.log(Level.INFO, testPerformance.getPerformanceTestResult(getNombreMetodo()));
        }
        logger.exiting(getClass().getName(), getNombreMetodo());
        return result;
    }

    public static void hacerBackUpBaseDatos() {
        Path origen = Paths.get(getDbPath());
        Path destino = Paths.get("C:/users/franc/OneDrive/UB/ProDeSo/RSDataBaseBackUp");
        try {
            Files.copy(origen, destino, REPLACE_EXISTING);
        }
        catch (IOException e) {
            logger.addHandler(getArchivoLog());
            logger.log(Level.SEVERE, IOException.class.getName(), e.getMessage());
        }
    }

    public static int getLimiteMaximo() {
        return LIMITE_MAXIMO;
    }

    public static String getDbPath() { return dbPath; }

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