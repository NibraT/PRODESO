package ar.edu.ub.pcsw.remisoft.vista.frame;

import ar.edu.ub.pcsw.remisoft.vista.panel.CPanelActividad;
import ar.edu.ub.pcsw.remisoft.vista.panel.CPanelMenu;
import ar.edu.ub.pcsw.remisoft.vista.panel.CPanelPrincipal;
import ar.edu.ub.pcsw.remisoft.vista.panel.CPanelSuperior;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CFrameRemisoft extends JFrame {

    public CFrameRemisoft() {
        super();
        this.inicializar();
    }

    private void inicializar() {
        this.setLocationRelativeTo(null);
        this.setBounds(5, 0, 1350, 1350);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        this.setMaximizedBounds(env.getMaximumWindowBounds());
        this.setIconImage(new ImageIcon("src/data/software-icon.png").getImage());
        this.setTitle("RemiSoft 1.0");
        this.add(new CPanelSuperior(), BorderLayout.NORTH);
        CPanelPrincipal panelPrincipal = new CPanelPrincipal();
        panelPrincipal.setPreferredSize(new Dimension(150, this.getHeight()));
        this.add(panelPrincipal, BorderLayout.WEST);
        this.add(new CPanelMenu());
        CPanelActividad panelActividad = new CPanelActividad();
        panelActividad.setPreferredSize(new Dimension(1065, this.getHeight()));
        this.add(panelActividad, BorderLayout.EAST);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int opcion = JOptionPane.showConfirmDialog(CFrameRemisoft.super.getOwner(),
                        "¿Confirma que desea salir de la aplicación?", "Salir de la Aplicación",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opcion == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        this.setVisible(true);
    }

}


