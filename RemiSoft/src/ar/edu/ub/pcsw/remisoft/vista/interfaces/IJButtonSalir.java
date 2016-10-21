package ar.edu.ub.pcsw.remisoft.vista.interfaces;

import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public interface IJButtonSalir extends IFrameRemisoft {

    default void accionarSalirButton(ActionEvent e) {
        // método default de IFrameRemisoft
        getFrameRemisoft().setPanelMenu(null);
        // método default de IFrameRemisoft
        getFrameRemisoft().setPanelActividad(((CButtonSelectorPanel)e.getSource()).getFactory().crearPanel());
        cerrarJOptionPane();
    }

    default void cerrarJOptionPane() {
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JDialog) {
                JDialog dialog = (JDialog) window;
                if ((dialog.getContentPane().getComponentCount() == 1) &&
                        (dialog.getContentPane().getComponent(0) instanceof JOptionPane)) {
                    dialog.dispose();
                }
            }
        }
    }



}
