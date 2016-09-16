package ar.edu.ub.pcsw.remisoft.modelo.rendiciones;

import ar.edu.ub.pcsw.remisoft.modelo.empleados.CAdministrativo;
import ar.edu.ub.pcsw.remisoft.modelo.viajes.CViaje;

import java.util.Calendar;

public class CRendicion {

    private int numero;
    private Calendar fecha;
    private CAdministrativo recepcionista;
    private CViaje viaje;
    private float precioTestigo;

    public CRendicion(int numero, Calendar fecha, CAdministrativo recepcionista, CViaje viaje, float precioTestigo) {
        this.setNumero(numero);
        this.setFecha(fecha);
        this.setRecepcionista(recepcionista);
        this.setViaje(viaje);
        this.setPrecioTestigo(precioTestigo);
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Calendar getFecha() {
        return this.fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public CAdministrativo getRecepcionista() {
        return this.recepcionista;
    }

    public void setRecepcionista(CAdministrativo recepcionista) {
        this.recepcionista = recepcionista;
    }

    public CViaje getViaje() {
        return this.viaje;
    }

    public void setViaje(CViaje viaje) {
        this.viaje = viaje;
    }

    public float getPrecioTestigo() {
        return this.precioTestigo;
    }

    public void setPrecioTestigo(float precioTestigo) {
        this.precioTestigo = precioTestigo;
    }

    public String toString() {
        return null;
    }

}
