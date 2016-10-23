package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IFrameRemisoft;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IPanelFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CPanelClientes extends JPanel implements IFrameRemisoft {

    public CPanelClientes() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(EColorPanel.CLIENTES.getColor());
        this.setBorder(BorderFactory.createEtchedBorder());
        CButtonSelectorPanel clientesButton = new CButtonSelectorPanel(new IPanelFactory() {
            @Override
            public JPanel crearPanel() {
                return new CPanelMenuClientes();
            }
        }, ETextoButton.CLIENTES.getTexto(), EToolTipTextTexto.MENUCLIENTES.getTexto());
        clientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(clientesButton)) {
                    // método default de IFrameRemisoft
                    getFrameRemisoft().setearPanelMenu(((CButtonSelectorPanel)e.getSource()).getFactory().crearPanel());
                }
            }
        });
        this.add(clientesButton);
    }

}
