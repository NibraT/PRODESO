package ar.edu.ub.pcsw.remisoft.modelo.clientes;

import ar.edu.ub.pcsw.remisoft.modelo.cuentas.CCuenta;
import ar.edu.ub.pcsw.remisoft.modelo.interfaces.ITemporizable;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class CCliente implements ITemporizable {

    private String domicilio;
    private String identificacion;
    private String nombreYApellidoORazonSocial;
    private String telefono;
    private String fechaDeAlta;
    private String fechaDeBaja;
    private List<CCuenta> cuentasActivas;
    private List<CCuenta> cuentasBloqueadas;

    public CCliente(String nombreYApellidoORazonSocial, String identificacion, String domicilio, String telefono) {
        this.setNombreYApellidoORazonSocial(nombreYApellidoORazonSocial);
        this.setIdentificacion(identificacion);
        this.setDomicilio(domicilio);
        this.setTelefono(telefono);
        this.setFechaDeAlta(setFechaYHora());
        this.cuentasActivas = new LinkedList<>();
        this.cuentasBloqueadas = new LinkedList<>();
        this.agregarCuenta(this.activarCuenta(), cuentasActivas);
    }

    public CCuenta activarCuenta() {
       return new CCuenta();
    }

    public void agregarCuenta(CCuenta cuenta) {
        cuentasActivas.add(cuenta);
    }

    public void agregarCuenta(CCuenta cuenta, List<CCuenta> cuentas) {
        cuentas.add(cuenta);
    }

    public void eliminarCuenta(String numero) {
        for (CCuenta cuenta : this.getCuentasActivas()) {
            if (cuenta.getNumero().equals(numero)) {
                cuentasActivas.remove(cuenta);
                cuentasBloqueadas.remove(cuenta);
            }
        }
    }

    public Calendar calcularTiempo() {
        return null;
    }

    public String getDomicilio() {
            return this.domicilio;
        }

    public void setDomicilio(String domicilio) {
            this.domicilio = domicilio;
        }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombreYApellidoORazonSocial() {
        return this.nombreYApellidoORazonSocial;
    }

    public void setNombreYApellidoORazonSocial(String nombreYApellidoORazonSocial) {
        this.nombreYApellidoORazonSocial = nombreYApellidoORazonSocial;
    }

    public String getTelefono() {
            return this.telefono;
        }

    public void setTelefono(String telefono) {
            this.telefono = telefono;
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

    /*public List<CCuenta> getCuenta() {
            return this.cuentas;
        }

    public void setCuenta(List<CCuenta> cuentas) {
            this.cuentas = cuentas;
        }*/

    public List<CCuenta> getCuentasActivas() {
        return this.cuentasActivas;
    }

    public void setCuentasActivas(List<CCuenta> cuentasActivas) {
        this.cuentasActivas = cuentasActivas;
    }

    public List<CCuenta> getCuentasBloqueadas() {
        return cuentasBloqueadas;
    }

    public void setCuentasBloqueadas(List<CCuenta> cuentasBloqueadas) {
        this.cuentasBloqueadas = cuentasBloqueadas;
    }

    public String mostrarCuentasActivas() {
        String cuentas = "";
        for (CCuenta cuenta : this.getCuentasActivas()) {
            cuentas += "" + cuenta + "\n      ";
        }
        cuentas = cuentas.isEmpty() ? "El cliente sólo tiene cuenta/s bloqueada/s." : cuentas;
        return cuentas;
    }

    public String mostrarCuentasBloqueadas() {
        String cuentas = "";
        for (CCuenta cuenta : this.getCuentasBloqueadas()) {
            cuentas += "" + cuenta + "\n      ";
        }
        cuentas = cuentas.isEmpty() ? "El cliente no tiene cuenta/s bloqueada/s." : cuentas;
        return cuentas;
    }

    public String toString() {
        return "Cliente: " + "\n Nombre: " + this.getNombreYApellidoORazonSocial() + "\n ID: " +
                this.getIdentificacion() + "\n Domicilio: " + this.getDomicilio() + "\n Tel.: " +
                this.getTelefono() + "\n Alta: " + this.getFechaDeAlta() + "\n Ctas. Activas: " +
                this.mostrarCuentasActivas() + "\n Ctas. Bloqueadas: " + this.mostrarCuentasBloqueadas();
    }

}
