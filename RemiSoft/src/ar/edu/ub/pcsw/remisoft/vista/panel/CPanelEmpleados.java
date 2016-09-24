package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.frame.CFrameRemisoft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CPanelEmpleados extends JPanel implements ActionListener {

    private CButtonSelectorPanel empleadosButton;

    public CPanelEmpleados() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.MAGENTA);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setEmpleadosButton(new CButtonSelectorPanel(new CPanelFactory(), ETextoButton.EMPLEADOS.getTexto()));
        empleadosButton.addActionListener(this);
        this.add(empleadosButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getEmpleadosButton())) {
            ((CFrameRemisoft)getParent().getParent().getParent().getParent().getParent()).setPanelMenu(((CButtonSelectorPanel)e.getSource()).getFactory().crearPanel(getEmpleadosButton()));
        }
    }

    public CButtonSelectorPanel getEmpleadosButton() {
        return this.empleadosButton;
    }

    public void setEmpleadosButton(CButtonSelectorPanel empleadosButton) {
        this.empleadosButton = empleadosButton;
    }

}
