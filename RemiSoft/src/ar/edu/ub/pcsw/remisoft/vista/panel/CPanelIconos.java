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
        String ubicacionMapas = EIcono.MAPAS.getUbicacion();
        int reduccionMapas = EIcono.MAPAS.getReduccion();
        String urlMapas = EIcono.MAPAS.getUrl();
        ImageIcon mapas = CButtonIcono.procesarImagen(ubicacionMapas, reduccionMapas);
        CButtonIcono mapasButton = new CButtonIcono(mapas, Color.BLUE, false, "Mapas", urlMapas);
        String ubicacionAuxilioMecanico = EIcono.AUXILIOMECANICO.getUbicacion();
        int reduccionAuxilioMecanico = EIcono.AUXILIOMECANICO.getReduccion();
        String urlAuxilioMecanico = EIcono.AUXILIOMECANICO.getUrl();
        ImageIcon auxilioMecanico = CButtonIcono.procesarImagen(ubicacionAuxilioMecanico, reduccionAuxilioMecanico);
        CButtonIcono auxilioMecanicoButton = new CButtonIcono(auxilioMecanico, Color.BLUE, false, "Auxilio Mecánico", urlAuxilioMecanico);
        String ubicacionEmergenciaMedica = EIcono.EMERGENCIAMEDICA.getUbicacion();
        int reduccionEmergenciaMedica = EIcono.EMERGENCIAMEDICA.getReduccion();
        String urlEmergenciaMedica = EIcono.EMERGENCIAMEDICA.getUrl();
        ImageIcon emergenciaMedica = CButtonIcono.procesarImagen(ubicacionEmergenciaMedica, reduccionEmergenciaMedica);
        CButtonIcono emergenciaMedicaButton = new CButtonIcono(emergenciaMedica, Color.BLUE, false, "Emergencia Médica", urlEmergenciaMedica);
        String ubicacionPolicia = EIcono.POLICIA.getUbicacion();
        int reduccionPolicia = EIcono.POLICIA.getReduccion();
        String urlPolicia = EIcono.POLICIA.getUrl();
        ImageIcon policia = CButtonIcono.procesarImagen(ubicacionPolicia, reduccionPolicia);
        CButtonIcono policiaButton = new CButtonIcono(policia, Color.BLUE, false, "Policía", urlPolicia);
        String ubicacionBomberos = EIcono.BOMBEROS.getUbicacion();
        int reduccionBomberos = EIcono.BOMBEROS.getReduccion();
        String urlBomberos = EIcono.BOMBEROS.getUrl();
        ImageIcon bomberos = CButtonIcono.procesarImagen(ubicacionBomberos, reduccionBomberos);
        CButtonIcono bomberosButton = new CButtonIcono(bomberos, Color.BLUE, false, "Bomberos", urlBomberos);
        String ubicacionGuiaTelefonica = EIcono.GUIATELEFONICA.getUbicacion();
        int reduccionGuiaTelefonica = EIcono.GUIATELEFONICA.getReduccion();
        String urlGuiaTelefonica = EIcono.GUIATELEFONICA.getUrl();
        ImageIcon guiaTelefonica = CButtonIcono.procesarImagen(ubicacionGuiaTelefonica, reduccionGuiaTelefonica);
        CButtonIcono guiaTelefonicaButton = new CButtonIcono(guiaTelefonica, Color.BLUE, false, "Guía Telefónica", urlGuiaTelefonica);
        String ubicacionCorreoElectronico = EIcono.CORREOELECTRONICO.getUbicacion();
        int reduccionCorreoElectronico = EIcono.CORREOELECTRONICO.getReduccion();
        String urlCorreoElectronico = EIcono.CORREOELECTRONICO.getUrl();
        ImageIcon correoElectronico = CButtonIcono.procesarImagen(ubicacionCorreoElectronico, reduccionCorreoElectronico);
        CButtonIcono correoElectronicoButton = new CButtonIcono(correoElectronico, Color.BLUE, false, "Email", urlCorreoElectronico);
        String ubicacionCorreoPostal = EIcono.CORREOPOSTAL.getUbicacion();
        int reduccionCorreoPostal = EIcono.CORREOPOSTAL.getReduccion();
        String urlCorreoPostal = EIcono.CORREOPOSTAL.getUrl();
        ImageIcon correoPostal = CButtonIcono.procesarImagen(ubicacionCorreoPostal, reduccionCorreoPostal);
        CButtonIcono correoPostalButton = new CButtonIcono(correoPostal, Color.BLUE, false, "Correo Postal", urlCorreoPostal);
        String ubicacionTransito = EIcono.TRANSITO.getUbicacion();
        int reduccionTransito = EIcono.TRANSITO.getReduccion();
        String urlTransito = EIcono.TRANSITO.getUrl();
        ImageIcon transito = CButtonIcono.procesarImagen(ubicacionTransito, reduccionTransito);
        CButtonIcono transitoButton = new CButtonIcono(transito, Color.BLUE, false, "Estado del Tránsito", urlTransito);
        this.add(mapasButton);
        this.add(Box.createHorizontalStrut(40));
        this.add(transitoButton);
        this.add(Box.createHorizontalStrut(40));
        this.add(guiaTelefonicaButton);
        this.add(Box.createHorizontalStrut(40));
        this.add(correoElectronicoButton);
        this.add(Box.createHorizontalStrut(40));
        this.add(auxilioMecanicoButton);
        this.add(Box.createHorizontalStrut(40));
        this.add(emergenciaMedicaButton);
        this.add(Box.createHorizontalStrut(40));
        this.add(policiaButton);
        this.add(Box.createHorizontalStrut(40));
        this.add(bomberosButton);
        this.add(Box.createHorizontalStrut(40));
        this.add(correoPostalButton);
    }

}
