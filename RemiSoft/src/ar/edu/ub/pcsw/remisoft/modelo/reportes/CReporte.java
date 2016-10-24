package ar.edu.ub.pcsw.remisoft.modelo.reportes;

import ar.edu.ub.pcsw.remisoft.modelo.sucursales.CSucursal;

public class CReporte {

    private CSucursal sucursal;
    private int numero;
    private String autor;
    private String fecha;
    private String tipo;
    private String titulo;

    /*
    Constructor
     */
    public CReporte() {
        this(null, null, null, 0, null, null);
    }

    /*
    Constructor
     */
    public CReporte(String titulo, String tipo, String autor, int numero, CSucursal sucursal, String fecha) {
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

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String toString() {
        return null;
    }

}
