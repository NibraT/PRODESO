package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IPanelFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CPanelMenuViajes extends CPanelMenuBase {

    public CPanelMenuViajes() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(EColorPanel.VIAJES.getColor());
        this.setButtonUno(new CButtonSelectorPanel(new IPanelFactory() {
            @Override
            public JPanel crearPanel() {
                return new CPanelActividadTomarViaje();
            }
        }, "  " + ETextoButton.TOMARVIAJE.getTexto() + "  ", EToolTipTextTexto.ACTIVIDADTOMARVIAJE.getTexto()));
        this.getButtonUno().addActionListener(this);
        this.setButtonDos(new CButtonSelectorPanel(new IPanelFactory() {
            @Override
            public JPanel crearPanel() {
                return new CPanelActividadCancelarViaje();
            }
        }, ETextoButton.CANCELARVIAJE.getTexto(), EToolTipTextTexto.ACTIVIDADCANCELARVIAJE.getTexto()));
        this.getButtonDos().addActionListener(this);
        this.setButtonTres(new CButtonSelectorPanel(new IPanelFactory() {
            @Override
            public JPanel crearPanel() {
                return new CPanelActividadRendirViaje();
            }
        }, "  " + ETextoButton.RENDIRVIAJE.getTexto() + "  ", EToolTipTextTexto.ACTIVIDADRENDIRVIAJE.getTexto()));
        this.getButtonTres().addActionListener(this);
        this.add(Box.createHorizontalStrut(27));
        this.add(this.getButtonUno());
        this.add(Box.createVerticalStrut(125));
        this.add(this.getButtonDos());
        this.add(Box.createVerticalStrut(125));
        this.add(this.getButtonTres());
        this.add(Box.createVerticalStrut(125));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ((e.getSource().equals(getButtonUno())) || (e.getSource().equals(getButtonDos())) ||
                (e.getSource().equals(getButtonTres()))) {
            getFrameRemisoft().setearPanelActividad(((CButtonSelectorPanel)e.getSource()).getFactory().crearPanel());
        }
    }

}
