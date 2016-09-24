package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.frame.CFrameRemisoft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CPanelMenuReportes extends JPanel implements ActionListener {

    private CButtonSelectorPanel reporteGestionButton;
    private CButtonSelectorPanel reporteCajaButton;

    public CPanelMenuReportes() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.PINK);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setReporteGestionButton(new CButtonSelectorPanel(new CPanelFactory(), ETextoButton.REPORTEGESTION.getTexto()));
        reporteGestionButton.addActionListener(this);
        this.setReporteCajaButton(new CButtonSelectorPanel(new CPanelFactory(), ETextoButton.REPORTECAJA.getTexto()));
        reporteCajaButton.addActionListener(this);
        this.add(Box.createHorizontalStrut(35));
        this.add(reporteGestionButton);
        this.add(Box.createVerticalStrut(150));
        this.add(reporteCajaButton);
        this.add(Box.createVerticalStrut(200));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getReporteGestionButton())) {
            ((CFrameRemisoft)getParent().getParent().getParent().getParent().getParent()).setPanelActividad(((CButtonSelectorPanel)e.getSource()).getFactory().crearPanel(getReporteGestionButton()));
        }
        else if (e.getSource().equals(getReporteCajaButton())) {
            ((CFrameRemisoft)getParent().getParent().getParent().getParent().getParent()).setPanelActividad(((CButtonSelectorPanel)e.getSource()).getFactory().crearPanel(getReporteCajaButton()));
        }
    }

    public CButtonSelectorPanel getReporteGestionButton() {
        return this.reporteGestionButton;
    }

    public void setReporteGestionButton(CButtonSelectorPanel reporteGestionButton) {
        this.reporteGestionButton = reporteGestionButton;
    }

    public CButtonSelectorPanel getReporteCajaButton() {
        return this.reporteCajaButton;
    }

    public void setReporteCajaButton(CButtonSelectorPanel reporteCajaButton) {
        this.reporteCajaButton = reporteCajaButton;
    }

}
