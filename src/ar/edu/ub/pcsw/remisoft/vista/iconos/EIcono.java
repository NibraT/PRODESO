package ar.edu.ub.pcsw.remisoft.vista.iconos;

public enum EIcono {

    AUXILIOMECANICO("src/data/acaLogo.jpg", 20, "http://www.aca.org.ar/"),
    BOMBEROS("src/data/bomberosLogo.jpg", 7, "http://www.bomberosra.org.ar/ta-provincias/buenos-aires/page/4"),
    CALENDARIO("src/data/calendar-icon.png", 9, "http://www.cuandoenelmundo.com"),
    CORREOELECTRONICO("src/data/email-icon.png", 17, "https://www.google.com.ar"),
    CORREOPOSTAL("src/data/correoargentino-icon.jpg", 5, "http://www.correoargentino.com.ar/"),
    EMERGENCIAMEDICA("src/data/emergenciasMedicasLogo.jpg", 5, "http://www.emergencias.com.ar/"),
    GUIATELEFONICA("src/data/phonebook-icon.png", 17, "http://guias.telecom.com.ar/"),
    MAPAS("src/data/googlemaps-icon2.png", 4, "https://www.google.com.ar/maps"),
    POLICIA("src/data/policiaPBALogo.jpg", 5, "http://www.pol.gba.gov.ar/"),
    SERVICIOMETEOROLOGICO("src/data/weather-icon.png", 9, "http://www.smn.gov.ar"),
    TRANSITO("src/data/trafficjam-icon.png", 17, "http://servicios.lanacion.com.ar/transito");

    private int reduccion;
    private String ubicacion;
    private String url;

    EIcono(String path, int reduc, String url) {
        this.setUbicacion(path);
        this.setReduccion(reduc);
        this.setUrl(url);
    }

    public int getReduccion() {
        return this.reduccion;
    }

    public void setReduccion(int reduccion) {
        this.reduccion = reduccion;
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
