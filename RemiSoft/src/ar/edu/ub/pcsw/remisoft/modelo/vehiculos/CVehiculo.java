package ar.edu.ub.pcsw.remisoft.modelo.vehiculos;

public class CVehiculo {

    private String aseguradora;
    private String causaBaja;
    private String consumo;
    private String fechaDeAlta;
    private String fechaDeBaja;
    private String kilometraje;
    private String marca;
    private String modelo;
    private String patente;

    /*
    Constructor
     */
    public CVehiculo() {
        this(null, null, null, null, null, null, null, null, null);
    }

    /*
    Constructor
     */
    public CVehiculo(String marca, String modelo, String patente, String aseguradora, String kilometraje,
                     String consumo, String fechaDeAlta, String fechaDeBaja, String causaBaja) {
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setPatente(patente);
        this.setAseguradora(aseguradora);
        this.setKilometraje(kilometraje);
        this.setConsumo(consumo);
        this.setFechaDeAlta(fechaDeAlta);
        this.setFechaDeBaja(fechaDeBaja);
        this.setCausaBaja(causaBaja);
    }

    public String getAseguradora() { return this.aseguradora; }

    public void setAseguradora(String aseguradora) { this.aseguradora = aseguradora; }

    public String getCausaBaja() { return this.causaBaja; }

    public void setCausaBaja(String causaBaja) { this.causaBaja = causaBaja; }

    public String getConsumo() { return this.consumo; }

    public void setConsumo(String consumo) { this.consumo = consumo; }

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

    public String getKilometraje() { return this.kilometraje; }

    public void setKilometraje(String kilometraje) { this.kilometraje = kilometraje; }

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

    public String toString() {
        return "Marca: " + this.getMarca() + "\nModelo: " + this.getModelo() +
                "\nPatente: " + this.getPatente() + "\nAseguradora: " + this.getAseguradora() +
                "\nKilometraje: " + this.getKilometraje() + "\nConsumo: " + this.getConsumo() +
                "\nFecha de alta: " + this.getFechaDeAlta();
    }

}