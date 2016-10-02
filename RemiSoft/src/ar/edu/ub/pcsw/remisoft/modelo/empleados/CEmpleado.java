package ar.edu.ub.pcsw.remisoft.modelo.empleados;

public class CEmpleado {

    private String apellido;
    private String dni;
    private String domicilio;
    private String fechaDeAlta;
    private String fechaDeBaja;
    private String nombre;
    private String telefono;
    private String turno;

    public CEmpleado() {
        this(null, null, null, null, null, null, null, null);
    }

    public CEmpleado(String nombre, String apellido, String dni, String domicilio, String telefono, String turno,
                     String fechaDeAlta, String fechaDeBaja) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setDni(dni);
        this.setDomicilio(domicilio);
        this.setTelefono(telefono);
        this.setTurno(turno);
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

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDomicilio() {
        return this.domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() { return this.telefono; }

    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getTurno() {
        return this.turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

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

    public String toString() {
        return null;
    }

}
