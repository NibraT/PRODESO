package ar.edu.ub.pcsw.remisoft.controlador.main;

import ar.edu.ub.pcsw.remisoft.modelo.interfaces.ITemporizable;

import java.sql.*;
import java.util.Calendar;

public class CInsertSQL extends CDataBase implements ITemporizable{

    public void insertarEmpleado(String dni, String apellido, String nombre, String domicilio, String telefono,
                                  String turno, String fechaDeAlta) {
        String sql = "INSERT INTO Empleado(Dni, apellido, nombre, domicilio, telefono, turno, fechaAlta, disponible, " +
                "turno) VALUES(?,?,?,?,?,?,?,?)";
        try (Connection conn = super.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dni);
            pstmt.setString(2, apellido);
            pstmt.setString(3, nombre);
            pstmt.setString(4, domicilio);
            pstmt.setString(5, telefono);
            pstmt.setString(6, fechaDeAlta);
            pstmt.setInt(7, 1);
            pstmt.setString(8, turno);
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertarCliente(String name, String identificacion, String domicilio, String telefono,
                                String fechaDeAlta) {
        String sql = "INSERT INTO Cliente(identificacion, nombreORazonSocial, domicilio, telefono," +
                " fechaAlta) VALUES(?,?,?,?,?)";
        try (Connection conn = super.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, identificacion);
            pstmt.setString(2, name);
            pstmt.setString(3, domicilio);
            pstmt.setString(4, telefono);
            pstmt.setString(5, fechaDeAlta);
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertarArregloAuto (String descripcion, int monto, String patente) {
        String sql = "INSERT INTO ArregloAuto(descripcion, monto, patente) VALUES(?,?,?)";
        try (Connection conn = super.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, descripcion);
            pstmt.setInt(2, monto);
            pstmt.setString(3, patente);
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertarCuenta (String tipoCuenta) {
        String sql = "INSERT INTO Cuenta(tipoCuenta, fechaAlta) VALUES(?,?)";
        try (Connection conn = super.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tipoCuenta);
            pstmt.setString(2, setFechaString(Calendar.getInstance()));
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertarFactura (int monto, int idTipoFactura) {
        String sql = "INSERT INTO Factura(fecha, monto, idTipoFactura) VALUES(?,?,?)";
        try (Connection conn = super.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, setFechaString(Calendar.getInstance()));
            pstmt.setInt(2, monto);
            pstmt.setInt(3, idTipoFactura);
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertarSucursal (String domicilio) {
        String sql = "INSERT INTO Sucursal(domicilio, fechaAlta) VALUES(?,?)";
        try (Connection conn = super.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, domicilio);
            pstmt.setString(2, setFechaString(Calendar.getInstance()));
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertarTipoFactura (String descripcion) {
        String sql = "INSERT INTO TipoFactura(descripcion) VALUES(?)";
        try (Connection conn = super.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, descripcion);
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertarUsuario (String nombre, String password) {
        String sql = "INSERT INTO Usuario(NombreUsuario, password) VALUES(?,?)";
        try (Connection conn = super.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertarVehiculo (String patente, String marca, String modelo, int consumo, int kilometraje) {
        String sql = "INSERT INTO Vehiculo(Patente, marca, modelo, fechaAlta, disponible, consumo," +
                " kilometraje) VALUES(?,?,?,?,?,?,?)";
        try (Connection conn = super.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, patente);
            pstmt.setString(2, marca);
            pstmt.setString(3, modelo);
            pstmt.setString(4, setFechaString(Calendar.getInstance()));
            pstmt.setInt(5, 1);
            pstmt.setInt(6, consumo);
            pstmt.setInt(7, kilometraje);
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertarViaje (String origen, String destino, int distancia,int precio, String horaInicio,
                               String identificacion, String dni, String patente, int idSucursal) {
        String sql = "INSERT INTO Viaje(origen, destino, distancia, precio, fecha, horaInicio, identificacion, dni," +
                " patente, idSucursal) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = super.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, origen);
            pstmt.setString(2, destino);
            pstmt.setInt(3, distancia);
            pstmt.setInt(4, precio);
            pstmt.setString(5, setFechaString(Calendar.getInstance()));
            pstmt.setString(6, horaInicio);
            pstmt.setString(7, identificacion);
            pstmt.setString(8, dni);
            pstmt.setString(9, patente);
            pstmt.setInt(10, idSucursal);
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertarViajeMotivoCancelacion (String motivo) {
        String sql = "INSERT INTO Viaje(motivoCancelacion) VALUES(?)";
        try (Connection conn = super.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, motivo);
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertarClienteCuenta (String identificacion, int idCuenta) {
        String sql = "INSERT INTO ClienteCuenta(Identificacion, IdCuenta) VALUES(?,?)";
        try (Connection conn = super.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, identificacion);
            pstmt.setInt(2, idCuenta);
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CInsertSQL db = new CInsertSQL();
        //db.insertarCliente("Didier", "2", "Paraguay 100, Garin, BsAs", "15487654321");
        //db.insertarArregloAuto("Arreglo paragolpes delantero", 5000, "AAA000");
        //db.insertarCuenta("Personal", 1000);
        //db.insertarFactura(200, 1);
        //db.insertarSucursal("Las cuartetas 100");
        //db.insertarTipoFactura("C");
        //db.insertarUsuario("Diego", "1234");
        //db.insertarVehiculo("CCC000", "Ford", "focus", 15, 30000);
        //db.insertarViaje("Lacroze 1000, caba", "Juramento 2000, caba", 200, 50, "09:00", "33444555", "doaho", "CCC000", 1);
        //db.insertarClienteCuenta("11222333", 1);
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
