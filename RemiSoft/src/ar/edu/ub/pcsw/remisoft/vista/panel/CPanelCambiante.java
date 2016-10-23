package ar.edu.ub.pcsw.remisoft.vista.panel;

import javax.swing.*;

public abstract class CPanelCambiante extends CPanelBase {

    public void cambiarPanel(JPanel nuevoPanel) {
        while (getComponents().length > 0) {
            this.remove(0);
        }
        if (nuevoPanel != null) {
            this.add(nuevoPanel);
        }
        else {
            this.add(new CPanelFondo(EFondoPanel.MAPAZONAGARIN.getTexto(), EFondoPanel.MAPAZONAGARIN.getAncho(),
                    EFondoPanel.MAPAZONAGARIN.getAlto()));
        }
    }

}
