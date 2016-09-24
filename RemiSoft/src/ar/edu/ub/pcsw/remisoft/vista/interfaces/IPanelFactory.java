package ar.edu.ub.pcsw.remisoft.vista.interfaces;

import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;

import javax.swing.*;

public interface IPanelFactory {

    JPanel crearPanel(CButtonSelectorPanel jButton);

}
