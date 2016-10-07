package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.modelo.clientes.CCliente;
import ar.edu.ub.pcsw.remisoft.modelo.empleados.CEmpleado;
import ar.edu.ub.pcsw.remisoft.modelo.viajes.CViaje;
import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJButtonSalir;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJComboBoxFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJTextFieldFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IPanelFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CPanelActividadCancelarViaje extends JPanel implements IJButtonSalir, IJComboBoxFactory,
        IJTextFieldFactory, ActionListener, KeyListener {

    private CButtonSelectorPanel salirButton;
    private CViaje viaje = new CViaje();
    private JButton guardarButton;
    private JComboBox<String> motivosLista;
    private JComboBox<String> recepcionistasLista;
    private JTextField autoTextField;
    private JTextField choferTextField;
    private JTextField clienteTextField;
    private JTextField fechaTextField;
    private JTextField horaTextField;
    private JTextField numeroTextField;
    private String auto;
    private String chofer;
    private String cliente;
    private String fecha;
    private String hora;
    private String[] motivos = new String[] {" ", "Cliente desistió de viajar", "Sin auto disponible", "Sin chofer disponible"};
    private String[] recepcionistas = new String[] {" ", "15733921", "39576117", "10944823"};

    public CPanelActividadCancelarViaje() {
        this.inicializar();
    }

    public void inicializar() {
        this.setBackground(Color.ORANGE);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BorderLayout());
        JLabel cancelarViajeLabel = new JLabel("CANCELAR VIAJE", SwingConstants.CENTER);
        cancelarViajeLabel.setPreferredSize(new Dimension(this.getWidth(), 80));
        cancelarViajeLabel.setFont(new Font("Arial", Font.BOLD, 25));
        cancelarViajeLabel.setForeground(Color.WHITE);
        this.add(cancelarViajeLabel, BorderLayout.NORTH);
        JLabel surLabel = new JLabel();
        surLabel.setPreferredSize(new Dimension(this.getWidth(), 60));
        this.add(surLabel, BorderLayout.SOUTH);
        JPanel panelInput = new JPanel();
        panelInput.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(10, 0, 10, 0);
        JLabel referenciasLabel = new JLabel("(/) indica alternativa; (*) indica campo obligatorio");
        referenciasLabel.setFont(new Font("Arial", Font.ITALIC, 10));
        JLabel clienteLabel = new JLabel("Cliente DNI / CUIL / CUIT (*)");
        clienteLabel.setPreferredSize(new Dimension(260, 15));
        JLabel numeroLabel = new JLabel("Viaje Número");
        JLabel choferLabel = new JLabel("Chofer");
        JLabel autoLabel = new JLabel("Auto");
        JLabel fechaLabel = new JLabel("Fecha");
        JLabel horaLabel = new JLabel("Hora");
        JLabel motivoLabel = new JLabel("Motivo de la cancelación (*)");
        JLabel recepcionistaLabel = new JLabel("Recepcionista (*)");
        int ancho = 30;
        this.setClienteTextField(this.setTextField(ancho, "Ingrese sólo letras y espacios en blanco", this));
        this.setNumeroTextField(this.setTextField(ancho, "Número del Viaje a cancelar", this));
        this.setChoferTextField(this.setTextField(ancho, "Chofer del Viaje a cancelar", this));
        this.setAutoTextField(this.setTextField(ancho, "Auto del Viaje a cancelar", this));
        this.setFechaTextField(this.setTextField(ancho, "Fecha del Viaje a cancelar", this));
        this.setHoraTextField(this.setTextField(ancho, "Hora del Viaje a cancelar", this));
        this.setMotivosLista(this.crearComboBox(this.getMotivos(), 333, 20, Color.WHITE, "Seleccione motivo", this));
        this.setRecepcionistasLista(this.crearComboBox(this.getRecepcionistas(), 333, 20, Color.WHITE, "Seleccione recepcionista", this));
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
        panelInput.add(clienteLabel, gbc);
        gbc.gridy++;
        panelInput.add(numeroLabel, gbc);
        gbc.gridy++;
        panelInput.add(choferLabel, gbc);
        gbc.gridy++;
        panelInput.add(autoLabel, gbc);
        gbc.gridy++;
        panelInput.add(fechaLabel, gbc);
        gbc.gridy++;
        panelInput.add(horaLabel, gbc);
        gbc.gridy++;
        panelInput.add(motivoLabel, gbc);
        gbc.gridy++;
        panelInput.add(recepcionistaLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelInput.add(this.getClienteTextField(), gbc);
        gbc.gridy++;
        panelInput.add(this.getNumeroTextField(), gbc);
        gbc.gridy++;
        panelInput.add(this.getChoferTextField(), gbc);
        gbc.gridy++;
        panelInput.add(this.getAutoTextField(), gbc);
        gbc.gridy++;
        panelInput.add(this.getFechaTextField(), gbc);
        gbc.gridy++;
        panelInput.add(this.getHoraTextField(), gbc);
        gbc.gridy++;
        panelInput.add(this.getMotivosLista(), gbc);
        gbc.gridy++;
        panelInput.add(this.getRecepcionistasLista(), gbc);
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
        if (e.getSource().equals(getClienteTextField())) {
            if ((getClienteTextField().getText() != null) || (! getClienteTextField().getText().isEmpty())) {
                setCliente(getClienteTextField().getText());
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getViaje().setCliente(new CCliente());
        viaje.setRecepcionista(new CEmpleado());
        if (e.getSource().equals(getRecepcionistasLista())) {
            getGuardarButton().setEnabled(true);
        }
        else if (e.getSource().equals(getMotivosLista().getSelectedItem())) {
            if ((getMotivosLista().getSelectedItem().toString() != null) ||
                    (! getMotivosLista().getSelectedItem().toString().isEmpty())) {
                viaje.setMotivoCancelacion(getMotivosLista().getSelectedItem().toString());
            }
        }
        else if (e.getSource().equals(getRecepcionistasLista().getSelectedItem())) {
            if ((getRecepcionistasLista().getSelectedItem().toString() != null) ||
                    (! getRecepcionistasLista().getSelectedItem().toString().isEmpty())) {
                viaje.getRecepcionista().setDni(getRecepcionistasLista().getSelectedItem().toString());
            }
        }
        else if (e.getSource().equals(getGuardarButton())) {
            viaje.getCliente().setIdentificacion(this.getCliente());
            viaje.setMotivoCancelacion(getMotivosLista().getSelectedItem().toString());
            viaje.getRecepcionista().setDni(getRecepcionistasLista().getSelectedItem().toString());
        }
        else if (e.getSource().equals(getSalirButton())) {
            accionarSalirButton(e); // método default de IJButtonSalir
        }
    }

    public CButtonSelectorPanel getSalirButton() { return this.salirButton; }

    public void setSalirButton(CButtonSelectorPanel salirButton) { this.salirButton = salirButton; }

    public CViaje getViaje() { return this.viaje; }

    public void setViaje(CViaje viaje) { this.viaje = viaje; }

    public JButton getGuardarButton() { return this.guardarButton; }

    public void setGuardarButton(JButton guardarButton) { this.guardarButton = guardarButton; }

    public JComboBox<String> getMotivosLista() { return this.motivosLista; }

    public void setMotivosLista(JComboBox<String> motivosLista) { this.motivosLista = motivosLista; }

    public JComboBox<String> getRecepcionistasLista() { return this.recepcionistasLista; }

    public void setRecepcionistasLista(JComboBox<String> recepcionistasLista) { this.recepcionistasLista = recepcionistasLista; }

    public JTextField getAutoTextField() { return this.autoTextField; }

    public void setAutoTextField(JTextField autoTextField) { this.autoTextField = autoTextField; }

    public JTextField getClienteTextField() { return this.clienteTextField; }

    public void setClienteTextField(JTextField clienteTextField) { this.clienteTextField = clienteTextField; }

    public JTextField getNumeroTextField() { return this.numeroTextField; }

    public void setNumeroTextField(JTextField numeroTextField) { this.numeroTextField = numeroTextField; }

    public JTextField getChoferTextField() { return this.choferTextField; }

    public void setChoferTextField(JTextField cuentaTextField) { this.choferTextField = cuentaTextField; }

    public JTextField getFechaTextField() { return this.fechaTextField; }

    public void setFechaTextField(JTextField fechaTextField) { this.fechaTextField = fechaTextField; }

    public JTextField getHoraTextField() { return this.horaTextField; }

    public void setHoraTextField(JTextField horaTextField) { this.horaTextField = horaTextField; }

    public String getAuto() { return this.auto; }

    public void setAuto(String destino) { this.auto = auto; }

    public String getCliente() { return this.cliente; }

    public void setCliente(String cliente) { this.cliente = cliente; }

    public String getChofer() { return this.chofer; }

    public void setChofer(String chofer) { this.chofer = chofer; }

    public String getFecha() { return this.fecha; }

    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getHora() { return this.hora; }

    public void setHora(String hora) { this.hora = hora; }

    public String[] getMotivos() { return this.motivos; }

    public void setMotivos(String[] motivos) { this.motivos = motivos; }

    public String[] getRecepcionistas() { return this.recepcionistas; }

    public void setRecepcionistas(String[] recepcionistas) { this.recepcionistas = recepcionistas; }

}
