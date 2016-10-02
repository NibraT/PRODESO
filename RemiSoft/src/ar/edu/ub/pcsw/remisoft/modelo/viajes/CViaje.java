package ar.edu.ub.pcsw.remisoft.modelo.viajes;

import ar.edu.ub.pcsw.remisoft.modelo.clientes.CCliente;
import ar.edu.ub.pcsw.remisoft.modelo.cuentas.CCuenta;
import ar.edu.ub.pcsw.remisoft.modelo.empleados.CEmpleado;
import ar.edu.ub.pcsw.remisoft.modelo.interfaces.ITemporizable;
import ar.edu.ub.pcsw.remisoft.modelo.vehiculos.CVehiculo;

import java.util.Calendar;

public class CViaje implements ITemporizable {

    private int numero;
    private CEmpleado chofer;
    private CVehiculo auto;
    private String origen;
    private String destino;
    private float distancia;
    private int tramos;
    private Calendar duracion;
    private float precio;
    private float costo;
    private Calendar fecha;
    private Calendar horaDeInicio;
    private Calendar horaDeFin;
    private CCliente cliente;
    private CCuenta cuenta;
    private CEmpleado recepcionista;    private String motivoCancelacion;

    /*
    Constructor
     */
    public CViaje() {
        this(0, null, null, null, null, 0, 0, null, 0, 0, null, null, null, null, null, null, null);
    }

    /*
    Constructor
     */
    public CViaje(int numero, CEmpleado chofer, CVehiculo auto, String origen, String destino, float distancia, int tramos,
                  Calendar duracion, float precio, float costo, Calendar fecha, Calendar horaDeInicio, Calendar horaDeFin,
                  CCliente cliente, CCuenta cuenta, CEmpleado recepcionista, String motivoCancelacion) {
        this.setNumero(numero);
        this.setChofer(chofer);
        this.setAuto(auto);
        this.setOrigen(origen);
        this.setDestino(destino);
        this.setDistancia(distancia);
        this.setTramos(tramos);
        this.setDuracion(duracion);
        this.setPrecio(precio);
        this.setCosto(costo);
        this.setFecha(fecha);
        this.setHoraDeInicio(horaDeInicio);
        this.setHoraDeFin(horaDeFin);
        this.setCliente(cliente);
        this.setCuenta(cuenta);
        this.setRecepcionista(recepcionista);
        this.setMotivoCancelacion(motivoCancelacion);
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public CEmpleado getChofer() { return this.chofer; }

    public void setChofer(CEmpleado chofer) {
        this.chofer = chofer;
    }

    public String getOrigen() {
        return this.origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return this.destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public float getDistancia() {
        return this.distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public int getTramos() {
        return this.tramos;
    }

    public void setTramos(int tramos) {
        this.tramos = tramos;
    }

    public Calendar getDuracion() {
        return this.duracion;
    }

    public void setDuracion(Calendar duracion) {
        this.duracion = duracion;
    }

    public float getPrecio() {
        return this.precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getCosto() {
        return this.costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public Calendar getHoraDeInicio() {
        return this.horaDeInicio;
    }

    public void setHoraDeInicio(Calendar horaDeInicio) {
        this.horaDeInicio = horaDeInicio;
    }

    public Calendar getHoraDeFin() {
        return this.horaDeFin;
    }

    public void setHoraDeFin(Calendar horaDeFin) {
        this.horaDeFin = horaDeFin;
    }

    public CCliente getCliente() {
        return this.cliente;
    }

    public void setCliente(CCliente cliente) {
        this.cliente = cliente;
    }

    public CCuenta getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(CCuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Calendar getFecha() {
        return fecha;
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

    public CVehiculo getAuto() {
        return this.auto;
    }

    public void setAuto(CVehiculo auto) {
        this.auto = auto;
    }

    public String getMotivoCancelacion() { return this.motivoCancelacion; }

    public void setMotivoCancelacion(String motivoCancelacion) { this.motivoCancelacion = motivoCancelacion; }

    public String toString() {
        //String fecha = this.setFechaString(this.getFecha());
        //String hora = this.setHoraString(this.getHoraDeInicio());
        return "Origen: " + this.getOrigen() + "\n Destino: " + this.getDestino() +
                "\n Cliente DNI: " + this.getCliente().getIdentificacion() + "\n Cuenta: " +
                this.getCliente().getCuentasActivas().get(0).getNumero() +
                "\n Patente: " + this.getAuto().getPatente() + "\n Chofer: " + this.getChofer().getDni() +
                "\n Recepcionista: " + this.getRecepcionista().getDni()  + "\n Fecha: " + this.getFecha() +
                "\n Hora: " + this.getHoraDeInicio();
    }

    @Override
    public Calendar calcularTiempo() {
        return null;
    }

    @Override
    public String setFechaYHora() {
        return null;
    }

}

