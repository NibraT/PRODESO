package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.controlador.main.CInsertSQL;
import ar.edu.ub.pcsw.remisoft.modelo.clientes.CCliente;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJTextFieldFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IValidadorInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class CPanelActividadAltaCliente extends CPanelActividadBase implements ActionListener, FocusListener,
        IJTextFieldFactory, IValidadorInput, KeyListener {

    //private CInsertSQL insert = new CInsertSQL();
    private int numeroCuentaAdicional;
    private JLabel cuentaAdicionalLabel;
    private JLabel identificacionLabel;
    private JLabel nombreYApellidoORazonSocialLabel;
    private JTextField cuentaAdicionalTextField;
    private JTextField identificacionTextField;
    private JTextField nombreYApellidoORazonSocialTextField;

    public CPanelActividadAltaCliente() {
        super("1");
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(EColorPanel.CLIENTES.getColor());
        this.getNorteLabel().setText(ETextoButton.ALTACLIENTE.getTexto().toUpperCase());
        this.add(getNorteLabel(), BorderLayout.NORTH);
        this.add(getSurLabel(), BorderLayout.SOUTH);
        this.getGbc().anchor = GridBagConstraints.LINE_START;
        this.setNombreYApellidoORazonSocialLabel(new JLabel("Nombre(s) y Apellido / Razón Social"));
        this.getNombreYApellidoORazonSocialLabel().setPreferredSize(new Dimension(260, 15));
        this.getNombreYApellidoORazonSocialLabel().setForeground(Color.RED);
        this.setIdentificacionLabel(new JLabel("DNI / CUIL / CUIT"));
        this.getIdentificacionLabel().setForeground(Color.RED);
        this.setCuentaAdicionalLabel(new JLabel("Cuenta(s) Adicional(es)"));
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
                        IDENTIFICACION.getTexto(), getIdentificacionTextField().getToolTipText(),
                getIdentificacionLabel().getText()));
        // método default de IJTextFieldFactory
        this.setCuentaAdicionalTextField(this.setTextField(ancho, "0", EToolTipTextTexto.CUENTAADICIONAL.getTexto(),
                this));
        // método default de IValidadorInput
        this.getCuentaAdicionalTextField().setInputVerifier(validadorInput(ERegexValidadorInput.
                        CUENTAADICIONAL.getTexto(), getCuentaAdicionalTextField().getToolTipText(),
                getCuentaAdicionalLabel().getText()));
        this.getGuardarButton().addActionListener(this);
        this.getGbc().gridx = 0;
        this.getGbc().gridy = 0;
        this.getPanelInput().add(this.getReferenciasLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getNombreYApellidoORazonSocialLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getIdentificacionLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getDomicilioLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getTelefonoLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getCuentaAdicionalLabel(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 1;
        this.getPanelInput().add(this.getNombreYApellidoORazonSocialTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getIdentificacionTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getDomicilioTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getTelefonoTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getCuentaAdicionalTextField(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 6;
        this.getPanelInput().add(this.getGuardarButton(), this.getGbc());
        this.getGbc().anchor = GridBagConstraints.LINE_END;
        this.getPanelInput().add(this.getSalirButton(), this.getGbc());
        this.add(this.getPanelInput());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource().equals(getTelefonoTextField())) {
            if ((getTelefonoTextField().getText() != null) || (! getTelefonoTextField().getText().isEmpty())) {
                getGuardarButton().setEnabled(true);
            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource().equals(getCuentaAdicionalTextField())) {
            getCuentaAdicionalTextField().selectAll();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getGuardarButton())) {
            CCliente cliente = new CCliente();
            cliente.setNombreYApellidoORazonSocial(getNombreYApellidoORazonSocialTextField().getText());
            cliente.setIdentificacion(getIdentificacionTextField().getText());
            cliente.setDomicilio(getDomicilioTextField().getText());
            cliente.setTelefono(getTelefonoTextField().getText());
            setNumeroCuentaAdicional(Integer.parseInt(getCuentaAdicionalTextField().getText()));
            if (this.getNumeroCuentaAdicional() > 0) {
                for (int i = 0; i < this.getNumeroCuentaAdicional(); i++) {
                    cliente.agregarCuenta(cliente.abrirCuenta(), cliente.getCuentasActivas());
                }
            }
            // método default de ITemporizable
            cliente.setFechaDeAlta(setFechaString());
            new CInsertSQL().insertarCliente(cliente.getNombreYApellidoORazonSocial(), cliente.getIdentificacion(),
                    cliente.getDomicilio(), cliente.getTelefono());
        }
    }

    public JLabel getCuentaAdicionalLabel() { return this.cuentaAdicionalLabel; }

    public void setCuentaAdicionalLabel(JLabel cuentaAdicionalLabel) {
        this.cuentaAdicionalLabel = cuentaAdicionalLabel;
    }

    public JLabel getIdentificacionLabel() { return this.identificacionLabel; }

    public void setIdentificacionLabel(JLabel identificacionLabel) { this.identificacionLabel = identificacionLabel; }

    public JLabel getNombreYApellidoORazonSocialLabel() { return this.nombreYApellidoORazonSocialLabel; }

    public void setNombreYApellidoORazonSocialLabel(JLabel nombreYApellidoORazonSocialLabel) {
        this.nombreYApellidoORazonSocialLabel = nombreYApellidoORazonSocialLabel;
    }

    public int getNumeroCuentaAdicional() {
        return this.numeroCuentaAdicional;
    }

    public void setNumeroCuentaAdicional(int numeroCuentaAdicional) {
        this.numeroCuentaAdicional = numeroCuentaAdicional;
    }

    public JTextField getNombreYApellidoORazonSocialTextField() {
        return this.nombreYApellidoORazonSocialTextField;
    }

    public void setNombreYApellidoORazonSocialTextField(JTextField nombreYApellidoORazonSocialTextField) {
        this.nombreYApellidoORazonSocialTextField = nombreYApellidoORazonSocialTextField;
    }

    public JTextField getIdentificacionTextField() {
        return this.identificacionTextField;
    }

    public void setIdentificacionTextField(JTextField identificacionTextField) {
        this.identificacionTextField = identificacionTextField;
    }

    public JTextField getCuentaAdicionalTextField() {
        return this.cuentaAdicionalTextField;
    }

    public void setCuentaAdicionalTextField(JTextField cuentaAdicionalTextField) {
        this.cuentaAdicionalTextField = cuentaAdicionalTextField;
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
