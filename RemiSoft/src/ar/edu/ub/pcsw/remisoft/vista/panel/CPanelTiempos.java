package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.CButtonIcono;
import ar.edu.ub.pcsw.remisoft.vista.iconos.EIcono;
import ar.edu.ub.pcsw.remisoft.vista.label.CReloj;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class CPanelTiempos extends JPanel {

    public CPanelTiempos() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(EColorPanel.TIEMPOS.getColor());
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(5,5,5,5), new EtchedBorder()));
        CReloj reloj = new CReloj();
        reloj.start();
        EIcono calendario = EIcono.CALENDARIO;
        calendario.setColor(this.getBackground());
        this.add(new CButtonIcono(calendario));
        this.add(Box.createHorizontalStrut(40));
        this.add(reloj.time);
        this.add(Box.createHorizontalStrut(40));
        EIcono servicioMeteorologico = EIcono.SERVICIOMETEOROLOGICO;
        servicioMeteorologico.setColor(this.getBackground());
        this.add(new CButtonIcono(servicioMeteorologico));
    }

}
