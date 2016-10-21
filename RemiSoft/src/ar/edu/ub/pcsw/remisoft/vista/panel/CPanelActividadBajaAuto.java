package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.modelo.interfaces.ITemporizable;
import ar.edu.ub.pcsw.remisoft.modelo.vehiculos.CVehiculo;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJButtonSalir;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJComboBoxFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJTextFieldFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IValidadorInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class CPanelActividadBajaAuto extends CPanelActividadBase implements IJButtonSalir, IJComboBoxFactory,
        IJTextFieldFactory, ITemporizable, IValidadorInput, ActionListener, FocusListener, KeyListener {

    private JComboBox<String> causasLista;
    private JComboBox<String> marcasLista;
    private JComboBox<String> modelosLista;
    private JComboBox<String> patentesLista;
    private JLabel marcaLabel;
    private JLabel modeloLabel;
    private JLabel patenteLabel;
    private String marca;
    private String modelo;
    private String patente;
    private String[] causas = new String[] {" ", "Venta", "Daño", "Robo"};
    private String[] marcas = new String[] {" ", "A", "B", "C", "D"};
    private String[] modelos = new String[] {" ", "A", "B", "C", "D"};
    private String[] patentes = new String[] {" ", "A", "B", "C", "D"};

    public CPanelActividadBajaAuto() {
        super(2);
        this.inicializar(); }

    private void inicializar() {
        this.setBackground(Color.GREEN);
        this.getNorteLabel().setText("BAJA AUTO");
        this.add(getNorteLabel(), BorderLayout.NORTH);
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
        // método default de IJComboBoxFactory
        this.setMarcasLista(this.crearComboBox(this.getMarcas(), 333, 20, Color.WHITE, EToolTipTextTexto.
                SELECCIONAR.getTexto() + getMarcaLabel().getText(), this));
        // método default de IValidadorInput
        this.validadorInput(getMarcasLista(), getMarcasLista().getToolTipText(), getMarcaLabel().getText());
        // método default de IJComboBoxFactory
        this.setModelosLista(this.crearComboBox(this.getModelos(), 333, 20, Color.WHITE, EToolTipTextTexto.
                SELECCIONAR.getTexto() + getModeloLabel().getText(), this));
        // método default de IValidadorInput
        this.validadorInput(getModelosLista(), getModelosLista().getToolTipText(), getModeloLabel().getText());
        // método default de IJComboBoxFactory
        this.setPatentesLista(this.crearComboBox(this.getPatentes(), 333, 20, Color.WHITE, EToolTipTextTexto.
                SELECCIONAR.getTexto() + getPatenteLabel().getText(), this));
        // método default de IValidadorInput
        this.validadorInput(getPatentesLista(), getPatentesLista().getToolTipText(), getPatenteLabel().getText());
        // método default de IJComboBoxFactory
        this.setCausasLista(this.crearComboBox(this.getCausas(), 333, 20, Color.WHITE, EToolTipTextTexto.
                SELECCIONAR.getTexto() + getCausaLabel().getText(), this));
        // método default de IValidadorInput
        this.validadorInput(getCausasLista(), getCausasLista().getToolTipText(), getCausaLabel().getText());
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
        this.getPanelInput().add(this.getCausaLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getFechaLabel(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 1;
        this.getPanelInput().add(this.getMarcasLista(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getModelosLista(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getPatentesLista(), this.getGbc());
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
        if (e.getSource().equals(getFechaTextField())) {
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
        else if (e.getSource().equals(getMarcasLista().getSelectedItem())) {
            if ((getMarcasLista().getSelectedItem().toString() != null) ||
                    (! getMarcasLista().getSelectedItem().toString().isEmpty())) {
                setMarca(this.getMarca());
            }
        }
        else if (e.getSource().equals(getModelosLista().getSelectedItem())) {
            if ((getModelosLista().getSelectedItem().toString() != null) ||
                    (! getModelosLista().getSelectedItem().toString().isEmpty())) {
                setModelo(this.getModelo());
            }
        }
        else if (e.getSource().equals(getPatentesLista().getSelectedItem())) {
            if ((getPatentesLista().getSelectedItem().toString() != null) ||
                    (! getPatentesLista().getSelectedItem().toString().isEmpty())) {
                setPatente(this.getPatente());
            }
        }
        else if (e.getSource().equals(getCausasLista().getSelectedItem())) {
            if ((getCausasLista().getSelectedItem().toString() != null) ||
                    (! getCausasLista().getSelectedItem().toString().isEmpty())) {
                setFecha(this.getFecha());
            }
        }
        else if (e.getSource().equals(getGuardarButton())) {
            CVehiculo auto = new CVehiculo();
            auto.setMarca(this.getMarca());
            auto.setModelo(this.getModelo());
            auto.setPatente(this.getPatente());
            auto.setFechaDeBaja(this.getFecha());
        }
        else if (e.getSource().equals(getSalirButton())) {
            // método default de IJButtonSalir
            accionarSalirButton(e);
        }
    }

    public JComboBox<String> getCausasLista() {
        return this.causasLista;
    }

    public void setCausasLista(JComboBox<String> causasLista) {
        this.causasLista = causasLista;
    }

    public JComboBox<String> getMarcasLista() { return this.marcasLista; }

    public void setMarcasLista(JComboBox<String> marcasLista) { this.marcasLista = marcasLista; }

    public JComboBox<String> getModelosLista() { return this.modelosLista; }

    public void setModelosLista(JComboBox<String> modelosLista) { this.modelosLista = modelosLista; }

    public JComboBox<String> getPatentesLista() { return this.patentesLista; }

    public void setPatentesLista(JComboBox<String> patentesLista) { this.patentesLista = patentesLista; }

    public JLabel getMarcaLabel() { return this.marcaLabel; }

    public void setMarcaLabel(JLabel marcaLabel) { this.marcaLabel = marcaLabel; }

    public JLabel getModeloLabel() { return this.modeloLabel; }

    public void setModeloLabel(JLabel modeloLabel) { this.modeloLabel = modeloLabel; }

    public JLabel getPatenteLabel() { return this.patenteLabel; }

    public void setPatenteLabel(JLabel patenteLabel) { this.patenteLabel = patenteLabel; }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPatente() {
        return this.patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String[] getCausas() {
        return this.causas;
    }

    public void setCausas(String[] causas) {
        this.causas = causas;
    }

    public String[] getMarcas() { return this.marcas; }

    public void setMarcas(String[] marcas) { this.marcas = marcas; }

    public String[] getModelos() { return this.modelos; }

    public void setModelos(String[] modelos) { this.modelos = modelos; }

    public String[] getPatentes() { return this.patentes; }

    public void setPatentes(String[] patentes) { this.patentes = patentes; }

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
