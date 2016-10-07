package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.modelo.clientes.CCliente;
import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJButtonSalir;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJTextFieldFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IPanelFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CPanelActividadAltaCliente extends JPanel implements IJTextFieldFactory, IJButtonSalir, ActionListener,
        FocusListener, KeyListener {

    private CButtonSelectorPanel salirButton;
    private int numeroCuentaAdicional;
    private JButton guardarButton;
    private JTextField cuentaAdicionalTextField;
    private JTextField domicilioTextField;
    private JTextField identificacionTextField;
    private JTextField nombreYApellidoORazonSocialTextField;
    private JTextField telefonoTextField;
    private String domicilio;
    private String identificacion;
    private String nombreYApellidoORazonSocial;
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
        JLabel nombreYApellidoORazonSocialLabel = new JLabel("Nombre(s) y Apellido / Razón Social (*)");
        nombreYApellidoORazonSocialLabel.setPreferredSize(new Dimension(260, 15));
        JLabel identificacionLabel = new JLabel("DNI / CUIL / CUIT (*)");
        JLabel domicilioLabel = new JLabel("Domicilio (*)");
        JLabel telefonoLabel = new JLabel("Teléfono (*)");
        JLabel cuentaAdicionalLabel = new JLabel("Cuenta(s) Adicional(es)");
        int ancho = 30;
        this.setNombreYApellidoORazonSocialTextField(this.setTextField(ancho, "Ingrese sólo letras y espacios en blanco", this));
        this.setIdentificacionTextField(this.setTextField(ancho, "Ingrese sólo números sin espacios en blanco", this));
        this.setDomicilioTextField(this.setTextField(ancho, "Ingrese letras, números, símbolos y espacios en blanco", this));
        this.setTelefonoTextField(this.setTextField(ancho, "Ingrese sólo números sin espacios en blanco", this));
        this.setCuentaAdicionalTextField(this.setTextField(ancho, "0", "Ingrese un número de 1 a 4", this));
        this.setGuardarButton(new JButton("Guardar"));
        this.getGuardarButton().setPreferredSize(new Dimension(100, 30));
        this.getGuardarButton().setEnabled(false);
        this.getGuardarButton().addActionListener(this);
        this.setSalirButton(new CButtonSelectorPanel(new IPanelFactory() {
            JPanel panel = crearPanel();
        }, ETextoButton.SALIR.getTexto(), "Habilita Salir de la Actividad"));
        this.getSalirButton().addActionListener(this);
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
        panelInput.add(this.getNombreYApellidoORazonSocialTextField(), gbc);
        gbc.gridy++;
        panelInput.add(this.getIdentificacionTextField(), gbc);
        gbc.gridy++;
        panelInput.add(this.getDomicilioTextField(), gbc);
        gbc.gridy++;
        panelInput.add(this.getTelefonoTextField(), gbc);
        gbc.gridy++;
        panelInput.add(this.getCuentaAdicionalTextField(), gbc);
        gbc.gridx = 1;
        gbc.gridy = 6;
        panelInput.add(this.getGuardarButton(), gbc);
        gbc.anchor = GridBagConstraints.LINE_END;
        panelInput.add(this.getSalirButton(), gbc);
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
            if ((getNombreYApellidoORazonSocialTextField().getText() != null) || (! getNombreYApellidoORazonSocialTextField().getText().isEmpty())) {
                setNombreYApellidoORazonSocial(getNombreYApellidoORazonSocialTextField().getText());
            }
        }
        else if (e.getSource().equals(getIdentificacionTextField())) {
            if ((getIdentificacionTextField().getText() != null) || (! getIdentificacionTextField().getText().isEmpty())) {
                setIdentificacion(getIdentificacionTextField().getText());
            }
        }
        else if (e.getSource().equals(getDomicilioTextField())) {
            if ((getDomicilioTextField().getText() != null) || (! getDomicilioTextField().getText().isEmpty())) {
                setDomicilio(getDomicilioTextField().getText());
            }
        }
        else if (e.getSource().equals(getTelefonoTextField())) {
            if ((getTelefonoTextField().getText() != null) || (! getTelefonoTextField().getText().isEmpty())) {
                setTelefono(getTelefonoTextField().getText());
                getGuardarButton().setEnabled(true);
            }
        }
        else if (e.getSource().equals(getCuentaAdicionalTextField())) {
            if ((getCuentaAdicionalTextField().getText() != null) || (! getCuentaAdicionalTextField().getText().isEmpty())) {
                setNumeroCuentaAdicional(Integer.parseInt(getCuentaAdicionalTextField().getText()));
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
            accionarSalirButton(e); // método default de IJButtonSalir
        }
    }

    public JButton getGuardarButton() {
        return this.guardarButton;
    }

    public void setGuardarButton(JButton guardarButton) { this.guardarButton = guardarButton; }

    public CButtonSelectorPanel getSalirButton() { return this.salirButton;     }

    public int getNumeroCuentaAdicional() {
        return this.numeroCuentaAdicional;
    }

    public void setNumeroCuentaAdicional(int numeroCuentaAdicional) { this.numeroCuentaAdicional = numeroCuentaAdicional; }

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

    public void setIdentificacionTextField(JTextField identificacionTextField) { this.identificacionTextField = identificacionTextField; }

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
