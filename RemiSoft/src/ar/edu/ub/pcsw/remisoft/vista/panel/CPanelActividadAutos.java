package ar.edu.ub.pcsw.remisoft.vista.panel;

import javax.swing.*;
import java.awt.*;

public class CPanelActividadAutos extends JPanel {

    public CPanelActividadAutos() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.GREEN);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JButton altaVehiculoButton = new JButton("A DEFINIR");
        JButton bajaVehiculoButton = new JButton("A DEFINIR");
        altaVehiculoButton.setPreferredSize(new Dimension(100, 30));
        bajaVehiculoButton.setPreferredSize(new Dimension(100, 30));
        this.add(Box.createHorizontalStrut(35));
        this.add(altaVehiculoButton);
        this.add(Box.createVerticalStrut(150));
        this.add(bajaVehiculoButton);
        this.add(Box.createVerticalStrut(200));
    }

}
