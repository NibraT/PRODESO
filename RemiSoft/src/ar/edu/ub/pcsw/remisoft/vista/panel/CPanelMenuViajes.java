package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.frame.CFrameRemisoft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CPanelMenuViajes extends JPanel implements ActionListener {

    private CButtonSelectorPanel tomarViajeButton;
    private CButtonSelectorPanel rendirViajeButton;

    public CPanelMenuViajes() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.ORANGE);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setTomarViajeButton(new CButtonSelectorPanel(new CPanelFactory(), ETextoButton.TOMARVIAJE.getTexto()));
        tomarViajeButton.addActionListener(this);
        this.setRendirViajeButton(new CButtonSelectorPanel(new CPanelFactory(), ETextoButton.RENDIRVIAJE.getTexto()));
        rendirViajeButton.addActionListener(this);
        this.add(Box.createHorizontalStrut(35));
        this.add(tomarViajeButton);
        this.add(Box.createVerticalStrut(150));
        this.add(rendirViajeButton);
        this.add(Box.createVerticalStrut(200));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getTomarViajeButton())) {
            ((CFrameRemisoft)getParent().getParent().getParent().getParent().getParent()).setPanelActividad(((CButtonSelectorPanel)e.getSource()).getFactory().crearPanel(getTomarViajeButton()));
        }
        else if (e.getSource().equals(getRendirViajeButton())) {
            ((CFrameRemisoft)getParent().getParent().getParent().getParent().getParent()).setPanelActividad(((CButtonSelectorPanel)e.getSource()).getFactory().crearPanel(getRendirViajeButton()));
        }
    }

    public CButtonSelectorPanel getTomarViajeButton() {
        return this.tomarViajeButton;
    }

    public void setTomarViajeButton(CButtonSelectorPanel tomarViajeButton) {
        this.tomarViajeButton = tomarViajeButton;
    }

    public CButtonSelectorPanel getRendirViajeButton() {
        return this.rendirViajeButton;
    }

    public void setRendirViajeButton(CButtonSelectorPanel rendirViajeButton) {
        this.rendirViajeButton = rendirViajeButton;
    }

}
