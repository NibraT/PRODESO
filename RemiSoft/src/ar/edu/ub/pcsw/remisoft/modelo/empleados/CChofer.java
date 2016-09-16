package ar.edu.ub.pcsw.remisoft.modelo.empleados;

import java.util.Calendar;

public abstract class CChofer extends CEmpleado {

    private String turno;

    public CChofer(String nombre, String apellido, int dni, String domicilio, Calendar fechaDeAlta,
                   Calendar fechaDeBaja, String turno) {
        super(nombre, apellido, dni, domicilio, fechaDeAlta, fechaDeBaja);
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setDni(dni);
        this.setDomicilio(domicilio);
        this.setFechaDeAlta(fechaDeAlta);
        this.setFechaDeBaja(fechaDeBaja);
        this.setTurno(turno);
    }

    public String getTurno() {
        return this.turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

}
