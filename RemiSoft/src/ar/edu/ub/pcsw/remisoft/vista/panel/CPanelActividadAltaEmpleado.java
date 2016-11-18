package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.controlador.main.CInsertSQL;
import ar.edu.ub.pcsw.remisoft.modelo.empleados.CEmpleado;
import ar.edu.ub.pcsw.remisoft.modelo.usuarios.CUsuario;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
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

public class CPanelActividadAltaEmpleado extends CPanelActividadBase implements ActionListener, IJComboBoxFactory,
        IJTextFieldFactory, IValidadorInput, KeyListener {

    private JComboBox<String> categoriasLista;
    private JComboBox<String> turnosLista;
    private JLabel apellidoLabel;
    private JLabel categoriaLabel;
    private JLabel claveLabel;
    private JLabel dniLabel;
    private JLabel nombreLabel;
    private JLabel turnoLabel;
    private JLabel usuarioLabel;
    private JTextField apellidoTextField;
    private JTextField claveTextField;
    private JTextField dniTextField;
    private JTextField nombreTextField;
    private JTextField usuarioTextField;
    private String[] categorias = new String[] {" ", "Chofer", "Recepcionista"};
    private String[] turnos = new String[] {" ", "6-15", "15-24"};

    public CPanelActividadAltaEmpleado() {
        super("1");
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(EColorPanel.EMPLEADOS.getColor());
        this.getNorteLabel().setText(ETextoButton.ALTAEMPLEADO.getTexto().toUpperCase());
        this.getNorteLabel().setPreferredSize(new Dimension(this.getWidth(), 65));
        this.add(getNorteLabel(), BorderLayout.NORTH);
        this.getSurLabel().setPreferredSize(new Dimension(this.getWidth(), 30));
        this.add(getSurLabel(), BorderLayout.SOUTH);
        this.getGbc().anchor = GridBagConstraints.LINE_START;
        this.getGbc().insets = new Insets (10, 0, 10, 0);
        this.getReferenciasLabel().setText("<html><font color='red'>rojo</font> indica campo obligatorio</html>");
        this.setNombreLabel(new JLabel("Nombre(s)"));
        this.getNombreLabel().setForeground(Color.RED);
        this.getNombreLabel().setPreferredSize(new Dimension(165, 15));
        this.setApellidoLabel(new JLabel("Apellido"));
        this.getApellidoLabel().setForeground(Color.RED);
        this.setDniLabel(new JLabel("DNI"));
        this.getDniLabel().setForeground(Color.RED);
        this.setCategoriaLabel(new JLabel("Categoria"));
        this.getCategoriaLabel().setForeground(Color.RED);
        this.setTurnoLabel(new JLabel("Turno"));
        this.getTurnoLabel().setForeground(Color.RED);
        this.setUsuarioLabel(new JLabel("Nombre de Usuario"));
        this.setClaveLabel(new JLabel("Clave de Usuario"));
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
        this.setCategoriasLista((this.crearComboBox(this.getCategorias(), 333, 20, Color.WHITE, EToolTipTextTexto.
                SELECCIONAR.getTexto() + getCategoriaLabel().getText(), this)));
        // método default de IValidadorInput
        this.validadorInput(getCategoriasLista(), getCategoriasLista().getToolTipText(), getCategoriaLabel().getText());
        // método default de IJComboBoxFactory
        this.setTurnosLista((this.crearComboBox(this.getTurnos(), 333, 20, Color.WHITE, EToolTipTextTexto.
                SELECCIONAR.getTexto() + getTurnoLabel().getText(), this)));
        // método default de IValidadorInput
        this.validadorInput(getTurnosLista(), getTurnosLista().getToolTipText(), getTurnoLabel().getText());
        // método default de IJTextFieldFactory
        this.setUsuarioTextField(this.setTextField(ancho, EToolTipTextTexto.SOLOLETRAS.getTexto(), this));
        // método default de IValidadorInput
        this.getUsuarioTextField().setInputVerifier(validadorInput(ERegexValidadorInput.NOMBRE.getTexto(),
                getUsuarioTextField().getToolTipText(), getUsuarioLabel().getText()));
        // método default de IJTextFieldFactory
        this.setClaveTextField(this.setTextField(ancho, EToolTipTextTexto.SOLOLETRASYNUMEROS.getTexto(), this));
        // método default de IValidadorInput
        this.getClaveTextField().setInputVerifier(validadorInput(ERegexValidadorInput.CLAVE.getTexto(),
                getClaveTextField().getToolTipText(), getClaveLabel().getText()));
        this.getGuardarButton().addActionListener(this);
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
        this.getPanelInput().add(this.getCategoriaLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getTurnoLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getUsuarioLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getClaveLabel(), this.getGbc());
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
        this.getPanelInput().add(this.getCategoriasLista(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getTurnosLista(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getUsuarioTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getClaveTextField(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 11;
        this.getPanelInput().add(this.getGuardarButton(), this.getGbc());
        this.getGbc().anchor = GridBagConstraints.LINE_END;
        this.getPanelInput().add(this.getSalirButton(), this.getGbc());
        this.add(this.getPanelInput());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getTurnosLista())) {
            getGuardarButton().setEnabled(true);
        }
        else if (e.getSource().equals(getGuardarButton())) {
            CEmpleado empleado = new CEmpleado();
            CUsuario usuario = new CUsuario();
            empleado.setNombre(getNombreTextField().getText());
            empleado.setApellido(getApellidoTextField().getText());
            empleado.setDni(getDniTextField().getText());
            empleado.setDomicilio(getDomicilioTextField().getText());
            empleado.setTelefono(getTelefonoTextField().getText());
            String categoria = getCategoriasLista().getSelectedItem().toString().equals("Chofer") ? "1" : "2";
            empleado.setCategoria(categoria);
            empleado.setTurno(getTurnosLista().getSelectedItem().toString());
            // método default de ITemporizable
            empleado.setFechaDeAlta(setFechaString());
            if (getUsuarioTextField().getText().isEmpty() || getClaveTextField().getText().isEmpty()) {
                usuario.setNombre(null);
                usuario.setClave(null);
            }
            else {
                usuario.setNombre(getUsuarioTextField().getText());
                usuario.setClave(getClaveTextField().getText());
            }
            new CInsertSQL().insertarEmpleado(empleado);
            new CInsertSQL().insertarEmpleadoClavePass(usuario);
        }
    }

    public JComboBox<String> getCategoriasLista() { return this.categoriasLista; }

    public void setCategoriasLista(JComboBox<String> categoriasLista) { this.categoriasLista = categoriasLista; }

    public JComboBox<String> getTurnosLista() { return this.turnosLista; }

    public void setTurnosLista(JComboBox<String> turnosLista) { this.turnosLista = turnosLista; }

    public JLabel getApellidoLabel() { return this.apellidoLabel; }

    public void setApellidoLabel(JLabel apellidoLabel) { this.apellidoLabel = apellidoLabel; }

    public JLabel getCategoriaLabel() { return this.categoriaLabel; }

    public void setCategoriaLabel(JLabel categoriaLabel) { this.categoriaLabel = categoriaLabel; }

    public JLabel getClaveLabel() { return this.claveLabel; }

    public void setClaveLabel(JLabel claveLabel) { this.claveLabel = claveLabel; }

    public JLabel getDniLabel() { return this.dniLabel; }

    public void setDniLabel(JLabel dniLabel) { this.dniLabel = dniLabel; }

    public JLabel getNombreLabel() { return this.nombreLabel; }

    public void setNombreLabel(JLabel nombreLabel) { this.nombreLabel = nombreLabel; }

    public JLabel getTurnoLabel() { return this.turnoLabel; }

    public void setTurnoLabel(JLabel turnoLabel) { this.turnoLabel = turnoLabel; }

    public JLabel getUsuarioLabel() { return this.usuarioLabel; }

    public void setUsuarioLabel(JLabel usuarioLabel) { this.usuarioLabel = usuarioLabel; }

    public JTextField getApellidoTextField() { return this.apellidoTextField; }

    public void setApellidoTextField(JTextField apellidoTextField) { this.apellidoTextField = apellidoTextField; }

    public JTextField getClaveTextField() { return this.claveTextField; }

    public void setClaveTextField(JTextField claveTextField) { this.claveTextField = claveTextField; }

    public JTextField getDniTextField() { return this.dniTextField; }

    public void setDniTextField(JTextField dniTextField) { this.dniTextField = dniTextField; }

    public JTextField getNombreTextField() { return this.nombreTextField; }

    public void setNombreTextField(JTextField nombreTextField) { this.nombreTextField = nombreTextField; }

    public JTextField getUsuarioTextField() { return this.usuarioTextField; }

    public void setUsuarioTextField(JTextField usuarioTextField) { this.usuarioTextField = usuarioTextField; }

    public String[] getCategorias() { return this.categorias; }

    public void setCategorias(String[] categorias) { this.categorias = categorias; }

    public String[] getTurnos() { return this.turnos; }

    public void setTurnos(String[] turnos) { this.turnos = turnos; }

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