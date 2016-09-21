package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.CButtonIcono;
import ar.edu.ub.pcsw.remisoft.vista.iconos.EIcono;
import ar.edu.ub.pcsw.remisoft.vista.label.CReloj;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class CPanelTiempos extends JPanel {

    public CPanelTiempos() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.cyan);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(5,5,5,5), new EtchedBorder()));
        CReloj reloj = new CReloj();
        reloj.start();
        String ubicacionCalendario = EIcono.CALENDARIO.getUbicacion();
        int reduccionCalendario = EIcono.CALENDARIO.getReduccion();
        String urlCalendario = EIcono.CALENDARIO.getUrl();
        ImageIcon calendario = CButtonIcono.procesarImagen(ubicacionCalendario, reduccionCalendario);
        CButtonIcono calendarioButton = new CButtonIcono(calendario, Color.CYAN, false, "Calendario", urlCalendario);
        String ubicacionServicioMeteorologico = EIcono.SERVICIOMETEOROLOGICO.getUbicacion();
        int reduccionServicioMeteorologico = EIcono.SERVICIOMETEOROLOGICO.getReduccion();
        String urlServicioMeteorologico = EIcono.SERVICIOMETEOROLOGICO.getUrl();
        ImageIcon servicioMeteorologico = CButtonIcono.procesarImagen(ubicacionServicioMeteorologico, reduccionServicioMeteorologico);
        CButtonIcono servicioMeteorologicoButton = new CButtonIcono(servicioMeteorologico, Color.CYAN, false, "Servicio Meteorológico", urlServicioMeteorologico);
        this.add(calendarioButton);
        this.add(Box.createHorizontalStrut(40));
        this.add(reloj.time);
        this.add(Box.createHorizontalStrut(40));
        this.add(servicioMeteorologicoButton);
    }

}
