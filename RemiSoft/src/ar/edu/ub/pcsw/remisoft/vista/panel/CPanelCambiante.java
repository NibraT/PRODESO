package ar.edu.ub.pcsw.remisoft.vista.panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CPanelCambiante extends JPanel{

    public CPanelCambiante(JPanel ... paneles) {
        JPanel panelCambiante = this;
        this.setLayout(new CardLayout());
        for (JPanel panel : paneles) {
            panel.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    CardLayout cardLayout = (CardLayout) panelCambiante.getLayout();
                    cardLayout.next(panelCambiante);
                }
            });
            this.add(panel);
        }
    }

}
