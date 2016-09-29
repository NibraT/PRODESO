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

public class CPanelReportes extends JPanel implements ActionListener, MouseListener {

    private CButtonSelectorPanel reportesButton;

    public CPanelReportes() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.PINK);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setReportesButton(new CButtonSelectorPanel(new CPanelFactory(), ETextoButton.REPORTES.getTexto()));
        this.getReportesButton().setEnabled(false);
        this.getReportesButton().addActionListener(this);
        this.add(getReportesButton());
        this.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getReportesButton())) {
            ((CFrameRemisoft)getParent().getParent().getParent().getParent().getParent()).setPanelMenu(((CButtonSelectorPanel)e.getSource()).getFactory().crearPanel(getReportesButton()));
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(this)) {
            getReportesButton().setEnabled(true);
            CDialogLimitadorAcceso.agregarLogin(getReportesButton());
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

    public CButtonSelectorPanel getReportesButton() {
        return this.reportesButton;
    }

    public void setReportesButton(CButtonSelectorPanel reportesButton) {
        this.reportesButton = reportesButton;
    }

}
