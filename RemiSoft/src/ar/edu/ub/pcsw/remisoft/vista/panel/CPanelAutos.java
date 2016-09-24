package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.frame.CFrameRemisoft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CPanelAutos extends JPanel implements ActionListener {

    private CButtonSelectorPanel autosButton;

    public CPanelAutos() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.GREEN);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setAutosButton(new CButtonSelectorPanel(new CPanelFactory(), ETextoButton.AUTOS.getTexto()));
        autosButton.addActionListener(this);
        this.add(autosButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getAutosButton())) {
            ((CFrameRemisoft)getParent().getParent().getParent().getParent().getParent()).setPanelMenu(((CButtonSelectorPanel)e.getSource()).getFactory().crearPanel(getAutosButton()));
        }
    }

    public CButtonSelectorPanel getAutosButton() {
        return this.autosButton;
    }

    public void setAutosButton(CButtonSelectorPanel autosButton) {
        this.autosButton = autosButton;
    }

}
