package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.modelo.clientes.CCliente;
import ar.edu.ub.pcsw.remisoft.modelo.empleados.CChoferSinVehiculo;
import ar.edu.ub.pcsw.remisoft.modelo.empleados.CEmpleado;
import ar.edu.ub.pcsw.remisoft.modelo.interfaces.ITemporizable;
import ar.edu.ub.pcsw.remisoft.modelo.vehiculos.CVehiculo;
import ar.edu.ub.pcsw.remisoft.modelo.viajes.CViaje;
import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJButtonSalir;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJComboBoxFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJTextFieldFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IPanelFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class CPanelActividadTomarViaje extends JPanel implements IJButtonSalir, IJComboBoxFactory, IJTextFieldFactory,
        ITemporizable, ActionListener, FocusListener, KeyListener {

    private CButtonSelectorPanel salirButton;
    private CViaje viaje = new CViaje();
    private JButton guardarButton;
    private JComboBox<String> autosLista;
    private JComboBox<String> choferesLista;
    private JComboBox<String> recepcionistasLista;
    private JTextField clienteTextField;
    private JTextField cuentaTextField;
    private JTextField destinoTextField;
    private JTextField fechaTextField;
    private JTextField horaTextField;
    private JTextField origenTextField;
    private String cliente;
    private String cuenta;
    private String destino;
    private String fecha;
    private String hora;
    private String origen;
    private String[] autos = new String[] {" ", "NHU544", "KOW902", "LDP657", "PWS390"};
    private String[] choferes = new String[] {" ", "19222185", "12089450", "14279142", "11782006"};
    private String[] recepcionistas = new String[] {" ", "15733921", "39576117", "10944823"};

    public CPanelActividadTomarViaje() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.ORANGE);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BorderLayout());
        JLabel tomarViajeLabel = new JLabel("TOMAR VIAJE", SwingConstants.CENTER);
        tomarViajeLabel.setPreferredSize(new Dimension(this.getWidth(), 75));
        tomarViajeLabel.setFont(new Font("Arial", Font.BOLD, 25));
        tomarViajeLabel.setForeground(Color.WHITE);
        this.add(tomarViajeLabel, BorderLayout.NORTH);
        JLabel surLabel = new JLabel();
        surLabel.setPreferredSize(new Dimension(this.getWidth(), 25));
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
        JLabel cuentaLabel = new JLabel("Cuenta Número");
        JLabel choferLabel = new JLabel("Chofer (*)");
        JLabel autoLabel = new JLabel("Auto (*)");
        JLabel origenLabel = new JLabel("Origen (*)");
        JLabel destinoLabel = new JLabel("Destino (*)");
        JLabel fechaLabel = new JLabel("Fecha (*)");
        JLabel horaLabel = new JLabel("Hora (*)");
        JLabel recepcionistaLabel = new JLabel("Recepcionista (*)");
        int ancho = 30;
        this.setClienteTextField(this.setTextField(ancho, "Ingrese sólo letras y espacios en blanco", this));
        this.setCuentaTextField(this.setTextField(ancho, "000", "Ingrese sólo letras y espacios en blanco", this));
        this.setChoferesLista(this.crearComboBox(this.getChoferes(), 333, 20, Color.WHITE, "Seleccione chofer", this));
        this.setAutosLista(this.crearComboBox(this.getAutos(), 333, 20, Color.WHITE, "Seleccione auto", this));
        this.setOrigenTextField(this.setTextField(ancho, "Ingrese letras, números, símbolos y espacios en blanco", this));
        this.setDestinoTextField(this.setTextField(ancho, "Ingrese letras, números, símbolos y espacios en blanco", this));
        this.setFechaTextField(this.setTextField(ancho, "00/00/0000", "Ingrese la fecha con formato DD/MM/AAAA", this));
        this.setHoraTextField(this.setTextField(ancho, "00:00:00", "Ingrese la hora con formato 00:00:00", this));
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
        panelInput.add(cuentaLabel, gbc);
        gbc.gridy++;
        panelInput.add(choferLabel, gbc);
        gbc.gridy++;
        panelInput.add(autoLabel, gbc);
        gbc.gridy++;
        panelInput.add(origenLabel, gbc);
        gbc.gridy++;
        panelInput.add(destinoLabel, gbc);
        gbc.gridy++;
        panelInput.add(fechaLabel, gbc);
        gbc.gridy++;
        panelInput.add(horaLabel, gbc);
        gbc.gridy++;
        panelInput.add(recepcionistaLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelInput.add(this.getClienteTextField(), gbc);
        gbc.gridy++;
        panelInput.add(this.getCuentaTextField(), gbc);
        gbc.gridy++;
        panelInput.add(this.getChoferesLista(), gbc);
        gbc.gridy++;
        panelInput.add(this.getAutosLista(), gbc);
        gbc.gridy++;
        panelInput.add(this.getOrigenTextField(), gbc);
        gbc.gridy++;
        panelInput.add(this.getDestinoTextField(), gbc);
        gbc.gridy++;
        panelInput.add(this.getFechaTextField(), gbc);
        gbc.gridy++;
        panelInput.add(this.getHoraTextField(), gbc);
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
        else if (e.getSource().equals(getCuentaTextField())) {
            if ((getCuentaTextField().getText() != null) || (! getCuentaTextField().getText().isEmpty())) {
                setCuenta(getCuentaTextField().getText());
            }
        }
        else if (e.getSource().equals(getOrigenTextField())) {
            if ((getOrigenTextField().getText() != null) || (! getOrigenTextField().getText().isEmpty())) {
                setOrigen(getOrigenTextField().getText());
            }
        }
        else if (e.getSource().equals(getDestinoTextField())) {
            if ((getDestinoTextField().getText() != null) || (! getDestinoTextField().getText().isEmpty())) {
                setDestino(getDestinoTextField().getText());
            }
        }
        else if (e.getSource().equals(getFechaTextField())) {
            if ((getFechaTextField().getText() != null) || (! getFechaTextField().getText().isEmpty())) {
                setFecha(getFechaTextField().getText());
            }
        }
        else if (e.getSource().equals(getHoraTextField())) {
            if ((getHoraTextField().getText() != null) || (! getHoraTextField().getText().isEmpty())) {
                setHora(getHoraTextField().getText());
            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource().equals(getCuentaTextField())) {
            getCuentaTextField().selectAll();
        }
        else if (e.getSource().equals(getFechaTextField())) {
            getFechaTextField().selectAll();
        }
        else if (e.getSource().equals(getHoraTextField())) {
            getHoraTextField().selectAll();
        }
    }

    @Override
    public void focusLost(FocusEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getViaje().setCliente(new CCliente());
        viaje.setCuenta(viaje.getCliente().getCuentasActivas().get(0));
        viaje.setChofer(new CChoferSinVehiculo());
        viaje.setAuto(new CVehiculo());
        viaje.setRecepcionista(new CEmpleado());
        if (e.getSource().equals(getRecepcionistasLista())) {
            getGuardarButton().setEnabled(true);
        }
        else if (e.getSource().equals(getChoferesLista().getSelectedItem())) {
            if ((getChoferesLista().getSelectedItem().toString() != null) ||
                    (! getChoferesLista().getSelectedItem().toString().isEmpty())) {
                viaje.getChofer().setDni(getChoferesLista().getSelectedItem().toString());
            }
        }
        else if (e.getSource().equals(getAutosLista().getSelectedItem())) {
            if ((getAutosLista().getSelectedItem().toString() != null) ||
                    (! getAutosLista().getSelectedItem().toString().isEmpty())) {
                viaje.getAuto().setPatente(getAutosLista().getSelectedItem().toString());
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
            viaje.getChofer().setDni(getChoferesLista().getSelectedItem().toString());
            viaje.getAuto().setPatente(getAutosLista().getSelectedItem().toString());
            viaje.getRecepcionista().setDni(getRecepcionistasLista().getSelectedItem().toString());
            viaje.setOrigen(this.getOrigen());
            viaje.setDestino(this.getDestino());
            setFecha(getFechaTextField().getText());
            setHora(getHoraTextField().getText());
            viaje.setFecha(this.setFechaCalendar(this.getFecha()));
            viaje.setHoraDeInicio(this.setHoraCalendar(this.getHora()));
        }
        else if (e.getSource().equals(getSalirButton())) {
            accionarSalirButton(e); // método default de IJButtonSalir
        }
    }

    public JButton getGuardarButton() {
        return this.guardarButton;
    }

    public void setGuardarButton(JButton guardarButton) { this.guardarButton = guardarButton; }

    public CButtonSelectorPanel getSalirButton() {
        return this.salirButton;
    }

    public void setSalirButton(CButtonSelectorPanel salirButton) {
        this.salirButton = salirButton;
    }

    public CViaje getViaje() { return this.viaje; }

    public void setViaje(CViaje viaje) { this.viaje = viaje; }

    public JTextField getClienteTextField() {
        return this.clienteTextField;
    }

    public void setClienteTextField(JTextField clienteTextField) { this.clienteTextField = clienteTextField; }

    public JTextField getCuentaTextField() {
        return this.cuentaTextField;
    }

    public void setCuentaTextField(JTextField cuentaTextField) {
        this.cuentaTextField = cuentaTextField;
    }

    public JTextField getOrigenTextField() {
        return this.origenTextField;
    }

    public void setOrigenTextField(JTextField origenTextField) {
        this.origenTextField = origenTextField;
    }

    public JTextField getDestinoTextField() {
        return this.destinoTextField;
    }

    public void setDestinoTextField(JTextField destinoTextField) {
        this.destinoTextField = destinoTextField;
    }

    public JTextField getFechaTextField() {
        return this.fechaTextField;
    }

    public void setFechaTextField(JTextField fechaTextField) {
        this.fechaTextField = fechaTextField;
    }

    public JTextField getHoraTextField() {
        return this.horaTextField;
    }

    public void setHoraTextField(JTextField horaTextField) {
        this.horaTextField = horaTextField;
    }

    public String getCliente() {
        return this.cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getOrigen() {
        return this.origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return this.destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return this.hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String[] getChoferes() {
        return this.choferes;
    }

    public void setChoferes(String[] choferes) {
        this.choferes = choferes;
    }

    public String[] getAutos() {
        return this.autos;
    }

    public void setAutos(String[] autos) {
        this.autos = autos;
    }

    public String[] getRecepcionistas() {
        return this.recepcionistas;
    }

    public void setRecepcionistas(String[] recepcionistas) {
        this.recepcionistas = recepcionistas;
    }

    public JComboBox<String> getAutosLista() {
        return this.autosLista;
    }

    public void setAutosLista(JComboBox<String> autosLista) {
        this.autosLista = autosLista;
    }

    public JComboBox<String> getChoferesLista() {
        return this.choferesLista;
    }

    public void setChoferesLista(JComboBox<String> choferesLista) {
        this.choferesLista = choferesLista;
    }

    public JComboBox<String> getRecepcionistasLista() {
        return this.recepcionistasLista;
    }

    public void setRecepcionistasLista(JComboBox<String> recepcionistasLista) {
        this.recepcionistasLista = recepcionistasLista;
    }

    public Calendar calcularTiempo() { return null; }

    public String setFechaYHora() { return null; }

}
