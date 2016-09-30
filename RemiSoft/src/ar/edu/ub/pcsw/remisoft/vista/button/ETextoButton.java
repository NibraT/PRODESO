package ar.edu.ub.pcsw.remisoft.vista.button;

public enum ETextoButton {

    ALTAAUTO("Alta Auto"),
    ALTACLIENTE("Alta Cliente"),
    ALTAEMPLEADO("Alta Empleado"),
    AUTOS("Autos"),
    BAJAAUTO("Baja Auto"),
    BAJACLIENTE("Baja Cliente"),
    BAJAEMPLEADO("Baja Empleado"),
    CLIENTES("Clientes"),
    EMPLEADOS("Empleados"),
    RENDIRVIAJE("Rendir Viaje"),
    REPORTECAJA("Reporte Caja"),
    REPORTEGESTION("Reporte Gestión"),
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
