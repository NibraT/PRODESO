package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.controlador.main.CSelectSQL;
import ar.edu.ub.pcsw.remisoft.controlador.main.CUpdateSQL;
import ar.edu.ub.pcsw.remisoft.controlador.main.ETablas;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJComboBoxFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJTextFieldFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IValidadorInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

import static java.lang.Integer.parseInt;

public class CPanelActividadCancelarViaje extends CPanelActividadBase implements ActionListener, FocusListener,
        IJComboBoxFactory, IJTextFieldFactory, IValidadorInput, KeyListener {

    private JComboBox<String> motivosLista;
    private JComboBox<String> viajesLista;
    private JLabel motivoLabel;
    private JLabel numeroLabel;
    private JTextField autoTextField;
    private JTextField choferTextField;
    private JTextField clienteTextField;
    private JTextField destinoTextField;
    private JTextField fechaTextField;
    private JTextField horaTextField;
    private JTextField origenTextField;
    private String[] motivos = new String[] {" ", "Cliente desistió de viajar", "Sin auto disponible",
            "Sin chofer disponible"};

    public CPanelActividadCancelarViaje() {
        super(3.0);
        this.inicializar();
    }

    public void inicializar() {
        this.getNorteLabel().setText(ETextoButton.CANCELARVIAJE.getTexto().toUpperCase());
        this.getNorteLabel().setPreferredSize(new Dimension(this.getWidth(), 50));
        this.add(getNorteLabel(), BorderLayout.NORTH);
        this.getSurLabel().setPreferredSize(new Dimension(this.getWidth(), 15));
        this.add(getSurLabel(), BorderLayout.SOUTH);
        this.getGbc().anchor = GridBagConstraints.LINE_START;
        this.getGbc().insets = new Insets (10, 0, 10, 0);
        this.setNumeroLabel(new JLabel("Viaje Reservado"));
        this.getNumeroLabel().setForeground(Color.RED);
        JLabel choferLabel = new JLabel("Chofer Asignado");
        JLabel autoLabel = new JLabel("Auto Asignado");
        this.getFechaLabel().setForeground(Color.BLACK);
        JLabel horaLabel = new JLabel("Hora");
        JLabel origenLabel = new JLabel("Origen");
        JLabel destinoLabel = new JLabel("Destino");
        this.setMotivoLabel(new JLabel("Motivo de la cancelación"));
        this.getMotivoLabel().setForeground(Color.RED);
        int ancho = 30;
        // método default de IJTextFieldFactory
        this.setClienteTextField(this.setTextField(ancho, EToolTipTextTexto.IDENTIFICACION.getTexto(), this));
        this.getClienteTextField().setEditable(false);
        this.getClienteTextField().addFocusListener(this);
        // método default de IValidadorInput
        this.getClienteTextField().setInputVerifier(validadorInput(ERegexValidadorInput.IDENTIFICACION.getTexto(),
                getClienteTextField().getToolTipText(), getClienteLabel().getText()));
        // método default de IJComboBoxFactory
        this.setViajesLista(this.crearComboBox(new CSelectSQL().selectRecursoParaBaja("Numero",
                getClienteTextField().getText()), 333, 20, Color.WHITE,
                EToolTipTextTexto.SELECCIONAR.getTexto() + getNumeroLabel().getText(), this));
        this.getViajesLista().setEnabled(false);
        this.getViajesLista().addFocusListener(this);
        // método default de IValidadorInput
        this.validadorInput(getViajesLista(), getViajesLista().getToolTipText(), getNumeroLabel().getText());
        // método default de IJTextFieldFactory
        this.setChoferTextField(this.setTextField(ancho, choferLabel.getText() + " del Viaje a cancelar", this));
        this.getChoferTextField().setEditable(false);
        // método default de IJTextFieldFactory
        this.setAutoTextField(this.setTextField(ancho, autoLabel.getText() + " del Viaje a cancelar", this));
        this.getAutoTextField().setEditable(false);
        this.getFechaTextField().setToolTipText(getFechaLabel().getText() + " del Viaje a cancelar");
        // método default de IJTextFieldFactory
        this.setHoraTextField(this.setTextField(ancho, horaLabel.getText() + " del Viaje a cancelar", this));
        this.getHoraTextField().setEditable(false);
        // método default de IJTextFieldFactory
        this.setOrigenTextField(this.setTextField(ancho, origenLabel.getText() + " del Viaje a cancelar", this));
        this.getOrigenTextField().setEditable(false);
        // método default de IJTextFieldFactory
        this.setDestinoTextField(this.setTextField(ancho, destinoLabel.getText() + " del Viaje a cancelar", this));
        this.getDestinoTextField().setEditable(false);
        // método default de IJComboBoxFactory
        this.setMotivosLista(this.crearComboBox(this.getMotivos(), 333, 20, Color.WHITE,
                EToolTipTextTexto.SELECCIONAR.getTexto() + getMotivoLabel().getText(), this));
        this.getMotivosLista().setEnabled(false);
        // método default de IValidadorInput
        this.validadorInput(getMotivosLista(), getMotivosLista().getToolTipText(), getMotivoLabel().getText());
        this.getGuardarButton().addActionListener(this);
        this.getHabilitarButton().addActionListener(this);
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
        this.getPanelInput().add(origenLabel, this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(destinoLabel, this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getMotivoLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getRecepcionistaLabel(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 0;
        this.getGbc().anchor = GridBagConstraints.CENTER;
        this.getPanelInput().add(getHabilitarButton(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 1;
        this.getPanelInput().add(this.getClienteTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getViajesLista(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getChoferTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getAutoTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getFechaTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getHoraTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getOrigenTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getDestinoTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getMotivosLista(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getRecepcionistasLista(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 15;
        this.getGbc().anchor = GridBagConstraints.LINE_START;
        this.getPanelInput().add(this.getGuardarButton(), this.getGbc());
        this.getGbc().anchor = GridBagConstraints.LINE_END;
        this.getPanelInput().add(this.getSalirButton(), this.getGbc());
        this.add(this.getPanelInput());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getHabilitarButton())) {
            getClienteTextField().setEditable(true);
            getViajesLista().setEnabled(true);
            getMotivosLista().setEnabled(true);
            getRecepcionistasLista().setEnabled(true);
        }
        else if (e.getSource().equals(getRecepcionistasLista())) {
            getGuardarButton().setEnabled(true);
        }
        else if (e.getSource().equals(getGuardarButton())) {
            if ((getClienteTextField().getText().isEmpty()) ||
                    (getClienteTextField().getText() == null) ||
                    (getClienteTextField().getText().equals(" ")) ||
                    (getViajesLista().getSelectedItem().toString().isEmpty()) ||
                    (getViajesLista().getSelectedItem().toString() == null) ||
                    (getViajesLista().getSelectedItem().toString().equals(" ")) ||
                    (getMotivosLista().getSelectedItem().toString().isEmpty()) ||
                    (getMotivosLista().getSelectedItem().toString() == null) ||
                    (getMotivosLista().getSelectedItem().toString().equals(" ")) ||
                    (getRecepcionistasLista().getSelectedItem().toString().isEmpty()) ||
                    (getRecepcionistasLista().getSelectedItem().toString() == null) ||
                    (getRecepcionistasLista().getSelectedItem().toString().equals(" "))) {
                JOptionPane.showMessageDialog(null, getMensajeErrorActividad(),
                        "Error en " + getNorteLabel().getText(), JOptionPane.ERROR_MESSAGE);
            }
            else {
                CUpdateSQL update = new CUpdateSQL();
                update.updateTabla(ETablas.VIAJE, "cancelado", "motivoCancelacion",
                        getMotivosLista().getSelectedItem().toString(),
                        parseInt(getViajesLista().getSelectedItem().toString()));
                update.updateTabla(ETablas.VEHICULO, "disponible", "Patente", getAutoTextField().getText(), 1);
                update.updateTabla(ETablas.EMPLEADO, "disponible", "Dni", getChoferTextField().getText(), 1);
            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource().equals(getClienteTextField())) {
            if ((getClienteTextField().isFocusOwner()) && (! getClienteTextField().getText().equals(" "))) {
                this.getViajesLista().removeAllItems();
                for (String numero : new CSelectSQL().selectRecursoParaBaja("Numero",
                        getClienteTextField().getText())) {
                    this.getViajesLista().addItem(numero);
                }
            }
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        CSelectSQL select = new CSelectSQL();
        if (e.getSource().equals(getViajesLista())) {
            if ((getViajesLista().getSelectedItem().toString().equals(" ") ||
                    (getViajesLista().getSelectedItem().toString().isEmpty())) ||
                    (getViajesLista().getSelectedItem().toString() == null)) {
                this.getChoferTextField().setText(" ");
                this.getAutoTextField().setText(" ");
            }
            else {
                this.getChoferTextField().setText(select.selectRecurso("viaje", null,
                        "dni", Integer.parseInt(getViajesLista().getSelectedItem().toString())));
                this.getAutoTextField().setText(select.selectRecurso("viaje", null,
                        "patente", Integer.parseInt(getViajesLista().getSelectedItem().toString())));
                this.getFechaTextField().setText(select.selectRecurso("viaje", null,
                        "fecha", Integer.parseInt(getViajesLista().getSelectedItem().toString())));
                this.getHoraTextField().setText(select.selectRecurso("viaje", null,
                        "horaInicio", Integer.parseInt(getViajesLista().getSelectedItem().toString())));
                this.getOrigenTextField().setText(select.selectRecurso("viaje", null,
                        "origen", Integer.parseInt(getViajesLista().getSelectedItem().toString())));
                this.getDestinoTextField().setText(select.selectRecurso("viaje", null,
                        "destino", Integer.parseInt(getViajesLista().getSelectedItem().toString())));
            }
        }
    }

    public JComboBox<String> getMotivosLista() { return this.motivosLista; }

    public void setMotivosLista(JComboBox<String> motivosLista) { this.motivosLista = motivosLista; }

    public JComboBox<String> getViajesLista() { return this.viajesLista; }

    public void setViajesLista(JComboBox<String> viajesLista) { this.viajesLista = viajesLista; }

    public JLabel getNumeroLabel() { return this.numeroLabel; }

    public void setNumeroLabel(JLabel numeroLabel) { this.numeroLabel = numeroLabel; }

    public JLabel getMotivoLabel() { return this.motivoLabel; }

    public void setMotivoLabel(JLabel motivoLabel) { this.motivoLabel = motivoLabel; }

    public JTextField getAutoTextField() { return this.autoTextField; }

    public void setAutoTextField(JTextField autoTextField) { this.autoTextField = autoTextField; }

    public JTextField getClienteTextField() { return this.clienteTextField; }

    public void setClienteTextField(JTextField clienteTextField) { this.clienteTextField = clienteTextField; }

    public JTextField getDestinoTextField() { return this.destinoTextField; }

    public void setDestinoTextField(JTextField destinoTextField) { this.destinoTextField = destinoTextField; }

    public JTextField getChoferTextField() { return this.choferTextField; }

    public void setChoferTextField(JTextField cuentaTextField) { this.choferTextField = cuentaTextField; }

    public JTextField getHoraTextField() { return this.horaTextField; }

    public void setHoraTextField(JTextField horaTextField) { this.horaTextField = horaTextField; }

    public JTextField getOrigenTextField() { return this.origenTextField; }

    public void setOrigenTextField(JTextField origenTextField) { this.origenTextField = origenTextField; }

    public String[] getMotivos() { return this.motivos; }

    public void setMotivos(String[] motivos) { this.motivos = motivos; }

    public JTextField getFechaTextField() { return this.fechaTextField; }

    public void setFechaTextField(JTextField fechaTextField) { this.fechaTextField = fechaTextField; }

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