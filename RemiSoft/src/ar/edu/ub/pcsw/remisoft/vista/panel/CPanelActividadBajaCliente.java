package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.modelo.clientes.CCliente;
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
    private JLabel identificacionLabel;
    private JLabel nombreYApellidoORazonSocialLabel;
    private JTextField identificacionTextField;
    private JTextField nombreYApellidoORazonSocialTextField;
    private String[] causas = new String[] {" ", "Morosidad", "Incobrable", "Administración RSG"};

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
        int ancho = 30;
        // método default de IJTextFieldFactory
        this.setNombreYApellidoORazonSocialTextField(this.setTextField(ancho, EToolTipTextTexto.SOLOLETRAS.getTexto(),
                this));
        // método default de IValidadorInput
        this.getNombreYApellidoORazonSocialTextField().setInputVerifier(validadorInput(ERegexValidadorInput.
                        NOMBREYAPELLIDOORAZONSOCIAL.getTexto(), getNombreYApellidoORazonSocialTextField().
                getToolTipText(), getNombreYApellidoORazonSocialLabel().getText()));
        // método default de IJTextFieldFactory
        this.setIdentificacionTextField(this.setTextField(ancho, EToolTipTextTexto.SOLONUMEROS.getTexto(), this));
        // método default de IValidadorInput
        this.getIdentificacionTextField().setInputVerifier(validadorInput(ERegexValidadorInput.
                        IDENTIFICACION.getTexto(),
                getIdentificacionTextField().getToolTipText(), getIdentificacionLabel().getText()));
        // método default de IJComboBoxFactory
        this.setCausasLista(this.crearComboBox(this.getCausas(), 333, 20, Color.WHITE, EToolTipTextTexto.
                SELECCIONAR.getTexto() + getCausaLabel().getText(), this));
        // método default de IValidadorInput
        this.validadorInput(getCausasLista(), getCausasLista().getToolTipText(), getCausaLabel().getText());
        this.getGuardarButton().addActionListener(this);
        this.getGbc().gridx = 0;
        this.getGbc().gridy = 0;
        this.getPanelInput().add(this.getReferenciasLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getNombreYApellidoORazonSocialLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getIdentificacionLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getCausaLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getFechaLabel(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 1;
        this.getPanelInput().add(this.getNombreYApellidoORazonSocialTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getIdentificacionTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getCausasLista(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getFechaTextField(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 10;
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
        if (e.getSource().equals(getCausasLista())) {
            getGuardarButton().setEnabled(true);
        }
        else if (e.getSource().equals(getGuardarButton())) {
            CCliente cliente = new CCliente();
            cliente.setNombreYApellidoORazonSocial(getNombreYApellidoORazonSocialTextField().getText());
            cliente.setIdentificacion(getIdentificacionTextField().getText());
            cliente.setCausaBaja(getCausasLista().getSelectedItem().toString());
            cliente.setFechaDeBaja(getFechaTextField().getText());
        }
    }

    public JComboBox<String> getCausasLista() { return this.causasLista; }

    public void setCausasLista(JComboBox<String> causasLista) { this.causasLista = causasLista; }

    public JLabel getIdentificacionLabel() { return this.identificacionLabel; }

    public void setIdentificacionLabel(JLabel identificacionLabel) { this.identificacionLabel = identificacionLabel; }

    public JLabel getNombreYApellidoORazonSocialLabel() { return this.nombreYApellidoORazonSocialLabel; }

    public void setNombreYApellidoORazonSocialLabel(JLabel nombreYApellidoORazonSocialLabel) {
        this.nombreYApellidoORazonSocialLabel = nombreYApellidoORazonSocialLabel;
    }

    public JTextField getIdentificacionTextField() { return this.identificacionTextField; }

    public void setIdentificacionTextField(JTextField identificacionTextField) {
        this.identificacionTextField = identificacionTextField;
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
    public void focusLost(FocusEvent e) {

    }

    @Override
    public Calendar calcularTiempo() {
        return null;
    }

}
