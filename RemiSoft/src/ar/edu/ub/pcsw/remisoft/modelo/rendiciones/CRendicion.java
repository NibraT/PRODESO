package ar.edu.ub.pcsw.remisoft.modelo.rendiciones;

import ar.edu.ub.pcsw.remisoft.modelo.empleados.CEmpleado;
import ar.edu.ub.pcsw.remisoft.modelo.viajes.CViaje;

import java.util.Calendar;

public class CRendicion {

    private Calendar fecha;
    private CEmpleado recepcionista;
    private CViaje viaje;
    private String numero;
    private String precioTestigo;

    public CRendicion() {
        this(null, null, null, null, null);
    }

    public CRendicion(String numero, Calendar fecha, CEmpleado recepcionista, CViaje viaje, String precioTestigo) {
        this.setNumero(numero);
        this.setFecha(fecha);
        this.setRecepcionista(recepcionista);
        this.setViaje(viaje);
        this.setPrecioTestigo(precioTestigo);
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Calendar getFecha() {
        return this.fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public CEmpleado getRecepcionista() {
        return this.recepcionista;
    }

    public void setRecepcionista(CEmpleado recepcionista) {
        this.recepcionista = recepcionista;
    }

    public CViaje getViaje() {
        return this.viaje;
    }

    public void setViaje(CViaje viaje) {
        this.viaje = viaje;
    }

    public String getPrecioTestigo() {
        return this.precioTestigo;
    }

    public void setPrecioTestigo(String precioTestigo) {
        this.precioTestigo = precioTestigo;
    }

    public String toString() {
        return null;
    }

}
