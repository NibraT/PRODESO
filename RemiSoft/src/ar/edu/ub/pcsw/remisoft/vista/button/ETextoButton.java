package ar.edu.ub.pcsw.remisoft.vista.button;

public enum ETextoButton {

    ALTAAUTO("Alta Auto"),
    ALTACLIENTE("Alta Cliente"),
    ALTAEMPLEADO("Alta Empleado"),
    AUTOS("Autos"),
    BAJAAUTO("Baja Auto"),
    BAJACLIENTE("Baja Cliente"),
    BAJAEMPLEADO("Baja Empleado"),
    CANCELARVIAJE("Cancelar Viaje"),
    CLIENTES("Clientes"),
    EMPLEADOS("Empleados"),
    RENDIRVIAJE("Rendir Viaje"),
    REPORTEFINANCIERO("Financiero"),
    REPORTEOPERATIVO("Operativo"),
    REPORTES("Reportes"),
    SALIR("Salir"),
    TOMARVIAJE("Tomar Viaje"),
    VIAJES("Viajes");

    private String texto;

    ETextoButton(String texto) {
        this.setTexto(texto);
    }

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

}
