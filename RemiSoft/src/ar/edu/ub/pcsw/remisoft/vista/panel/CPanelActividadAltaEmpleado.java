package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.modelo.empleados.CEmpleado;
import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJButtonSalir;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJComboBoxFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJTextFieldFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IPanelFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CPanelActividadAltaEmpleado extends JPanel  implements IJButtonSalir, IJComboBoxFactory,
        IJTextFieldFactory, ActionListener, KeyListener {

    private CButtonSelectorPanel salirButton;
    private JButton guardarButton;
    private JComboBox<String> turnosLista;
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
    private String[] turnos = new String[] {" ", "6-15", "15-24"};

    public CPanelActividadAltaEmpleado() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.MAGENTA);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BorderLayout());
        JLabel altaEmpleadoLabel = new JLabel("ALTA EMPLEADO", SwingConstants.CENTER);
        altaEmpleadoLabel.setPreferredSize(new Dimension(this.getWidth(), 75));
        altaEmpleadoLabel.setFont(new Font("Arial", Font.BOLD, 25));
        altaEmpleadoLabel.setForeground(Color.WHITE);
        this.add(altaEmpleadoLabel, BorderLayout.NORTH);
        JLabel surLabel = new JLabel();
        surLabel.setPreferredSize(new Dimension(this.getWidth(), 75));
        this.add(surLabel, BorderLayout.SOUTH);
        JPanel panelInput = new JPanel();
        panelInput.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(15, 0, 15, 0);
        JLabel referenciasLabel = new JLabel("(*) indica campo obligatorio");
        referenciasLabel.setFont(new Font("Arial", Font.ITALIC, 10));
        JLabel nombreLabel = new JLabel("Nombre(s) (*)");
        nombreLabel.setPreferredSize(new Dimension(165, 15));
        JLabel apellidoLabel = new JLabel("Apellido (*)");
        JLabel dniLabel = new JLabel("DNI (*)");
        JLabel domicilioLabel = new JLabel("Domicilio (*)");
        JLabel telefonoLabel = new JLabel("Teléfono (*)");
        JLabel turnoLabel = new JLabel("Turno (*)");
        int ancho = 30;
        this.setNombreTextField(this.setTextField(ancho, "Ingrese sólo letras y espacios en blanco", this));
        this.setApellidoTextField(this.setTextField(ancho, "Ingrese sólo letras y espacios en blanco", this));
        this.setDniTextField(this.setTextField(ancho, "Ingrese sólo números", this));
        this.setDomicilioTextField(this.setTextField(ancho, "Ingrese sólo letras, números y espacios en blanco", this));
        this.setTelefonoTextField(this.setTextField(ancho, "Ingrese sólo números", this));
        this.setTurnosLista((this.crearComboBox(this.getTurnos(), 333, 20, Color.WHITE, "Seleccione turno", this)));
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
        panelInput.add(nombreLabel, gbc);
        gbc.gridy++;
        panelInput.add(apellidoLabel, gbc);
        gbc.gridy++;
        panelInput.add(dniLabel, gbc);
        gbc.gridy++;
        panelInput.add(domicilioLabel, gbc);
        gbc.gridy++;
        panelInput.add(telefonoLabel, gbc);
        gbc.gridy++;
        panelInput.add(turnoLabel, gbc);
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
        gbc.gridy++;
        panelInput.add(this.getTurnosLista(), gbc);
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
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CEmpleado empleado = new CEmpleado();
        if (e.getSource().equals(getTurnosLista())) {
            getGuardarButton().setEnabled(true);
        }
        else if (e.getSource().equals(getTurnosLista().getSelectedItem())) {
            if ((getTurnosLista().getSelectedItem().toString() != null) ||
                    (! getTurnosLista().getSelectedItem().toString().isEmpty())) {
                empleado.setTurno((getTurnosLista().getSelectedItem().toString()));
            }
        }
        else if (e.getSource().equals(getGuardarButton())) {
            empleado.setNombre(this.getNombre());
            empleado.setApellido(this.getApellido());
            empleado.setDni(this.getDni());
            empleado.setDomicilio(this.getDomicilio());
            empleado.setTelefono(this.getTelefono());
            empleado.setTurno((getTurnosLista().getSelectedItem().toString()));
        }
        else if (e.getSource().equals(getSalirButton())) {
            accionarSalirButton(e); // método default de IJButtonSalir
        }
    }

    public CButtonSelectorPanel getSalirButton() { return this.salirButton; }

    public void setSalirButton(CButtonSelectorPanel salirButton) { this.salirButton = salirButton; }

    public JButton getGuardarButton() { return this.guardarButton; }

    public void setGuardarButton(JButton guardarButton) { this.guardarButton = guardarButton; }

    public JComboBox<String> getTurnosLista() { return this.turnosLista; }

    public void setTurnosLista(JComboBox<String> turnosLista) { this.turnosLista = turnosLista; }

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

    public String[] getTurnos() { return this.turnos; }

    public void setTurnos(String[] turnos) { this.turnos = turnos; }

}
