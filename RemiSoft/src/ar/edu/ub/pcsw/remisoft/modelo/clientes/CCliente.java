package ar.edu.ub.pcsw.remisoft.modelo.clientes;

import ar.edu.ub.pcsw.remisoft.modelo.cuentas.CCuenta;

import java.util.Calendar;
import java.util.List;

public class CCliente {

        private String domicilio;
        private String telefono;
        private Calendar fechaDeAlta;
        private Calendar fechaDeBaja;
        private List<CCuenta> cuentas;

        public CCliente(String domicilio, String telefono) {
        this.setDomicilio(domicilio);
        this.setTelefono(telefono);
        }

        public CCliente(String domicilio, String telefono, Calendar fechaDeAlta, Calendar fechaDeBaja, List<CCuenta> cuentas) {
            this.setDomicilio(domicilio);
            this.setTelefono(telefono);
            this.setFechaDeAlta(fechaDeAlta);
            this.setFechaDeBaja(fechaDeBaja);
            this.setCuenta(cuentas);
        }

        public List<CCuenta> agregarCuenta(CCuenta cuenta) {
            return null;
        }

        public void quitarCuenta() {

        }

        public String getDomicilio() {
            return this.domicilio;
        }

        public void setDomicilio(String domicilio) {
            this.domicilio = domicilio;
        }

        public String getTelefono() {
            return this.telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
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

        public List<CCuenta> getCuenta() {
            return this.cuentas;
        }

        public void setCuenta(List<CCuenta> cuentas) {
            this.cuentas = cuentas;
        }

        public String toString() {
            return null;
        }

}
