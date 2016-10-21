package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IFrameRemisoft;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IPanelFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CPanelViajes extends JPanel implements ActionListener, IFrameRemisoft {

    private CButtonSelectorPanel viajesButton;

    public CPanelViajes() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.ORANGE);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setViajesButton(new CButtonSelectorPanel(new IPanelFactory() {
            @Override
            public JPanel crearPanel() {
                return new CPanelMenuViajes();
            }
        }, ETextoButton.VIAJES.getTexto(), EToolTipTextTexto.MENUVIAJES.getTexto()));
        this.getViajesButton().addActionListener(this);
        this.add(this.getViajesButton());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getViajesButton())) {
            getFrameRemisoft().setPanelMenu(((CButtonSelectorPanel)e.getSource()).getFactory().crearPanel());
        }
    }

    public CButtonSelectorPanel getViajesButton() {
        return this.viajesButton;
    }

    public void setViajesButton(CButtonSelectorPanel viajesButton) {
        this.viajesButton = viajesButton;
    }

}



