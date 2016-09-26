package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.modelo.clientes.CCliente;
import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.frame.CFrameRemisoft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CPanelActividadAltaCliente extends JPanel implements ActionListener, KeyListener, FocusListener {

    private CButtonSelectorPanel guardarButton;
    private CButtonSelectorPanel salirButton;
    private int numeroCuentaAdicional;
    private JTextField nombreYApellidoORazonSocialTextField;
    private JTextField identificacionTextField;
    private JTextField domicilioTextField;
    private JTextField telefonoTextField;
    private JTextField cuentaAdicionalTextField;
    private String nombreYApellidoORazonSocial;
    private String identificacion;
    private String domicilio;
    private String telefono;

    public CPanelActividadAltaCliente() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BorderLayout());
        JLabel altaClienteLabel = new JLabel("ALTA CLIENTE", SwingConstants.CENTER);
        altaClienteLabel.setPreferredSize(new Dimension(this.getWidth(), 100));
        altaClienteLabel.setFont(new Font("Arial", Font.BOLD, 25));
        altaClienteLabel.setForeground(Color.WHITE);
        this.add(altaClienteLabel, BorderLayout.NORTH);
        JLabel surLabel = new JLabel();
        surLabel.setPreferredSize(new Dimension(this.getWidth(), 100));
        this.add(surLabel, BorderLayout.SOUTH);
        JPanel panelInput = new JPanel();
        panelInput.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(15, 0, 15, 0);
        JLabel referenciasLabel = new JLabel("(/) indica alternativa; (*) indica campo obligatorio");
        referenciasLabel.setFont(new Font("Arial", Font.ITALIC, 10));
        JLabel nombreYApellidoORazonSocialLabel = new JLabel("Nombre(s) y Apellido(s) / Razón Social (*)");
        nombreYApellidoORazonSocialLabel.setPreferredSize(new Dimension(260, 15));
        JLabel identificacionLabel = new JLabel("DNI / CUIL / CUIT (*)");
        JLabel domicilioLabel = new JLabel("Domicilio (*)");
        JLabel telefonoLabel = new JLabel("Teléfono (*)");
        JLabel cuentaAdicionalLabel = new JLabel("Cuenta(s) Adicional(es)");
        this.setNombreYApellidoORazonSocialTextField(new JTextField(30));
        nombreYApellidoORazonSocialTextField.setToolTipText("Ingrese sólo letras y espacios en blanco");
        nombreYApellidoORazonSocialTextField.addKeyListener(this);
        this.setIdentificacionTextField(new JTextField(30));
        identificacionTextField.setToolTipText("Ingrese sólo números sin espacios en blanco");
        identificacionTextField.addKeyListener(this);
        this.setDomicilioTextField(new JTextField(30));
        domicilioTextField.setToolTipText("Ingrese letras, números, símbolos y espacios en blanco");
        domicilioTextField.addKeyListener(this);
        this.setTelefonoTextField(new JTextField(30));
        telefonoTextField.setToolTipText("Ingrese sólo números sin espacios en blanco");
        telefonoTextField.addKeyListener(this);
        this.setCuentaAdicionalTextField(new JTextField(30));
        cuentaAdicionalTextField.setToolTipText("Ingrese un número de 1 a 4");
        cuentaAdicionalTextField.setText("0");
        cuentaAdicionalTextField.addFocusListener(this);
        this.setGuardarButton(new CButtonSelectorPanel(new CPanelFactory(), ETextoButton.GUARDAR.getTexto()));
        guardarButton.setEnabled(false);
        guardarButton.addActionListener(this);
        this.setSalirButton(new CButtonSelectorPanel(new CPanelFactory(), ETextoButton.SALIR.getTexto()));
        salirButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelInput.add(referenciasLabel, gbc);
        gbc.gridy++;
        panelInput.add(nombreYApellidoORazonSocialLabel, gbc);
        gbc.gridy++;
        panelInput.add(identificacionLabel, gbc);
        gbc.gridy++;
        panelInput.add(domicilioLabel, gbc);
        gbc.gridy++;
        panelInput.add(telefonoLabel, gbc);
        gbc.gridy++;
        panelInput.add(cuentaAdicionalLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelInput.add(nombreYApellidoORazonSocialTextField, gbc);
        gbc.gridy++;
        panelInput.add(identificacionTextField, gbc);
        gbc.gridy++;
        panelInput.add(domicilioTextField, gbc);
        gbc.gridy++;
        panelInput.add(telefonoTextField, gbc);
        gbc.gridy++;
        panelInput.add(cuentaAdicionalTextField, gbc);
        gbc.gridx = 1;
        gbc.gridy = 6;
        panelInput.add(guardarButton, gbc);
        gbc.anchor = GridBagConstraints.LINE_END;
        panelInput.add(salirButton, gbc);
        this.add(panelInput);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource().equals(getNombreYApellidoORazonSocialTextField())) {
            setNombreYApellidoORazonSocial(getNombreYApellidoORazonSocialTextField().getText());
        }
        else if (e.getSource().equals(getIdentificacionTextField())) {
            setIdentificacion(getIdentificacionTextField().getText());
        }
        else if (e.getSource().equals(getDomicilioTextField())) {
            setDomicilio(getDomicilioTextField().getText());
        }
        else if (e.getSource().equals(getTelefonoTextField())) {
            setTelefono(getTelefonoTextField().getText());
            getGuardarButton().setEnabled(true);
        }
        else if (e.getSource().equals(getCuentaAdicionalTextField())) {
            setNumeroCuentaAdicional(Integer.parseInt(getCuentaAdicionalTextField().getText()));
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource().equals(getCuentaAdicionalTextField())) {
            getCuentaAdicionalTextField().selectAll();
        }
    }

    @Override
    public void focusLost(FocusEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getGuardarButton())) {
            CCliente cliente = new CCliente();
            cliente.setNombreYApellidoORazonSocial(this.getNombreYApellidoORazonSocial());
            cliente.setIdentificacion(this.getIdentificacion());
            cliente.setDomicilio(this.getDomicilio());
            cliente.setTelefono(this.getTelefono());
            setNumeroCuentaAdicional(Integer.parseInt(getCuentaAdicionalTextField().getText()));
            if (this.getNumeroCuentaAdicional() > 0) {
                for (int i = 0; i < this.getNumeroCuentaAdicional(); i++) {
                    cliente.agregarCuenta(cliente.abrirCuenta(), cliente.getCuentasActivas());
                }
            }
        }
        else if (e.getSource().equals(getSalirButton())) {
            ((CFrameRemisoft)getParent().getParent().getParent().getParent().getParent()).setPanelActividad(((CButtonSelectorPanel)e.getSource()).getFactory().crearPanel(getSalirButton()));
        }
    }

    public CButtonSelectorPanel getGuardarButton() {
        return this.guardarButton;
    }

    public void setGuardarButton(CButtonSelectorPanel guardarButton) {
        this.guardarButton = guardarButton;
    }

    public CButtonSelectorPanel getSalirButton() {
        return this.salirButton;
    }

    public int getNumeroCuentaAdicional() {
        return this.numeroCuentaAdicional;
    }

    public void setNumeroCuentaAdicional(int numeroCuentaAdicional) {
        this.numeroCuentaAdicional = numeroCuentaAdicional;
    }

    public void setSalirButton(CButtonSelectorPanel salirButton) {
        this.salirButton = salirButton;
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

    public JTextField getDomicilioTextField() {
        return this.domicilioTextField;
    }

    public void setDomicilioTextField(JTextField domicilioTextField) {
        this.domicilioTextField = domicilioTextField;
    }

    public JTextField getTelefonoTextField() {
        return this.telefonoTextField;
    }

    public void setTelefonoTextField(JTextField telefonoTextField) {
        this.telefonoTextField = telefonoTextField;
    }

    public JTextField getCuentaAdicionalTextField() {
        return this.cuentaAdicionalTextField;
    }

    public void setCuentaAdicionalTextField(JTextField cuentaAdicionalTextField) {
        this.cuentaAdicionalTextField = cuentaAdicionalTextField;
    }

    public String getNombreYApellidoORazonSocial() {
        return this.nombreYApellidoORazonSocial;
    }

    public void setNombreYApellidoORazonSocial(String nombreYApellidoORazonSocial) {
        this.nombreYApellidoORazonSocial = nombreYApellidoORazonSocial;
    }

    public String getIdentificacion() {
        return this.identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDomicilio() {
        return this.domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
