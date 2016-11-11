package ar.edu.ub.pcsw.remisoft.modelo.empleados;

public class CChoferSinVehiculo extends CChofer {

    public CChoferSinVehiculo() {
        this(null, null, null, null, null, null, null, null, null);
    }

    public CChoferSinVehiculo(String nombre, String apellido, String dni, String domicilio, String telefono,
                              String categoria, String turno, String fechaDeAlta, String fechaDeBaja) {
        super(nombre, apellido, dni, domicilio, telefono, categoria, turno, fechaDeAlta, fechaDeBaja);
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setDni(dni);
        this.setDomicilio(domicilio);
        this.setTelefono(telefono);
        this.setTurno(turno);
        this.setFechaDeAlta(fechaDeAlta);
        this.setFechaDeBaja(fechaDeBaja);
    }

}
