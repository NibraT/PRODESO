package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IFrameRemisoft;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IPanelFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CPanelMenuViajes extends JPanel implements ActionListener, IFrameRemisoft {

    private CButtonSelectorPanel cancelarViajeButton;
    private CButtonSelectorPanel rendirViajeButton;
    private CButtonSelectorPanel tomarViajeButton;


    public CPanelMenuViajes() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.ORANGE);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setCancelarViajeButton(new CButtonSelectorPanel(new IPanelFactory() {
            @Override
            public JPanel crearPanel() {
                return new CPanelActividadCancelarViaje();
            }
        }, ETextoButton.CANCELARVIAJE.getTexto(), "Habilita Actividad Cancelar Viaje"));
        this.getCancelarViajeButton().addActionListener(this);
        this.setTomarViajeButton(new CButtonSelectorPanel(new IPanelFactory() {
            @Override
            public JPanel crearPanel() {
                return new CPanelActividadTomarViaje();
            }
        }, ETextoButton.TOMARVIAJE.getTexto(), "Habilita Actividad Tomar Viaje"));
        this.getTomarViajeButton().addActionListener(this);
        this.setRendirViajeButton(new CButtonSelectorPanel(new IPanelFactory() {
            @Override
            public JPanel crearPanel() {
                return new CPanelActividadRendirViaje();
            }
        }, ETextoButton.RENDIRVIAJE.getTexto(), "Habilita Actividad Rendir Viaje"));
        this.getRendirViajeButton().addActionListener(this);
        this.add(Box.createHorizontalStrut(35));
        this.add(this.getTomarViajeButton());
        this.add(Box.createVerticalStrut(125));
        this.add(this.getCancelarViajeButton());
        this.add(Box.createVerticalStrut(125));
        this.add(this.getRendirViajeButton());
        this.add(Box.createVerticalStrut(125));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ((e.getSource().equals(getTomarViajeButton())) || (e.getSource().equals(getCancelarViajeButton())) ||
                (e.getSource().equals(getRendirViajeButton()))) {
            getFrameRemisoft().setPanelActividad(((CButtonSelectorPanel)e.getSource()).getFactory().crearPanel());
        }
    }

    public CButtonSelectorPanel getCancelarViajeButton() { return this.cancelarViajeButton; }

    public void setCancelarViajeButton(CButtonSelectorPanel cancelarViajeButton) {
        this.cancelarViajeButton = cancelarViajeButton;
    }

    public CButtonSelectorPanel getRendirViajeButton() {
        return this.rendirViajeButton;
    }

    public void setRendirViajeButton(CButtonSelectorPanel rendirViajeButton) {
        this.rendirViajeButton = rendirViajeButton;
    }

    public CButtonSelectorPanel getTomarViajeButton() {
        return this.tomarViajeButton;
    }

    public void setTomarViajeButton(CButtonSelectorPanel tomarViajeButton) {
        this.tomarViajeButton = tomarViajeButton;
    }

}
