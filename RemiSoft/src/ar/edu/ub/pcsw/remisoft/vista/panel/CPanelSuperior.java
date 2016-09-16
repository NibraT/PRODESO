package ar.edu.ub.pcsw.remisoft.vista.panel;

import javax.swing.*;
import java.awt.*;

public class CPanelSuperior extends JPanel {

    public CPanelSuperior() {
        this.setBackground(Color.cyan);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(new CPanelTiempos());
        this.add(new CPanelIconos());
    }

}
