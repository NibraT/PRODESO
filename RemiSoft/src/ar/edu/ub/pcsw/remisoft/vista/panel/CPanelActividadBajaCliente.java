package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.modelo.clientes.CCliente;
import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJButtonSalir;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJComboBoxFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJTextFieldFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IPanelFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CPanelActividadBajaCliente extends JPanel implements IJButtonSalir, IJComboBoxFactory, IJTextFieldFactory,
        ActionListener, FocusListener, KeyListener {

    private CButtonSelectorPanel salirButton;
    private JButton guardarButton;
    private JComboBox<String> causasLista;
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
        JLabel bajaClienteLabel = new JLabel("BAJA CLIENTE", SwingConstants.CENTER);
        bajaClienteLabel.setPreferredSize(new Dimension(this.getWidth(), 125));
        bajaClienteLabel.setFont(new Font("Arial", Font.BOLD, 25));
        bajaClienteLabel.setForeground(Color.WHITE);
        this.add(bajaClienteLabel, BorderLayout.NORTH);
        JLabel surLabel = new JLabel();
        surLabel.setPreferredSize(new Dimension(this.getWidth(), 125));
        this.add(surLabel, BorderLayout.SOUTH);
        JPanel panelInput = new JPanel();
        panelInput.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(15, 0, 15, 0);
        JLabel referenciasLabel = new JLabel("(/) indica alternativa; (*) indica campo obligatorio");
        referenciasLabel.setFont(new Font("Arial", Font.ITALIC, 10));
        JLabel nombreYApellidoORazonSocialLabel = new JLabel("Nombre(s) y Apellido / Razón Social (*)");
        nombreYApellidoORazonSocialLabel.setPreferredSize(new Dimension(260, 15));
        JLabel identificacionLabel = new JLabel("DNI / CUIL / CUIT (*)");
        JLabel causaBajaLabel = new JLabel("Causa de la baja (*)");
        JLabel fechaLabel = new JLabel("Fecha de la baja");
        int ancho = 30;
        this.setNombreYApellidoORazonSocialTextField(this.setTextField(ancho, "Ingrese sólo letras y espacios en blanco", this));
        this.setIdentificacionTextField(this.setTextField(ancho, "Ingrese sólo números", this));
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
        panelInput.add(nombreYApellidoORazonSocialLabel, gbc);
        gbc.gridy++;
        panelInput.add(identificacionLabel, gbc);
        gbc.gridy++;
        panelInput.add(causaBajaLabel, gbc);
        gbc.gridy++;
        panelInput.add(fechaLabel, gbc);
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
            if ((getNombreYApellidoORazonSocialTextField().getText() != null) ||
                    (! getNombreYApellidoORazonSocialTextField().getText().isEmpty())) {
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
        }
        else if (e.getSource().equals(getSalirButton())) {
            accionarSalirButton(e); // método default de IJButtonSalir
        }
    }

    public CButtonSelectorPanel getSalirButton() { return this.salirButton; }

    public void setSalirButton(CButtonSelectorPanel salirButton) { this.salirButton = salirButton; }

    public JButton getGuardarButton() { return this.guardarButton; }

    public void setGuardarButton(JButton guardarButton) { this.guardarButton = guardarButton; }

    public JComboBox<String> getCausasLista() { return this.causasLista; }

    public void setCausasLista(JComboBox<String> causasLista) { this.causasLista = causasLista; }

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
