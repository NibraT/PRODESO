package ar.edu.ub.pcsw.remisoft.controlador.main;

import ar.edu.ub.pcsw.remisoft.modelo.clientes.CCliente;
import ar.edu.ub.pcsw.remisoft.modelo.empleados.CEmpleado;
import ar.edu.ub.pcsw.remisoft.modelo.interfaces.ITemporizable;
import ar.edu.ub.pcsw.remisoft.modelo.rendiciones.CRendicion;
import ar.edu.ub.pcsw.remisoft.modelo.usuarios.CUsuario;
import ar.edu.ub.pcsw.remisoft.modelo.vehiculos.CVehiculo;
import ar.edu.ub.pcsw.remisoft.modelo.viajes.CViaje;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CInsertSQL extends CDataBase implements ITemporizable {

    private static FileHandler archivoLog;
    private static final Logger logger = Logger.getLogger(CInsertSQL.class.getName());

    private static void setArchivoLog() {
        try {
            CInsertSQL.archivoLog = new FileHandler("RemiSoft1.0-" + CInsertSQL.class.getName() + "-log.%u.%g.txt",
                    1024 * 1024, 10);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static FileHandler getArchivoLog() {
        setArchivoLog();
        return archivoLog;
    }

    public void insertarEmpleado(CEmpleado empleado) {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        String sql = "INSERT INTO Empleado(Dni, apellido, nombre, domicilio, telefono, fechaAlta, disponible, turno, " +
                "TipoEmpleado) VALUES(?,?,?,?,?,?,?,?,?)";
        try (Connection conn = super.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, empleado.getDni());
            pstmt.setString(2, empleado.getApellido());
            pstmt.setString(3, empleado.getNombre());
            pstmt.setString(4, empleado.getDomicilio());
            pstmt.setString(5, empleado.getTelefono());
            pstmt.setString(6, setFechaString(Calendar.getInstance()));
            pstmt.setInt(7, 1);
            pstmt.setString(8, empleado.getTurno());
            pstmt.setString(9, empleado.getCategoria());
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            logger.addHandler(getArchivoLog());
            logger.log(Level.SEVERE, SQLException.class.getName(), e.getMessage());
        }
        logger.exiting(getClass().getName(), getNombreMetodo());
    }

    public void insertarCliente(CCliente cliente) {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        String sql = "INSERT INTO Cliente(identificacion, nombreORazonSocial, domicilio, telefono," +
                " fechaAlta) VALUES(?,?,?,?,?)";
        try (Connection conn = super.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cliente.getIdentificacion());
            pstmt.setString(2, cliente.getNombreYApellidoORazonSocial());
            pstmt.setString(3, cliente.getDomicilio());
            pstmt.setString(4, cliente.getTelefono());
            pstmt.setString(5, setFechaString(Calendar.getInstance()));
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            logger.addHandler(getArchivoLog());
            logger.log(Level.SEVERE, SQLException.class.getName(), e.getMessage());
        }
        logger.exiting(getClass().getName(), getNombreMetodo());
    }

    public void insertarVehiculo(CVehiculo vehiculo) {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        String sql = "INSERT INTO Vehiculo(Patente, marca, modelo, aseguradora, fechaAlta, disponible, consumo," +
                " kilometraje) VALUES(?,?,?,?,?,?,?,?)";
        try (Connection conn = super.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, vehiculo.getPatente());
            pstmt.setString(2, vehiculo.getMarca());
            pstmt.setString(3, vehiculo.getModelo());
            pstmt.setString(4, vehiculo.getAseguradora());
            pstmt.setString(5, setFechaString(Calendar.getInstance()));
            pstmt.setInt(6, 1);
            pstmt.setInt(7, Integer.parseInt(vehiculo.getConsumo()));
            pstmt.setInt(8, Integer.parseInt(vehiculo.getKilometraje()));
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            logger.addHandler(getArchivoLog());
            logger.log(Level.SEVERE, SQLException.class.getName(), e.getMessage());
        }
        logger.exiting(getClass().getName(), getNombreMetodo());
    }

    public void insertarViaje(CViaje viaje) {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        String sql = "INSERT INTO Viaje(origen, destino, precio, fecha, horaInicio, identificacion, dni," +
                " patente, idSucursal) VALUES(?,?,?,?,?,?,?,?,?)";
        try (Connection conn = super.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, viaje.getOrigen());
            pstmt.setString(2, viaje.getDestino());
            pstmt.setInt(3, Integer.parseInt(viaje.getPrecio()));
            pstmt.setString(4, setFechaString(Calendar.getInstance()));
            pstmt.setString(5, viaje.getHoraDeInicio());
            pstmt.setString(6, viaje.getCliente().getIdentificacion());
            pstmt.setString(7, viaje.getChofer().getDni());
            pstmt.setString(8, viaje.getAuto().getPatente());
            pstmt.setInt(9, Integer.parseInt(viaje.getSucursal().getNumero()));
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            logger.addHandler(getArchivoLog());
            logger.log(Level.SEVERE, SQLException.class.getName(), e.getMessage());
        }
        logger.exiting(getClass().getName(), getNombreMetodo());
    }

    public void insertarViajeRendicion(CRendicion rendicion) {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        String sql = "INSERT INTO Rendicion(IdViaje, costoEfectivo, costoTestigo, IdEmpleado) VALUES(?,?,?,?)";
        try (Connection conn = super.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, Integer.parseInt(rendicion.getViajeNumero()));
            pstmt.setInt(2, Integer.parseInt(rendicion.getCostoEfectivo()));
            pstmt.setDouble(3, Double.parseDouble((rendicion.getCostoTestigo())));
            pstmt.setInt(4, Integer.parseInt(rendicion.getRecepcionista().getDni()));
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            logger.addHandler(getArchivoLog());
            logger.log(Level.SEVERE, SQLException.class.getName(), e.getMessage());
        }
        logger.exiting(getClass().getName(), getNombreMetodo());
    }

    public void insertarEmpleadoClavePass(CUsuario usuario) {
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        logger.entering(getClass().getName(), getNombreMetodo());
        String sql = "INSERT INTO Usuario (NombreUsuario, password) VALUES(?,?)";
        try (Connection conn = super.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getClave());
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            logger.addHandler(getArchivoLog());
            logger.log(Level.SEVERE, SQLException.class.getName(), e.getMessage());
        }
        logger.exiting(getClass().getName(), getNombreMetodo());
    }

    @Override
    public Calendar calcularTiempo() {
        return null;
    }

    @Override
    public String setFechaYHora() {
        return null;
    }

}