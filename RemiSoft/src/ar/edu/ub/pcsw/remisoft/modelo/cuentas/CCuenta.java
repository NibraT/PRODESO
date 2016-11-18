package ar.edu.ub.pcsw.remisoft.modelo.cuentas;

import ar.edu.ub.pcsw.remisoft.modelo.clientes.CCliente;
import ar.edu.ub.pcsw.remisoft.modelo.interfaces.ITemporizable;

import java.util.Calendar;

public class CCuenta implements ITemporizable {

    private CCliente cliente;
    private double saldo;
    private String fechaDeAlta;
    private String fechaDeBaja;
    private String numero;
    private final static double SALDO_MAXIMO = 1000.0;

    /*
    Constructor.
     */
    public CCuenta(CCliente cliente) {
        this.setNumero(asignarNumeroDeCuenta());
        this.setCliente(cliente);
        this.setFechaDeAlta(this.setFechaYHora());
    }

    /*
    Método que asigna un número de cuenta al azar.
     */
    private String asignarNumeroDeCuenta() {
        Integer numero = 0;
        numero = (int)(Math.random() * 1000);
        return numero.toString();
    }

    public double calcularSaldo() {
        return 0;
    }

    public void verSaldo() {
    }

    public Calendar calcularTiempo() {
        return null;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public CCliente getCliente() {
        return this.cliente;
    }

    public void setCliente(CCliente cliente) {
        this.cliente = cliente;
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

    public static double getLimiteSaldo() {
        return SALDO_MAXIMO;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String toString() {
            return " Nro.: " + this.getNumero() + "\n       Alta: " + this.getFechaDeAlta() +
                    "\n       Saldo Actual: " + this.getSaldo() + "\n       Saldo Límite: " + CCuenta.getLimiteSaldo();
    }

}