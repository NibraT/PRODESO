package ar.edu.ub.pcsw.remisoft.controlador.main;

import java.sql.*;

/**
 * Created by Pulpo1 on 9/24/16.
 */
public class CInsertApp extends CDataBase {

    public void insertarChofer (int dni, String name, String direccion, String telefono, int disponible, int idComision) {
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

    public void insertarCliente (String name, String identificacion, String domicilio, String telefono) {
        String sql = "INSERT INTO Cliente(identificacion, nombreORazonSocial, domicilio, telefono, fechaAlta) VALUES(?,?,?,?,?)";

        try (Connection conn = super.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, identificacion);
            pstmt.setString(2, name);
            pstmt.setString(3, domicilio);
            pstmt.setString(4, telefono);
            pstmt.setString(5, "20160930");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CInsertApp db = new CInsertApp();
        db.insertarCliente("Didier Renard", "11222333", "Paraguay 100, Garin, BsAs", "15487654321");
    }
}
