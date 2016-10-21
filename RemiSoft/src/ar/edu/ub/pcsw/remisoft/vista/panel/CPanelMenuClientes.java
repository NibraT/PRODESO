package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IPanelFactory;

import javax.swing.*;
import java.awt.*;

public class CPanelMenuClientes extends CPanelMenuBase {

    public CPanelMenuClientes() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.GRAY);
        this.setButtonUno(new CButtonSelectorPanel(new IPanelFactory() {
            @Override
            public JPanel crearPanel() {
                return new CPanelActividadAltaCliente();
            }
        }, ETextoButton.ALTACLIENTE.getTexto(), EToolTipTextTexto.ACTIVIDADALTACLIENTE.getTexto()));
        this.getButtonUno().addActionListener(this);
        this.setButtonDos(new CButtonSelectorPanel(new IPanelFactory() {
            @Override
            public JPanel crearPanel() {
                return new CPanelActividadBajaCliente();
            }
        }, ETextoButton.BAJACLIENTE.getTexto(), EToolTipTextTexto.ACTIVIDADBAJACLIENTE.getTexto()));
        this.getButtonDos().addActionListener(this);
        this.add(Box.createHorizontalStrut(40));
        this.add(this.getButtonUno());
        this.add(Box.createVerticalStrut(150));
        this.add(this.getButtonDos());
        this.add(Box.createVerticalStrut(200));
    }

}
