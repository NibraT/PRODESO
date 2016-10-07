package ar.edu.ub.pcsw.remisoft.vista.interfaces;

import ar.edu.ub.pcsw.remisoft.vista.panel.CPanelFondo;
import ar.edu.ub.pcsw.remisoft.vista.panel.EFondoPanel;

import javax.swing.*;

public interface IPanelFactory {

    default JPanel crearPanel() {
        return new CPanelFondo(EFondoPanel.MAPAGARIN.getTexto(), EFondoPanel.MAPAGARIN.getAncho(),
                EFondoPanel.MAPAGARIN.getAlto());
    }

}
