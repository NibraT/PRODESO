package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.controlador.main.CSelectSQL;
import ar.edu.ub.pcsw.remisoft.controlador.main.CUpdateSQL;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJComboBoxFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJTextFieldFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IValidadorInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class CPanelActividadBajaCliente extends CPanelActividadBase implements ActionListener, FocusListener,
        IJComboBoxFactory, IJTextFieldFactory, IValidadorInput, KeyListener {

    private JComboBox<String> causasLista;
    private JComboBox<String> identificacionesLista;
    private JLabel identificacionLabel;
    private JLabel nombreYApellidoORazonSocialLabel;
    private JTextField nombreYApellidoORazonSocialTextField;
    private String[] causas = new String[] {" ", "Administración RSG", "Cese", "Fallecimiento", "Incapacidad",
            "Incobrable", "Morosidad"};

    public CPanelActividadBajaCliente() {
        super(2);
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(EColorPanel.CLIENTES.getColor());
        this.getNorteLabel().setText(ETextoButton.BAJACLIENTE.getTexto().toUpperCase());
        this.getNorteLabel().setPreferredSize(new Dimension(this.getWidth(), 125));
        this.add(getNorteLabel(), BorderLayout.NORTH);
        this.getSurLabel().setPreferredSize(new Dimension(this.getWidth(), 125));
        this.add(getSurLabel(), BorderLayout.SOUTH);
        this.getGbc().anchor = GridBagConstraints.LINE_START;
        this.setNombreYApellidoORazonSocialLabel(new JLabel("Nombre(s) y Apellido / Razón Social"));
        this.getNombreYApellidoORazonSocialLabel().setPreferredSize(new Dimension(260, 15));
        this.getNombreYApellidoORazonSocialLabel().setForeground(Color.RED);
        this.setIdentificacionLabel(new JLabel("DNI / CUIL / CUIT"));
        this.getIdentificacionLabel().setForeground(Color.RED);
        // método default de IJComboBoxFactory
        this.setIdentificacionesLista(this.crearComboBox(new CSelectSQL().selectRecursoParaBaja("identificacion", null),
                333, 20, Color.WHITE, EToolTipTextTexto.SELECCIONAR.getTexto() +
                        getIdentificacionLabel().getText(), this));
        this.getIdentificacionesLista().setEnabled(false);
        this.getIdentificacionesLista().addFocusListener(this);
        // método default de IValidadorInput
        this.validadorInput(getIdentificacionesLista(), getIdentificacionesLista().getToolTipText(),
                getIdentificacionLabel().getText());
        // método default de IJTextFieldFactory
        this.setNombreYApellidoORazonSocialTextField(this.setTextField(30,
                getNombreYApellidoORazonSocialLabel().getText() + " del cliente a dar de baja", this));
        this.getNombreYApellidoORazonSocialTextField().setEditable(false);
        // método default de IJComboBoxFactory
        this.setCausasLista(this.crearComboBox(this.getCausas(), 333, 20, Color.WHITE, EToolTipTextTexto.
                SELECCIONAR.getTexto() + getCausaLabel().getText(), this));
        this.getCausasLista().setEnabled(false);
        // método default de IValidadorInput
        this.validadorInput(getCausasLista(), getCausasLista().getToolTipText(), getCausaLabel().getText());
        this.getGuardarButton().addActionListener(this);
        this.getHabilitarButton().addActionListener(this);
        this.getGbc().gridx = 0;
        this.getGbc().gridy = 0;
        this.getPanelInput().add(this.getReferenciasLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getIdentificacionLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getNombreYApellidoORazonSocialLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getCausaLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getFechaLabel(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 0;
        this.getGbc().anchor = GridBagConstraints.CENTER;
        this.getPanelInput().add(getHabilitarButton(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 1;
        this.getPanelInput().add(this.getIdentificacionesLista(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getNombreYApellidoORazonSocialTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getCausasLista(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getFechaTextField(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 10;
        this.getGbc().anchor = GridBagConstraints.LINE_START;
        this.getPanelInput().add(this.getGuardarButton(), this.getGbc());
        this.getGbc().anchor = GridBagConstraints.LINE_END;
        this.getPanelInput().add(this.getSalirButton(), this.getGbc());
        this.add(this.getPanelInput());
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource().equals(getFechaTextField())) {
            getFechaTextField().selectAll();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getHabilitarButton())) {
            getIdentificacionesLista().setEnabled(true);
            getCausasLista().setEnabled(true);
            getFechaTextField().setEditable(true);
        }
        else if (e.getSource().equals(getCausasLista())) {
            getGuardarButton().setEnabled(true);
        }
        else if (e.getSource().equals(getGuardarButton())) {
            if ((getIdentificacionesLista().getSelectedItem().toString().isEmpty()) ||
                    (getIdentificacionesLista().getSelectedItem().toString() == null) ||
                    (getIdentificacionesLista().getSelectedItem().toString().equals(" ")) ||
                    (getCausasLista().getSelectedItem().toString().isEmpty()) ||
                    (getCausasLista().getSelectedItem().toString() == null) ||
                    (getCausasLista().getSelectedItem().toString().equals(" "))) {
                JOptionPane.showMessageDialog(null, getMensajeErrorActividad(),
                        "Error en " + getNorteLabel().getText(), JOptionPane.ERROR_MESSAGE);
            }
            else {
                new CUpdateSQL().updateFechaBajaCliente(getIdentificacionesLista().getSelectedItem().toString());
            }
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        this.getNombreYApellidoORazonSocialTextField().setText(new CSelectSQL().selectRecurso("cliente",
                getIdentificacionesLista().getSelectedItem().toString(), "nombreORazonSocial", 3));
    }

    public JComboBox<String> getCausasLista() { return this.causasLista; }

    public void setCausasLista(JComboBox<String> causasLista) { this.causasLista = causasLista; }

    public JComboBox<String> getIdentificacionesLista() { return this.identificacionesLista; }

    public void setIdentificacionesLista(JComboBox<String> identificacionesLista) {
        this.identificacionesLista = identificacionesLista;
    }

    public JLabel getIdentificacionLabel() { return this.identificacionLabel; }

    public void setIdentificacionLabel(JLabel identificacionLabel) { this.identificacionLabel = identificacionLabel; }

    public JLabel getNombreYApellidoORazonSocialLabel() { return this.nombreYApellidoORazonSocialLabel; }

    public void setNombreYApellidoORazonSocialLabel(JLabel nombreYApellidoORazonSocialLabel) {
        this.nombreYApellidoORazonSocialLabel = nombreYApellidoORazonSocialLabel;
    }

    public JTextField getNombreYApellidoORazonSocialTextField() { return this.nombreYApellidoORazonSocialTextField; }

    public void setNombreYApellidoORazonSocialTextField(JTextField nombreYApellidoORazonSocialTextField) {
        this.nombreYApellidoORazonSocialTextField = nombreYApellidoORazonSocialTextField;
    }

    public String[] getCausas() { return this.causas; }

    public void setCausas(String[] causas) { this.causas = causas; }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public Calendar calcularTiempo() {
        return null;
    }

}