package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.modelo.interfaces.ITemporizable;
import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public abstract class CPanelActividadBase extends JPanel implements IJButtonSalir, IJComboBoxFactory,
        IJTextFieldFactory, ITemporizable, IValidadorInput {

    private CButtonSelectorPanel salirButton;
    private GridBagConstraints gbc;
    private JButton guardarButton;
    private JComboBox<String> recepcionistasLista;
    private JLabel causaLabel;
    private JLabel clienteLabel;
    private JLabel domicilioLabel;
    private JLabel fechaLabel;
    private JLabel norteLabel;
    private JLabel recepcionistaLabel;
    private JLabel referenciasLabel;
    private JLabel surLabel;
    private JLabel telefonoLabel;
    private JPanel panelInput;
    private JTextField domicilioTextField;
    private JTextField fechaTextField;
    private JTextField telefonoTextField;
    private String domicilio;
    private String fecha;
    private String telefono;
    private String[] recepcionistas = new String[] {" ", "15733921", "39576117", "10944823"};

    public CPanelActividadBase() {
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BorderLayout());
        this.setNorteLabel(new JLabel("", SwingConstants.CENTER));
        this.getNorteLabel().setPreferredSize(new Dimension(this.getWidth(), 100));
        this.getNorteLabel().setFont(new Font("Arial", Font.BOLD, 25));
        this.getNorteLabel().setForeground(Color.WHITE);
        this.setSurLabel(new JLabel());
        this.getSurLabel().setPreferredSize(new Dimension(this.getWidth(), 100));
        this.setPanelInput(new JPanel());
        this.getPanelInput().setLayout(new GridBagLayout());
        this.setGbc(new GridBagConstraints());
        this.getGbc().insets = new Insets(15, 0, 15, 0);
        this.setReferenciasLabel(new JLabel("<html>(/) indica alternativa; <font color='red'>rojo</font> indica" +
                " campo obligatorio</html>"));
        this.getReferenciasLabel().setFont(new Font("Arial", Font.ITALIC, 10));
        this.setGuardarButton(new JButton("Guardar"));
        this.getGuardarButton().setPreferredSize(new Dimension(100, 30));
        this.getGuardarButton().setToolTipText(EToolTipTextTexto.GUARDAR.getTexto());
        this.getGuardarButton().setEnabled(false);
        this.setSalirButton(new CButtonSelectorPanel(new IPanelFactory() {
            JPanel panelFondo = crearPanel();
        }, ETextoButton.SALIR.getTexto(), EToolTipTextTexto.SALIRACTIVIDAD.getTexto()));
        this.getSalirButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(getSalirButton())) {
                    // método default de IJButtonSalir
                    accionarSalirButton(e);
                }
            }
        });
    }

    public CPanelActividadBase(String uno) {
        this();
        this.setDomicilioLabel(new JLabel("Domicilio"));
        this.getDomicilioLabel().setForeground(Color.RED);
        this.setTelefonoLabel(new JLabel("Teléfono"));
        this.getTelefonoLabel().setForeground(Color.RED);
        int ancho = 30;
        // método default de IJTextFieldFactory
        this.setDomicilioTextField(this.setTextField(ancho, EToolTipTextTexto.SOLOLETRASYNUMEROS.getTexto(), this));
        // método default de IValidadorInput
        this.getDomicilioTextField().setInputVerifier(validadorInput(ERegexValidadorInput.DOMICILIO.getTexto(),
                getDomicilioTextField().getToolTipText(), getDomicilioLabel().getText()));
        // método default de IJTextFieldFactory
        this.setTelefonoTextField(this.setTextField(ancho, EToolTipTextTexto.SOLONUMEROS.getTexto(), this));
        // método default de IValidadorInput
        this.getTelefonoTextField().setInputVerifier(validadorInput(ERegexValidadorInput.TELEFONO.getTexto(),
                getTelefonoTextField().getToolTipText(), getTelefonoLabel().getText()));
    }

    public CPanelActividadBase(int dos) {
        this();
        this.setCausaLabel(new JLabel("Causa de la baja"));
        this.getCausaLabel().setForeground(Color.RED);
        this.setFechaLabel(new JLabel("Fecha de la baja"));
        // método default de IJTextFieldFactory
        this.setFechaTextField(this.setTextField(30, setFechaString(Calendar.getInstance()),
                EToolTipTextTexto.FECHA.getTexto(), this));
        // método default de IValidadorInput
        this.getFechaTextField().setInputVerifier(validadorInput(ERegexValidadorInput.FECHA.getTexto(),
                getFechaTextField().getToolTipText(), getFechaLabel().getText()));
    }

    public CPanelActividadBase(double tres) {
        this();
        this.setBackground(EColorPanel.VIAJES.getColor());
        this.setClienteLabel(new JLabel("Cliente DNI / CUIL / CUIT"));
        this.getClienteLabel().setPreferredSize(new Dimension(260, 15));
        this.getClienteLabel().setForeground(Color.RED);
        this.setFechaLabel(new JLabel("Fecha"));
        this.getFechaLabel().setForeground(Color.RED);
        this.setRecepcionistaLabel(new JLabel("Recepcionista"));
        this.getRecepcionistaLabel().setForeground(Color.RED);
        // método default de IJTextFieldFactory
        this.setFechaTextField(this.setTextField(30, setFechaString(Calendar.getInstance()),
                EToolTipTextTexto.FECHA.getTexto(), this));
        // método default de IValidadorInput
        this.getFechaTextField().setInputVerifier(validadorInput(ERegexValidadorInput.FECHA.getTexto(),
                getFechaTextField().getToolTipText(), getFechaLabel().getText()));
        // método default de IJComboBoxFactory
        this.setRecepcionistasLista(this.crearComboBox(this.getRecepcionistas(), 333, 20, Color.WHITE,
                EToolTipTextTexto.SELECCIONAR.getTexto() + getRecepcionistaLabel().getText(), this));
        // método default de IValidadorInput
        this.validadorInput(getRecepcionistasLista(), getRecepcionistasLista().getToolTipText(),
                getRecepcionistaLabel().getText());
   }

    public CButtonSelectorPanel getSalirButton() { return this.salirButton; }

    public void setSalirButton(CButtonSelectorPanel salirButton) { this.salirButton = salirButton; }

    public GridBagConstraints getGbc() { return this.gbc; }

    public void setGbc(GridBagConstraints gbc) { this.gbc = gbc; }

    public JButton getGuardarButton() { return this.guardarButton; }

    public void setGuardarButton(JButton guardarButton) { this.guardarButton = guardarButton; }

    public JComboBox<String> getRecepcionistasLista() { return this.recepcionistasLista; }

    public void setRecepcionistasLista(JComboBox<String> recepcionistasLista) {
        this.recepcionistasLista = recepcionistasLista;
    }

    public JLabel getCausaLabel() { return this.causaLabel; }

    public void setCausaLabel(JLabel causaLabel) { this.causaLabel = causaLabel; }

    public JLabel getClienteLabel() { return this.clienteLabel; }

    public void setClienteLabel(JLabel clienteLabel) { this.clienteLabel = clienteLabel; }

    public JLabel getDomicilioLabel() { return this.domicilioLabel; }

    public void setDomicilioLabel(JLabel domicilioLabel) { this.domicilioLabel = domicilioLabel; }

    public JLabel getFechaLabel() { return this.fechaLabel; }

    public void setFechaLabel(JLabel fechaLabel) { this.fechaLabel = fechaLabel; }

    public JLabel getNorteLabel() { return this.norteLabel; }

    public void setNorteLabel(JLabel norteLabel) { this.norteLabel = norteLabel; }

    public JLabel getRecepcionistaLabel() { return this.recepcionistaLabel; }

    public void setRecepcionistaLabel(JLabel recepcionistaLabel) {
        this.recepcionistaLabel = recepcionistaLabel;
    }

    public JLabel getReferenciasLabel() { return this.referenciasLabel; }

    public void setReferenciasLabel(JLabel referenciasLabel) { this.referenciasLabel = referenciasLabel; }

    public JLabel getSurLabel() { return this.surLabel; }

    public void setSurLabel(JLabel surLabel) { this.surLabel = surLabel; }

    public JLabel getTelefonoLabel() { return this.telefonoLabel; }

    public void setTelefonoLabel(JLabel telefonoLabel) { this.telefonoLabel = telefonoLabel; }

    public JPanel getPanelInput() { return this.panelInput; }

    public void setPanelInput(JPanel panelInput) { this.panelInput = panelInput; }

    public JTextField getDomicilioTextField() { return this.domicilioTextField; }

    public void setDomicilioTextField(JTextField domicilioTextField) { this.domicilioTextField = domicilioTextField; }

    public JTextField getFechaTextField() { return this.fechaTextField; }

    public void setFechaTextField(JTextField fechaTextField) { this.fechaTextField = fechaTextField; }

    public JTextField getTelefonoTextField() { return this.telefonoTextField; }

    public void setTelefonoTextField(JTextField telefonoTextField) { this.telefonoTextField = telefonoTextField; }

    public String getDomicilio() { return this.domicilio; }

    public void setDomicilio(String domicilio) { this.domicilio = domicilio; }

    public String getFecha() { return this.fecha; }

    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getTelefono() { return this.telefono; }

    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String[] getRecepcionistas() { return this.recepcionistas; }

    public void setRecepcionistas(String[] recepcionistas) { this.recepcionistas = recepcionistas; }

}
