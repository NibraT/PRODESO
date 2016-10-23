package ar.edu.ub.pcsw.remisoft.vista.panel;

import java.awt.*;

public class CPanelMenu extends CPanelCambiante {

    public CPanelMenu() {
        this.inicializar();
    }

    private void inicializar() {
        this.add(new CPanelFondo(EFondoPanel.MAPAZONAGARIN.getTexto(), EFondoPanel.MAPAZONAGARIN.getAncho(),
                EFondoPanel.MAPAZONAGARIN.getAlto()), BorderLayout.CENTER);
    }

}
