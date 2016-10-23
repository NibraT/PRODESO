package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IFrameRemisoft;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IPanelFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CPanelViajes extends JPanel implements IFrameRemisoft {

    public CPanelViajes() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(EColorPanel.VIAJES.getColor());
        this.setBorder(BorderFactory.createEtchedBorder());
        CButtonSelectorPanel viajesButton = new CButtonSelectorPanel(new IPanelFactory() {
            @Override
            public JPanel crearPanel() {
                return new CPanelMenuViajes();
            }
        }, ETextoButton.VIAJES.getTexto(), EToolTipTextTexto.MENUVIAJES.getTexto());
        viajesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(viajesButton)) {
                    // método default de IFrameRemisoft
                    getFrameRemisoft().setearPanelMenu(((CButtonSelectorPanel)e.getSource()).getFactory().crearPanel());
                }
            }
        });
        this.add(viajesButton);
    }

}



