package ar.edu.ub.pcsw.remisoft.controlador.main;

import ar.edu.ub.pcsw.remisoft.modelo.interfaces.ITemporizable;

import java.sql.*;
import java.util.Calendar;

/**
 * Created by Pulpo1 on 9/24/16.
 */
public class CInsertApp extends CDataBase implements ITemporizable{

    public void insertarEmpleado (String dni, String apellido, String nombre, String domicilio, String telefono, String turno) {
        String sql = "INSERT INTO Empleado(Dni, apellido, nombre, domicilio, telefono, fechaAlta, disponible, turno) VALUES(?,?,?,?,?,?,?,?)";

        try (Connection conn = super.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dni);
            pstmt.setString(2, apellido);
            pstmt.setString(3, nombre);
            pstmt.setString(4, domicilio);
            pstmt.setString(5, telefono);
            pstmt.setString(6, setFechaString(Calendar.getInstance()));
            pstmt.setInt(7, 1);
            pstmt.setString(8, turno);
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
    public String setHoraString(Calendar hora) {
        return null;
    }
}
