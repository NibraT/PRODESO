package ar.edu.ub.pcsw.remisoft.modelo.sucursales;

import ar.edu.ub.pcsw.remisoft.modelo.clientes.CCliente;
import ar.edu.ub.pcsw.remisoft.modelo.empleados.CEmpleado;
import ar.edu.ub.pcsw.remisoft.modelo.vehiculos.CVehiculo;

import java.util.Calendar;
import java.util.List;

public class CSucursal {

    private int numero;
    private String domicilio;
    private List<CCliente> clientes;
    private List<CEmpleado> empleados;
    private List<CVehiculo> vehiculos;
    private Calendar fechaDeAlta;
    private Calendar fechaDeBaja;

    public CSucursal(int numero, String domicilio, List<CCliente> clientes, List<CEmpleado> empleados, List<CVehiculo> vehiculos,
                     Calendar fechaDeAlta, Calendar fechaDeBaja) {
        this.setNumero(numero);
        this.setDomicilio(domicilio);
        this.setClientes(clientes);
        this.setEmpleados(empleados);
        this.setVehiculos(vehiculos);
        this.setFechaDeAlta(fechaDeAlta);
        this.setFechaDeBaja(fechaDeBaja);
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDomicilio() {
        return this.domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
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

    public Calendar getFechaDeAlta() {
        return this.fechaDeAlta;
    }

    public void setFechaDeAlta(Calendar fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    public Calendar getFechaDeBaja() {
        return this.fechaDeBaja;
    }

    public void setFechaDeBaja(Calendar fechaDeBaja) {
        this.fechaDeBaja = fechaDeBaja;
    }

    public String toString() {
        return null;
    }

}
