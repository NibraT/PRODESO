package ar.edu.ub.pcsw.remisoft.vista.button;

import ar.edu.ub.pcsw.remisoft.vista.interfaces.IPanelFactory;

import javax.swing.*;
import java.awt.*;

public class CButtonSelectorPanel extends JButton {

    private IPanelFactory factory;

    public CButtonSelectorPanel(IPanelFactory iPanelFactory, String texto) {
        this.setFactory(iPanelFactory);
        this.setText(texto);
        this.setPreferredSize(new Dimension(100, 30));
    }

    public CButtonSelectorPanel(IPanelFactory iPanelFactory, String texto, int ancho, int alto) {
        this(iPanelFactory, texto);
        this.setPreferredSize(new Dimension(ancho, alto));
    }

    public void botonSelector (IPanelFactory panelSeleccionado) {
        this.setFactory(panelSeleccionado);
    }

    public IPanelFactory getFactory() {
        return this.factory;
    }

    public void setFactory(IPanelFactory factory) {
        this.factory = factory;
    }

}
