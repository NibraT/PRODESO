package ar.edu.ub.pcsw.remisoft.vista.panel;

public enum EToolTipTextTexto {

    ACTIVIDADALTAAUTO("Habilita Actividad Alta Auto"),
    ACTIVIDADALTACLIENTE("Habilita Actividad Alta Cliente"),
    ACTIVIDADALTAEMPLEADO("Habilita Actividad Alta Empleado"),
    ACTIVIDADBAJAAUTO("Habilita Actividad Baja Auto"),
    ACTIVIDADBAJACLIENTE("Habilita Actividad Baja Cliente"),
    ACTIVIDADBAJAEMPLEADO("Habilita Actividad Baja Empleado"),
    ACTIVIDADCANCELARVIAJE("Habilita Actividad Cancelar Viaje"),
    ACTIVIDADRENDIRVIAJE("Habilita Actividad Rendir Viaje"),
    ACTIVIDADREPORTECAJA("Habilita Actividad Reporte Caja"),
    ACTIVIDADREPORTEGESTION("Habilita Actividad Reporte Gestión"),
    ACTIVIDADTOMARVIAJE("Habilita Actividad Tomar Viaje"),
    APELLIDOONOMBRE("Completar 2 a 20 posiciones ingresando sólo letras y espacios en blanco"),
    AUXILIOMECANICO("Auxilio Mecánico"),
    BOMBEROS("Bomberos"),
    CALENDARIO("Calendario"),
    CLAVE("Completar 8 a 12 posiciones ingresando al menos una letra minúscula, una letra mayúscula, un número entre " +
            "0 y 9 y un caracter de entre #$%_!&()"),
    CONSUMO("Completar 2 posiciones ingresando sólo un número entre 10 y 99"),
    CORREOELECTRONICO("Email"),
    CORREOPOSTAL("Correo"),
    CUENTAADICIONAL("Aceptar 0 o completar 1 posición ingresando sólo un número entre 1 y 4"),
    EMERGENCIAMEDICA("Emergencia Médica"),
    DNI("Completar 8 posiciones ingresando sólo un número entre 10000000 y 99999999"),
    DOMICILIO("Completar 2 a 35 posiciones ingresando una combinación de sólo letras, números, espacios en blanco y ()"),
    FECHA("Completar 8 ó 10 posiciones ingresando sólo números y / con formato D/M/AAAA o DD/MM/AAAA"),
    GUARDAR("Habilita Guardar la Actividad"),
    GUIATELEFONICA("Guía Telefónica"),
    HABILITARINGRESO("Habilita Campos para Completarlos"),
    HORA("Completar 4 ó 5 posiciones ingresando sólo números y : con formato 0:00 o 00:00"),
    IDENTIFICACION("Completar 8 a 11 posiciones ingresando sólo un número entre 10000000 y 99999999999"),
    KILOMETRAJE("Completar 1 a 6 posiciones ingresando sólo un número entre 0 y 999999"),
    MANUALTECNICO("Manual Técnico"),
    MAPAS("Mapas"),
    MARCA("Completar 2 a 25 posiciones ingresando una combinación de sólo letras, números y espacios en blanco"),
    MENUAUTOS("Habilita Menú Autos"),
    MENUCLIENTES("Habilita Menú Clientes"),
    MENUEMPLEADOS("Habilita Menú Empleados"),
    MENUREPORTES("Habilita Menú Reportes"),
    MENUVIAJES("Habilita Menú Viajes"),
    MODELO("Completar 2 a 25 posiciones ingresando una combinación de sólo letras, números y espacios en blanco"),
    NOMBREYAPELLIDOORAZONSOCIAL("Completar 2 a 40 posiciones ingresando sólo letras y espacios en blanco"),
    NUMEROVIAJE("Completar 1 a 5 posiciones ingresando sólo un número entre 1 y 99999"),
    PATENTE("Completar 7 ó 9 posiciones ingresando una combinación de letras, números y espacios en blanco con " +
            "formato LLL NNN o LL NNN LL"),
    POLICIA("Policía"),
    PRECIO("Completar 3 ó 4 posiciones ingresando sólo un número entre 100 y 9999"),
    SALIRACTIVIDAD("Habilita Salir de la Actividad"),
    SELECCIONAR("Seleccionar "),
    SERVICIOMETEOROLOGICO("Clima"),
    TELEFONO("Completar 8 ó 10 posiciones ingresando sólo un número entre 10000000 y 9999999999"),
    TRANSITO("Estado del Tránsito");

    private String texto;

    EToolTipTextTexto(String texto) {
        this.setTexto(texto);
    }

    public String getTexto() { return this.texto; }

    public void setTexto(String texto) { this.texto = texto; }

}