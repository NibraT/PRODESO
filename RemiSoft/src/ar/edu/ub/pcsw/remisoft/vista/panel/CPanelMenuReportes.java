package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IPanelFactory;

import javax.swing.*;

public class CPanelMenuReportes extends CPanelMenuBase {

    public CPanelMenuReportes() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(EColorPanel.REPORTES.getColor());
        this.setButtonUno(new CButtonSelectorPanel(new IPanelFactory() {
            @Override
            public JPanel crearPanel() {
                return new CPanelActividadReporteOperativo();
            }
        }, ETextoButton.REPORTEOPERATIVO.getTexto(), EToolTipTextTexto.ACTIVIDADREPORTEGESTION.getTexto()));
        this.getButtonUno().addActionListener(this);
        this.setButtonDos(new CButtonSelectorPanel(new IPanelFactory() {
            @Override
            public JPanel crearPanel() {
                return new CPanelActividadReporteFinanciero();
            }
        }, ETextoButton.REPORTEFINANCIERO.getTexto(), EToolTipTextTexto.ACTIVIDADREPORTECAJA.getTexto()));
        this.getButtonDos().addActionListener(this);
        this.add(Box.createHorizontalStrut(45));
        this.add(this.getButtonUno());
        this.add(Box.createVerticalStrut(150));
        this.add(this.getButtonDos());
        this.add(Box.createVerticalStrut(200));
    }

}
