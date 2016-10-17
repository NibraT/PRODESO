package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.modelo.vehiculos.CVehiculo;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJButtonSalir;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJTextFieldFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IValidadorInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;

public class CPanelActividadAltaAuto extends CPanelActividadBase implements IJButtonSalir, IJTextFieldFactory,
        IValidadorInput, ActionListener, KeyListener {

    private JLabel aseguradoraLabel;
    private JLabel marcaLabel;
    private JLabel modeloLabel;
    private JLabel patenteLabel;
    private JTextField aseguradoraTextField;
    private JTextField marcaTextField;
    private JTextField modeloTextField;
    private JTextField patenteTextField;
    private String aseguradora;
    private String marca;
    private String modelo;
    private String patente;

    public CPanelActividadAltaAuto() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.GREEN);
        this.getNorteLabel().setText("ALTA AUTO");
        this.getNorteLabel().setPreferredSize(new Dimension(this.getWidth(), 125));
        this.add(getNorteLabel(), BorderLayout.NORTH);
        this.getSurLabel().setPreferredSize(new Dimension(this.getWidth(), 125));
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
        int ancho = 30;
        // método default de IJTextFieldFactory
        this.setMarcaTextField(this.setTextField(ancho, EToolTipTextTexto.SOLOLETRAS.getTexto(), this));
        // método default de IValidadorInput
        this.getMarcaTextField().setInputVerifier(validadorInput(ERegexValidadorInput.MARCA.getTexto(),
                getMarcaTextField().getToolTipText(), getMarcaLabel().getText()));
        // método default de IJTextFieldFactory
        this.setModeloTextField(this.setTextField(ancho, EToolTipTextTexto.SOLOLETRAS.getTexto(), this));
        // método default de IValidadorInput
        this.getModeloTextField().setInputVerifier(validadorInput(ERegexValidadorInput.MODELO.getTexto(),
                getModeloTextField().getToolTipText(), getModeloLabel().getText()));
        // método default de IJTextFieldFactory
        this.setPatenteTextField(this.setTextField(ancho, EToolTipTextTexto.SOLOLETRASYNUMEROS.getTexto(), this));
        // método default de IValidadorInput
        this.getPatenteTextField().setInputVerifier(validadorInput(ERegexValidadorInput.PATENTE.getTexto(),
                getPatenteTextField().getToolTipText(), getPatenteLabel().getText()));
        // método default de IJTextFieldFactory
        this.setAseguradoraTextField(this.setTextField(ancho, EToolTipTextTexto.SOLOLETRAS.getTexto(), this));
        // método default de IValidadorInput
        this.getAseguradoraTextField().setInputVerifier(validadorInput(ERegexValidadorInput.
                        NOMBREYAPELLIDOORAZONSOCIAL.getTexto(), getAseguradoraTextField().getToolTipText(),
                getAseguradoraLabel().getText()));
        this.getGuardarButton().addActionListener(this);
        this.getSalirButton().addActionListener(this);
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
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 1;
        this.getPanelInput().add(this.getMarcaTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getModeloTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getPatenteTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getAseguradoraTextField(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 10;
        this.getPanelInput().add(this.getGuardarButton(), this.getGbc());
        this.getGbc().anchor = GridBagConstraints.LINE_END;
        this.getPanelInput().add(this.getSalirButton(), this.getGbc());
        this.add(this.getPanelInput());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource().equals(getMarcaTextField())) {
            if ((getMarcaTextField().getText() != null) || (! getMarcaTextField().getText().isEmpty())) {
                setMarca(getMarcaTextField().getText());
            }
        }
        else if (e.getSource().equals(getModeloTextField())) {
            if ((getModeloTextField().getText() != null) || (! getModeloTextField().getText().isEmpty())) {
                setModelo(getModeloTextField().getText());
            }
        }
        else if (e.getSource().equals(getPatenteTextField())) {
            if ((getPatenteTextField().getText() != null) || (! getPatenteTextField().getText().isEmpty())) {
                setPatente(getPatenteTextField().getText());
            }
        }
        else if (e.getSource().equals(getAseguradoraTextField())) {
            if ((getAseguradoraTextField().getText() != null) || (! getAseguradoraTextField().getText().isEmpty())) {
                setAseguradora(getAseguradoraTextField().getText());
                getGuardarButton().setEnabled(true);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getGuardarButton())) {
            CVehiculo auto = new CVehiculo();
            auto.setMarca(this.getMarca());
            auto.setModelo(this.getModelo());
            auto.setPatente(this.getPatente());
            auto.setAseguradora(this.getAseguradora());
        }
        else if (e.getSource().equals(getSalirButton())) {
            // método default de IJButtonSalir
            accionarSalirButton(e);
        }
    }

    public JLabel getAseguradoraLabel() { return this.aseguradoraLabel; }

    public void setAseguradoraLabel(JLabel aseguradoraLabel) { this.aseguradoraLabel = aseguradoraLabel; }

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

    public JTextField getMarcaTextField() { return this.marcaTextField; }

    public void setMarcaTextField(JTextField marcaTextField) { this.marcaTextField = marcaTextField; }

    public JTextField getModeloTextField() { return this.modeloTextField; }

    public void setModeloTextField(JTextField modeloTextField) { this.modeloTextField = modeloTextField; }

    public JTextField getPatenteTextField() { return this.patenteTextField; }

    public void setPatenteTextField(JTextField patenteTextField) { this.patenteTextField = patenteTextField; }

    public String getAseguradora() { return this.aseguradora; }

    public void setAseguradora(String aseguradora) { this.aseguradora = aseguradora; }

    public String getMarca() { return this.marca; }

    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return this.modelo; }

    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getPatente() { return this.patente; }

    public void setPatente(String patente) { this.patente = patente; }

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
