package ar.edu.ub.pcsw.remisoft.vista.panel;

import javax.swing.*;
import java.awt.*;

public class CPanelActividadClientes extends JPanel {

    public CPanelActividadClientes() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JButton altaClienteButton = new JButton("A DEFINIR");
        JButton bajaClienteButton = new JButton("A DEFINIR");
        altaClienteButton.setPreferredSize(new Dimension(100, 30));
        bajaClienteButton.setPreferredSize(new Dimension(100, 30));
        this.add(Box.createHorizontalStrut(35));
        this.add(altaClienteButton);
        this.add(Box.createVerticalStrut(150));
        this.add(bajaClienteButton);
        this.add(Box.createVerticalStrut(200));
    }

}
