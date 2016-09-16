package ar.edu.ub.pcsw.remisoft.modelo.empleados;

import ar.edu.ub.pcsw.remisoft.modelo.vehiculos.CVehiculo;

import java.util.Calendar;

public class CChoferConVehiculo extends CChofer {

    private CVehiculo vehiculo;

    public CChoferConVehiculo(String nombre, String apellido, int dni, String domicilio, Calendar fechaDeAlta,
                              Calendar fechaDeBaja, String turno, CVehiculo vehiculo) {
        super(nombre, apellido, dni, domicilio, fechaDeAlta, fechaDeBaja, turno);
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setDni(dni);
        this.setDomicilio(domicilio);
        this.setFechaDeAlta(fechaDeAlta);
        this.setFechaDeBaja(fechaDeBaja);
        this.setTurno(turno);
        this.setVehiculo(vehiculo);
    }

    public CVehiculo getVehiculo() {
        return this.vehiculo;
    }

    public void setVehiculo(CVehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

}
