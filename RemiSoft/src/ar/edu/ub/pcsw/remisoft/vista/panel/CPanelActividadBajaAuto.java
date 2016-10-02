package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.modelo.vehiculos.CVehiculo;
import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJButtonSalir;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJComboBoxFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJTextFieldFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IPanelFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CPanelActividadBajaAuto extends JPanel implements IJButtonSalir, IJComboBoxFactory, IJTextFieldFactory,
        ActionListener, FocusListener, KeyListener {

    private CButtonSelectorPanel salirButton;
    private JButton guardarButton;
    private JComboBox<String> causasLista;
    private JComboBox<String> propietariosLista;
    private JTextField fechaTextField;
    private JTextField marcaTextField;
    private JTextField modeloTextField;
    private JTextField patenteTextField;
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
        JLabel bajaAutoLabel = new JLabel("BAJA AUTO", SwingConstants.CENTER);
        bajaAutoLabel.setPreferredSize(new Dimension(this.getWidth(), 75));
        bajaAutoLabel.setFont(new Font("Arial", Font.BOLD, 25));
        bajaAutoLabel.setForeground(Color.WHITE);
        this.add(bajaAutoLabel, BorderLayout.NORTH);
        JLabel surLabel = new JLabel();
        surLabel.setPreferredSize(new Dimension(this.getWidth(), 75));
        this.add(surLabel, BorderLayout.SOUTH);
        JPanel panelInput = new JPanel();
        panelInput.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(15, 0, 15, 0);
        JLabel referenciasLabel = new JLabel("(*) indica campo obligatorio");
        referenciasLabel.setFont(new Font("Arial", Font.ITALIC, 10));
        JLabel marcaLabel = new JLabel("Marca (*)");
        marcaLabel.setPreferredSize(new Dimension(165, 15));
        JLabel modeloLabel = new JLabel("Modelo (*)");
        JLabel patenteLabel = new JLabel("Patente (*)");
        JLabel propietarioLabel = new JLabel("Propietario (*)");
        JLabel causaBajaLabel = new JLabel("Causa de la baja (*)");
        JLabel fechaLabel = new JLabel("Fecha de la baja");
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
        this.setSalirButton(new CButtonSelectorPanel(new IPanelFactory() {
            @Override
            public JPanel crearPanel() {
                return new CPanelFondo(EFondoPanel.MAPAGARIN.getTexto(), EFondoPanel.MAPAGARIN.getAncho(),
                        EFondoPanel.MAPAGARIN.getAlto());
            }
        }, ETextoButton.SALIR.getTexto(), "Habilita Salir de la Actividad"));
        this.getSalirButton().addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelInput.add(referenciasLabel, gbc);
        gbc.gridy++;
        panelInput.add(marcaLabel, gbc);
        gbc.gridy++;
        panelInput.add(modeloLabel, gbc);
        gbc.gridy++;
        panelInput.add(patenteLabel, gbc);
        gbc.gridy++;
        panelInput.add(propietarioLabel, gbc);
        gbc.gridy++;
        panelInput.add(causaBajaLabel, gbc);
        gbc.gridy++;
        panelInput.add(fechaLabel, gbc);
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
                setPropietario((getPropietariosLista().getSelectedItem().toString()));
            }
        }
        else if (e.getSource().equals(getCausasLista().getSelectedItem())) {
            if ((getCausasLista().getSelectedItem().toString() != null) ||
                    (! getCausasLista().getSelectedItem().toString().isEmpty())) {
                setFecha(this.getFecha());
            }
        }
        else if (e.getSource().equals(getGuardarButton())) {
            auto.setMarca(this.getMarca());
            auto.setModelo(this.getModelo());
            auto.setPatente(this.getPatente());
            auto.setPropietario(this.getPropietario());
            auto.setFechaDeBaja(this.getFecha());
        }
        else if (e.getSource().equals(getSalirButton())) {
            accionarSalirButton(e); // método default de IJButtonSalir
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
