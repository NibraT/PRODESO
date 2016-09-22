package ar.edu.ub.pcsw.remisoft.vista.dialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CDialogLimitadorAcceso {

    public static void agregarLogin(JButton jButton) {
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel label_login = new JLabel("Usuario:");
                JTextField login = new JTextField();
                JLabel label_password = new JLabel("Clave:");
                JPasswordField password = new JPasswordField();
                Object[] array = {label_login, login, label_password, password};
                int res = JOptionPane.showConfirmDialog(null, array, "ACCESO RESTRINGIDO",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (res == JOptionPane.OK_OPTION) {
                    /*if (jButton.getText().equals("Clientes")) {
                        CPanelMenuClientes panelMenuClientes = new CPanelMenuClientes();
                        CFrameRemisoft frameRemisoft = new CFrameRemisoft();
                        frameRemisoft.add(panelMenuClientes);
                    }
                    else if (jButton.getText().equals("Autos")) {
                        CPanelMenuAutos panelMenuAutos = new CPanelMenuAutos();
                    }*/
                    /*if (jButton.getText().equals("Empleados")) {
                        CPanelMenuEmpleados panelMenuEmpleados = new CPanelMenuEmpleados();
                        CFrameRemisoft frameRemisoft = CFrameRemisoft.getRemiSoftFrame();
                        CPanelFondo panelMapa = CPanelFondo.getPanelMapa();
                        frameRemisoft.getContentPane().remove(panelMapa);
                        frameRemisoft.getContentPane().add(panelMenuEmpleados);
                    }*/
                    /*else if (jButton.getText().equals("Reportes")) {
                        CPanelMenuReportes panelMenuReportes = new CPanelMenuReportes();
                        new CFrameRemisoft().add(panelMenuReportes);
                    }*/
                }
            }
        });
    }

}
