package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.modelo.empleados.CEmpleado;
import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJButtonSalir;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJComboBoxFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJTextFieldFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IPanelFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CPanelActividadBajaEmpleado extends JPanel implements IJButtonSalir, IJComboBoxFactory, IJTextFieldFactory,
        ActionListener, FocusListener, KeyListener {

    private CButtonSelectorPanel salirButton;
    private JButton guardarButton;
    private JComboBox<String> causasLista;
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
        JLabel bajaEmpleadoLabel = new JLabel("BAJA EMPLEADO", SwingConstants.CENTER);
        bajaEmpleadoLabel.setPreferredSize(new Dimension(this.getWidth(), 100));
        bajaEmpleadoLabel.setFont(new Font("Arial", Font.BOLD, 25));
        bajaEmpleadoLabel.setForeground(Color.WHITE);
        this.add(bajaEmpleadoLabel, BorderLayout.NORTH);
        JLabel surLabel = new JLabel();
        surLabel.setPreferredSize(new Dimension(this.getWidth(), 100));
        this.add(surLabel, BorderLayout.SOUTH);
        JPanel panelInput = new JPanel();
        panelInput.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(15, 0, 15, 0);
        JLabel referenciasLabel = new JLabel("(*) indica campo obligatorio");
        referenciasLabel.setFont(new Font("Arial", Font.ITALIC, 10));
        JLabel nombreLabel = new JLabel("Nombre(s) (*)");
        nombreLabel.setPreferredSize(new Dimension(165, 15));
        JLabel apellidoLabel = new JLabel("Apellido (*)");
        JLabel identificacionLabel = new JLabel("DNI (*)");
        JLabel causaBajaLabel = new JLabel("Causa de la baja (*)");
        JLabel fechaLabel = new JLabel("Fecha de la baja");
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
        this.setSalirButton(new CButtonSelectorPanel(new IPanelFactory() {
            JPanel panel = crearPanel();
        }, ETextoButton.SALIR.getTexto(), "Habilita Salir de la Actividad"));
        this.getSalirButton().addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelInput.add(referenciasLabel, gbc);
        gbc.gridy++;
        panelInput.add(nombreLabel, gbc);
        gbc.gridy++;
        panelInput.add(apellidoLabel, gbc);
        gbc.gridy++;
        panelInput.add(identificacionLabel, gbc);
        gbc.gridy++;
        panelInput.add(causaBajaLabel, gbc);
        gbc.gridy++;
        panelInput.add(fechaLabel, gbc);
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
