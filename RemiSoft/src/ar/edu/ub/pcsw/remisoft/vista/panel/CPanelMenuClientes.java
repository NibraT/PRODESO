package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IFrameRemisoft;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IPanelFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CPanelMenuClientes extends JPanel implements ActionListener, IFrameRemisoft {

    private CButtonSelectorPanel altaClienteButton;
    private CButtonSelectorPanel bajaClienteButton;

    public CPanelMenuClientes() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setAltaClienteButton(new CButtonSelectorPanel(new IPanelFactory() {
            @Override
            public JPanel crearPanel() {
                return new CPanelActividadAltaCliente();
            }
        }, ETextoButton.ALTACLIENTE.getTexto(), "Habilita Actividad Alta Cliente"));
        this.getAltaClienteButton().addActionListener(this);
        this.setBajaClienteButton(new CButtonSelectorPanel(new IPanelFactory() {
            @Override
            public JPanel crearPanel() {
                return new CPanelActividadBajaCliente();
            }
        }, ETextoButton.BAJACLIENTE.getTexto(), "Habilita Actividad Baja Cliente"));
        this.getBajaClienteButton().addActionListener(this);
        this.add(Box.createHorizontalStrut(40));
        this.add(this.getAltaClienteButton());
        this.add(Box.createVerticalStrut(150));
        this.add(this.getBajaClienteButton());
        this.add(Box.createVerticalStrut(200));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ((e.getSource().equals(getAltaClienteButton())) || (e.getSource().equals(getBajaClienteButton()))) {
            getFrameRemisoft().setPanelActividad(((CButtonSelectorPanel)e.getSource()).getFactory().crearPanel());
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
