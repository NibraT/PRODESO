package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IPanelFactory;

import javax.swing.*;
import java.awt.*;

public class CPanelMenuReportes extends CPanelMenuBase {

    public CPanelMenuReportes() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.PINK);
        this.setButtonUno(new CButtonSelectorPanel(new IPanelFactory() {
            @Override
            public JPanel crearPanel() {
                return new CPanelActividadReporteGestion();
            }
        }, ETextoButton.REPORTEGESTION.getTexto(), EToolTipTextTexto.ACTIVIDADREPORTEGESTION.getTexto()));
        this.getButtonUno().addActionListener(this);
        this.setButtonDos(new CButtonSelectorPanel(new IPanelFactory() {
            @Override
            public JPanel crearPanel() {
                return new CPanelActividadReporteCaja();
            }
        }, ETextoButton.REPORTECAJA.getTexto(), EToolTipTextTexto.ACTIVIDADREPORTECAJA.getTexto()));
        this.getButtonDos().addActionListener(this);
        this.add(Box.createHorizontalStrut(35));
        this.add(this.getButtonUno());
        this.add(Box.createVerticalStrut(150));
        this.add(this.getButtonDos());
        this.add(Box.createVerticalStrut(200));
    }

}
