package ar.edu.ub.pcsw.remisoft.modelo.vehiculos;

import java.util.Calendar;

public class CVehiculo {

    private String marca;
    private int modelo;
    private String patente;
    private String propietario;
    private Calendar fechaDeAlta;
    private Calendar fechaDeBaja;

    public CVehiculo(String marca, int modelo, String patente, String propietario, Calendar fechaDeAlta,
                     Calendar fechaDeBaja) {
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

    public int getModelo() {
        return this.modelo;
    }

    public void setModelo(int modelo) {
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

    public Calendar getFechaDeAlta() {
        return this.fechaDeAlta;
    }

    public void setFechaDeAlta(Calendar fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    public Calendar getFechaDeBaja() {
        return this.fechaDeBaja;
    }

    public void setFechaDeBaja(Calendar fechaDeBaja) {
        this.fechaDeBaja = fechaDeBaja;
    }

    public String toString() {
        return null;
    }

}
