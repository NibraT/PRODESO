package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.frame.CFrameRemisoft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CPanelMenuEmpleados extends JPanel implements ActionListener {

    private CButtonSelectorPanel altaEmpleadoButton;
    private CButtonSelectorPanel bajaEmpleadoButton;

    public CPanelMenuEmpleados() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.MAGENTA);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setAltaEmpleadoButton(new CButtonSelectorPanel(new CPanelFactory(), ETextoButton.ALTAEMPLEADO.getTexto()));
        altaEmpleadoButton.addActionListener(this);
        this.setBajaEmpleadoButton(new CButtonSelectorPanel(new CPanelFactory(), ETextoButton.BAJAEMPLEADO.getTexto()));
        bajaEmpleadoButton.addActionListener(this);
        this.add(Box.createHorizontalStrut(35));
        this.add(altaEmpleadoButton);
        this.add(Box.createVerticalStrut(150));
        this.add(bajaEmpleadoButton);
        this.add(Box.createVerticalStrut(200));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getAltaEmpleadoButton())) {
            ((CFrameRemisoft)getParent().getParent().getParent().getParent().getParent()).setPanelActividad(((CButtonSelectorPanel)e.getSource()).getFactory().crearPanel(getAltaEmpleadoButton()));
        }
        else if (e.getSource().equals(getBajaEmpleadoButton())) {
            ((CFrameRemisoft)getParent().getParent().getParent().getParent().getParent()).setPanelActividad(((CButtonSelectorPanel)e.getSource()).getFactory().crearPanel(getBajaEmpleadoButton()));
        }
    }

    public CButtonSelectorPanel getAltaEmpleadoButton() {
        return this.altaEmpleadoButton;
    }

    public void setAltaEmpleadoButton(CButtonSelectorPanel altaEmpleadoButton) {
        this.altaEmpleadoButton = altaEmpleadoButton;
    }

    public CButtonSelectorPanel getBajaEmpleadoButton() {
        return this.bajaEmpleadoButton;
    }

    public void setBajaEmpleadoButton(CButtonSelectorPanel bajaEmpleadoButton) {
        this.bajaEmpleadoButton = bajaEmpleadoButton;
    }

}
