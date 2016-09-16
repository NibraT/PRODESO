package ar.edu.ub.pcsw.remisoft.modelo.cuentas;

import ar.edu.ub.pcsw.remisoft.modelo.clientes.CCliente;

import java.util.Calendar;

public class CCuenta {

        private int numero;
        private CCliente cliente;
        private Calendar fechaDeAlta;
        private Calendar fechaDeBaja;
        private float saldo;

        public CCuenta(int numero, CCliente cliente, Calendar fechaDeAlta, Calendar fechaDeBaja, float saldo) {
            this.setNumero(numero);
            this.setCliente(cliente);
            this.setFechaDeAlta(fechaDeAlta);
            this.setFechaDeBaja(fechaDeBaja);
            this.setSaldo(saldo);
        }

        public float calcularSaldo() {
            return 0;
        }

        public void verSaldo() {

        }

        public int getNumero() {
            return this.numero;
        }

        public void setNumero(int numero) {
            this.numero = numero;
        }

        public CCliente getCliente() {
            return this.cliente;
        }

        public void setCliente(CCliente cliente) {
            this.cliente = cliente;
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

        public float getSaldo() {
            return this.saldo;
        }

        public void setSaldo(float saldo) {
            this.saldo = saldo;
        }

        public String toString() {
            return null;
        }

}


