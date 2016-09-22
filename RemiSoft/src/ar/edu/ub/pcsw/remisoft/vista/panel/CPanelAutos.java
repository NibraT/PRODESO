package ar.edu.ub.pcsw.remisoft.vista.panel;

import javax.swing.*;
import java.awt.*;

public class CPanelAutos extends JPanel {

    public CPanelAutos() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.GREEN);
        this.setBorder(BorderFactory.createEtchedBorder());
        JButton autosButton = new JButton("Autos");
        autosButton.setPreferredSize(new Dimension(100, 30));
        this.add(autosButton);
    }
}
