package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.modelo.empleados.CEmpleado;
import ar.edu.ub.pcsw.remisoft.modelo.interfaces.ITemporizable;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJButtonSalir;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJComboBoxFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJTextFieldFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IValidadorInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class CPanelActividadBajaEmpleado extends CPanelActividadBase implements IJButtonSalir, IJComboBoxFactory,
        IJTextFieldFactory, ITemporizable, IValidadorInput, ActionListener, FocusListener, KeyListener {

    private JComboBox<String> apellidosLista;
    private JComboBox<String> causasLista;
    private JComboBox<String> identificacionesLista;
    private JComboBox<String> nombresLista;
    private JLabel apellidoLabel;
    private JLabel identificacionLabel;
    private JLabel nombreLabel;
    private String apellido;
    private String identificacion;
    private String nombre;
    private String[] apellidos = new String[] {" ", "A", "B", "C", "D"};
    private String[] identificaciones = new String[] {" ", "A", "B", "C", "D"};
    private String[] nombres = new String[] {" ", "A", "B", "C", "D"};
    private String[] causas = new String[] {" ", "Licencia", "Renuncia", "Despido", "Incapacidad", "Fallecimiento"};

    public CPanelActividadBajaEmpleado() {
        super(2);
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.MAGENTA);
        this.getNorteLabel().setText("BAJA EMPLEADO");
        this.add(getNorteLabel(), BorderLayout.NORTH);
        this.add(getSurLabel(), BorderLayout.SOUTH);
        this.getGbc().anchor = GridBagConstraints.LINE_START;
        this.getReferenciasLabel().setText("<html><font color='red'>rojo</font> indica campo obligatorio</html>");
        this.setNombreLabel(new JLabel("Nombre(s)"));
        this.getNombreLabel().setPreferredSize(new Dimension(160, 15));
        this.getNombreLabel().setForeground(Color.RED);
        this.setApellidoLabel(new JLabel("Apellido"));
        this.getApellidoLabel().setForeground(Color.RED);
        this.setIdentificacionLabel(new JLabel("DNI"));
        this.getIdentificacionLabel().setForeground(Color.RED);
        // método default de IJComboBoxFactory
        this.setNombresLista(this.crearComboBox(this.getNombres(), 333, 20, Color.WHITE,
                EToolTipTextTexto.SELECCIONAR.getTexto() + getNombreLabel().getText(), this));
        // método default de IValidadorInput
        this.validadorInput(getNombresLista(), getNombresLista().getToolTipText(), getNombreLabel().getText());
        // método default de IJComboBoxFactory
        this.setApellidosLista(this.crearComboBox(this.getApellidos(), 333, 20, Color.WHITE,
                EToolTipTextTexto.SELECCIONAR.getTexto() + getApellidoLabel().getText(), this));
        // método default de IValidadorInput
        this.validadorInput(getApellidosLista(), getApellidosLista().getToolTipText(), getApellidoLabel().getText());
        // método default de IJComboBoxFactory
        this.setIdentificacionesLista(this.crearComboBox(this.getIdentificaciones(), 333, 20, Color.WHITE,
                EToolTipTextTexto.SELECCIONAR.getTexto() +
                getIdentificacionLabel().getText(), this));
        // método default de IValidadorInput
        this.validadorInput(getIdentificacionesLista(), getIdentificacionesLista().getToolTipText(),
                getIdentificacionLabel().getText());
        // método default de IJComboBoxFactory
        this.setCausasLista(this.crearComboBox(this.getCausas(), 333, 20, Color.WHITE,
                EToolTipTextTexto.SELECCIONAR.getTexto() + getCausaLabel().getText(), this));
        // método default de IValidadorInput
        this.validadorInput(getCausasLista(), getCausasLista().getToolTipText(), getCausaLabel().getText());
        this.getSalirButton().addActionListener(this);
        this.getGbc().gridx = 0;
        this.getGbc().gridy = 0;
        this.getPanelInput().add(this.getReferenciasLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getNombreLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getApellidoLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getIdentificacionLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getCausaLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getFechaLabel(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 1;
        this.getPanelInput().add(this.getNombresLista(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getApellidosLista(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getIdentificacionesLista(), this.getGbc());
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
    public void keyReleased(KeyEvent e) {
        if  (e.getSource().equals(getFechaTextField())) {
            if ((getFechaTextField().getText() != null) || (! getFechaTextField().getText().isEmpty())) {
                setFecha(getFechaTextField().getText());
            }
        }
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
        else if (e.getSource().equals(getNombresLista().getSelectedItem())) {
            if ((getNombresLista().getSelectedItem().toString() != null) ||
                    (! getNombresLista().getSelectedItem().toString().isEmpty())) {
                setNombre(this.getNombre());
            }
        }
        else if (e.getSource().equals(getApellidosLista().getSelectedItem())) {
            if ((getApellidosLista().getSelectedItem().toString() != null) ||
                    (! getApellidosLista().getSelectedItem().toString().isEmpty())) {
                setApellido(this.getApellido());
            }
        }
        else if (e.getSource().equals(getIdentificacionesLista().getSelectedItem())) {
            if ((getIdentificacionesLista().getSelectedItem().toString() != null) ||
                    (! getIdentificacionesLista().getSelectedItem().toString().isEmpty())) {
                setIdentificacion(this.getIdentificacion());
            }
        }
        else if (e.getSource().equals(getCausasLista().getSelectedItem())) {
            if ((getCausasLista().getSelectedItem().toString() != null) ||
                    (! getCausasLista().getSelectedItem().toString().isEmpty())) {
                setFecha(this.getFecha());
            }
        }
        else if (e.getSource().equals(getGuardarButton())) {
            CEmpleado empleado = new CEmpleado();
            empleado.setNombre(this.getNombre());
            empleado.setApellido((this.getApellido()));
            empleado.setDni(this.getIdentificacion());
            empleado.setFechaDeBaja(this.getFecha());
        }
        else if (e.getSource().equals(getSalirButton())) {
            // método default de IJButtonSalir
            accionarSalirButton(e);
        }
    }

    public JComboBox<String> getApellidosLista() { return this.apellidosLista; }

    public void setApellidosLista(JComboBox<String> apellidosLista) { this.apellidosLista = apellidosLista; }

    public JComboBox<String> getCausasLista() { return this.causasLista; }

    public void setCausasLista(JComboBox<String> causasLista) { this.causasLista = causasLista; }

    public JComboBox<String> getIdentificacionesLista() { return this.identificacionesLista; }

    public void setIdentificacionesLista(JComboBox<String> identificacionesLista) {
        this.identificacionesLista = identificacionesLista;
    }

    public JComboBox<String> getNombresLista() { return this.nombresLista; }

    public void setNombresLista(JComboBox<String> nombresLista) { this.nombresLista = nombresLista; }

    public JLabel getApellidoLabel() { return this.apellidoLabel; }

    public void setApellidoLabel(JLabel apellidoLabel) { this.apellidoLabel = apellidoLabel; }

    public JLabel getIdentificacionLabel() { return this.identificacionLabel; }

    public void setIdentificacionLabel(JLabel identificacionLabel) { this.identificacionLabel = identificacionLabel; }

    public JLabel getNombreLabel() { return this.nombreLabel; }

    public void setNombreLabel(JLabel nombreLabel) { this.nombreLabel = nombreLabel; }

    public String getApellido() { return this.apellido; }

    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getIdentificacion() { return this.identificacion; }

    public void setIdentificacion(String identificacion) { this.identificacion = identificacion; }

    public String getNombre() { return this.nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String[] getApellidos() { return this.apellidos; }

    public void setApellidos(String[] apellidos) { this.apellidos = apellidos; }

    public String[] getCausas() { return this.causas; }

    public void setCausas(String[] causas) { this.causas = causas; }

    public String[] getIdentificaciones() { return this.identificaciones; }

    public void setIdentificaciones(String[] identificaciones) { this.identificaciones = identificaciones; }

    public String[] getNombres() { return this.nombres; }

    public void setNombres(String[] nombres) { this.nombres = nombres; }

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
