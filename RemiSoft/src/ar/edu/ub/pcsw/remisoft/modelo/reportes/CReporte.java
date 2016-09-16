package ar.edu.ub.pcsw.remisoft.modelo.reportes;

import ar.edu.ub.pcsw.remisoft.modelo.sucursales.CSucursal;

import java.util.Calendar;

public class CReporte {

    private String titulo;
    private String tipo;
    private String autor;
    private int numero;
    private CSucursal sucursal;
    private Calendar fecha;

    public CReporte(String titulo, String tipo, String autor, int numero, CSucursal sucursal, Calendar fecha) {
        this.setTitulo(titulo);
        this.setTipo(tipo);
        this.setAutor(autor);
        this.setNumero(numero);
        this.setSucursal(sucursal);
        this.setFecha(fecha);
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public CSucursal getSucursal() {
        return this.sucursal;
    }

    public void setSucursal(CSucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Calendar getFecha() {
        return this.fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public String toString() {
        return null;
    }

}
