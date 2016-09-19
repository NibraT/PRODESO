package ar.edu.ub.pcsw.remisoft.vista.dialog;

import ar.edu.ub.pcsw.remisoft.vista.frame.CFrameRemisoft;
import ar.edu.ub.pcsw.remisoft.vista.panel.CPanelMenuClientes;
import ar.edu.ub.pcsw.remisoft.vista.panel.CPanelMenuAutos;
import ar.edu.ub.pcsw.remisoft.vista.panel.CPanelMenuEmpleados;
import ar.edu.ub.pcsw.remisoft.vista.panel.CPanelMenuReportes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CDialogLogin {

    public static void agregarLogin(JButton jButton) {
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel label_login = new JLabel("Usuario:");
                JTextField login = new JTextField();
                JLabel label_password = new JLabel("Clave:");
                JPasswordField password = new JPasswordField();
                Object[] array = {label_login, login, label_password, password};
                int res = JOptionPane.showConfirmDialog(null, array, "Acceso Restringido",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (res == JOptionPane.OK_OPTION) {
                    if (jButton.getText().equals("Clientes")) {
                        CPanelMenuClientes panelMenuClientes = new CPanelMenuClientes();
                        new CFrameRemisoft().add(panelMenuClientes);
                    }
                    else if (jButton.getText().equals("Autos")) {
                        CPanelMenuAutos panelMenuAutos = new CPanelMenuAutos();
                        new CFrameRemisoft().add(panelMenuAutos);
                    }
                    else if (jButton.getText().equals("Empleados")) {
                        CPanelMenuEmpleados panelMenuEmpleados = new CPanelMenuEmpleados();
                        new CFrameRemisoft().add(panelMenuEmpleados);
                    }
                    else if (jButton.getText().equals("Reportes")) {
                        CPanelMenuReportes panelMenuReportes = new CPanelMenuReportes();
                        new CFrameRemisoft().add(panelMenuReportes);
                    }
                }
            }
        });
    }

}
