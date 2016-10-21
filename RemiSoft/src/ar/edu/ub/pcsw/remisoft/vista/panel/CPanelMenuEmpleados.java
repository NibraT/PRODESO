package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IPanelFactory;

import javax.swing.*;
import java.awt.*;

public class CPanelMenuEmpleados extends CPanelMenuBase {

    public CPanelMenuEmpleados() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.MAGENTA);
        this.setButtonUno(new CButtonSelectorPanel(new IPanelFactory() {
            @Override
            public JPanel crearPanel() {
                return new CPanelActividadAltaEmpleado();
            }
        }, ETextoButton.ALTAEMPLEADO.getTexto(), EToolTipTextTexto.ACTIVIDADALTAEMPLEADO.getTexto()));
        this.getButtonUno().addActionListener(this);
        this.setButtonDos(new CButtonSelectorPanel(new IPanelFactory() {
            @Override
            public JPanel crearPanel() {
                return new CPanelActividadBajaEmpleado();
            }
        }, ETextoButton.BAJAEMPLEADO.getTexto(), EToolTipTextTexto.ACTIVIDADBAJAEMPLEADO.getTexto()));
        this.getButtonDos().addActionListener(this);
        this.add(Box.createHorizontalStrut(25));
        this.add(getButtonUno());
        this.add(Box.createVerticalStrut(150));
        this.add(getButtonDos());
        this.add(Box.createVerticalStrut(200));
    }

}
