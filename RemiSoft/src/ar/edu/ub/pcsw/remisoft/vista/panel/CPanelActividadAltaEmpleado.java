package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.controlador.main.CInsertSQL;
import ar.edu.ub.pcsw.remisoft.controlador.main.CInsertSQL;
import ar.edu.ub.pcsw.remisoft.modelo.empleados.CEmpleado;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJButtonSalir;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJComboBoxFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJTextFieldFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IValidadorInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;

public class CPanelActividadAltaEmpleado extends CPanelActividadBase implements IJButtonSalir, IJComboBoxFactory,
        IJTextFieldFactory, IValidadorInput, ActionListener, KeyListener {

    private JComboBox<String> turnosLista;
    private JLabel apellidoLabel;
    private JLabel dniLabel;
    private JLabel nombreLabel;
    private JLabel turnoLabel;
    private JTextField apellidoTextField;
    private JTextField dniTextField;
    private JTextField nombreTextField;
    private String apellido;
    private String dni;
    private String nombre;
    private String turno;
    private String[] turnos = new String[] {" ", "6-15", "15-24"};

    public CPanelActividadAltaEmpleado() {
        super("1");
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.MAGENTA);
        this.getNorteLabel().setText("ALTA EMPLEADO");
        this.getNorteLabel().setPreferredSize(new Dimension(this.getWidth(), 75));
        this.add(getNorteLabel(), BorderLayout.NORTH);
        this.getSurLabel().setPreferredSize(new Dimension(this.getWidth(), 75));
        this.add(getSurLabel(), BorderLayout.SOUTH);
        this.getGbc().anchor = GridBagConstraints.LINE_START;
        this.getReferenciasLabel().setText("<html><font color='red'>rojo</font> indica campo obligatorio</html>");
        this.setNombreLabel(new JLabel("Nombre(s)"));
        this.getNombreLabel().setForeground(Color.RED);
        this.getNombreLabel().setPreferredSize(new Dimension(165, 15));
        this.setApellidoLabel(new JLabel("Apellido"));
        this.getApellidoLabel().setForeground(Color.RED);
        this.setDniLabel(new JLabel("DNI"));
        this.getDniLabel().setForeground(Color.RED);
        this.setTurnoLabel(new JLabel("Turno"));
        this.getTurnoLabel().setForeground(Color.RED);
        int ancho = 30;
        // método default de IJTextFieldFactory
        this.setNombreTextField(this.setTextField(ancho, EToolTipTextTexto.SOLOLETRAS.getTexto(), this));
        // método default de IValidadorInput
        this.getNombreTextField().setInputVerifier(validadorInput(ERegexValidadorInput.NOMBRE.getTexto(),
                getNombreTextField().getToolTipText(), getNombreLabel().getText()));
        // método default de IJTextFieldFactory
        this.setApellidoTextField(this.setTextField(ancho, EToolTipTextTexto.SOLOLETRAS.getTexto(), this));
        // método default de IValidadorInput
        this.getApellidoTextField().setInputVerifier(validadorInput(ERegexValidadorInput.APELLIDO.getTexto(),
                getApellidoTextField().getToolTipText(), getApellidoLabel().getText()));
        // método default de IJTextFieldFactory
        this.setDniTextField(this.setTextField(ancho, EToolTipTextTexto.SOLONUMEROS.getTexto(), this));
        // método default de IValidadorInput
        this.getDniTextField().setInputVerifier(validadorInput(ERegexValidadorInput.DNI.getTexto(),
                getDniTextField().getToolTipText(), getDniLabel().getText()));
        // método default de IJComboBoxFactory
        this.setTurnosLista((this.crearComboBox(this.getTurnos(), 333, 20, Color.WHITE, EToolTipTextTexto.
                SELECCIONAR.getTexto() + getTurnoLabel().getText(), this)));
        // método default de IValidadorInput
        this.validadorInput(getTurnosLista(), getTurnosLista().getToolTipText(), getTurnoLabel().getText());
        this.getGuardarButton().addActionListener(this);
        this.getSalirButton().addActionListener(this);
        this.getGbc().gridx = 0;
        this.getGbc().gridy = 0;
        this.getPanelInput().add(this.getReferenciasLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getNombreLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getApellidoLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getDniLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getDomicilioLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getTelefonoLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getTurnoLabel(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 1;
        this.getPanelInput().add(this.getNombreTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getApellidoTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getDniTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getDomicilioTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getTelefonoTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getTurnosLista(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 10;
        this.getPanelInput().add(this.getGuardarButton(), this.getGbc());
        this.getGbc().anchor = GridBagConstraints.LINE_END;
        this.getPanelInput().add(this.getSalirButton(), this.getGbc());
        this.add(this.getPanelInput());
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
        if (e.getSource().equals(getTurnosLista())) {
            getGuardarButton().setEnabled(true);
        }
        else if (e.getSource().equals(getTurnosLista().getSelectedItem())) {
            if ((getTurnosLista().getSelectedItem().toString() != null) ||
                    (! getTurnosLista().getSelectedItem().toString().isEmpty())) {
                setTurno((getTurnosLista().getSelectedItem().toString()));
            }
        }
        else if (e.getSource().equals(getGuardarButton())) {
            CEmpleado empleado = new CEmpleado();
            empleado.setNombre(this.getNombre());
            empleado.setApellido(this.getApellido());
            empleado.setDni(this.getDni());
            empleado.setDomicilio(this.getDomicilio());
            empleado.setTelefono(this.getTelefono());
            empleado.setTurno(this.getTurno());
            CInsertSQL db = new CInsertSQL();
            db.insertarEmpleado(empleado.getDni(), empleado.getApellido(), empleado.getNombre(),
                    empleado.getDomicilio(), empleado.getTelefono(), empleado.getTurno());
        }
        else if (e.getSource().equals(getSalirButton())) {
            // método default de IJButtonSalir
            accionarSalirButton(e);
        }
    }

    public JComboBox<String> getTurnosLista() { return this.turnosLista; }

    public void setTurnosLista(JComboBox<String> turnosLista) { this.turnosLista = turnosLista; }

    public JLabel getApellidoLabel() { return this.apellidoLabel; }

    public void setApellidoLabel(JLabel apellidoLabel) { this.apellidoLabel = apellidoLabel; }

    public JLabel getDniLabel() { return this.dniLabel; }

    public void setDniLabel(JLabel dniLabel) { this.dniLabel = dniLabel; }

    public JLabel getNombreLabel() { return this.nombreLabel; }

    public void setNombreLabel(JLabel nombreLabel) { this.nombreLabel = nombreLabel; }

    public JLabel getTurnoLabel() { return this.turnoLabel; }

    public void setTurnoLabel(JLabel turnoLabel) { this.turnoLabel = turnoLabel; }

    public JTextField getNombreTextField() { return this.nombreTextField; }

    public void setNombreTextField(JTextField nombreTextField) { this.nombreTextField = nombreTextField; }

    public JTextField getApellidoTextField() { return this.apellidoTextField; }

    public void setApellidoTextField(JTextField apellidoTextField) { this.apellidoTextField = apellidoTextField; }

    public JTextField getDniTextField() { return this.dniTextField; }

    public void setDniTextField(JTextField dniTextField) { this.dniTextField = dniTextField; }

    public String getNombre() { return this.nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return this.apellido; }

    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getDni() { return this.dni; }

    public void setDni(String dni) { this.dni = dni; }

    public String getTurno() { return this.turno; }

    public void setTurno(String turno) { this.turno = turno; }

    public String[] getTurnos() { return this.turnos; }

    public void setTurnos(String[] turnos) { this.turnos = turnos; }

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
