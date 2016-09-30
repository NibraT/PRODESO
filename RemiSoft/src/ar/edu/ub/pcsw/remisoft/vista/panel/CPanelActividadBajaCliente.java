package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.modelo.clientes.CCliente;
import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.frame.CFrameRemisoft;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJComboBoxFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJTextFieldFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CPanelActividadBajaCliente extends JPanel implements IJComboBoxFactory, IJTextFieldFactory,
        ActionListener, FocusListener, KeyListener {

    private CButtonSelectorPanel salirButton;
    private JButton guardarButton;
    private JComboBox<String> causasLista;
    private JLabel bajaClienteLabel;
    private JLabel causaBaja;
    private JLabel fechaLabel;
    private JLabel identificacionLabel;
    private JLabel nombreYApellidoORazonSocialLabel;
    private JLabel referenciasLabel;
    private JLabel surLabel;
    private JTextField fechaTextField;
    private JTextField identificacionTextField;
    private JTextField nombreYApellidoORazonSocialTextField;
    private String fecha;
    private String identificacion;
    private String nombreYApellidoORazonSocial;
    private String[] causas = new String[] {" ", "Morosidad", "Incobrable", "Administración RSG"};

    public CPanelActividadBajaCliente() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BorderLayout());
        this.setBajaClienteLabel(new JLabel("BAJA CLIENTE", SwingConstants.CENTER));
        this.getBajaClienteLabel().setPreferredSize(new Dimension(this.getWidth(), 125));
        this.getBajaClienteLabel().setFont(new Font("Arial", Font.BOLD, 25));
        this.getBajaClienteLabel().setForeground(Color.WHITE);
        this.add(this.getBajaClienteLabel(), BorderLayout.NORTH);
        this.setSurLabel(new JLabel());
        this.getSurLabel().setPreferredSize(new Dimension(this.getWidth(), 125));
        this.add(this.getSurLabel(), BorderLayout.SOUTH);
        JPanel panelInput = new JPanel();
        panelInput.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(15, 0, 15, 0);
        this.setReferenciasLabel(new JLabel("(/) indica alternativa; (*) indica campo obligatorio"));
        this.getReferenciasLabel().setFont(new Font("Arial", Font.ITALIC, 10));
        this.setNombreYApellidoORazonSocialLabel(new JLabel("Nombre(s) y Apellido / Razón Social (*)"));
        this.getNombreYApellidoORazonSocialLabel().setPreferredSize(new Dimension(260, 15));
        this.setIdentificacionLabel(new JLabel("DNI / CUIL / CUIT (*)"));
        this.setCausaBaja(new JLabel("Causa de la baja (*)"));
        this.setFechaLabel(new JLabel("Fecha de la baja"));
        int ancho = 30;
        this.setNombreYApellidoORazonSocialTextField(this.setTextField(ancho, "Ingrese sólo letras y espacios en blanco", this));
        this.setIdentificacionTextField(this.setTextField(ancho, "Ingrese sólo números", this));
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
        panelInput.add(this.getNombreYApellidoORazonSocialLabel(), gbc);
        gbc.gridy++;
        panelInput.add(this.getIdentificacionLabel(), gbc);
        gbc.gridy++;
        panelInput.add(this.getCausaBaja(), gbc);
        gbc.gridy++;
        panelInput.add(this.getFechaLabel(), gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelInput.add(this.getNombreYApellidoORazonSocialTextField(), gbc);
        gbc.gridy++;
        panelInput.add(this.getIdentificacionTextField(), gbc);
        gbc.gridy++;
        panelInput.add(this.getCausasLista(), gbc);
        gbc.gridy++;
        panelInput.add(this.getFechaTextField(), gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
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
        if (e.getSource().equals(getNombreYApellidoORazonSocialTextField())) {
            if ((getNombreYApellidoORazonSocialTextField().getText() != null) || (! getNombreYApellidoORazonSocialTextField().getText().isEmpty())) {
                setNombreYApellidoORazonSocial(getNombreYApellidoORazonSocialTextField().getText());
            }
        }
        else if (e.getSource().equals(getIdentificacionTextField())) {
            if ((getIdentificacionTextField().getText() != null) || (! getIdentificacionTextField().getText().isEmpty())) {
                setIdentificacion(getIdentificacionTextField().getText());
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
        CCliente cliente = new CCliente();
        if (e.getSource().equals(getCausasLista())) {
            getGuardarButton().setEnabled(true);
        }
        else if (e.getSource().equals(getCausasLista().getSelectedItem())) {
            if ((getCausasLista().getSelectedItem().toString() != null) ||
                    (! getCausasLista().getSelectedItem().toString().isEmpty())) {
                cliente.setFechaDeBaja(this.getFecha());
            }
        }
        else if (e.getSource().equals(getGuardarButton())) {
            cliente.setNombreYApellidoORazonSocial(this.getNombreYApellidoORazonSocial());
            cliente.setIdentificacion(this.getIdentificacion());
            cliente.setFechaDeBaja(this.getFecha());
            cliente.eliminarCliente();
        }
        else if (e.getSource().equals(getSalirButton())) {
            ((CFrameRemisoft) getParent().getParent().getParent().getParent().getParent()).setPanelActividad(((CButtonSelectorPanel) e.getSource()).getFactory().crearPanel(getSalirButton()));
        }
    }

    public CButtonSelectorPanel getSalirButton() { return this.salirButton; }

    public void setSalirButton(CButtonSelectorPanel salirButton) { this.salirButton = salirButton; }

    public JButton getGuardarButton() { return this.guardarButton; }

    public void setGuardarButton(JButton guardarButton) { this.guardarButton = guardarButton; }

    public JComboBox<String> getCausasLista() { return this.causasLista; }

    public void setCausasLista(JComboBox<String> causasLista) { this.causasLista = causasLista; }

    public JLabel getBajaClienteLabel() { return this.bajaClienteLabel; }

    public void setBajaClienteLabel(JLabel bajaClienteLabel) { this.bajaClienteLabel = bajaClienteLabel; }

    public JLabel getCausaBaja() { return this.causaBaja; }

    public void setCausaBaja(JLabel causaBaja) { this.causaBaja = causaBaja; }

    public JLabel getFechaLabel() { return this.fechaLabel; }

    public void setFechaLabel(JLabel fechaLabel) { this.fechaLabel = fechaLabel; }

    public JLabel getIdentificacionLabel() { return this.identificacionLabel; }

    public void setIdentificacionLabel(JLabel identificacionLabel) { this.identificacionLabel = identificacionLabel; }

    public JLabel getNombreYApellidoORazonSocialLabel() { return this.nombreYApellidoORazonSocialLabel; }

    public void setNombreYApellidoORazonSocialLabel(JLabel nombreYApellidoORazonSocialLabel) {
        this.nombreYApellidoORazonSocialLabel = nombreYApellidoORazonSocialLabel;
    }

    public JLabel getReferenciasLabel() { return this.referenciasLabel; }

    public void setReferenciasLabel(JLabel referenciasLabel) { this.referenciasLabel = referenciasLabel; }

    public JLabel getSurLabel() { return this.surLabel; }

    public void setSurLabel(JLabel surLabel) { this.surLabel = surLabel; }

    public JTextField getFechaTextField() { return this.fechaTextField; }

    public void setFechaTextField(JTextField fechaTextField) { this.fechaTextField = fechaTextField; }

    public JTextField getIdentificacionTextField() { return this.identificacionTextField; }

    public void setIdentificacionTextField(JTextField identificacionTextField) {
        this.identificacionTextField = identificacionTextField;
    }

    public JTextField getNombreYApellidoORazonSocialTextField() { return this.nombreYApellidoORazonSocialTextField; }

    public void setNombreYApellidoORazonSocialTextField(JTextField nombreYApellidoORazonSocialTextField) {
        this.nombreYApellidoORazonSocialTextField = nombreYApellidoORazonSocialTextField;
    }

    public String getFecha() { return this.fecha; }

    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getIdentificacion() { return this.identificacion; }

    public void setIdentificacion(String identificacion) { this.identificacion = identificacion; }

    public String getNombreYApellidoORazonSocial() { return this.nombreYApellidoORazonSocial; }

    public void setNombreYApellidoORazonSocial(String nombreYApellidoORazonSocial) {
        this.nombreYApellidoORazonSocial = nombreYApellidoORazonSocial;
    }

    public String[] getCausas() { return this.causas; }

    public void setCausas(String[] causas) { this.causas = causas; }

}
