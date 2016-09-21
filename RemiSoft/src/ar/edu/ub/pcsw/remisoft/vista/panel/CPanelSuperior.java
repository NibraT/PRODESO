package ar.edu.ub.pcsw.remisoft.vista.panel;

import javax.swing.*;

public class CPanelSuperior extends JPanel {

    public CPanelSuperior() {
        this.inicializar();
    }

    private void inicializar() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(new CPanelTiempos());
        this.add(new CPanelIconos());
    }

}
