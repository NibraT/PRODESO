package ar.edu.ub.pcsw.remisoft.vista.iconos;

import ar.edu.ub.pcsw.remisoft.vista.panel.EToolTipTextTexto;

import java.awt.*;

public enum EIcono {

    //enums se declaran según el orden con el cual se desea mostrarlos
    MAPAS("RemiSoft/src/data/googlemaps-icon2.png", 4, "https://www.google.com.ar/maps", EToolTipTextTexto.MAPAS.getTexto(),
            Color.WHITE),
    TRANSITO("RemiSoft/src/data/trafficjam-icon.png", 17, "http://servicios.lanacion.com.ar/transito",
            EToolTipTextTexto.TRANSITO.getTexto(), Color.WHITE),
    GUIATELEFONICA("RemiSoft/src/data/phonebook-icon.png", 17, "http://guias.telecom.com.ar/",
            EToolTipTextTexto.GUIATELEFONICA.getTexto(), Color.WHITE),
    CORREOELECTRONICO("RemiSoft/src/data/email-icon.png", 17, "https://www.google.com.ar",
            EToolTipTextTexto.CORREOELECTRONICO.getTexto(), Color.WHITE),
    AUXILIOMECANICO("RemiSoft/src/data/acaLogo.jpg", 20, "http://www.aca.org.ar/", EToolTipTextTexto.AUXILIOMECANICO.getTexto(),
            Color.WHITE),
    MANUALTECNICO("RemiSoft/src/data/logontic.jpg", 3, "http://localhost/nticmasters/",
            EToolTipTextTexto.MANUALTECNICO.getTexto(), Color.WHITE),
    EMERGENCIAMEDICA("RemiSoft/src/data/emergenciasMedicasLogo.jpg", 5, "http://localhost/prored/",
            EToolTipTextTexto.EMERGENCIAMEDICA.getTexto(), Color.WHITE),
    POLICIA("RemiSoft/src/data/policiaPBALogo.jpg", 5, "http://www.pol.gba.gov.ar/", EToolTipTextTexto.POLICIA.getTexto(),
            Color.WHITE),
    BOMBEROS("RemiSoft/src/data/bomberosLogo.jpg", 7, "http://www.bomberosra.org.ar/ta-provincias/buenos-aires/page/4",
            EToolTipTextTexto.BOMBEROS.getTexto(), Color.WHITE),
    CORREOPOSTAL("RemiSoft/src/data/correoargentino-icon.jpg", 5, "http://www.correoargentino.com.ar/",
            EToolTipTextTexto.CORREOPOSTAL.getTexto(), Color.WHITE),
    CALENDARIO("RemiSoft/src/data/calendar-icon.png", 9, "http://www.cuandoenelmundo.com",
            EToolTipTextTexto.CALENDARIO.getTexto(), Color.WHITE),
    SERVICIOMETEOROLOGICO("RemiSoft/src/data/weather-icon.png", 9, "http://www.smn.gov.ar",
            EToolTipTextTexto.SERVICIOMETEOROLOGICO.getTexto(), Color.WHITE);

    private int reduccion;
    private Color color;
    private String texto;
    private String ubicacion;
    private String url;

    EIcono(String path, int reduc, String url, String texto, Color color) {
        this.setUbicacion(path);
        this.setReduccion(reduc);
        this.setUrl(url);
        this.setTexto(texto);
        this.setColor(color);
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getReduccion() {
        return this.reduccion;
    }

    public void setReduccion(int reduccion) {
        this.reduccion = reduccion;
    }

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getUbicacion() {
        return this.ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
