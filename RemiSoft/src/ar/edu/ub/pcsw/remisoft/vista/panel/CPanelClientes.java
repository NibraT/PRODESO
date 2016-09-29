package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.frame.CFrameRemisoft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CPanelClientes extends JPanel implements ActionListener {

    private CButtonSelectorPanel clientesButton;

    public CPanelClientes() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setClientesButton(new CButtonSelectorPanel(new CPanelFactory(), ETextoButton.CLIENTES.getTexto()));
        this.getClientesButton().addActionListener(this);
        this.add(getClientesButton());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getClientesButton())) {
            ((CFrameRemisoft)getParent().getParent().getParent().getParent().getParent()).setPanelMenu(((CButtonSelectorPanel)e.getSource()).getFactory().crearPanel(getClientesButton()));
        }
    }

    public CButtonSelectorPanel getClientesButton() {
        return this.clientesButton;
    }

    public void setClientesButton(CButtonSelectorPanel clientesButton) {
        this.clientesButton = clientesButton;
    }

}
