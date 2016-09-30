package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.dialog.CDialogLimitadorAcceso;
import ar.edu.ub.pcsw.remisoft.vista.frame.CFrameRemisoft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CPanelEmpleados extends JPanel implements ActionListener, MouseListener {

    private CButtonSelectorPanel empleadosButton;

    public CPanelEmpleados() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.MAGENTA);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setEmpleadosButton(new CButtonSelectorPanel(new CPanelFactory(), ETextoButton.EMPLEADOS.getTexto()));
        this.getEmpleadosButton().setEnabled(false);
        this.getEmpleadosButton().addActionListener(this);
        this.add(getEmpleadosButton());
        this.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getEmpleadosButton())) {
            ((CFrameRemisoft)getParent().getParent().getParent().getParent().getParent()).setPanelMenu(((CButtonSelectorPanel)e.getSource()).getFactory().crearPanel(getEmpleadosButton()));
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(this)) {
            getEmpleadosButton().setEnabled(true);
            CDialogLimitadorAcceso.agregarLogin(getEmpleadosButton());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public CButtonSelectorPanel getEmpleadosButton() {
        return this.empleadosButton;
    }

    public void setEmpleadosButton(CButtonSelectorPanel empleadosButton) {
        this.empleadosButton = empleadosButton;
    }

}
