package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.frame.CFrameRemisoft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CPanelViajes extends JPanel implements ActionListener {

    private CButtonSelectorPanel viajesButton;

    public CPanelViajes() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.ORANGE);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setViajesButton(new CButtonSelectorPanel(new CPanelFactory(), ETextoButton.VIAJES.getTexto()));
        viajesButton.addActionListener(this);
        this.add(viajesButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getViajesButton())) {
            ((CFrameRemisoft)getParent().getParent().getParent().getParent().getParent()).setPanelMenu(((CButtonSelectorPanel)e.getSource()).getFactory().crearPanel(getViajesButton()));
        }
    }

    public CButtonSelectorPanel getViajesButton() {
        return this.viajesButton;
    }

    public void setViajesButton(CButtonSelectorPanel viajesButton) {
        this.viajesButton = viajesButton;
    }

}



