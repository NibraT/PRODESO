package ar.edu.ub.pcsw.remisoft.controlador.main;

import java.sql.*;

/**
 * Created by Pulpo1 on 9/16/16.
 */
public class DataBase {
    Connection connect() {
        String url = "jdbc:sqlite:/Users/Pulpo1/Documents/UB/Programacion/UB/ProyectoSoftware/PRODESO/RemiSoftDB";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}

