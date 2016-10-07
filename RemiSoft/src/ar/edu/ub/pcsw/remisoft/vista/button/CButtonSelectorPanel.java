package ar.edu.ub.pcsw.remisoft.vista.button;

import ar.edu.ub.pcsw.remisoft.vista.interfaces.IPanelFactory;

import javax.swing.*;
import java.awt.*;

public class CButtonSelectorPanel extends JButton {

    private IPanelFactory factory;

    public CButtonSelectorPanel(IPanelFactory iPanelFactory) {
        this.setFactory(iPanelFactory);
    }

    public CButtonSelectorPanel(IPanelFactory iPanelFactory, String texto1, String texto2) {
        this(iPanelFactory);
        this.setText(texto1);
        this.setPreferredSize(new Dimension(100, 30));
        this.setToolTipText(texto2);
    }

    public CButtonSelectorPanel(IPanelFactory iPanelFactory, String texto1, String texto2, int ancho, int alto) {
        this(iPanelFactory, texto1, texto2);
        this.setPreferredSize(new Dimension(ancho, alto));
    }

    public IPanelFactory getFactory() {
        return this.factory;
    }

    public void setFactory(IPanelFactory factory) {
        this.factory = factory;
    }

}
