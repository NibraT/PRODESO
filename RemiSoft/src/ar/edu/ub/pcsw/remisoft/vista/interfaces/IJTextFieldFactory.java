package ar.edu.ub.pcsw.remisoft.vista.interfaces;

import javax.swing.*;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;

public interface IJTextFieldFactory {

    default JTextField setTextField(int ancho, String texto, Object objeto) {
        JTextField jTextField = new JTextField(ancho);
        jTextField.setToolTipText(texto);
        jTextField.addKeyListener((KeyListener) objeto);
        return jTextField;
    }

    default JTextField setTextField(int ancho, String texto1, String texto2, Object objeto) {
        JTextField jTextField = new JTextField(ancho);
        jTextField.setText(texto1);
        jTextField.setToolTipText(texto2);
        jTextField.addFocusListener((FocusListener) objeto);
        return jTextField;
    }

}