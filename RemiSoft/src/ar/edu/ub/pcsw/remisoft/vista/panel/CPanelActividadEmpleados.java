package ar.edu.ub.pcsw.remisoft.vista.panel;

import javax.swing.*;
import java.awt.*;

public class CPanelActividadEmpleados extends JPanel {

    public CPanelActividadEmpleados() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.MAGENTA);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JButton altaEmpleadoButton = new JButton("A DEFINIR");
        JButton bajaEmpleadoButton = new JButton("A DEFINIR");
        altaEmpleadoButton.setPreferredSize(new Dimension(100, 30));
        bajaEmpleadoButton.setPreferredSize(new Dimension(100, 30));
        this.add(Box.createHorizontalStrut(35));
        this.add(altaEmpleadoButton);
        this.add(Box.createVerticalStrut(150));
        this.add(bajaEmpleadoButton);
        this.add(Box.createVerticalStrut(200));
    }

}
