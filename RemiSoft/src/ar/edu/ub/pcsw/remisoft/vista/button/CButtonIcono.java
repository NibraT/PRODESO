package ar.edu.ub.pcsw.remisoft.vista.button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class CButtonIcono extends JButton {

    public CButtonIcono(ImageIcon icono, Color color, boolean highlight, String texto, String urlString) {
        super(icono);
        this.setBackground(color);
        this.setFocusPainted(highlight);
        this.setToolTipText(texto);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                URL paginaWeb = null;
                try {
                    paginaWeb = new URL(urlString);
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                }
                abrirPaginaWeb(paginaWeb);
            }
        });

    }

    public static ImageIcon procesarImagen(String path, int reduc) {
        ImageIcon icono = new ImageIcon(path);
        Image imagen = icono.getImage();
        imagen = imagen.getScaledInstance(imagen.getWidth(null)/reduc, imagen.getHeight(null)/reduc, Image.SCALE_SMOOTH);
        icono.setImage(imagen);
        return icono;
    }

    public static void abrirPaginaWeb(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if ((desktop != null) && (desktop.isSupported(Desktop.Action.BROWSE))) {
            try {
                desktop.browse(uri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void abrirPaginaWeb(URL url) {
        try {
            abrirPaginaWeb(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

}
