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
    AUXILIOMECANICO("Auxilio Mecánico"),
    BOMBEROS("Bomberos"),
    CALENDARIO("Calendario"),
    CORREOELECTRONICO("Email"),
    CORREOPOSTAL("Correo"),
    CUENTAADICIONAL("Acepte 0 o Ingrese número de 1 a 4"),
    EMERGENCIAMEDICA("Emergencia Médica"),
    FECHA("Ingrese la fecha con formato DD/MM/AAAA"),
    GUARDAR("Habilita Guardar la Actividad"),
    GUIATELEFONICA("Guía Telefónica"),
    HORA("Ingrese la hora con formato 00:00"),
    MANUALTECNICO("Manual Técnico"),
    MAPAS("Mapas"),
    MENUAUTOS("Habilita Menú Autos"),
    MENUCLIENTES("Habilita Menú Clientes"),
    MENUEMPLEADOS("Habilita Menú Empleados"),
    MENUREPORTES("Habilita Menú Reportes"),
    MENUVIAJES("Habilita Menú Viajes"),
    POLICIA("Policía"),
    SALIRACTIVIDAD("Habilita Salir de la Actividad"),
    SELECCIONAR("Seleccione "),
    SERVICIOMETEOROLOGICO("Clima"),
    SOLOLETRAS("Ingrese sólo letras y espacios en blanco"),
    SOLOLETRASYNUMEROS("Ingrese sólo letras, números y espacios en blanco"),
    SOLONUMEROS("Ingrese sólo números sin espacios en blanco"),
    TRANSITO("Estado del Tránsito");

    private String texto;

    EToolTipTextTexto(String texto) {
        this.setTexto(texto);
    }

    public String getTexto() { return this.texto; }

    public void setTexto(String texto) { this.texto = texto; }

}

