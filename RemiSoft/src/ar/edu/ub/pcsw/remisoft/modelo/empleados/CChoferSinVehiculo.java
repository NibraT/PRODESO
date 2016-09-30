package ar.edu.ub.pcsw.remisoft.modelo.empleados;

import java.util.Calendar;

public class CChoferSinVehiculo extends CChofer {

    public CChoferSinVehiculo() {
        this(null, null, null, null, null, null, null, null);
    }

    public CChoferSinVehiculo(String nombre, String apellido, String dni, String domicilio, String telefono, String fechaDeAlta,
                              String fechaDeBaja, String turno) {
        super(nombre, apellido, dni, domicilio, telefono, fechaDeAlta, fechaDeBaja, turno);
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setDni(dni);
        this.setDomicilio(domicilio);
        this.setTelefono(telefono);
        this.setFechaDeAlta(fechaDeAlta);
        this.setFechaDeBaja(fechaDeBaja);
        this.setTurno(turno);
    }

}
