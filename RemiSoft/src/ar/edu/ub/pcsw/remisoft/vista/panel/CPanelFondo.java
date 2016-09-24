package ar.edu.ub.pcsw.remisoft.vista.panel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CPanelFondo extends JPanel {

    private static int IMG_WIDTH;
    private static int IMG_HEIGHT;

    public CPanelFondo(String texto, int ancho, int alto) {
        this.inicializar(texto, ancho, alto);
    }

    private void inicializar(String texto, int ancho, int alto) {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEtchedBorder());
        BufferedImage imagenFondo = null;
        try {
            imagenFondo = ImageIO.read(new File(texto));
            int type = imagenFondo.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : imagenFondo.getType();
            imagenFondo = resizeImage(imagenFondo, type, ancho, alto);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel picLabel = new JLabel(new ImageIcon(imagenFondo));
        picLabel.setBorder(BorderFactory.createEtchedBorder());
        this.add(picLabel, BorderLayout.NORTH);
    }

    private static BufferedImage resizeImage(BufferedImage imagenOriginal, int tipo, int width, int height) {
        IMG_WIDTH = width;
        IMG_HEIGHT = height;
        BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, tipo);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(imagenOriginal, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
        g.dispose();
        return resizedImage;
    }

}

