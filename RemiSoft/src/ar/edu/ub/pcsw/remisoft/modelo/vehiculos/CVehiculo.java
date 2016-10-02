package ar.edu.ub.pcsw.remisoft.modelo.vehiculos;

public class CVehiculo {

    private String fechaDeAlta;
    private String fechaDeBaja;
    private String marca;
    private String modelo;
    private String patente;
    private String propietario;

    /*
    Constructor
     */
    public CVehiculo() {
        this(null, null, null, null, null, null);
    }

    /*
    Constructor
     */

    public CVehiculo(String marca, String modelo, String patente, String propietario, String fechaDeAlta,
                     String fechaDeBaja) {

        this.setMarca(marca);
        this.setModelo(modelo);
        this.setPatente(patente);
        this.setPropietario(propietario);
        this.setFechaDeAlta(fechaDeAlta);
        this.setFechaDeBaja(fechaDeBaja);
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPatente() {
        return this.patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getPropietario() {
        return this.propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
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
        return "Marca: " + this.getMarca() + "\nModelo: " + this.getModelo() +
                "\nPatente: " + this.getPatente() + "\nPropietario: " + this.getPropietario();
    }

}
