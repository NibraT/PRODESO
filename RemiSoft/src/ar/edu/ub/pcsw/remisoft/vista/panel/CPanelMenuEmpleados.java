package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IFrameRemisoft;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IPanelFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CPanelMenuEmpleados extends JPanel implements ActionListener, IFrameRemisoft {

    private CButtonSelectorPanel altaEmpleadoButton;
    private CButtonSelectorPanel bajaEmpleadoButton;

    public CPanelMenuEmpleados() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.MAGENTA);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setAltaEmpleadoButton(new CButtonSelectorPanel(new IPanelFactory() {
            @Override
            public JPanel crearPanel() {
                return new CPanelActividadAltaEmpleado();
            }
        }, ETextoButton.ALTAEMPLEADO.getTexto(), "Habilita Actividad Alta Empleado"));
        this.getAltaEmpleadoButton().addActionListener(this);
        this.setBajaEmpleadoButton(new CButtonSelectorPanel(new IPanelFactory() {
            @Override
            public JPanel crearPanel() {
                return new CPanelActividadBajaEmpleado();
            }
        }, ETextoButton.BAJAEMPLEADO.getTexto(), "Habilita Actividad Baja Empleado"));
        this.getBajaEmpleadoButton().addActionListener(this);
        this.add(Box.createHorizontalStrut(25));
        this.add(getAltaEmpleadoButton());
        this.add(Box.createVerticalStrut(150));
        this.add(getBajaEmpleadoButton());
        this.add(Box.createVerticalStrut(200));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ((e.getSource().equals(getAltaEmpleadoButton())) || (e.getSource().equals(getBajaEmpleadoButton()))) {
            getFrameRemisoft().setPanelActividad(((CButtonSelectorPanel)e.getSource()).getFactory().crearPanel());
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
