package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;

import javax.swing.*;
import java.awt.*;

public class CPanelActividadAltaEmpleado extends JPanel {

    public CPanelActividadAltaEmpleado() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.MAGENTA);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BorderLayout());
        JButton altaEmpleadoButton = new JButton(ETextoButton.ALTAEMPLEADO.getTexto());
        altaEmpleadoButton.setPreferredSize(new Dimension(100, 30));
        this.add(altaEmpleadoButton, BorderLayout.NORTH);
        this.add(Box.createVerticalStrut(100));
    }

}
