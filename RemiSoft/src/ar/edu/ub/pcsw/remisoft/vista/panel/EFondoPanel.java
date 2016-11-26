package ar.edu.ub.pcsw.remisoft.vista.panel;

public enum EFondoPanel {

    MAPAGARIN("RemiSoft/src/data/mapaGarin.jpg", 1100, 587),
    MAPAZONAGARIN("RemiSoft/src/data/mapaZonaGarin.jpg", 200, 587);

    private int alto;
    private int ancho;
    private String texto;

    EFondoPanel(String texto, int ancho, int alto) {
        this.setTexto(texto);
        this.setAncho(ancho);
        this.setAlto(alto);
    }

    public int getAlto() { return this.alto; }

    public void setAlto(int alto) { this.alto = alto; }

    public int getAncho() { return this.ancho; }

    public void setAncho(int ancho) { this.ancho = ancho; }

    public String getTexto() { return this.texto; }

    public void setTexto(String texto) { this.texto = texto; }

}
