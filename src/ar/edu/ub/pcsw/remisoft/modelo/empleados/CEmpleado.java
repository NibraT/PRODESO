package ar.edu.ub.pcsw.remisoft.modelo.empleados;

import java.util.Calendar;

public abstract class CEmpleado {

    private String nombre;
    private String apellido;
    private int dni;
    private String domicilio;
    private Calendar fechaDeAlta;
    private Calendar fechaDeBaja;

    public CEmpleado(String nombre, String apellido, int dni, String domicilio, Calendar fechaDeAlta,
                     Calendar fechaDeBaja) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setDni(dni);
        this.setDomicilio(domicilio);
        this.setFechaDeAlta(fechaDeAlta);
        this.setFechaDeBaja(fechaDeBaja);
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return this.dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getDomicilio() {
        return this.domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
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
