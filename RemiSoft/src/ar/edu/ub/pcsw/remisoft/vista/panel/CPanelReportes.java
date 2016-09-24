package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.frame.CFrameRemisoft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CPanelReportes extends JPanel implements ActionListener {

    private CButtonSelectorPanel reportesButton;

    public CPanelReportes() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.PINK);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setReportesButton(new CButtonSelectorPanel(new CPanelFactory(), ETextoButton.REPORTES.getTexto()));
        reportesButton.addActionListener(this);
        this.add(reportesButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getReportesButton())) {
            ((CFrameRemisoft)getParent().getParent().getParent().getParent().getParent()).setPanelMenu(((CButtonSelectorPanel)e.getSource()).getFactory().crearPanel(getReportesButton()));
        }
    }

    public CButtonSelectorPanel getReportesButton() {
        return this.reportesButton;
    }

    public void setReportesButton(CButtonSelectorPanel reportesButton) {
        this.reportesButton = reportesButton;
    }

}
