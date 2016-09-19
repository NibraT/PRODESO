package ar.edu.ub.pcsw.remisoft.vista.panel;

import javax.swing.*;
import java.awt.*;

public class CPanelMenuAutos extends JPanel {

    public CPanelMenuAutos() {
        this.setLocation(100, 100);
        this.setBackground(Color.GREEN);
        this.setBorder(BorderFactory.createEtchedBorder());
        JButton altaAutoButton = new JButton("Alta Auto");
        JButton bajaAutoButton = new JButton("Baja Auto");
        this.add(altaAutoButton);
        this.add(bajaAutoButton);
    }
}
