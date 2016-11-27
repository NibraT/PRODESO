package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.controlador.main.CSelectSQL;
import ar.edu.ub.pcsw.remisoft.controlador.main.CUpdateSQL;
import ar.edu.ub.pcsw.remisoft.controlador.main.ETablas;
import ar.edu.ub.pcsw.remisoft.modelo.interfaces.ITemporizable;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJComboBoxFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJTextFieldFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IValidadorInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class CPanelActividadBajaEmpleado extends CPanelActividadBase implements ActionListener, FocusListener,
        IJComboBoxFactory, IJTextFieldFactory, ITemporizable, IValidadorInput, KeyListener {

    private JComboBox<String> causasLista;
    private JComboBox<String> identificacionesLista;
    private JLabel apellidoLabel;
    private JLabel categoriaLabel;
    private JLabel identificacionLabel;
    private JLabel nombreLabel;
    private JTextField apellidoTextField;
    private JTextField categoriaTextField;
    private JTextField nombreTextField;
    private String[] causas = new String[] {" ", "Despido", "Fallecimiento", "Incapacidad", "Licencia", "Renuncia",
            "Vacaciones"};

    public CPanelActividadBajaEmpleado() {
        super(2);
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(EColorPanel.EMPLEADOS.getColor());
        this.getNorteLabel().setText(ETextoButton.BAJAEMPLEADO.getTexto().toUpperCase());
        this.getNorteLabel().setPreferredSize(new Dimension(this.getWidth(), 85));
        this.add(getNorteLabel(), BorderLayout.NORTH);
        this.getSurLabel().setPreferredSize(new Dimension(this.getWidth(), 65));
        this.add(getSurLabel(), BorderLayout.SOUTH);
        this.getGbc().anchor = GridBagConstraints.LINE_START;
        this.getReferenciasLabel().setText("<html><font color='red'>rojo</font> indica campo obligatorio</html>");
        this.setNombreLabel(new JLabel("Nombre(s)"));
        this.setApellidoLabel(new JLabel("Apellido"));
        this.setCategoriaLabel(new JLabel("Categoría"));
        this.setIdentificacionLabel(new JLabel("DNI"));
        this.getIdentificacionLabel().setPreferredSize(new Dimension(160, 15));
        this.getIdentificacionLabel().setForeground(Color.RED);
        int ancho = 30;
        // método default de IJTextFieldFactory
        this.setApellidoTextField(this.setTextField(ancho, getApellidoLabel().getText() +
                " del empleado a dar de baja", this));
        this.getApellidoTextField().setEditable(false);
        // método default de IJTextFieldFactory
        this.setNombreTextField(this.setTextField(ancho, getNombreLabel().getText() +
                " del empleado a dar de baja", this));
        this.getNombreTextField().setEditable(false);
        // método default de IJTextFieldFactory
        this.setCategoriaTextField(this.setTextField(ancho, getCategoriaLabel().getText() +
                " del empleado a dar de baja", this));
        this.getCategoriaTextField().setEditable(false);
        // método default de IJComboBoxFactory
        this.setIdentificacionesLista(this.crearComboBox(new CSelectSQL().selectRecursoParaBaja("Dni", null), 333, 20,
                Color.WHITE, EToolTipTextTexto.SELECCIONAR.getTexto() +
                getIdentificacionLabel().getText(), this));
        this.getIdentificacionesLista().setEnabled(false);
        this.getIdentificacionesLista().addFocusListener(this);
        // método default de IValidadorInput
        this.validadorInput(getIdentificacionesLista(), getIdentificacionesLista().getToolTipText(),
                getIdentificacionLabel().getText());
        // método default de IJComboBoxFactory
        this.setCausasLista(this.crearComboBox(this.getCausas(), 333, 20, Color.WHITE,
                EToolTipTextTexto.SELECCIONAR.getTexto() + getCausaLabel().getText(), this));
        this.getCausasLista().setEnabled(false);
        // método default de IValidadorInput
        this.validadorInput(getCausasLista(), getCausasLista().getToolTipText(), getCausaLabel().getText());
        this.getGuardarButton().addActionListener(this);
        this.getHabilitarButton().addActionListener(this);
        this.getGbc().gridx = 0;
        this.getGbc().gridy = 0;
        this.getPanelInput().add(this.getReferenciasLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getIdentificacionLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getApellidoLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getNombreLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getCategoriaLabel(), this.getGbc());
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
        this.getPanelInput().add(this.getIdentificacionesLista(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getApellidoTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getNombreTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getCategoriaTextField(), this.getGbc());
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
            getIdentificacionesLista().setEnabled(true);
            getCausasLista().setEnabled(true);
            getFechaTextField().setEditable(true);
        }
        else if (e.getSource().equals(getCausasLista())) {
            getGuardarButton().setEnabled(true);
        }
        else if (e.getSource().equals(getGuardarButton())) {
            if ((getIdentificacionesLista().getSelectedItem().toString().isEmpty()) ||
                    (getIdentificacionesLista().getSelectedItem().toString() == null) ||
                    (getIdentificacionesLista().getSelectedItem().toString().equals(" ")) ||
                    (getCausasLista().getSelectedItem().toString().isEmpty()) ||
                    (getCausasLista().getSelectedItem().toString() == null) ||
                    (getCausasLista().getSelectedItem().toString().equals(" "))) {
                JOptionPane.showMessageDialog(null, getMensajeErrorActividad(),
                        "Error en " + getNorteLabel().getText(), JOptionPane.ERROR_MESSAGE);
            }
            else {
                CUpdateSQL update = new CUpdateSQL();
                update.updateTabla(ETablas.EMPLEADO, "fechaBaja", "Dni",
                        getIdentificacionesLista().getSelectedItem().toString(), 0);
                update.updateTabla(ETablas.EMPLEADO, "disponible", "Dni",
                        getIdentificacionesLista().getSelectedItem().toString(), 0);
            }
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        CSelectSQL select = new CSelectSQL();
        this.getApellidoTextField().setText(select.selectRecurso("empleado",
                getIdentificacionesLista().getSelectedItem().toString(), "apellido", 3));
        this.getNombreTextField().setText(select.selectRecurso("empleado",
                getIdentificacionesLista().getSelectedItem().toString(), "nombre", 3));
        String categoria = select.selectRecurso("empleado", getIdentificacionesLista().getSelectedItem().toString(),
                "TipoEmpleado", 3).equals("1") ? "chofer" : "recepcionista";
        this.getCategoriaTextField().setText(categoria);
    }

    public JComboBox<String> getCausasLista() { return this.causasLista; }

    public void setCausasLista(JComboBox<String> causasLista) { this.causasLista = causasLista; }

    public JComboBox<String> getIdentificacionesLista() { return this.identificacionesLista; }

    public void setIdentificacionesLista(JComboBox<String> identificacionesLista) {
        this.identificacionesLista = identificacionesLista;
    }

    public JLabel getApellidoLabel() { return this.apellidoLabel; }

    public void setApellidoLabel(JLabel apellidoLabel) { this.apellidoLabel = apellidoLabel; }

    public JLabel getCategoriaLabel() { return this.categoriaLabel; }

    public void setCategoriaLabel(JLabel categoriaLabel) { this.categoriaLabel = categoriaLabel; }

    public JLabel getIdentificacionLabel() { return this.identificacionLabel; }

    public void setIdentificacionLabel(JLabel identificacionLabel) { this.identificacionLabel = identificacionLabel; }

    public JLabel getNombreLabel() { return this.nombreLabel; }

    public void setNombreLabel(JLabel nombreLabel) { this.nombreLabel = nombreLabel; }

    public JTextField getApellidoTextField() { return this.apellidoTextField; }

    public void setApellidoTextField(JTextField apellidosTextField) { this.apellidoTextField = apellidosTextField; }

    public JTextField getCategoriaTextField() { return this.categoriaTextField; }

    public void setCategoriaTextField(JTextField categoriaTextField) { this.categoriaTextField = categoriaTextField; }

    public JTextField getNombreTextField() { return this.nombreTextField; }

    public void setNombreTextField(JTextField nombresTextField) { this.nombreTextField = nombresTextField; }

    public String[] getCausas() { return this.causas; }

    public void setCausas(String[] causas) { this.causas = causas; }

    @Override
    public void keyReleased(KeyEvent e) {

    }

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