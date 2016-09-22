package ar.edu.ub.pcsw.remisoft.vista.panel;

import javax.swing.*;
import java.awt.*;

public class CPanelMenuAutos extends JPanel {

    public CPanelMenuAutos() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.GREEN);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JButton altaVehiculoButton = new JButton("Alta Vehiculo");
        JButton bajaVehiculoButton = new JButton("Baja Vehiculo");
        altaVehiculoButton.setPreferredSize(new Dimension(100, 30));
        bajaVehiculoButton.setPreferredSize(new Dimension(100, 30));
        this.add(Box.createHorizontalStrut(35));
        this.add(altaVehiculoButton);
        this.add(Box.createVerticalStrut(150));
        this.add(bajaVehiculoButton);
        this.add(Box.createVerticalStrut(200));
    }

}
