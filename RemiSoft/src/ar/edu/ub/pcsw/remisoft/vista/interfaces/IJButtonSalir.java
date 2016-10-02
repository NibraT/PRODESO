package ar.edu.ub.pcsw.remisoft.vista.interfaces;

import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;

import java.awt.event.ActionEvent;

public interface IJButtonSalir extends IFrameRemisoft {

    default void accionarSalirButton(ActionEvent e) {
        getFrameRemisoft().setPanelMenu(null); // método default de IFrameRemisoft
        getFrameRemisoft().setPanelActividad(((CButtonSelectorPanel)e.getSource()).getFactory().crearPanel());
    }

}
