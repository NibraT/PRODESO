package ar.edu.ub.pcsw.remisoft.vista.panel;

import java.awt.*;

public enum EColorPanel {

    AUTOS(new Color(208, 230, 158)),
    CLIENTES(new Color(251, 210, 0)),
    EMPLEADOS(new Color(199, 209, 176)),
    ICONOS(new Color(36, 115, 142)),
    REPORTES(new Color(150, 180, 157)),
    TIEMPOS(new Color(169, 192, 204)),
    VIAJES(new Color(255, 126, 0));

    private Color color;

    EColorPanel(Color color) {
        this.setColor(color);
    }

    public Color getColor() { return this.color; }

    public void setColor(Color color) { this.color = color; }

}
