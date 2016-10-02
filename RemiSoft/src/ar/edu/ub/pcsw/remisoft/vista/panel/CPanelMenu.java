package ar.edu.ub.pcsw.remisoft.vista.panel;

import javax.swing.*;
import java.awt.*;

public class CPanelMenu extends CPanelCambiante {

    public CPanelMenu() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BorderLayout());
        this.add(new CPanelFondo(EFondoPanel.MAPAZONAGARIN.getTexto(), EFondoPanel.MAPAZONAGARIN.getAncho(),
                EFondoPanel.MAPAZONAGARIN.getAlto()), BorderLayout.CENTER);
    }

}
