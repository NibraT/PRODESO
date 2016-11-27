package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.controlador.main.CInsertSQL;
import ar.edu.ub.pcsw.remisoft.modelo.vehiculos.CVehiculo;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJTextFieldFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IValidadorInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;

public class CPanelActividadAltaAuto extends CPanelActividadBase implements ActionListener, IJTextFieldFactory,
        IValidadorInput, KeyListener {

    private JLabel aseguradoraLabel;
    private JLabel consumoLabel;
    private JLabel kilometrajeLabel;
    private JLabel marcaLabel;
    private JLabel modeloLabel;
    private JLabel patenteLabel;
    private JTextField aseguradoraTextField;
    private JTextField consumoTextField;
    private JTextField kilometrajeTextField;
    private JTextField marcaTextField;
    private JTextField modeloTextField;
    private JTextField patenteTextField;

    public CPanelActividadAltaAuto() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(EColorPanel.AUTOS.getColor());
        this.getNorteLabel().setText(ETextoButton.ALTAAUTO.getTexto().toUpperCase());
        this.getNorteLabel().setPreferredSize(new Dimension(this.getWidth(), 85));
        this.add(getNorteLabel(), BorderLayout.NORTH);
        this.getSurLabel().setPreferredSize(new Dimension(this.getWidth(), 65));
        this.add(getSurLabel(), BorderLayout.SOUTH);
        this.getGbc().anchor = GridBagConstraints.LINE_START;
        this.getReferenciasLabel().setText("<html><font color='red'>rojo</font> indica campo obligatorio</html>");
        this.setMarcaLabel(new JLabel("Marca"));
        this.getMarcaLabel().setPreferredSize(new Dimension(165, 15));
        this.getMarcaLabel().setForeground(Color.RED);
        this.setModeloLabel(new JLabel("Modelo"));
        this.getModeloLabel().setForeground(Color.RED);
        this.setPatenteLabel(new JLabel("Patente"));
        this.getPatenteLabel().setForeground(Color.RED);
        this.setAseguradoraLabel(new JLabel("Aseguradora"));
        this.getAseguradoraLabel().setForeground(Color.RED);
        this.setKilometrajeLabel(new JLabel("Kilometraje"));
        this.getKilometrajeLabel().setForeground(Color.RED);
        this.setConsumoLabel(new JLabel("Consumo (km/l)"));
        this.getConsumoLabel().setForeground(Color.RED);
        int ancho = 30;
        // método default de IJTextFieldFactory
        this.setMarcaTextField(this.setTextField(ancho, EToolTipTextTexto.MARCA.getTexto(), this));
        this.getMarcaTextField().setEditable(false);
        // método default de IValidadorInput
        this.getMarcaTextField().setInputVerifier(validadorInput(ERegexValidadorInput.MARCA.getTexto(),
                getMarcaTextField().getToolTipText(), getMarcaLabel().getText()));
        // método default de IJTextFieldFactory
        this.setModeloTextField(this.setTextField(ancho, EToolTipTextTexto.MODELO.getTexto(), this));
        this.getModeloTextField().setEditable(false);
        // método default de IValidadorInput
        this.getModeloTextField().setInputVerifier(validadorInput(ERegexValidadorInput.MODELO.getTexto(),
                getModeloTextField().getToolTipText(), getModeloLabel().getText()));
        // método default de IJTextFieldFactory
        this.setPatenteTextField(this.setTextField(ancho, EToolTipTextTexto.PATENTE.getTexto(), this));
        this.getPatenteTextField().setEditable(false);
        // método default de IValidadorInput
        this.getPatenteTextField().setInputVerifier(validadorInput(ERegexValidadorInput.PATENTE.getTexto(),
                getPatenteTextField().getToolTipText(), getPatenteLabel().getText()));
        // método default de IJTextFieldFactory
        this.setAseguradoraTextField(this.setTextField(ancho, EToolTipTextTexto.NOMBREYAPELLIDOORAZONSOCIAL.getTexto(),
                this));
        this.getAseguradoraTextField().setEditable(false);
        // método default de IValidadorInput
        this.getAseguradoraTextField().setInputVerifier(validadorInput(ERegexValidadorInput.
                        NOMBREYAPELLIDOORAZONSOCIAL.getTexto(), getAseguradoraTextField().getToolTipText(),
                getAseguradoraLabel().getText()));
        // método default de IJTextFieldFactory
        this.setKilometrajeTextField(this.setTextField(ancho, EToolTipTextTexto.KILOMETRAJE.getTexto(), this));
        this.getKilometrajeTextField().setEditable(false);
        // método default de IValidadorInput
        this.getKilometrajeTextField().setInputVerifier(validadorInput(ERegexValidadorInput.KILOMETRAJE.getTexto(),
                getKilometrajeTextField().getToolTipText(), getKilometrajeLabel().getText()));
        // método default de IJTextFieldFactory
        this.setConsumoTextField(this.setTextField(ancho, EToolTipTextTexto.CONSUMO.getTexto(), this));
        this.getConsumoTextField().setEditable(false);
        // método default de IValidadorInput
        this.getConsumoTextField().setInputVerifier(validadorInput(ERegexValidadorInput.CONSUMO.getTexto(),
                getConsumoTextField().getToolTipText(), getConsumoLabel().getText()));
        this.getGuardarButton().addActionListener(this);
        this.getHabilitarButton().addActionListener(this);
        this.getGbc().gridx = 0;
        this.getGbc().gridy = 0;
        this.getPanelInput().add(this.getReferenciasLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getMarcaLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getModeloLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getPatenteLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getAseguradoraLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getKilometrajeLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getConsumoLabel(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 0;
        this.getGbc().anchor = GridBagConstraints.CENTER;
        this.getPanelInput().add(getHabilitarButton(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 1;
        this.getPanelInput().add(this.getMarcaTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getModeloTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getPatenteTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getAseguradoraTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getKilometrajeTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getConsumoTextField(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 10;
        this.getGbc().anchor = GridBagConstraints.LINE_START;
        this.getPanelInput().add(this.getGuardarButton(), this.getGbc());
        this.getGbc().anchor = GridBagConstraints.LINE_END;
        this.getPanelInput().add(this.getSalirButton(), this.getGbc());
        this.add(this.getPanelInput());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource().equals(getConsumoTextField())) {
            if ((getConsumoTextField().getText() != null) || (! getAseguradoraTextField().getText().isEmpty())) {
                getGuardarButton().setEnabled(true);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getHabilitarButton())) {
            getMarcaTextField().setEditable(true);
            getModeloTextField().setEditable(true);
            getPatenteTextField().setEditable(true);
            getAseguradoraTextField().setEditable(true);
            getKilometrajeTextField().setEditable(true);
            getConsumoTextField().setEditable(true);
        }
        else if (e.getSource().equals(getGuardarButton())) {
            if ((getPatenteTextField().getText().isEmpty()) ||
                    (getPatenteTextField().getText() == null) ||
                    (getPatenteTextField().getText().equals(" ")) ||
                    (getMarcaTextField().getText().isEmpty()) ||
                    (getMarcaTextField().getText() == null) ||
                    (getMarcaTextField().getText().equals(" ")) ||
                    (getModeloTextField().getText().isEmpty()) ||
                    (getModeloTextField().getText() == null) ||
                    (getModeloTextField().getText().equals(" ")) ||
                    (getAseguradoraTextField().getText().isEmpty()) ||
                    (getAseguradoraTextField().getText() == null) ||
                    (getAseguradoraTextField().getText().equals(" ")) ||
                    (getKilometrajeTextField().getText().isEmpty()) ||
                    (getKilometrajeTextField().getText() == null) ||
                    (getKilometrajeTextField().getText().equals(" ")) ||
                    (getConsumoTextField().getText().isEmpty()) ||
                    (getConsumoTextField().getText() == null) ||
                    (getConsumoTextField().getText().equals(" "))) {
                JOptionPane.showMessageDialog(null, getMensajeErrorActividad(),
                        "Error en " + getNorteLabel().getText(), JOptionPane.ERROR_MESSAGE);
            }
            else {
                CVehiculo vehiculo = new CVehiculo();
                vehiculo.setPatente(getPatenteTextField().getText());
                vehiculo.setMarca(getMarcaTextField().getText());
                vehiculo.setModelo(getModeloTextField().getText());
                vehiculo.setAseguradora(getAseguradoraTextField().getText());
                vehiculo.setKilometraje(getKilometrajeTextField().getText());
                vehiculo.setConsumo(getConsumoTextField().getText());
                new CInsertSQL().insertarVehiculo(vehiculo);
            }
        }
    }

    public JLabel getAseguradoraLabel() { return this.aseguradoraLabel; }

    public void setAseguradoraLabel(JLabel aseguradoraLabel) { this.aseguradoraLabel = aseguradoraLabel; }

    public JLabel getConsumoLabel() { return this.consumoLabel; }

    public void setConsumoLabel(JLabel consumoLabel) { this.consumoLabel = consumoLabel; }

    public JLabel getKilometrajeLabel() { return this.kilometrajeLabel; }

    public void setKilometrajeLabel(JLabel kilometrajeLabel) { this.kilometrajeLabel = kilometrajeLabel; }

    public JLabel getMarcaLabel() { return this.marcaLabel; }

    public void setMarcaLabel(JLabel marcaLabel) { this.marcaLabel = marcaLabel; }

    public JLabel getModeloLabel() { return this.modeloLabel; }

    public void setModeloLabel(JLabel modeloLabel) { this.modeloLabel = modeloLabel; }

    public JLabel getPatenteLabel() { return this.patenteLabel; }

    public void setPatenteLabel(JLabel patenteLabel) { this.patenteLabel = patenteLabel; }

    public JTextField getAseguradoraTextField() { return this.aseguradoraTextField; }

    public void setAseguradoraTextField(JTextField aseguradoraTextField) {
        this.aseguradoraTextField = aseguradoraTextField;
    }

    public JTextField getConsumoTextField() { return this.consumoTextField; }

    public void setConsumoTextField(JTextField consumoTextField) { this.consumoTextField = consumoTextField; }

    public JTextField getKilometrajeTextField() { return this.kilometrajeTextField; }

    public void setKilometrajeTextField(JTextField kilometrajeTextField) {
        this.kilometrajeTextField = kilometrajeTextField;
    }

    public JTextField getMarcaTextField() { return this.marcaTextField; }

    public void setMarcaTextField(JTextField marcaTextField) { this.marcaTextField = marcaTextField; }

    public JTextField getModeloTextField() { return this.modeloTextField; }

    public void setModeloTextField(JTextField modeloTextField) { this.modeloTextField = modeloTextField; }

    public JTextField getPatenteTextField() { return this.patenteTextField; }

    public void setPatenteTextField(JTextField patenteTextField) { this.patenteTextField = patenteTextField; }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public Calendar calcularTiempo() {
        return null;
    }

}