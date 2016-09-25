package ar.edu.ub.pcsw.remisoft.controlador.main;

import java.sql.*;

/**
 * Created by Pulpo1 on 9/24/16.
 */
public class InsertApp extends DataBase{

    public void insert (int dni, String name, String direccion, String telefono, int disponible, int idComision) {
        String sql = "INSERT INTO Chofer(DNI, NombreCompletoChofer, DireccionChofer, TelefonoChofer, DisponibleChofer, IdComision) VALUES(?,?,?,?,?,?)";

        try (Connection conn = super.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, dni);
            pstmt.setString(2, name);
            pstmt.setString(3, direccion);
            pstmt.setString(4, telefono);
            pstmt.setInt(5, disponible);
            pstmt.setInt(6, idComision);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InsertApp db = new InsertApp();
        db.insert(34999999, "Prueba", "Paraguay 500, Garin, BsAs", "15487654321", 1, 1);
    }
}
