package ar.edu.ub.pcsw.remisoft.modelo.empleados;

public abstract class CChofer extends CEmpleado {


    public CChofer(String nombre, String apellido, String dni, String domicilio, String telefono, String fechaDeAlta,
                   String fechaDeBaja, String turno) {
        super(nombre, apellido, dni, domicilio, telefono, turno, fechaDeAlta, fechaDeBaja);
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
