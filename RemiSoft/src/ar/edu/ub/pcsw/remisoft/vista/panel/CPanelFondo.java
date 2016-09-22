package ar.edu.ub.pcsw.remisoft.vista.panel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CPanelFondo extends JPanel {

    private static final int IMG_WIDTH = 1225;
    private static final int IMG_HEIGHT = 583;

    public CPanelFondo() {
        this.inicializar();
    }

    private void inicializar() {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEtchedBorder());
        BufferedImage imagenFondo = null;
        try {
            imagenFondo = ImageIO.read(new File("src/data/mapaGarin.jpg"));
            int type = imagenFondo.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : imagenFondo.getType();
            imagenFondo = resizeImage(imagenFondo, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel picLabel = new JLabel(new ImageIcon(imagenFondo));
        picLabel.setBorder(BorderFactory.createEtchedBorder());
        this.add(picLabel, BorderLayout.NORTH);
    }

    private static BufferedImage resizeImage(BufferedImage imagenOriginal, int tipo) {
        BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, tipo);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(imagenOriginal, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
        g.dispose();
        return resizedImage;
    }

}

