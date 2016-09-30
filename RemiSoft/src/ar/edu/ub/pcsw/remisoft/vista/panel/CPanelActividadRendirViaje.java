package ar.edu.ub.pcsw.remisoft.vista.panel;

import javax.swing.*;
import java.awt.*;

public class CPanelActividadRendirViaje extends JPanel {

    public CPanelActividadRendirViaje() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.ORANGE);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BorderLayout());
        JLabel rendirViajeLabel = new JLabel("RENDIR VIAJE", SwingConstants.CENTER);
        rendirViajeLabel.setPreferredSize(new Dimension(this.getWidth(), 100));
        rendirViajeLabel.setFont(new Font("Arial", Font.BOLD, 25));
        rendirViajeLabel.setForeground(Color.WHITE);
        this.add(rendirViajeLabel, BorderLayout.NORTH);
        JLabel surLabel = new JLabel();
        surLabel.setPreferredSize(new Dimension(this.getWidth(), 100));
        this.add(surLabel, BorderLayout.SOUTH);
    }

}
