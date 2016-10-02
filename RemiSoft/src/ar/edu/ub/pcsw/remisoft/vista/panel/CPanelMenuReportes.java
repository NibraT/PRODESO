package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.frame.CFrameRemisoft;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IPanelFactory;

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
        this.setReporteGestionButton(new CButtonSelectorPanel(new IPanelFactory() {
            @Override
            public JPanel crearPanel() {
                return new CPanelActividadReporteGestion();
            }
        }, ETextoButton.REPORTEGESTION.getTexto(), "Habilita Actividad Reporte Gestión"));
        this.getReporteGestionButton().addActionListener(this);
        this.setReporteCajaButton(new CButtonSelectorPanel(new IPanelFactory() {
            @Override
            public JPanel crearPanel() {
                return new CPanelActividadReporteCaja();
            }
        }, ETextoButton.REPORTECAJA.getTexto(), "Habilita Actividad Reporte Caja"));
        this.getReporteCajaButton().addActionListener(this);
        this.add(Box.createHorizontalStrut(35));
        this.add(this.getReporteGestionButton());
        this.add(Box.createVerticalStrut(150));
        this.add(this.getReporteCajaButton());
        this.add(Box.createVerticalStrut(200));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getReporteGestionButton())) {
            ((CFrameRemisoft)getParent().getParent().getParent().getParent().getParent()).setPanelActividad(((CButtonSelectorPanel)e.getSource()).getFactory().crearPanel());
        }
        else if (e.getSource().equals(getReporteCajaButton())) {
            ((CFrameRemisoft)getParent().getParent().getParent().getParent().getParent()).setPanelActividad(((CButtonSelectorPanel)e.getSource()).getFactory().crearPanel());
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
