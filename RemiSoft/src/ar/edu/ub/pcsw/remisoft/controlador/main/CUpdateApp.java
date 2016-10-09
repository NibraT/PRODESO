package ar.edu.ub.pcsw.remisoft.controlador.main;

import ar.edu.ub.pcsw.remisoft.modelo.interfaces.ITemporizable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

/**
 * Created by Pulpo1 on 9/25/16.
 */
public class CUpdateApp extends CDataBase implements ITemporizable{
    public void updateFechaBajaCuenta (int idCuenta) {
        String sql = "UPDATE Cuenta SET fechaBaja = ? WHERE IdCuenta = ?";

        try (Connection conn = super.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, setFechaString(Calendar.getInstance()));
            pstmt.setInt(2, idCuenta);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateDomicilioSucursal (String domicilio, int idCuenta) {
        String sql = "UPDATE Sucursal SET domicilio = ? WHERE IdSucursal = ?";

        try (Connection conn = super.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, domicilio);
            pstmt.setInt(2, idCuenta);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateFechaBajaSucursal (int idCuenta) {
        String sql = "UPDATE Sucursal SET fechaBaja = ? WHERE IdSucursal = ?";

        try (Connection conn = super.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, setFechaString(Calendar.getInstance()));
            pstmt.setInt(2, idCuenta);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateDomicilioCliente (String domicilio, String identificacion) {
        String sql = "UPDATE Cliente SET domicilio = ? WHERE Identificacion = ?";

        try (Connection conn = super.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, domicilio);
            pstmt.setString(2, identificacion);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateTelefonoCliente (String telefono, String identificacion) {
        String sql = "UPDATE Cliente SET telefono = ? WHERE Identificacion = ?";

        try (Connection conn = super.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, telefono);
            pstmt.setString(2, identificacion);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateFechaBajaCliente (String identificacion) {
        String sql = "UPDATE Cliente SET fechaBaja = ? WHERE Identificacion = ?";

        try (Connection conn = super.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, setFechaString(Calendar.getInstance()));
            pstmt.setString(2, identificacion);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateSaldoClienteCuenta (int saldo, String identificacion) {
        String sql = "UPDATE ClienteCuenta SET saldo = ? WHERE Identificacion = ?";

        try (Connection conn = super.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, saldo);
            pstmt.setString(2, identificacion);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateDomicilioEmpleado (String domicilio, String dni) {
        String sql = "UPDATE Empleado SET domicilio = ? WHERE Dni = ?";

        try (Connection conn = super.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, domicilio);
            pstmt.setString(2, dni);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateTelefonoEmpleado (String telefono, String dni) {
        String sql = "UPDATE Empleado SET telefono = ? WHERE Dni = ?";

        try (Connection conn = super.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, telefono);
            pstmt.setString(2, dni);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateFechaBajaEmpleado (String dni) {
        String sql = "UPDATE Empleado SET fechaBaja = ? WHERE Dni = ?";

        try (Connection conn = super.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, setFechaString(Calendar.getInstance()));
            pstmt.setString(2, dni);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateDisponibleEmpleado (int disponible, String dni) {
        String sql = "UPDATE Empleado SET disponible = ? WHERE Dni = ?";

        try (Connection conn = super.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, disponible);
            pstmt.setString(2, dni);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateTurnoEmpleado (String turno, String dni) {
        String sql = "UPDATE Empleado SET turno = ? WHERE Dni = ?";

        try (Connection conn = super.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, turno);
            pstmt.setString(2, dni);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        CUpdateApp db = new CUpdateApp();
        //db.updateFechaBajaCuenta(1);
        //db.updateDomicilioSucursal("Parana 2300, Garin, BsAs", 1);
        //db.updateFechaBajaSucursal(1);
        //db.updateDomicilioCliente("Paraguay 2300", "11222333");
        //db.updateFechaBajaCliente("11222333");
        //db.updateSaldoClienteCuenta(1000, "11222333");
        //db.updateDomicilioEmpleado("Lanus Este", "doaho");
        //db.updateDisponibleEmpleado(0, "doaho");
        db.updateTurnoEmpleado("13-24", "doaho");
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
