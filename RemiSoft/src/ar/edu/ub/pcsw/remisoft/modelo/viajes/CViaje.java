package ar.edu.ub.pcsw.remisoft.modelo.viajes;

import ar.edu.ub.pcsw.remisoft.modelo.clientes.CCliente;
import ar.edu.ub.pcsw.remisoft.modelo.cuentas.CCuenta;
import ar.edu.ub.pcsw.remisoft.modelo.empleados.CEmpleado;
import ar.edu.ub.pcsw.remisoft.modelo.interfaces.ITemporizable;
import ar.edu.ub.pcsw.remisoft.modelo.sucursales.CSucursal;
import ar.edu.ub.pcsw.remisoft.modelo.vehiculos.CVehiculo;

import java.util.Calendar;

public class CViaje implements ITemporizable {

    private Calendar duracion;
    private CCliente cliente;
    private CCuenta cuenta;
    private CEmpleado chofer;
    private CEmpleado recepcionista;
    private CSucursal sucursal;
    private CVehiculo auto;
    private float costo;
    private float distancia;
    private int tramos;
    private String destino;
    private String fecha;
    private String horaDeFin;
    private String horaDeInicio;
    private String motivoCancelacion;
    private String numero;
    private String origen;
    private String precio;
    public static int numeroDeViaje = 1;

    /*
    Constructor
     */
    public CViaje() {
        this(null, null, null, null, 0, 0, null, null, 0, null, null, null, null, null, null, null, null);
    }

    /*
    Constructor
     */
    public CViaje(CEmpleado chofer, CVehiculo auto, String origen, String destino, float distancia,
                  int tramos, Calendar duracion, String precio, float costo, String fecha, String horaDeInicio,
                  String horaDeFin, CCliente cliente, CCuenta cuenta, CEmpleado recepcionista, CSucursal sucursal,
                  String motivoCancelacion) {
        this.setNumero(String.valueOf(numeroDeViaje++));
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
        this.setSucursal(sucursal);
        this.setMotivoCancelacion(motivoCancelacion);
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
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

    public String getPrecio() {
        return this.precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public float getCosto() {
        return this.costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getHoraDeInicio() {
        return this.horaDeInicio;
    }

    public void setHoraDeInicio(String horaDeInicio) {
        this.horaDeInicio = horaDeInicio;
    }

    public String getHoraDeFin() {
        return this.horaDeFin;
    }

    public void setHoraDeFin(String horaDeFin) {
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public CEmpleado getRecepcionista() {
        return this.recepcionista;
    }

    public void setRecepcionista(CEmpleado recepcionista) {
        this.recepcionista = recepcionista;
    }

    public CSucursal getSucursal() { return this.sucursal; }

    public void setSucursal(CSucursal sucursal) { this.sucursal = sucursal; }

    public CVehiculo getAuto() {
        return this.auto;
    }

    public void setAuto(CVehiculo auto) {
        this.auto = auto;
    }

    public String getMotivoCancelacion() { return this.motivoCancelacion; }

    public void setMotivoCancelacion(String motivoCancelacion) { this.motivoCancelacion = motivoCancelacion; }

    public String toString() {
        return "Cliente ID: " + this.getCliente().getIdentificacion() + "\n Cuenta: " +
                this.getCliente().getCuentasActivas().get(0).getNumero() +
                "\n Chofer: " + this.getChofer().getDni() + "\n Patente: " + this.getAuto().getPatente() +
                "\n Origen: " + this.getOrigen() + "\n Destino: " + this.getDestino() +
                "\n Fecha: " + this.getFecha() + "\n Hora: " + this.getHoraDeInicio() +
                "\n Precio: " + this.getPrecio() + "\n Recepcionista: " + this.getRecepcionista().getDni() +
                "\n Numero: " + this.getNumero() + "\n Sucursal: " + this.getSucursal().getNumero();
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