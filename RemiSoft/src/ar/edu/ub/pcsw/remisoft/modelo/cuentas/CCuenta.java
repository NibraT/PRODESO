package ar.edu.ub.pcsw.remisoft.modelo.cuentas;

import ar.edu.ub.pcsw.remisoft.modelo.clientes.CCliente;
import ar.edu.ub.pcsw.remisoft.modelo.interfaces.ITemporizable;

import java.util.Calendar;

public class CCuenta implements ITemporizable {

    private String numero;
    private CCliente cliente;
    private String fechaDeAlta;
    private String fechaDeBaja;
    private double saldo;
    private final static double SALDO_MAXIMO = 1000.0;

    public CCuenta() {
        this.setNumero(asignarNumeroDeCuenta());
        this.setFechaDeAlta(this.setFechaYHora());
        this.setSaldo(SALDO_MAXIMO);
    }

    public CCuenta(String numero, String fechaDeAlta, float saldo) {
        this.setNumero(numero);
        this.setFechaDeAlta(fechaDeAlta);
        this.setSaldo(saldo);
    }

    public CCuenta(String numero, String fechaDeAlta, String fechaDeBaja, float saldo) {
        this.setNumero(numero);
        this.setFechaDeAlta(fechaDeAlta);
        this.setFechaDeBaja(fechaDeBaja);
        this.setSaldo(saldo);
    }

    public String asignarNumeroDeCuenta() {
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
                    "\n       Saldo Limite: " + this.getSaldo();
        }

}


