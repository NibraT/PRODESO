package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IFrameRemisoft;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class CPanelMenuBase extends JPanel implements ActionListener, IFrameRemisoft {

    private CButtonSelectorPanel buttonUno;
    private CButtonSelectorPanel buttonDos;
    private CButtonSelectorPanel buttonTres;

    public CPanelMenuBase() {
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ((e.getSource().equals(getButtonUno())) || (e.getSource().equals(getButtonDos()))) {
            // método default de IFrameRemisoft
            getFrameRemisoft().setPanelActividad(((CButtonSelectorPanel)e.getSource()).getFactory().crearPanel());
        }
    }

    public CButtonSelectorPanel getButtonUno() { return this.buttonUno; }

    public void setButtonUno(CButtonSelectorPanel buttonUno) { this.buttonUno = buttonUno; }

    public CButtonSelectorPanel getButtonDos() { return this.buttonDos; }

    public void setButtonDos(CButtonSelectorPanel buttonDos) { this.buttonDos = buttonDos; }

    public CButtonSelectorPanel getButtonTres() { return this.buttonTres; }

    public void setButtonTres(CButtonSelectorPanel buttonTres) { this.buttonTres = buttonTres; }

}
