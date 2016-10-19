package ar.edu.ub.pcsw.remisoft.controlador.main;

import java.sql.*;

/**
 * Created by Pulpo1 on 9/16/16.
 */
public class CDataBase {
    Connection connect() {
        String url = "jdbc:sqlite:src/BaseDatos/RemiSoftDB";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}

