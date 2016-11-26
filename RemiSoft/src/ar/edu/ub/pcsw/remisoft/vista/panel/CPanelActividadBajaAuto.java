package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.controlador.main.CSelectSQL;
import ar.edu.ub.pcsw.remisoft.controlador.main.CUpdateSQL;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJComboBoxFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJTextFieldFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IValidadorInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class CPanelActividadBajaAuto extends CPanelActividadBase implements ActionListener, FocusListener,
        IJComboBoxFactory, IJTextFieldFactory, IValidadorInput, KeyListener {

    private JComboBox<String> causasLista;

    private JComboBox<String> patentesLista;
    private JLabel marcaLabel;
    private JLabel modeloLabel;
    private JLabel patenteLabel;
    private JTextField marcaTextField;
    private JTextField modeloTextField;

    private String[] causas = new String[] {" ", "Daño", "Robo", "Service", "Venta"};

    public CPanelActividadBajaAuto() {
        super(2);
        this.inicializar(); }

    private void inicializar() {
        this.setBackground(EColorPanel.AUTOS.getColor());
        this.getNorteLabel().setText(ETextoButton.BAJAAUTO.getTexto().toUpperCase());
        this.add(getNorteLabel(), BorderLayout.NORTH);
        this.add(getSurLabel(), BorderLayout.SOUTH);
        this.getGbc().anchor = GridBagConstraints.LINE_START;
        this.getReferenciasLabel().setText("<html><font color='red'>rojo</font> indica campo obligatorio</html>");
        this.setMarcaLabel(new JLabel("Marca"));
        this.setModeloLabel(new JLabel("Modelo"));
        this.setPatenteLabel(new JLabel("Patente"));
        this.getPatenteLabel().setPreferredSize(new Dimension(165, 15));
        this.getPatenteLabel().setForeground(Color.RED);
        int ancho = 30;
        // método default de IJTextFieldFactory
        this.setMarcaTextField(this.setTextField(ancho, getMarcaLabel().getText() + " del auto a dar de baja", this));
        this.getMarcaTextField().setEditable(false);
        // método default de IJTextFieldFactory
        this.setModeloTextField(this.setTextField(ancho, getModeloLabel().getText() + " del auto a dar de baja", this));
        this.getModeloTextField().setEditable(false);
        // método default de IJComboBoxFactory
        this.setPatentesLista(this.crearComboBox(new CSelectSQL().selectRecursoParaBaja("Patente", null), 333, 20, Color.WHITE,
                EToolTipTextTexto.SELECCIONAR.getTexto() + getPatenteLabel().getText(), this));
        this.getPatentesLista().setEnabled(false);
        this.getPatentesLista().addFocusListener(this);
        // método default de IValidadorInput
        this.validadorInput(getPatentesLista(), getPatentesLista().getToolTipText(), getPatenteLabel().getText());
        // método default de IJComboBoxFactory
        this.setCausasLista(this.crearComboBox(this.getCausas(), 333, 20, Color.WHITE, EToolTipTextTexto.
                SELECCIONAR.getTexto() + getCausaLabel().getText(), this));
        this.getCausasLista().setEnabled(false);
        // método default de IValidadorInput
        this.validadorInput(getCausasLista(), getCausasLista().getToolTipText(), getCausaLabel().getText());
        this.getGuardarButton().addActionListener(this);
        this.getHabilitarButton().addActionListener(this);
        this.getGbc().gridx = 0;
        this.getGbc().gridy = 0;
        this.getPanelInput().add(this.getReferenciasLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getPatenteLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getMarcaLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getModeloLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getCausaLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getFechaLabel(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 0;
        this.getGbc().anchor = GridBagConstraints.CENTER;
        this.getPanelInput().add(getHabilitarButton(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 1;
        this.getPanelInput().add(this.getPatentesLista(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getMarcaTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getModeloTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getCausasLista(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getFechaTextField(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 10;
        this.getGbc().anchor = GridBagConstraints.LINE_START;
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
        if (e.getSource().equals(getHabilitarButton())) {
            getPatentesLista().setEnabled(true);
            getCausasLista().setEnabled(true);
            getFechaTextField().setEditable(true);
        }
        else if (e.getSource().equals(getCausasLista())) {
            getGuardarButton().setEnabled(true);
        }
        else if (e.getSource().equals(getGuardarButton())) {
            if ((getPatentesLista().getSelectedItem().toString().isEmpty()) ||
                    (getPatentesLista().getSelectedItem().toString() == null) ||
                    (getPatentesLista().getSelectedItem().toString().equals(" ")) ||
                    (getCausasLista().getSelectedItem().toString().isEmpty()) ||
                    (getCausasLista().getSelectedItem().toString() == null) ||
                    (getCausasLista().getSelectedItem().toString().equals(" "))) {
                JOptionPane.showMessageDialog(null, getMensajeErrorActividad(),
                        "Error en " + getNorteLabel().getText(), JOptionPane.ERROR_MESSAGE);
            }
            else {
                CUpdateSQL update = new CUpdateSQL();
                update.updateDisponibleVehiculo(0, getPatentesLista().getSelectedItem().toString());
                update.updateFechaBajaVehiculo(getPatentesLista().getSelectedItem().toString());
            }
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        CSelectSQL select = new CSelectSQL();
        this.getMarcaTextField().setText(select.selectRecurso("auto", getPatentesLista().getSelectedItem().toString(),
                "marca", 3));
        this.getModeloTextField().setText(select.selectRecurso("auto", getPatentesLista().getSelectedItem().toString(),
                "modelo", 3));
    }

    public JComboBox<String> getCausasLista() {
        return this.causasLista;
    }

    public void setCausasLista(JComboBox<String> causasLista) {
        this.causasLista = causasLista;
    }

    public JComboBox<String> getPatentesLista() { return this.patentesLista; }

    public void setPatentesLista(JComboBox<String> patentesLista) { this.patentesLista = patentesLista; }

    public JLabel getMarcaLabel() { return this.marcaLabel; }

    public void setMarcaLabel(JLabel marcaLabel) { this.marcaLabel = marcaLabel; }

    public JLabel getModeloLabel() { return this.modeloLabel; }

    public void setModeloLabel(JLabel modeloLabel) { this.modeloLabel = modeloLabel; }

    public JLabel getPatenteLabel() { return this.patenteLabel; }

    public void setPatenteLabel(JLabel patenteLabel) { this.patenteLabel = patenteLabel; }

    public JTextField getMarcaTextField() { return this.marcaTextField; }

    public void setMarcaTextField(JTextField marcaTextField) { this.marcaTextField = marcaTextField; }

    public JTextField getModeloTextField() { return this.modeloTextField; }

    public void setModeloTextField(JTextField modeloTextField) { this.modeloTextField = modeloTextField; }

    public String[] getCausas() {
        return this.causas;
    }

    public void setCausas(String[] causas) {
        this.causas = causas;
    }

    @Override
    public Calendar calcularTiempo() {
        return null;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}