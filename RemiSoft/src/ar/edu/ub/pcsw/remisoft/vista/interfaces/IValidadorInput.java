package ar.edu.ub.pcsw.remisoft.vista.interfaces;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public interface IValidadorInput {

    default InputVerifier validadorInput(String texto1, String texto2, String texto3) {
        InputVerifier validador = new InputVerifier() {
            public boolean verify(JComponent input) {
                final JTextComponent source = (JTextComponent) input;
                if ((source.getText().length() == 0) || ((source.getText().length() != 0)
                        && (! (source.getText().matches(texto1))))) {
                    JOptionPane.showMessageDialog(source, texto2, "Error en " + texto3, JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                else {
                    return true;
                }
            }
        };
        return validador;
    }

    default void validadorInput(JComboBox<String> jComboBox, String texto1, String texto2) {
        jComboBox.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }
            @Override
            public void focusLost(FocusEvent e) {
                if (jComboBox.getSelectedItem().toString().matches(" ")) {
                        JOptionPane.showMessageDialog(jComboBox, texto1, "Error en " + texto2,
                                JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

}