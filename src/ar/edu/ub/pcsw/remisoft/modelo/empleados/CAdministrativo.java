package ar.edu.ub.pcsw.remisoft.modelo.empleados;

import java.util.Calendar;

public class CAdministrativo extends CEmpleado {

    public CAdministrativo(String nombre, String apellido, int dni, String domicilio, Calendar fechaDeAlta,
                           Calendar fechaDeBaja) {
        super(nombre, apellido, dni, domicilio, fechaDeAlta, fechaDeBaja);
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setDni(dni);
        this.setDomicilio(domicilio);
        this.setFechaDeAlta(fechaDeAlta);
        this.setFechaDeBaja(fechaDeBaja);
    }

}
