package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.CButtonIcono;
import ar.edu.ub.pcsw.remisoft.vista.iconos.EIcono;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class CPanelIconos extends JPanel {

    public CPanelIconos() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.BLUE);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(5,5,5,5), new EtchedBorder()));
        for(EIcono icono : EIcono.values()) {
            this.add(new CButtonIcono(icono));
            this.add(Box.createHorizontalStrut(40));
            if(icono == EIcono.CORREOPOSTAL) {
                break;
            }
        }
    }

}
