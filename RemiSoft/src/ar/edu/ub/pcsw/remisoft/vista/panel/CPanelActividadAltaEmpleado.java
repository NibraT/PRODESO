package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.modelo.empleados.CEmpleado;
import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.frame.CFrameRemisoft;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJTextFieldFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CPanelActividadAltaEmpleado extends JPanel  implements IJTextFieldFactory, ActionListener,
        KeyListener {

    private CButtonSelectorPanel salirButton;
    private JButton guardarButton;
    private JLabel altaEmpleadoLabel;
    private JLabel apellidoLabel;
    private JLabel dniLabel;
    private JLabel domicilioLabel;
    private JLabel nombreLabel;
    private JLabel referenciasLabel;
    private JLabel surLabel;
    private JLabel telefonoLabel;
    private JTextField apellidoTextField;
    private JTextField dniTextField;
    private JTextField domicilioTextField;
    private JTextField nombreTextField;
    private JTextField telefonoTextField;
    private String apellido;
    private String dni;
    private String domicilio;
    private String nombre;
    private String telefono;

    public CPanelActividadAltaEmpleado() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.MAGENTA);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BorderLayout());
        this.setAltaEmpleadoLabel(new JLabel("ALTA EMPLEADO", SwingConstants.CENTER));
        this.getAltaEmpleadoLabel().setPreferredSize(new Dimension(this.getWidth(), 100));
        this.getAltaEmpleadoLabel().setFont(new Font("Arial", Font.BOLD, 25));
        this.getAltaEmpleadoLabel().setForeground(Color.WHITE);
        this.add(this.getAltaEmpleadoLabel(), BorderLayout.NORTH);
        this.setSurLabel(new JLabel());
        this.getSurLabel().setPreferredSize(new Dimension(this.getWidth(), 100));
        this.add(this.getSurLabel(), BorderLayout.SOUTH);
        JPanel panelInput = new JPanel();
        panelInput.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(15, 0, 15, 0);
        this.setReferenciasLabel(new JLabel("(*) indica campo obligatorio"));
        this.getReferenciasLabel().setFont(new Font("Arial", Font.ITALIC, 10));
        this.setNombreLabel(new JLabel("Nombre(s) (*)"));
        this.getNombreLabel().setPreferredSize(new Dimension(165, 15));
        this.setApellidoLabel(new JLabel("Apellido (*)"));
        this.setDniLabel(new JLabel("DNI (*)"));
        this.setDomicilioLabel(new JLabel("Domicilio (*)"));
        this.setTelefonoLabel(new JLabel("Teléfono (*)"));
        int ancho = 30;
        this.setNombreTextField(this.setTextField(ancho, "Ingrese sólo letras y espacios en blanco", this));
        this.setApellidoTextField(this.setTextField(ancho, "Ingrese sólo letras y espacios en blanco", this));
        this.setDniTextField(this.setTextField(ancho, "Ingrese sólo números", this));
        this.setDomicilioTextField(this.setTextField(ancho, "Ingrese sólo letras, números y espacios en blanco", this));
        this.setTelefonoTextField(this.setTextField(ancho, "Ingrese sólo números", this));
        this.setGuardarButton(new JButton("Guardar"));
        this.getGuardarButton().setPreferredSize(new Dimension(100, 30));
        this.getGuardarButton().setEnabled(false);
        this.getGuardarButton().addActionListener(this);
        this.setSalirButton(new CButtonSelectorPanel(new CPanelFactory(), ETextoButton.SALIR.getTexto()));
        this.getSalirButton().addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelInput.add(this.getReferenciasLabel(), gbc);
        gbc.gridy++;
        panelInput.add(this.getNombreLabel(), gbc);
        gbc.gridy++;
        panelInput.add(this.getApellidoLabel(), gbc);
        gbc.gridy++;
        panelInput.add(this.getDniLabel(), gbc);
        gbc.gridy++;
        panelInput.add(this.getDomicilioLabel(), gbc);
        gbc.gridy++;
        panelInput.add(this.getTelefonoLabel(), gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelInput.add(this.getNombreTextField(), gbc);
        gbc.gridy++;
        panelInput.add(this.getApellidoTextField(), gbc);
        gbc.gridy++;
        panelInput.add(this.getDniTextField(), gbc);
        gbc.gridy++;
        panelInput.add(this.getDomicilioTextField(), gbc);
        gbc.gridy++;
        panelInput.add(this.getTelefonoTextField(), gbc);
        gbc.gridx = 1;
        gbc.gridy = 10;
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
        if (e.getSource().equals(getNombreTextField())) {
            if ((getNombreTextField().getText() != null) || (! getNombreTextField().getText().isEmpty())) {
                setNombre(getNombreTextField().getText());
            }
        }
        else if (e.getSource().equals(getApellidoTextField())) {
            if ((getApellidoTextField().getText() != null) || (! getApellidoTextField().getText().isEmpty())) {
                setApellido(getApellidoTextField().getText());
            }
        }
        else if (e.getSource().equals(getDniTextField())) {
            if ((getDniTextField().getText() != null) || (! getDniTextField().getText().isEmpty())) {
                setDni(getDniTextField().getText());
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CEmpleado empleado = new CEmpleado();
        if (e.getSource().equals(getGuardarButton())) {
            empleado.setNombre(this.getNombre());
            empleado.setApellido(this.getApellido());
            empleado.setDni(this.getDni());
            empleado.setDomicilio(this.getDomicilio());
            empleado.setTelefono(this.getTelefono());
        }
        else if (e.getSource().equals(getSalirButton())) {
            ((CFrameRemisoft) getParent().getParent().getParent().getParent().getParent()).setPanelActividad(((CButtonSelectorPanel) e.getSource()).getFactory().crearPanel(getSalirButton()));
        }
    }

    public CButtonSelectorPanel getSalirButton() { return this.salirButton; }

    public void setSalirButton(CButtonSelectorPanel salirButton) { this.salirButton = salirButton; }

    public JButton getGuardarButton() { return this.guardarButton; }

    public void setGuardarButton(JButton guardarButton) { this.guardarButton = guardarButton; }

    public JLabel getAltaEmpleadoLabel() { return this.altaEmpleadoLabel; }

    public void setAltaEmpleadoLabel(JLabel altaEmpleadoLabel) { this.altaEmpleadoLabel = altaEmpleadoLabel; }

    public JLabel getNombreLabel() { return this.nombreLabel; }

    public void setNombreLabel(JLabel nombreLabel) { this.nombreLabel = nombreLabel; }

    public JLabel getApellidoLabel() { return this.apellidoLabel; }

    public void setApellidoLabel(JLabel apellidoLabel) { this.apellidoLabel = apellidoLabel; }

    public JLabel getDniLabel() { return this.dniLabel; }

    public void setDniLabel(JLabel dniLabel) { this.dniLabel = dniLabel; }

    public JLabel getDomicilioLabel() { return this.domicilioLabel; }

    public void setDomicilioLabel(JLabel domicilioLabel) { this.domicilioLabel = domicilioLabel; }

    public JLabel getTelefonoLabel() { return this.telefonoLabel; }

    public void setTelefonoLabel(JLabel telefonoLabel) { this.telefonoLabel = telefonoLabel; }

    public JLabel getReferenciasLabel() { return this.referenciasLabel; }

    public void setReferenciasLabel(JLabel referenciasLabel) { this.referenciasLabel = referenciasLabel; }

    public JLabel getSurLabel() { return this.surLabel; }

    public void setSurLabel(JLabel surLabel) { this.surLabel = surLabel; }

    public JTextField getNombreTextField() { return this.nombreTextField; }

    public void setNombreTextField(JTextField nombreTextField) { this.nombreTextField = nombreTextField; }

    public JTextField getApellidoTextField() { return this.apellidoTextField; }

    public void setApellidoTextField(JTextField apellidoTextField) { this.apellidoTextField = apellidoTextField; }

    public JTextField getDniTextField() { return this.dniTextField; }

    public void setDniTextField(JTextField dniTextField) { this.dniTextField = dniTextField; }

    public JTextField getDomicilioTextField() { return this.domicilioTextField; }

    public void setDomicilioTextField(JTextField domicilioTextField) { this.domicilioTextField = domicilioTextField; }

    public JTextField getTelefonoTextField() { return this.telefonoTextField; }

    public void setTelefonoTextField(JTextField telefonoTextField) { this.telefonoTextField = telefonoTextField; }

    public String getNombre() { return this.nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return this.apellido; }

    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getDni() { return this.dni; }

    public void setDni(String dni) { this.dni = dni; }

    public String getDomicilio() { return this.domicilio; }

    public void setDomicilio(String domicilio) { this.domicilio = domicilio; }

    public String getTelefono() { return this.telefono; }

    public void setTelefono(String telefono) { this.telefono = telefono; }

}
