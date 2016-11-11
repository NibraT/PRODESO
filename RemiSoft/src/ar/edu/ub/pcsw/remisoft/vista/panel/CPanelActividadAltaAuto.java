package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.controlador.main.CInsertSQL;
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

    //private CInsertSQL insert = new CInsertSQL();
    private JLabel aseguradoraLabel;
    private JLabel marcaLabel;
    private JLabel modeloLabel;
    private JLabel patenteLabel;
    private JTextField aseguradoraTextField;
    private JTextField marcaTextField;
    private JTextField modeloTextField;
    private JTextField patenteTextField;

    public CPanelActividadAltaAuto() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(EColorPanel.AUTOS.getColor());
        this.getNorteLabel().setText(ETextoButton.ALTAAUTO.getTexto().toUpperCase());
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
        if (e.getSource().equals(getAseguradoraTextField())) {
            if ((getAseguradoraTextField().getText() != null) || (! getAseguradoraTextField().getText().isEmpty())) {
                getGuardarButton().setEnabled(true);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getGuardarButton())) {
            new CInsertSQL().insertarVehiculo(getPatenteTextField().getText(), getMarcaTextField().getText(),
                    getModeloTextField().getText(), 10, 12000); ///
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
