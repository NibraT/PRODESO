package ar.edu.ub.pcsw.remisoft.modelo.clientes;

import ar.edu.ub.pcsw.remisoft.modelo.cuentas.CCuenta;
import ar.edu.ub.pcsw.remisoft.modelo.interfaces.ITemporizable;

import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CCliente implements ITemporizable {

    private List<CCuenta> cuentasActivas;
    private List<CCuenta> cuentasBloqueadas;
    private String causaBaja;
    private String domicilio;
    private String fechaDeAlta;
    private String fechaDeBaja;
    private String identificacion;
    private String nombreYApellidoORazonSocial;
    private String telefono;

    /*
    Constructor
     */
    public CCliente() {
        this(null, null, null, null);
    }

    /*
    Constructor.
     */
    public CCliente(String nombreYApellidoORazonSocial, String identificacion, String domicilio, String telefono) {
        this.setNombreYApellidoORazonSocial(nombreYApellidoORazonSocial);
        this.setIdentificacion(identificacion);
        this.setDomicilio(domicilio);
        this.setTelefono(telefono);
        this.setFechaDeAlta(setFechaYHora());
        this.cuentasActivas = new LinkedList<>();
        this.cuentasBloqueadas = new LinkedList<>();
        this.agregarCuenta(this.abrirCuenta(), this.getCuentasActivas());
    }

    public CCuenta abrirCuenta() {
       return new CCuenta(this);
    }

    public void agregarCuenta(CCuenta cuenta, List<CCuenta> cuentas) {
        cuentas.add(cuenta);
    }

    /*
    Método que traspasa una cuenta del listado de cuentas activas
      al listado de cuentas bloqueadas si el saldo de la cuenta iguala o excede
      el saldo máximo prefijado.
     */
    public void bloquearCuenta() {
        if (! getCuentasActivas().isEmpty()) {
            Iterator<CCuenta> itrCuentas = cuentasActivas.iterator();
            while (itrCuentas.hasNext()) {
                CCuenta cuenta = itrCuentas.next();
                if (cuenta.getSaldo() >= CCuenta.getLimiteSaldo()) {
                    itrCuentas.remove();
                    agregarCuenta(cuenta, cuentasBloqueadas);
                }
            }
        }
    }

    /*
    Método que traspasa una cuenta del listado de cuentas bloqueadas
      al listado de cuentas activas si el saldo de la cuenta es menor
      al saldo máximo prefijado.
     */
    public void desbloquearCuenta() {
        if (! getCuentasBloqueadas().isEmpty()) {
            Iterator<CCuenta> itrCuentas = cuentasBloqueadas.iterator();
            while (itrCuentas.hasNext()) {
                CCuenta cuenta = itrCuentas.next();
                if (cuenta.getSaldo() < CCuenta.getLimiteSaldo()) {
                    itrCuentas.remove();
                    agregarCuenta(cuenta, cuentasActivas);
                }
            }
        }
    }

    public String getCausaBaja() { return this.causaBaja; }

    public void setCausaBaja(String causaBaja) { this.causaBaja = causaBaja; }

    public String getDomicilio() {
        return this.domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getIdentificacion() {
        return this.identificacion;
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

    public List<CCuenta> getCuentasActivas() {
        return this.cuentasActivas;
    }

    public void setCuentasActivas(List<CCuenta> cuentasActivas) {
        this.cuentasActivas = cuentasActivas;
    }

    public List<CCuenta> getCuentasBloqueadas() {
        return this.cuentasBloqueadas;
    }

    public void setCuentasBloqueadas(List<CCuenta> cuentasBloqueadas) {
        this.cuentasBloqueadas = cuentasBloqueadas;
    }

    /*
    Método que muestra el listado de cuentas activas.
     */
    public String mostrarCuentasActivas() {
        String cuentas = "";
        for (CCuenta cuenta : getCuentasActivas()) {
            cuentas += "" + cuenta + "\n      ";
        }
        cuentas = cuentas.isEmpty() ? "El cliente sólo tiene cuenta/s bloqueada/s.\n" : cuentas;
        return cuentas;
    }

    /*
    Método que muestra el listado de cuentas bloqueadas.
     */
    public String mostrarCuentasBloqueadas() {
        String cuentas = "";
        for (CCuenta cuenta : getCuentasBloqueadas()) {
            cuentas += "" + cuenta + "\n      ";
        }
        cuentas = cuentas.isEmpty() ? "El cliente no tiene cuenta/s bloqueada/s.\n" : cuentas;
        return cuentas;
    }

    public String toString() {
        return "Cliente: " + "\n Nombre: " + this.getNombreYApellidoORazonSocial() + "\n ID: " +
                this.getIdentificacion() + "\n Domicilio: " + this.getDomicilio() + "\n Tel.: " +
                this.getTelefono() + "\n Alta: " + this.getFechaDeAlta() + "\n Ctas. Activas:\n      " +
                this.mostrarCuentasActivas() + "\n Ctas. Bloqueadas:\n      " + this.mostrarCuentasBloqueadas();
    }

    public Calendar calcularTiempo() {
        return null;
    }

}
