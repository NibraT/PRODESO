package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.frame.CFrameRemisoft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CPanelMenuClientes extends JPanel implements ActionListener {

    private CButtonSelectorPanel altaClienteButton;
    private CButtonSelectorPanel bajaClienteButton;

    public CPanelMenuClientes() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setAltaClienteButton(new CButtonSelectorPanel(new CPanelFactory(), ETextoButton.ALTACLIENTE.getTexto()));
        altaClienteButton.addActionListener(this);
        this.setBajaClienteButton(new CButtonSelectorPanel(new CPanelFactory(), ETextoButton.BAJACLIENTE.getTexto()));
        bajaClienteButton.addActionListener(this);
        this.add(Box.createHorizontalStrut(40));
        this.add(altaClienteButton);
        this.add(Box.createVerticalStrut(150));
        this.add(bajaClienteButton);
        this.add(Box.createVerticalStrut(200));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getAltaClienteButton())) {
            ((CFrameRemisoft)getParent().getParent().getParent().getParent().getParent()).setPanelActividad(((CButtonSelectorPanel)e.getSource()).getFactory().crearPanel(getAltaClienteButton()));
        }
        else if (e.getSource().equals(getBajaClienteButton())) {
            ((CFrameRemisoft)getParent().getParent().getParent().getParent().getParent()).setPanelActividad(((CButtonSelectorPanel)e.getSource()).getFactory().crearPanel(getBajaClienteButton()));
        }
    }

    public CButtonSelectorPanel getAltaClienteButton() {
        return this.altaClienteButton;
    }

    public void setAltaClienteButton(CButtonSelectorPanel altaClienteButton) {
        this.altaClienteButton = altaClienteButton;
    }

    public CButtonSelectorPanel getBajaClienteButton() {
        return this.bajaClienteButton;
    }

    public void setBajaClienteButton(CButtonSelectorPanel bajaClienteButton) {
        this.bajaClienteButton = bajaClienteButton;
    }

}
