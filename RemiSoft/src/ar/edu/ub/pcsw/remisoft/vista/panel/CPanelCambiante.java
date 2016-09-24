package ar.edu.ub.pcsw.remisoft.vista.panel;

import javax.swing.*;

public class CPanelCambiante extends JPanel{

    public void cambiarPanel(JPanel nuevoPanel) {
        if (getComponents().length > 0) {
            this.remove(0);
        }
        this.add(nuevoPanel);
    }

}
