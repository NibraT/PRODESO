package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.controlador.main.CSelectSQL;
import ar.edu.ub.pcsw.remisoft.controlador.main.CUpdateSQL;
import ar.edu.ub.pcsw.remisoft.modelo.empleados.CEmpleado;
import ar.edu.ub.pcsw.remisoft.modelo.interfaces.ITemporizable;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJComboBoxFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJTextFieldFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IValidadorInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class CPanelActividadBajaEmpleado extends CPanelActividadBase implements ActionListener, FocusListener,
        IJComboBoxFactory, IJTextFieldFactory, ITemporizable, IValidadorInput, KeyListener {

    private JComboBox<String> apellidosLista;
    private JComboBox<String> causasLista;
    private JComboBox<String> identificacionesLista;
    private JComboBox<String> nombresLista;
    private JLabel apellidoLabel;
    private JLabel identificacionLabel;
    private JLabel nombreLabel;
    private String[] causas = new String[] {" ", "Licencia", "Renuncia", "Despido", "Incapacidad", "Fallecimiento"};

    public CPanelActividadBajaEmpleado() {
        super(2);
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(EColorPanel.EMPLEADOS.getColor());
        this.getNorteLabel().setText(ETextoButton.BAJAEMPLEADO.getTexto().toUpperCase());
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
        this.setNombresLista(this.crearComboBox(new CSelectSQL().selectNombreEmpleadoParaBaja(), 333, 20, Color.WHITE,
                EToolTipTextTexto.SELECCIONAR.getTexto() + getNombreLabel().getText(), this));
        // método default de IValidadorInput
        this.validadorInput(getNombresLista(), getNombresLista().getToolTipText(), getNombreLabel().getText());
        // método default de IJComboBoxFactory
        this.setApellidosLista(this.crearComboBox(new CSelectSQL().selectApellidoEmpleadoParaBaja(), 333, 20,
                Color.WHITE, EToolTipTextTexto.SELECCIONAR.getTexto() + getApellidoLabel().getText(), this));
        // método default de IValidadorInput
        this.validadorInput(getApellidosLista(), getApellidosLista().getToolTipText(), getApellidoLabel().getText());
        // método default de IJComboBoxFactory
        this.setIdentificacionesLista(this.crearComboBox(new CSelectSQL().selectDniEmpleadoParaBaja(), 333, 20,
                Color.WHITE, EToolTipTextTexto.SELECCIONAR.getTexto() +
                getIdentificacionLabel().getText(), this));
        // método default de IValidadorInput
        this.validadorInput(getIdentificacionesLista(), getIdentificacionesLista().getToolTipText(),
                getIdentificacionLabel().getText());
        // método default de IJComboBoxFactory
        this.setCausasLista(this.crearComboBox(this.getCausas(), 333, 20, Color.WHITE,
                EToolTipTextTexto.SELECCIONAR.getTexto() + getCausaLabel().getText(), this));
        // método default de IValidadorInput
        this.validadorInput(getCausasLista(), getCausasLista().getToolTipText(), getCausaLabel().getText());
        this.getGuardarButton().addActionListener(this);
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
            CEmpleado empleado = new CEmpleado();
            empleado.setNombre(getNombresLista().getSelectedItem().toString());
            empleado.setApellido(getApellidosLista().getSelectedItem().toString());
            empleado.setDni(getIdentificacionesLista().getSelectedItem().toString());
            empleado.setCausaBaja(getCausasLista().getSelectedItem().toString());
            empleado.setFechaDeBaja(getFechaTextField().getText());
            new CUpdateSQL().updateFechaBajaEmpleado(getIdentificacionesLista().getSelectedItem().toString());
            new CUpdateSQL().updateDisponibleEmpleado(0, getIdentificacionesLista().getSelectedItem().toString());
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