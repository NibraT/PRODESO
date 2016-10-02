package ar.edu.ub.pcsw.remisoft.modelo.empleados;

import ar.edu.ub.pcsw.remisoft.modelo.vehiculos.CVehiculo;

public class CChoferConVehiculo extends CChofer {

    private CVehiculo vehiculo;

    public CChoferConVehiculo() {
        this(null, null, null, null, null, null, null, null, null);
    }

    public CChoferConVehiculo(String nombre, String apellido, String dni, String domicilio, String telefono,
                              String turno, String fechaDeAlta, String fechaDeBaja, CVehiculo vehiculo) {
        super(nombre, apellido, dni, domicilio, telefono, turno, fechaDeAlta, fechaDeBaja);
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setDni(dni);
        this.setDomicilio(domicilio);
        this.setTelefono(telefono);
        this.setTurno(turno);
        this.setFechaDeAlta(fechaDeAlta);
        this.setFechaDeBaja(fechaDeBaja);
        this.setVehiculo(vehiculo);
    }

    public CVehiculo getVehiculo() {
        return this.vehiculo;
    }

    public void setVehiculo(CVehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

}
