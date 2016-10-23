package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.modelo.clientes.CCliente;
import ar.edu.ub.pcsw.remisoft.modelo.empleados.CEmpleado;
import ar.edu.ub.pcsw.remisoft.modelo.viajes.CViaje;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJComboBoxFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJTextFieldFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IValidadorInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class CPanelActividadCancelarViaje extends CPanelActividadBase implements ActionListener, FocusListener,
        IJComboBoxFactory, IJTextFieldFactory, IValidadorInput, KeyListener {

    private JComboBox<String> motivosLista;
    private JLabel motivoLabel;
    private JTextField autoTextField;
    private JTextField choferTextField;
    private JTextField clienteTextField;
    private JTextField horaTextField;
    private JTextField numeroTextField;
    private String[] motivos = new String[] {" ", "Cliente desistió de viajar", "Sin auto disponible",
            "Sin chofer disponible"};

    public CPanelActividadCancelarViaje() {
        super(3.0);
        this.inicializar();
    }

    public void inicializar() {
        this.getNorteLabel().setText(ETextoButton.CANCELARVIAJE.getTexto().toUpperCase());
        this.getNorteLabel().setPreferredSize(new Dimension(this.getWidth(), 80));
        this.add(getNorteLabel(), BorderLayout.NORTH);
        this.getSurLabel().setPreferredSize(new Dimension(this.getWidth(), 60));
        this.add(getSurLabel(), BorderLayout.SOUTH);
        this.getGbc().anchor = GridBagConstraints.LINE_START;
        this.getGbc().insets = new Insets (10, 0, 10, 0);
        JLabel numeroLabel = new JLabel("Viaje Reservado");
        JLabel choferLabel = new JLabel("Chofer Asignado");
        JLabel autoLabel = new JLabel("Auto Asignado");
        this.getFechaLabel().setForeground(Color.BLACK);
        JLabel horaLabel = new JLabel("Hora");
        this.setMotivoLabel(new JLabel("Motivo de la cancelación"));
        this.getMotivoLabel().setForeground(Color.RED);
        int ancho = 30;
        // método default de IJTextFieldFactory
        this.setClienteTextField(this.setTextField(ancho, EToolTipTextTexto.SOLONUMEROS.getTexto(), this));
        // método default de IValidadorInput
        this.getClienteTextField().setInputVerifier(validadorInput(ERegexValidadorInput.IDENTIFICACION.getTexto(),
                getClienteTextField().getToolTipText(), getClienteLabel().getText()));
        // método default de IJTextFieldFactory
        this.setNumeroTextField(this.setTextField(ancho, "Número del Viaje a cancelar", this));
        // método default de IJTextFieldFactory
        this.setChoferTextField(this.setTextField(ancho, "Chofer del Viaje a cancelar", this));
        // método default de IJTextFieldFactory
        this.setAutoTextField(this.setTextField(ancho, "Auto del Viaje a cancelar", this));
        this.getFechaTextField().setToolTipText("Fecha del Viaje a cancelar");
        // método default de IJTextFieldFactory
        this.setHoraTextField(this.setTextField(ancho, "Hora del Viaje a cancelar", this));
        // método default de IJComboBoxFactory
        this.setMotivosLista(this.crearComboBox(this.getMotivos(), 333, 20, Color.WHITE,
                EToolTipTextTexto.SELECCIONAR.getTexto() + getMotivoLabel().getText(), this));
        // método default de IValidadorInput
        this.validadorInput(getMotivosLista(), getMotivosLista().getToolTipText(), getMotivoLabel().getText());
        this.getGuardarButton().addActionListener(this);
        this.getGbc().gridx = 0;
        this.getGbc().gridy = 0;
        this.getPanelInput().add(this.getReferenciasLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getClienteLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(numeroLabel, this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(choferLabel, this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(autoLabel, this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getFechaLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(horaLabel, this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getMotivoLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getRecepcionistaLabel(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 1;
        this.getPanelInput().add(this.getClienteTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getNumeroTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getChoferTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getAutoTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getFechaTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getHoraTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getMotivosLista(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getRecepcionistasLista(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 10;
        this.getPanelInput().add(this.getGuardarButton(), this.getGbc());
        this.getGbc().anchor = GridBagConstraints.LINE_END;
        this.getPanelInput().add(this.getSalirButton(), this.getGbc());
        this.add(this.getPanelInput());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getRecepcionistasLista())) {
            getGuardarButton().setEnabled(true);
        }
        else if (e.getSource().equals(getGuardarButton())) {
            CViaje viaje = new CViaje();
            viaje.setCliente(new CCliente());
            viaje.setRecepcionista(new CEmpleado());
            viaje.getCliente().setIdentificacion(getClienteTextField().getText());
            viaje.setMotivoCancelacion(getMotivosLista().getSelectedItem().toString());
            viaje.getRecepcionista().setDni(getRecepcionistasLista().getSelectedItem().toString());
        }
    }

    public JComboBox<String> getMotivosLista() { return this.motivosLista; }

    public void setMotivosLista(JComboBox<String> motivosLista) { this.motivosLista = motivosLista; }

    public JLabel getMotivoLabel() { return this.motivoLabel; }

    public void setMotivoLabel(JLabel motivoLabel) { this.motivoLabel = motivoLabel; }

    public JTextField getAutoTextField() { return this.autoTextField; }

    public void setAutoTextField(JTextField autoTextField) { this.autoTextField = autoTextField; }

    public JTextField getClienteTextField() { return this.clienteTextField; }

    public void setClienteTextField(JTextField clienteTextField) { this.clienteTextField = clienteTextField; }

    public JTextField getNumeroTextField() { return this.numeroTextField; }

    public void setNumeroTextField(JTextField numeroTextField) { this.numeroTextField = numeroTextField; }

    public JTextField getChoferTextField() { return this.choferTextField; }

    public void setChoferTextField(JTextField cuentaTextField) { this.choferTextField = cuentaTextField; }

    public JTextField getHoraTextField() { return this.horaTextField; }

    public void setHoraTextField(JTextField horaTextField) { this.horaTextField = horaTextField; }

    public String[] getMotivos() { return this.motivos; }

    public void setMotivos(String[] motivos) { this.motivos = motivos; }

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
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {

    }

    @Override
    public Calendar calcularTiempo() {
        return null;
    }

}
