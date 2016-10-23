package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IPanelFactory;

import javax.swing.*;
import java.awt.*;

public class CPanelMenuAutos extends CPanelMenuBase {

    public CPanelMenuAutos() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(EColorPanel.AUTOS.getColor());
        this.setButtonUno(new CButtonSelectorPanel(new IPanelFactory() {
            @Override
            public JPanel crearPanel() {
                return new CPanelActividadAltaAuto();
            }
        }, ETextoButton.ALTAAUTO.getTexto(), EToolTipTextTexto.ACTIVIDADALTAAUTO.getTexto()));
        this.getButtonUno().addActionListener(this);
        this.setButtonDos(new CButtonSelectorPanel(new IPanelFactory() {
            @Override
            public JPanel crearPanel() {
                return new CPanelActividadBajaAuto();
            }
        }, ETextoButton.BAJAAUTO.getTexto(), EToolTipTextTexto.ACTIVIDADBAJAAUTO.getTexto()));
        this.getButtonDos().addActionListener(this);
        this.add(Box.createHorizontalStrut(45));
        this.add(getButtonUno());
        this.add(Box.createVerticalStrut(150));
        this.add(getButtonDos());
        this.add(Box.createVerticalStrut(200));
    }

}
