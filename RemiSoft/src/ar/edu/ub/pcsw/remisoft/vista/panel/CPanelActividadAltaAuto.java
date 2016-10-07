package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.modelo.vehiculos.CVehiculo;
import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.frame.CFrameRemisoft;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJComboBoxFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJTextFieldFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CPanelActividadAltaAuto extends JPanel implements IJComboBoxFactory, IJTextFieldFactory, ActionListener,
        KeyListener {

    private CButtonSelectorPanel salirButton;
    private JButton guardarButton;
    private JComboBox<String> propietariosLista;
    private JLabel altaAutoLabel;
    private JLabel marcaLabel;
    private JLabel modeloLabel;
    private JLabel patenteLabel;
    private JLabel propietarioLabel;
    private JLabel referenciasLabel;
    private JLabel surLabel;
    private JTextField marcaTextField;
    private JTextField modeloTextField;
    private JTextField patenteTextField;
    private JTextField propietarioTextField;
    private String marca;
    private String modelo;
    private String patente;
    private String[] propietarios = new String[] {" ", "RSG", "19222185", "12089450", "14279142", "11782006"};

    public CPanelActividadAltaAuto() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.GREEN);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BorderLayout());
        this.setAltaAutoLabel(new JLabel("ALTA AUTO", SwingConstants.CENTER));
        this.getAltaAutoLabel().setPreferredSize(new Dimension(this.getWidth(), 125));
        this.getAltaAutoLabel().setFont(new Font("Arial", Font.BOLD, 25));
        this.getAltaAutoLabel().setForeground(Color.WHITE);
        this.add(this.getAltaAutoLabel(), BorderLayout.NORTH);
        this.setSurLabel(new JLabel());
        this.getSurLabel().setPreferredSize(new Dimension(this.getWidth(), 125));
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
        int ancho = 30;
        this.setMarcaTextField(this.setTextField(ancho, "Ingrese sólo letras y espacios en blanco", this));
        this.setModeloTextField(this.setTextField(ancho, "Ingrese sólo letras y espacios en blanco", this));
        this.setPatenteTextField(this.setTextField(ancho, "Ingrese sólo letras, números y espacios en blanco", this));
        this.setPropietariosLista(this.crearComboBox(this.getPropietarios(), 333, 20, Color.WHITE, "Seleccione propietario", this));
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
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelInput.add(this.getMarcaTextField(), gbc);
        gbc.gridy++;
        panelInput.add(this.getModeloTextField(), gbc);
        gbc.gridy++;
        panelInput.add(this.getPatenteTextField(), gbc);
        gbc.gridy++;
        panelInput.add(this.getPropietariosLista(), gbc);
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CVehiculo auto = new CVehiculo();
        if (e.getSource().equals(getPropietariosLista())) {
            getGuardarButton().setEnabled(true);
        }
        else if (e.getSource().equals(getPropietariosLista().getSelectedItem())) {
            if ((getPropietariosLista().getSelectedItem().toString() != null) ||
                    (! getPropietariosLista().getSelectedItem().toString().isEmpty())) {
                auto.setPropietario((getPropietariosLista().getSelectedItem().toString()));
            }
        }
        else if (e.getSource().equals(getGuardarButton())) {
            auto.setMarca(this.getMarca());
            auto.setModelo(this.getModelo());
            auto.setPatente(this.getPatente());
            auto.setPropietario((getPropietariosLista().getSelectedItem().toString()));
        }
        else if (e.getSource().equals(getSalirButton())) {
            ((CFrameRemisoft) getParent().getParent().getParent().getParent().getParent()).setPanelMenu(null);
            ((CFrameRemisoft) getParent().getParent().getParent().getParent().getParent()).setPanelActividad(((CButtonSelectorPanel) e.getSource()).getFactory().crearPanel(getSalirButton()));
        }
    }

    public CButtonSelectorPanel getSalirButton() { return this.salirButton; }

    public void setSalirButton(CButtonSelectorPanel salirButton) { this.salirButton = salirButton; }

    public JButton getGuardarButton() { return this.guardarButton; }

    public void setGuardarButton(JButton guardarButton) { this.guardarButton = guardarButton; }

    public JLabel getAltaAutoLabel() { return this.altaAutoLabel; }

    public void setAltaAutoLabel(JLabel altaAutoLabel) { this.altaAutoLabel = altaAutoLabel; }

    public JLabel getReferenciasLabel() { return this.referenciasLabel; }

    public void setReferenciasLabel(JLabel referenciasLabel) { this.referenciasLabel = referenciasLabel; }

    public JLabel getSurLabel() { return this.surLabel; }

    public void setSurLabel(JLabel surLabel) { this.surLabel = surLabel; }

    public JLabel getMarcaLabel() { return this.marcaLabel; }

    public void setMarcaLabel(JLabel marcaLabel) { this.marcaLabel = marcaLabel; }

    public JLabel getModeloLabel() { return this.modeloLabel; }

    public void setModeloLabel(JLabel modeloLabel) { this.modeloLabel = modeloLabel; }

    public JLabel getPatenteLabel() { return this.patenteLabel; }

    public void setPatenteLabel(JLabel patenteLabel) { this.patenteLabel = patenteLabel; }

    public JLabel getPropietarioLabel() { return this.propietarioLabel; }

    public void setPropietarioLabel(JLabel propietarioLabel) { this.propietarioLabel = propietarioLabel; }

    public JTextField getMarcaTextField() { return this.marcaTextField; }

    public void setMarcaTextField(JTextField marcaTextField) { this.marcaTextField = marcaTextField; }

    public JTextField getModeloTextField() { return this.modeloTextField; }

    public void setModeloTextField(JTextField modeloTextField) { this.modeloTextField = modeloTextField; }

    public JTextField getPatenteTextField() { return this.patenteTextField; }

    public void setPatenteTextField(JTextField patenteTextField) { this.patenteTextField = patenteTextField; }

    public JTextField getPropietarioTextField() { return this.propietarioTextField; }

    public void setPropietarioTextField(JTextField propietarioTextField) { this.propietarioTextField = propietarioTextField; }

    public String[] getPropietarios() { return this.propietarios; }

    public void setPropietarios(String[] propietarios) { this.propietarios = propietarios; }

    public JComboBox<String> getPropietariosLista() { return this.propietariosLista; }

    public void setPropietariosLista(JComboBox<String> propietariosLista) { this.propietariosLista = propietariosLista; }

    public String getMarca() { return this.marca; }

    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return this.modelo; }

    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getPatente() { return this.patente; }

    public void setPatente(String patente) { this.patente = patente; }

}
