package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.frame.CFrameRemisoft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CPanelViajes extends JPanel {

    public CPanelViajes() {
        this.setBackground(Color.ORANGE);
        this.setBorder(BorderFactory.createEtchedBorder());
        JButton viajesButton = new JButton("Viajes");
        this.add(viajesButton);
        viajesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CPanelMenuViajes panelMenuViajes = new CPanelMenuViajes();
                new CFrameRemisoft().add(panelMenuViajes);
            }
        });
    }

}
