package ar.edu.ub.pcsw.remisoft.controlador.main;

import java.sql.*;

public class CDataBase {

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:src/BaseDatos/RemiSoftDB");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

}

