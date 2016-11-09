package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.controlador.main.CInsertSQL;
import ar.edu.ub.pcsw.remisoft.controlador.main.CSelectSQL;
import ar.edu.ub.pcsw.remisoft.controlador.main.CUpdateSQL;
import ar.edu.ub.pcsw.remisoft.modelo.clientes.CCliente;
import ar.edu.ub.pcsw.remisoft.modelo.empleados.CChoferSinVehiculo;
import ar.edu.ub.pcsw.remisoft.modelo.empleados.CEmpleado;
import ar.edu.ub.pcsw.remisoft.modelo.interfaces.ITemporizable;
import ar.edu.ub.pcsw.remisoft.modelo.sucursales.CSucursal;
import ar.edu.ub.pcsw.remisoft.modelo.vehiculos.CVehiculo;
import ar.edu.ub.pcsw.remisoft.modelo.viajes.CViaje;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJComboBoxFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJTextFieldFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IValidadorInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class CPanelActividadTomarViaje extends CPanelActividadBase implements ActionListener, FocusListener,
        IJComboBoxFactory, IJTextFieldFactory, ITemporizable, IValidadorInput, KeyListener {

    //private CSelectSQL select = new CSelectSQL();
    private JComboBox<String> autosLista;
    private JComboBox<String> choferesLista;
    private JComboBox<String> cuentasLista;
    private JLabel autoLabel;
    private JLabel choferLabel;
    private JLabel cuentaLabel;
    private JLabel destinoLabel;
    private JLabel horaLabel;
    private JLabel origenLabel;
    private JLabel precioLabel;
    private JTextField clienteTextField;
    private JTextField destinoTextField;
    private JTextField horaTextField;
    private JTextField origenTextField;
    private JTextField precioTextField;
    //private String[] autos = new String[] {};
    //private String[] choferes = new String[] {};
    private String[] cuentas = new String[] {};


    public CPanelActividadTomarViaje() {
        super(3.0);
        this.inicializar();
    }

    private void inicializar() {
        this.getNorteLabel().setText(ETextoButton.TOMARVIAJE.getTexto().toUpperCase());
        this.getNorteLabel().setPreferredSize(new Dimension(this.getWidth(), 50));
        this.add(getNorteLabel(), BorderLayout.NORTH);
        this.getSurLabel().setPreferredSize(new Dimension(this.getWidth(), 15));
        this.add(getSurLabel(), BorderLayout.SOUTH);
        this.getGbc().anchor = GridBagConstraints.LINE_START;
        this.getGbc().insets = new Insets (10, 0, 10, 0);
        this.setCuentaLabel(new JLabel("Cuenta Imputable"));
        this.getCuentaLabel().setForeground(Color.RED);
        this.setChoferLabel(new JLabel("Chofer Disponible"));
        this.getChoferLabel().setForeground(Color.RED);
        this.setAutoLabel(new JLabel("Auto Disponible"));
        this.getAutoLabel().setForeground(Color.RED);
        this.setOrigenLabel(new JLabel("Origen"));
        this.getOrigenLabel().setForeground(Color.RED);
        this.setDestinoLabel(new JLabel("Destino"));
        this.getDestinoLabel().setForeground(Color.RED);
        this.setHoraLabel(new JLabel("Hora"));
        this.getHoraLabel().setForeground(Color.RED);
        this.setPrecioLabel(new JLabel("Precio"));
        this.getPrecioLabel().setForeground(Color.RED);
        int ancho = 30;
        // método default de IJTextFieldFactory
        this.setClienteTextField(this.setTextField(ancho, EToolTipTextTexto.SOLONUMEROS.getTexto(), this));
        // método default de IValidadorInput
        this.getClienteTextField().setInputVerifier(validadorInput(ERegexValidadorInput.IDENTIFICACION.getTexto(),
                getClienteTextField().getToolTipText(), getClienteLabel().getText()));
        // método default de IJComboBoxFactory
        this.setCuentasLista(this.crearComboBox(this.getCuentas(), 333, 20, Color.WHITE,
                EToolTipTextTexto.SELECCIONAR.getTexto() + getCuentaLabel().getText(), this));
        // método default de IValidadorInput
        this.validadorInput(getCuentasLista(), getCuentasLista().getToolTipText(), getCuentaLabel().getText());
        // método default de IJComboBoxFactory
        this.setChoferesLista(this.crearComboBox(new CSelectSQL().selectEmpleadoDisponibles(1, 1), 333, 20, Color.WHITE,
                EToolTipTextTexto.SELECCIONAR.getTexto() + getChoferLabel().getText(), this)); ///
        // método default de IValidadorInput
        this.validadorInput(getChoferesLista(), getChoferesLista().getToolTipText(), getChoferLabel().getText());
        // método default de IJComboBoxFactory
        this.setAutosLista(this.crearComboBox(new CSelectSQL().selectAutoDisponibles(1), 333, 20, Color.WHITE,
                EToolTipTextTexto.SELECCIONAR.getTexto() + getAutoLabel().getText(), this)); ///
        // método default de IValidadorInput
        this.validadorInput(getAutosLista(), getAutosLista().getToolTipText(), getAutoLabel().getText());
        // método default de IJTextFieldFactory
        this.setOrigenTextField(this.setTextField(ancho, EToolTipTextTexto.SOLOLETRASYNUMEROS.getTexto(), this));
        // método default de IValidadorInput
        this.getOrigenTextField().setInputVerifier(validadorInput(ERegexValidadorInput.DOMICILIO.getTexto(),
                getOrigenTextField().getToolTipText(), getOrigenLabel().getText()));
        // método default de IJTextFieldFactory
        this.setDestinoTextField(this.setTextField(ancho, EToolTipTextTexto.SOLOLETRASYNUMEROS.getTexto(), this));
        // método default de IValidadorInput
        this.getDestinoTextField().setInputVerifier(validadorInput(ERegexValidadorInput.DOMICILIO.getTexto(),
                getDestinoTextField().getToolTipText(), getDestinoLabel().getText()));
        // método default de IJTextFieldFactory
        this.setHoraTextField(this.setTextField(ancho, "00:00", EToolTipTextTexto.HORA.getTexto(), this));
        // método default de IValidadorInput
        this.getHoraTextField().setInputVerifier(validadorInput(ERegexValidadorInput.HORA.getTexto(),
                getHoraTextField().getToolTipText(), getHoraLabel().getText()));
        // método default de IJTextFieldFactory
        this.setPrecioTextField(this.setTextField(ancho, EToolTipTextTexto.SOLONUMEROS.getTexto(), this));
        // método default de IValidadorInput
        this.getPrecioTextField().setInputVerifier(validadorInput(ERegexValidadorInput.PRECIO.getTexto(),
                getPrecioTextField().getToolTipText(), getPrecioLabel().getText()));
        this.getGuardarButton().addActionListener(this);
        this.getGbc().gridx = 0;
        this.getGbc().gridy = 0;
        this.getPanelInput().add(this.getReferenciasLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getClienteLabel(), this.getGbc());
        this.getGbc().gridy++;
        //this.getPanelInput().add(this.getCuentaLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getChoferLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getAutoLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getOrigenLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getDestinoLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getFechaLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getHoraLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getPrecioLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getRecepcionistaLabel(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 1;
        this.getPanelInput().add(this.getClienteTextField(), this.getGbc());
        this.getGbc().gridy++;
        //this.getPanelInput().add(this.getCuentasLista(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getChoferesLista(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getAutosLista(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getOrigenTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getDestinoTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getFechaTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getHoraTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getPrecioTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getRecepcionistasLista(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 15;
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
        else if (e.getSource().equals(getHoraTextField())) {
            getHoraTextField().selectAll();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getRecepcionistasLista())) {
            getGuardarButton().setEnabled(true);
        }
        else if (e.getSource().equals(getGuardarButton())) {
            CViaje viaje = new CViaje();
            CSucursal sucursal = new CSucursal();
            sucursal.setNumero("1");
            viaje.setSucursal(sucursal);
            viaje.setCliente(new CCliente());
            viaje.setCuenta(viaje.getCliente().getCuentasActivas().get(0));
            viaje.setChofer(new CChoferSinVehiculo());
            viaje.setAuto(new CVehiculo());
            viaje.setRecepcionista(new CEmpleado());
            viaje.getCliente().setIdentificacion(getClienteTextField().getText());
//            viaje.getCuenta().setNumero(getCuentasLista().getSelectedItem().toString());
            viaje.getChofer().setDni(getChoferesLista().getSelectedItem().toString());
            viaje.getAuto().setPatente(getAutosLista().getSelectedItem().toString());
            viaje.setOrigen(getOrigenTextField().getText());
            viaje.setDestino(getDestinoTextField().getText());
            viaje.setFecha(getFechaTextField().getText());
            viaje.setHoraDeInicio(getHoraTextField().getText());
            viaje.setPrecio(getPrecioTextField().getText());
            viaje.getRecepcionista().setDni(getRecepcionistasLista().getSelectedItem().toString());
            //sucursal.getViajes().add(viaje);
            new CInsertSQL().insertarViaje(getOrigenTextField().getText(), getDestinoTextField().getText()
                    , parseInt(getPrecioTextField().getText()), getHoraTextField().getText(),
                    getClienteTextField().getText(), getRecepcionistasLista().getSelectedItem().toString(),
                    getAutosLista().getSelectedItem().toString(), 1);
            new CUpdateSQL().updateDisponibleVehiculo(0, getAutosLista().getSelectedItem().toString());
            new CUpdateSQL().updateDisponibleEmpleado(0, getChoferesLista().getSelectedItem().toString());
        }
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

    public JComboBox<String> getCuentasLista() { return this.cuentasLista; }

    public void setCuentasLista(JComboBox<String> cuentasLista) { this.cuentasLista = cuentasLista; }

    public JLabel getAutoLabel() { return this.autoLabel; }

    public void setAutoLabel(JLabel autoLabel) { this.autoLabel = autoLabel; }

    public JLabel getChoferLabel() { return this.choferLabel; }

    public void setChoferLabel(JLabel choferLabel) { this.choferLabel = choferLabel; }

    public JLabel getCuentaLabel() { return this.cuentaLabel; }

    public void setCuentaLabel(JLabel cuentaLabel) { this.cuentaLabel = cuentaLabel; }

    public JLabel getDestinoLabel() { return this.destinoLabel; }

    public void setDestinoLabel(JLabel destinoLabel) { this.destinoLabel = destinoLabel; }

    public JLabel getHoraLabel() { return this.horaLabel; }

    public void setHoraLabel(JLabel horaLabel) { this.horaLabel = horaLabel; }

    public JLabel getOrigenLabel() { return this.origenLabel; }

    public void setOrigenLabel(JLabel origenLabel) { this.origenLabel = origenLabel; }

    public JLabel getPrecioLabel() { return this.precioLabel; }

    public void setPrecioLabel(JLabel precioLabel) { this.precioLabel = precioLabel; }

    public JTextField getClienteTextField() {
        return this.clienteTextField;
    }

    public void setClienteTextField(JTextField clienteTextField) { this.clienteTextField = clienteTextField; }

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

    public JTextField getHoraTextField() {
        return this.horaTextField;
    }

    public void setHoraTextField(JTextField horaTextField) {
        this.horaTextField = horaTextField;
    }

    public JTextField getPrecioTextField() { return this.precioTextField; }

    public void setPrecioTextField(JTextField precioTextField) { this.precioTextField = precioTextField; }
/*
    public String[] getAutos() { return this.autos; }

    public void setAutos(String[] autos) {
        this.autos = autos;
    }

    public String[] getChoferes() {
        return this.choferes;
    }

    public void setChoferes(String[] choferes) {
        this.choferes = choferes;
    }
*/

    public String[] getCuentas() { return this.cuentas; }

    public void setCuentas(String[] cuentas) { this.cuentas = cuentas; }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {

    }

    public Calendar calcularTiempo() { return null; }

}
