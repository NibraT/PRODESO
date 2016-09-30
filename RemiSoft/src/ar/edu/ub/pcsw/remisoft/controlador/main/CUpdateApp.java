package ar.edu.ub.pcsw.remisoft.controlador.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Pulpo1 on 9/25/16.
 */
public class CUpdateApp extends CDataBase {
    public void update (int dni, String name, String direccion, String telefono, int disponible, int idComision) {
        String sql = "UPDATE Chofer SET NombreCompletoChofer = ?, DireccionChofer = ?, TelefonoChofer = ?, DisponibleChofer = ?, IdComision = ? WHERE DNI = ?";

        try (Connection conn = super.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, direccion);
            pstmt.setString(3, telefono);
            pstmt.setInt(4, disponible);
            pstmt.setInt(5, idComision);
            pstmt.setInt(6, dni);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        CUpdateApp db = new CUpdateApp();
        db.update(34999999, "Prueba de Update", "Paraguay 500, Garin, BsAs", "15487654321", 1, 1);
    }
}
