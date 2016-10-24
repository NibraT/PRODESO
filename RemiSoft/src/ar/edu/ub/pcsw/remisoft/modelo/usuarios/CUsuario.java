package ar.edu.ub.pcsw.remisoft.modelo.usuarios;

public class CUsuario {

    private String clave;
    private String nombre;

    /*
    Constructor
     */
    public CUsuario() {
        this(null, null);
    }

    /*
    Constructor
     */
    public CUsuario(String nombre, String clave) {
        this.setNombre(nombre);
        this.setClave(clave);
    }

    public String getClave() { return this.clave; }

    public void setClave(String clave) { this.clave = clave; }

    public String getNombre() { return this.nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

}
