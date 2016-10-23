package ar.edu.ub.pcsw.remisoft.modelo.rendiciones;

import ar.edu.ub.pcsw.remisoft.modelo.empleados.CEmpleado;

public class CRendicion {

    private CEmpleado recepcionista;
    private String costoEfectivo;
    private String costoTestigo;
    private String fecha;
    private String numero;
    private String viajeNumero;
    public static int NUMERODERENDICION = 1;

    /*
    Constructor
     */
    public CRendicion() {
        this(null, null, null, null, null);
    }

    /*
    Constructor
     */
    public CRendicion(String fecha, CEmpleado recepcionista, String viajeNumero, String costoEfectivo,
                      String costoTestigo) {
        this.setNumero(String.valueOf(NUMERODERENDICION++));
        this.setFecha(fecha);
        this.setRecepcionista(recepcionista);
        this.setViajeNumero(viajeNumero);
        this.setCostoEfectivo(costoEfectivo);
        this.setCostoTestigo(costoTestigo);
    }

    public String getCostoEfectivo() { return this.costoEfectivo; }

    public void setCostoEfectivo(String costoEfectivo) { this.costoEfectivo = costoEfectivo; }

    public String getCostoTestigo() { return this.costoTestigo; }

    public void setCostoTestigo(String costoTestigo) { this.costoTestigo = costoTestigo; }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public CEmpleado getRecepcionista() {
        return this.recepcionista;
    }

    public void setRecepcionista(CEmpleado recepcionista) {
        this.recepcionista = recepcionista;
    }

    public String getViajeNumero() { return this.viajeNumero; }

    public void setViajeNumero(String viajeNumero) { this.viajeNumero = viajeNumero; }

    public String toString() {
        return "Fecha: " + this.getFecha() + "\n Viaje Número: " + this.getViajeNumero() +
                "\n Costo Efectivo: " + this.getCostoEfectivo() +
                "\n Recepcionista: " + this.getRecepcionista().getDni() +
                "\n Numero: " + this.getNumero();
    }

}
