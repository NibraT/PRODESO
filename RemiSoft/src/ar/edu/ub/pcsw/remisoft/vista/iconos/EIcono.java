package ar.edu.ub.pcsw.remisoft.vista.iconos;

import java.awt.Color;

public enum EIcono {

    //enums se declaran según el orden con el cual se desea mostrarlos
    MAPAS("src/data/googlemaps-icon2.png", 4, "https://www.google.com.ar/maps", "Mapas", Color.BLUE),
    TRANSITO("src/data/trafficjam-icon.png", 17, "http://servicios.lanacion.com.ar/transito", "Estado del Tránsito", Color.BLUE),
    GUIATELEFONICA("src/data/phonebook-icon.png", 17, "http://guias.telecom.com.ar/", "Guía Telefónica", Color.BLUE),
    CORREOELECTRONICO("src/data/email-icon.png", 17, "https://www.google.com.ar", "Email", Color.BLUE),
    AUXILIOMECANICO("src/data/acaLogo.jpg", 20, "http://www.aca.org.ar/", "Auxilio Mecánico", Color.BLUE),
    EMERGENCIAMEDICA("src/data/emergenciasMedicasLogo.jpg", 5, "http://www.emergencias.com.ar/", "Emergencia Médica", Color.BLUE),
    POLICIA("src/data/policiaPBALogo.jpg", 5, "http://www.pol.gba.gov.ar/", "Policía", Color.BLUE),
    BOMBEROS("src/data/bomberosLogo.jpg", 7, "http://www.bomberosra.org.ar/ta-provincias/buenos-aires/page/4", "Bomberos", Color.BLUE),
    CORREOPOSTAL("src/data/correoargentino-icon.jpg", 5, "http://www.correoargentino.com.ar/", "Correo", Color.BLUE),
    CALENDARIO("src/data/calendar-icon.png", 9, "http://www.cuandoenelmundo.com", "Calendario", Color.CYAN),
    SERVICIOMETEOROLOGICO("src/data/weather-icon.png", 9, "http://www.smn.gov.ar", "Clima", Color.CYAN);

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
