package ar.edu.ub.pcsw.remisoft.modelo.sucursales;

import ar.edu.ub.pcsw.remisoft.modelo.clientes.CCliente;
import ar.edu.ub.pcsw.remisoft.modelo.empleados.CEmpleado;
import ar.edu.ub.pcsw.remisoft.modelo.vehiculos.CVehiculo;
import ar.edu.ub.pcsw.remisoft.modelo.viajes.CViaje;

import java.util.LinkedList;
import java.util.List;

public class CSucursal {

    private List<CCliente> clientes;
    private List<CEmpleado> empleados;
    private List<CVehiculo> vehiculos;
    private List<CViaje> viajes;
    private String fechaDeAlta;
    private String fechaDeBaja;
    private String domicilio;
    private String numero;

    /*
    Constructor
     */
    public CSucursal() {
        this(null, null, null, null);
    }

    /*
    Constructor
     */
    public CSucursal(String numero, String domicilio, String fechaDeAlta, String fechaDeBaja) {
        this.setNumero(numero);
        this.setDomicilio(domicilio);
        this.setClientes(new LinkedList<>());
        this.setEmpleados(new LinkedList<>());
        this.setVehiculos(new LinkedList<>());
        this.setViajes(new LinkedList<>());
        this.setFechaDeAlta(fechaDeAlta);
        this.setFechaDeBaja(fechaDeBaja);
    }

    public List<CCliente> getClientes() {
        return this.clientes;
    }

    public void setClientes(List<CCliente> clientes) {
        this.clientes = clientes;
    }

    public List<CEmpleado> getEmpleados() {
        return this.empleados;
    }

    public void setEmpleados(List<CEmpleado> empleados) {
        this.empleados = empleados;
    }

    public List<CVehiculo> getVehiculos() {
        return this.vehiculos;
    }

    public void setVehiculos(List<CVehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public List<CViaje> getViajes() { return this.viajes; }

    public void setViajes(List<CViaje> viajes) { this.viajes = viajes; }

    public String getFechaDeAlta() {
        return this.fechaDeAlta;
    }

    public void setFechaDeAlta(String fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    public String getFechaDeBaja() {
        return this.fechaDeBaja;
    }

    public void setFechaDeBaja(String fechaDeBaja) {
        this.fechaDeBaja = fechaDeBaja;
    }

    public String getDomicilio() {
        return this.domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String toString() {
        return null;
    }

}
