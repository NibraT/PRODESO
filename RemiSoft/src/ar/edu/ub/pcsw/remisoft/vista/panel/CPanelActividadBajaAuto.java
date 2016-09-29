package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.modelo.vehiculos.CVehiculo;
import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.frame.CFrameRemisoft;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJComboBoxFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJTextFieldFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CPanelActividadBajaAuto extends JPanel implements IJComboBoxFactory, IJTextFieldFactory,
        ActionListener, FocusListener, KeyListener {

    private CButtonSelectorPanel salirButton;
    private JButton guardarButton;
    private JComboBox<String> causasLista;
    private JComboBox<String> propietariosLista;
    private JLabel bajaAutoLabel;
    private JLabel causaBajaLabel;
    private JLabel fechaLabel;
    private JLabel marcaLabel;
    private JLabel modeloLabel;
    private JLabel patenteLabel;
    private JLabel propietarioLabel;
    private JLabel referenciasLabel;
    private JLabel surLabel;
    private JTextField fechaTextField;
    private JTextField marcaTextField;
    private JTextField modeloTextField;
    private JTextField patenteTextField;
    private JTextField propietarioTextField;
    private String fecha;
    private String marca;
    private String modelo;
    private String patente;
    private String propietario;
    private String[] causas = new String[] {" ", "Venta", "Daño", "Robo"};
    private String[] propietarios = new String[] {" ", "RSG", "19222185", "12089450", "14279142", "11782006"};

    public CPanelActividadBajaAuto() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.GREEN);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BorderLayout());
        this.setBajaAutoLabel(new JLabel("BAJA AUTO", SwingConstants.CENTER));
        this.getBajaAutoLabel().setPreferredSize(new Dimension(this.getWidth(), 75));
        this.getBajaAutoLabel().setFont(new Font("Arial", Font.BOLD, 25));
        this.getBajaAutoLabel().setForeground(Color.WHITE);
        this.add(this.getBajaAutoLabel(), BorderLayout.NORTH);
        this.setSurLabel(new JLabel());
        this.getSurLabel().setPreferredSize(new Dimension(this.getWidth(), 75));
        this.add(this.getSurLabel(), BorderLayout.SOUTH);
        JPanel panelInput = new JPanel();
        panelInput.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(15, 0, 15, 0);
        this.setReferenciasLabel(new JLabel("(*) indica campo obligatorio"));
        this.getReferenciasLabel().setFont(new Font("Arial", Font.ITALIC, 10));
        this.setMarcaLabel(new JLabel("Marca (*)"));
        this.getMarcaLabel().setPreferredSize(new Dimension(165, 15));
        this.setModeloLabel(new JLabel("Modelo (*)"));
        this.setPatenteLabel(new JLabel("Patente (*)"));
        this.setPropietarioLabel(new JLabel("Propietario (*)"));
        this.setCausaBajaLabel(new JLabel("Causa de la baja (*)"));
        this.setFechaLabel(new JLabel("Fecha de la baja"));
        int ancho = 30;
        this.setMarcaTextField(this.setTextField(ancho, "Ingrese sólo letras y espacios en blanco", this));
        this.setModeloTextField(this.setTextField(ancho, "Ingrese sólo letras y espacios en blanco", this));
        this.setPatenteTextField(this.setTextField(ancho, "Ingrese sólo letras, números y espacios en blanco", this));
        this.setPropietariosLista(this.crearComboBox(this.getPropietarios(), 333, 20, Color.WHITE, "Seleccione propietario", this));
        this.setCausasLista(this.crearComboBox(this.getCausas(), 333, 20, Color.WHITE, "Seleccione causa", this));
        this.setFechaTextField(this.setTextField(ancho, "00/00/0000", "Ingrese la fecha con formato DD/MM/AAAA", this));
        this.setGuardarButton(new JButton("Guardar"));
        this.getGuardarButton().setPreferredSize(new Dimension(100, 30));
        this.getGuardarButton().setEnabled(false);
        this.getGuardarButton().addActionListener(this);
        this.setSalirButton(new CButtonSelectorPanel(new CPanelFactory(), ETextoButton.SALIR.getTexto()));
        this.getSalirButton().addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelInput.add(this.getReferenciasLabel(), gbc);
        gbc.gridy++;
        panelInput.add(this.getMarcaLabel(), gbc);
        gbc.gridy++;
        panelInput.add(this.getModeloLabel(), gbc);
        gbc.gridy++;
        panelInput.add(this.getPatenteLabel(), gbc);
        gbc.gridy++;
        panelInput.add(this.getPropietarioLabel(), gbc);
        gbc.gridy++;
        panelInput.add(this.getCausaBajaLabel(), gbc);
        gbc.gridy++;
        panelInput.add(this.getFechaLabel(), gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelInput.add(this.getMarcaTextField(), gbc);
        gbc.gridy++;
        panelInput.add(this.getModeloTextField(), gbc);
        gbc.gridy++;
        panelInput.add(this.getPatenteTextField(), gbc);
        gbc.gridy++;
        panelInput.add(this.getPropietariosLista(), gbc);
        gbc.gridy++;
        panelInput.add(this.getCausasLista(), gbc);
        gbc.gridy++;
        panelInput.add(this.getFechaTextField(), gbc);
        gbc.gridx = 1;
        gbc.gridy = 10;
        panelInput.add(this.getGuardarButton(), gbc);
        gbc.anchor = GridBagConstraints.LINE_END;
        panelInput.add(this.getSalirButton(), gbc);
        this.add(panelInput);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

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
        else if (e.getSource().equals(getFechaTextField())) {
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
    public void focusLost(FocusEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CVehiculo auto = new CVehiculo();
        if (e.getSource().equals(getCausasLista())) {
            getGuardarButton().setEnabled(true);
        }
        else if (e.getSource().equals(getPropietariosLista().getSelectedItem())) {
            if ((getPropietariosLista().getSelectedItem().toString() != null) ||
                    (! getPropietariosLista().getSelectedItem().toString().isEmpty())) {
                auto.setPropietario((getPropietariosLista().getSelectedItem().toString()));
            }
        }
        else if (e.getSource().equals(getCausasLista().getSelectedItem())) {
            if ((getCausasLista().getSelectedItem().toString() != null) ||
                    (! getCausasLista().getSelectedItem().toString().isEmpty())) {
                auto.setFechaDeBaja(this.getFecha());
            }
        }
        else if (e.getSource().equals(getGuardarButton())) {
            auto.setMarca(this.getMarca());
            auto.setModelo(this.getModelo());
            auto.setPatente(this.getPatente());
            auto.setPropietario((getPropietariosLista().getSelectedItem().toString()));
            auto.setFechaDeBaja(this.getFecha());
            auto.eliminarVehiculo();
        }
        else if (e.getSource().equals(getSalirButton())) {
            ((CFrameRemisoft) getParent().getParent().getParent().getParent().getParent()).setPanelActividad(((CButtonSelectorPanel) e.getSource()).getFactory().crearPanel(getSalirButton()));
        }
    }

    public CButtonSelectorPanel getSalirButton() {
        return this.salirButton;
    }

    public void setSalirButton(CButtonSelectorPanel salirButton) {
        this.salirButton = salirButton;
    }

    public JButton getGuardarButton() {
        return this.guardarButton;
    }

    public void setGuardarButton(JButton guardarButton) {
        this.guardarButton = guardarButton;
    }

    public JComboBox<String> getCausasLista() {
        return this.causasLista;
    }

    public void setCausasLista(JComboBox<String> causasLista) {
        this.causasLista = causasLista;
    }

    public JLabel getBajaAutoLabel() {
        return this.bajaAutoLabel;
    }

    public void setBajaAutoLabel(JLabel bajaAutoLabel) {
        this.bajaAutoLabel = bajaAutoLabel;
    }

    public JLabel getCausaBajaLabel() {
        return this.causaBajaLabel;
    }

    public void setCausaBajaLabel(JLabel causaBajaLabel) {
        this.causaBajaLabel = causaBajaLabel;
    }

    public JLabel getFechaLabel() {
        return this.fechaLabel;
    }

    public void setFechaLabel(JLabel fechaLabel) {
        this.fechaLabel = fechaLabel;
    }

    public JLabel getMarcaLabel() {
        return this.marcaLabel;
    }

    public void setMarcaLabel(JLabel marcaLabel) {
        this.marcaLabel = marcaLabel;
    }

    public JLabel getModeloLabel() {
        return this.modeloLabel;
    }

    public void setModeloLabel(JLabel modeloLabel) {
        this.modeloLabel = modeloLabel;
    }

    public JLabel getPatenteLabel() {
        return this.patenteLabel;
    }

    public void setPatenteLabel(JLabel patenteLabel) {
        this.patenteLabel = patenteLabel;
    }

    public JLabel getPropietarioLabel() {
        return this.propietarioLabel;
    }

    public void setPropietarioLabel(JLabel propietarioLabel) {
        this.propietarioLabel = propietarioLabel;
    }

    public JLabel getReferenciasLabel() {
        return this.referenciasLabel;
    }

    public void setReferenciasLabel(JLabel referenciasLabel) {
        this.referenciasLabel = referenciasLabel;
    }

    public JLabel getSurLabel() {
        return this.surLabel;
    }

    public void setSurLabel(JLabel surLabel) {
        this.surLabel = surLabel;
    }

    public JTextField getMarcaTextField() {
        return this.marcaTextField;
    }

    public void setMarcaTextField(JTextField marcaTextField) {
        this.marcaTextField = marcaTextField;
    }

    public JTextField getModeloTextField() {
        return this.modeloTextField;
    }

    public void setModeloTextField(JTextField modeloTextField) {
        this.modeloTextField = modeloTextField;
    }

    public JTextField getPatenteTextField() {
        return this.patenteTextField;
    }

    public void setPatenteTextField(JTextField patenteTextField) {
        this.patenteTextField = patenteTextField;
    }

    public JTextField getPropietarioTextField() {
        return this.propietarioTextField;
    }

    public void setPropietarioTextField(JTextField propietarioTextField) {
        this.propietarioTextField = propietarioTextField;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

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

    public String getPropietario() {
        return this.propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String[] getCausas() {
        return this.causas;
    }

    public void setCausas(String[] causas) {
        this.causas = causas;
    }

    public JComboBox<String> getPropietariosLista() {
        return this.propietariosLista;
    }

    public void setPropietariosLista(JComboBox<String> propietariosLista) {
        this.propietariosLista = propietariosLista;
    }

    public String[] getPropietarios() {
        return this.propietarios;
    }

    public void setPropietarios(String[] propietarios) {
        this.propietarios = propietarios;
    }

    public JTextField getFechaTextField() {
        return this.fechaTextField;
    }

    public void setFechaTextField(JTextField fechaTextField) {
        this.fechaTextField = fechaTextField;
    }

}
