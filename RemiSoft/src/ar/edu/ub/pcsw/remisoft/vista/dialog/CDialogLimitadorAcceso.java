package ar.edu.ub.pcsw.remisoft.vista.dialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CDialogLimitadorAcceso implements ActionListener {

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
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
