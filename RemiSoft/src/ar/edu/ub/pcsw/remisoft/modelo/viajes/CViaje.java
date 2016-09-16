package ar.edu.ub.pcsw.remisoft.modelo.viajes;

import ar.edu.ub.pcsw.remisoft.modelo.clientes.CCliente;
import ar.edu.ub.pcsw.remisoft.modelo.cuentas.CCuenta;
import ar.edu.ub.pcsw.remisoft.modelo.empleados.CEmpleado;
import ar.edu.ub.pcsw.remisoft.modelo.empleados.CAdministrativo;

import java.util.Calendar;

public class CViaje {

    private int numero;
    private CEmpleado chofer;
    private String destino;
    private float distancia;
    private int tramos;
    private Calendar duracion;
    private float precio;
    private float costo;
    private Calendar horaDeInicio;
    private Calendar horaDeFin;
    private CCliente cliente;
    private CCuenta cuenta;
    private CAdministrativo recepcionista;

    public CViaje(int numero, CEmpleado chofer, String destino, float distancia, int tramos, Calendar duracion, float precio,
                  float costo, Calendar horaDeInicio, Calendar horaDeFin, CCliente cliente, CCuenta cuenta,
                  CAdministrativo recepcionista) {
        this.setNumero(numero);
        this.setChofer(chofer);
        this.setDestino(destino);
        this.setDistancia(distancia);
        this.setTramos(tramos);
        this.setDuracion(duracion);
        this.setPrecio(precio);
        this.setCosto(costo);
        this.setHoraDeInicio(horaDeInicio);
        this.setHoraDeFin(horaDeFin);
        this.setCCliente(cliente);
        this.setCCuenta(cuenta);
        this.setRecepcionista(recepcionista);
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public CEmpleado getChofer() {
        return this.chofer;
    }

    public void setChofer(CEmpleado chofer) {
        this.chofer = chofer;
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

    public void setCCliente(CCliente cliente) {
        this.cliente = cliente;
    }

    public CCuenta getCuenta() {
        return this.cuenta;
    }

    public void setCCuenta(CCuenta cuenta) {
        this.cuenta = cuenta;
    }

    public CAdministrativo getRecepcionista() {
        return this.recepcionista;
    }

    public void setRecepcionista(CAdministrativo recepcionista) {
        this.recepcionista = recepcionista;
    }

    public String toString() {
        return null;
    }

}
