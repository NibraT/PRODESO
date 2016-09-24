package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;

import javax.swing.*;
import java.awt.*;

public class CPanelActividadBajaEmpleado extends JPanel {

    public CPanelActividadBajaEmpleado() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.MAGENTA);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BorderLayout());
        JButton bajaEmpleadoButton = new JButton(ETextoButton.BAJAEMPLEADO.getTexto());
        bajaEmpleadoButton.setPreferredSize(new Dimension(100, 30));
        this.add(bajaEmpleadoButton, BorderLayout.SOUTH);
        this.add(Box.createVerticalStrut(100));
    }

}
