package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.modelo.empleados.CEmpleado;
import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.frame.CFrameRemisoft;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJComboBoxFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJTextFieldFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CPanelActividadBajaEmpleado extends JPanel implements IJComboBoxFactory, IJTextFieldFactory,
        ActionListener, FocusListener, KeyListener {

    private CButtonSelectorPanel salirButton;
    private JButton guardarButton;
    private JComboBox<String> causasLista;
    private JLabel apellidoLabel;
    private JLabel bajaEmpleadoLabel;
    private JLabel causaBajaLabel;
    private JLabel fechaLabel;
    private JLabel identificacionLabel;
    private JLabel nombreLabel;
    private JLabel referenciasLabel;
    private JLabel surLabel;
    private JTextField apellidoTextField;
    private JTextField fechaTextField;
    private JTextField identificacionTextField;
    private JTextField nombreTextField;
    private String apellido;
    private String fecha;
    private String identificacion;
    private String nombre;
    private String[] causas = new String[] {" ", "Licencia", "Renuncia", "Despido", "Incapacidad", "Fallecimiento"};

    public CPanelActividadBajaEmpleado() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.MAGENTA);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BorderLayout());
        this.setBajaEmpleadoLabel(new JLabel("BAJA EMPLEADO", SwingConstants.CENTER));
        this.getBajaEmpleadoLabel().setPreferredSize(new Dimension(this.getWidth(), 100));
        this.getBajaEmpleadoLabel().setFont(new Font("Arial", Font.BOLD, 25));
        this.getBajaEmpleadoLabel().setForeground(Color.WHITE);
        this.add(this.getBajaEmpleadoLabel(), BorderLayout.NORTH);
        this.setSurLabel(new JLabel());
        this.getSurLabel().setPreferredSize(new Dimension(this.getWidth(), 100));
        this.add(this.getSurLabel(), BorderLayout.SOUTH);
        JPanel panelInput = new JPanel();
        panelInput.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(15, 0, 15, 0);
        this.setReferenciasLabel(new JLabel("(*) indica campo obligatorio"));
        this.getReferenciasLabel().setFont(new Font("Arial", Font.ITALIC, 10));
        this.setNombreLabel(new JLabel("Nombre(s) (*)"));
        this.getNombreLabel().setPreferredSize(new Dimension(165, 15));
        this.setApellidoLabel(new JLabel("Apellido (*)"));
        this.setIdentificacionLabel(new JLabel("DNI (*)"));
        this.setCausaBajaLabel(new JLabel("Causa de la baja (*)"));
        this.setFechaLabel(new JLabel("Fecha de la baja"));
        int ancho = 30;
        this.setNombreTextField(this.setTextField(ancho, "Ingrese sólo letras y espacios en blanco", this));
        this.setApellidoTextField(this.setTextField(ancho, "Ingrese sólo letras y espacios en blanco", this));
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
        panelInput.add(this.getNombreLabel(), gbc);
        gbc.gridy++;
        panelInput.add(this.getApellidoLabel(), gbc);
        gbc.gridy++;
        panelInput.add(this.getIdentificacionLabel(), gbc);
        gbc.gridy++;
        panelInput.add(this.getCausaBajaLabel(), gbc);
        gbc.gridy++;
        panelInput.add(this.getFechaLabel(), gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelInput.add(this.getNombreTextField(), gbc);
        gbc.gridy++;
        panelInput.add(this.getApellidoTextField(), gbc);
        gbc.gridy++;
        panelInput.add(this.getIdentificacionTextField(), gbc);
        gbc.gridy++;
        panelInput.add(this.getCausasLista(), gbc);
        gbc.gridy++;
        panelInput.add(this.getFechaTextField(), gbc);
        gbc.gridx = 1;
        gbc.gridy = 6;
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
        if (e.getSource().equals(getNombreTextField())) {
            if ((getNombreTextField().getText() != null) || (! getNombreTextField().getText().isEmpty())) {
                setNombre(getNombreTextField().getText());
            }
        }
        else if (e.getSource().equals(getApellidoTextField())) {
            if ((getApellidoTextField().getText() != null) || (! getApellidoTextField().getText().isEmpty())) {
                setApellido(getApellidoTextField().getText());
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
        CEmpleado empleado = new CEmpleado();
        if (e.getSource().equals(getCausasLista())) {
            getGuardarButton().setEnabled(true);
        }
        else if (e.getSource().equals(getCausasLista().getSelectedItem())) {
            if ((getCausasLista().getSelectedItem().toString() != null) ||
                    (! getCausasLista().getSelectedItem().toString().isEmpty())) {
                empleado.setFechaDeBaja(this.getFecha());
            }
        }
        else if (e.getSource().equals(getGuardarButton())) {
            empleado.setNombre(this.getNombre());
            empleado.setApellido((this.getApellido()));
            empleado.setDni(this.getIdentificacion());
            empleado.setFechaDeBaja(this.getFecha());
            empleado.eliminarEmpleado();
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

    public JLabel getApellidoLabel() { return this.apellidoLabel; }

    public void setApellidoLabel(JLabel apellidoLabel) { this.apellidoLabel = apellidoLabel; }

    public JLabel getBajaEmpleadoLabel() { return this.bajaEmpleadoLabel; }

    public void setBajaEmpleadoLabel(JLabel bajaEmpleadoLabel) { this.bajaEmpleadoLabel = bajaEmpleadoLabel; }

    public JLabel getCausaBajaLabel() { return this.causaBajaLabel; }

    public void setCausaBajaLabel(JLabel causaBajaLabel) { this.causaBajaLabel = causaBajaLabel; }

    public JLabel getFechaLabel() { return this.fechaLabel; }

    public void setFechaLabel(JLabel fechaLabel) { this.fechaLabel = fechaLabel; }

    public JLabel getIdentificacionLabel() { return this.identificacionLabel; }

    public void setIdentificacionLabel(JLabel identificacionLabel) {
        this.identificacionLabel = identificacionLabel;
    }

    public JLabel getNombreLabel() { return this.nombreLabel; }

    public void setNombreLabel(JLabel nombreLabel) { this.nombreLabel = nombreLabel; }

    public JLabel getReferenciasLabel() { return this.referenciasLabel; }

    public void setReferenciasLabel(JLabel referenciasLabel) { this.referenciasLabel = referenciasLabel; }

    public JLabel getSurLabel() { return this.surLabel; }

    public void setSurLabel(JLabel surLabel) { this.surLabel = surLabel; }

    public JTextField getApellidoTextField() { return this.apellidoTextField; }

    public void setApellidoTextField(JTextField apellidoTextField) {
        this.apellidoTextField = apellidoTextField;
    }

    public JTextField getFechaTextField() { return this.fechaTextField; }

    public void setFechaTextField(JTextField fechaTextField) {
        this.fechaTextField = fechaTextField;
    }

    public JTextField getIdentificacionTextField() { return this.identificacionTextField; }

    public void setIdentificacionTextField(JTextField identificacionTextField) {
        this.identificacionTextField = identificacionTextField;
    }

    public JTextField getNombreTextField() { return this.nombreTextField; }

    public void setNombreTextField(JTextField nombreTextField) { this.nombreTextField = nombreTextField; }

    public String getApellido() { return this.apellido; }

    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getFecha() { return this.fecha; }

    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getIdentificacion() { return this.identificacion; }

    public void setIdentificacion(String identificacion) { this.identificacion = identificacion; }

    public String getNombre() { return this.nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String[] getCausas() { return this.causas; }

    public void setCausas(String[] causas) { this.causas = causas; }

}
