package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.frame.CFrameRemisoft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CPanelMenuAutos extends JPanel implements ActionListener {

    private CButtonSelectorPanel altaAutoButton;
    private CButtonSelectorPanel bajaAutoButton;

    public CPanelMenuAutos() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.GREEN);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setAltaAutoButton(new CButtonSelectorPanel(new CPanelFactory(), ETextoButton.ALTAAUTO.getTexto()));
        altaAutoButton.addActionListener(this);
        this.setBajaAutoButton(new CButtonSelectorPanel(new CPanelFactory(), ETextoButton.BAJAAUTO.getTexto()));
        bajaAutoButton.addActionListener(this);
        this.add(Box.createHorizontalStrut(35));
        this.add(altaAutoButton);
        this.add(Box.createVerticalStrut(150));
        this.add(bajaAutoButton);
        this.add(Box.createVerticalStrut(200));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getAltaAutoButton())) {
            ((CFrameRemisoft)getParent().getParent().getParent().getParent().getParent()).setPanelActividad(((CButtonSelectorPanel)e.getSource()).getFactory().crearPanel(getAltaAutoButton()));
        }
        else if (e.getSource().equals(getBajaAutoButton())) {
            ((CFrameRemisoft)getParent().getParent().getParent().getParent().getParent()).setPanelActividad(((CButtonSelectorPanel)e.getSource()).getFactory().crearPanel(getBajaAutoButton()));
        }
    }

    public CButtonSelectorPanel getAltaAutoButton() {
        return this.altaAutoButton;
    }

    public void setAltaAutoButton(CButtonSelectorPanel altaAutoButton) {
        this.altaAutoButton = altaAutoButton;
    }

    public CButtonSelectorPanel getBajaAutoButton() {
        return this.bajaAutoButton;
    }

    public void setBajaAutoButton(CButtonSelectorPanel bajaAutoButton) {
        this.bajaAutoButton = bajaAutoButton;
    }

}
