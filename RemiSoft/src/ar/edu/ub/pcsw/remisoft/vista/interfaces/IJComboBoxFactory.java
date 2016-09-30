package ar.edu.ub.pcsw.remisoft.vista.interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public interface IJComboBoxFactory {

    default JComboBox<String> crearComboBox(String[] array, int ancho, int alto, Color color, String texto, Object objeto) {
        JComboBox<String> jComboBox = new JComboBox<>(array);
        jComboBox.setPreferredSize(new Dimension(ancho, alto));
        jComboBox.setBackground(color);
        jComboBox.setToolTipText(texto);
        jComboBox.addActionListener((ActionListener) objeto);
        return jComboBox;
    }

}
