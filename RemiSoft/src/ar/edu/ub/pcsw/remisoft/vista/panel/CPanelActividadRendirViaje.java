package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.modelo.empleados.CEmpleado;
import ar.edu.ub.pcsw.remisoft.modelo.interfaces.ITemporizable;
import ar.edu.ub.pcsw.remisoft.modelo.rendiciones.CRendicion;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJButtonSalir;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJComboBoxFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJTextFieldFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IValidadorInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class CPanelActividadRendirViaje extends CPanelActividadBase implements IJButtonSalir, IJComboBoxFactory,
        IJTextFieldFactory, ITemporizable, IValidadorInput, ActionListener, FocusListener, KeyListener {

    private JLabel costoEfectivoLabel;
    private JLabel costoTestigoLabel;
    private JLabel rendicionLabel;
    private JLabel viajeLabel;
    private JTextField costoEfectivoTextField;
    private JTextField costoTestigoTextField;
    private JTextField rendicionTextField;
    private JTextField viajeTextField;
    private String costoEfectivo;
    private String recepcionista;
    private String rendicion;
    private String viaje;

    public CPanelActividadRendirViaje() {
        super(3.0);
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.ORANGE);
        this.getNorteLabel().setText("RENDIR VIAJE");
        this.getNorteLabel().setPreferredSize(new Dimension(this.getWidth(), 75));
        this.add(getNorteLabel(), BorderLayout.NORTH);
        this.getSurLabel().setPreferredSize(new Dimension(this.getWidth(), 75));
        this.add(getSurLabel(), BorderLayout.SOUTH);
        this.getGbc().anchor = GridBagConstraints.LINE_START;
        this.getReferenciasLabel().setText("<html><font color='red'>rojo</font> indica campo obligatorio</html>");
        this.getFechaLabel().setText("Fecha de la rendición");
        this.getFechaLabel().setPreferredSize(new Dimension(175, 15));
        this.setRendicionLabel(new JLabel("Rendición número"));
        this.setViajeLabel(new JLabel("Viaje número"));
        this.getViajeLabel().setForeground(Color.RED);
        this.setCostoEfectivoLabel(new JLabel("Costo efectivo"));
        this.getCostoEfectivoLabel().setForeground(Color.RED);
        this.setCostoTestigoLabel(new JLabel("Costo testigo"));
        int ancho = 30;
        this.getFechaTextField().setToolTipText(getFechaLabel().getText());
        // método default de IJTextFieldFactory
        this.setRendicionTextField(this.setTextField(ancho, "Número de la rendición", this));
        // método default de IJTextFieldFactory
        this.setViajeTextField(this.setTextField(ancho, "Ingrese número del viaje a rendir", this));
        // método default de IValidadorInput
        this.getViajeTextField().setInputVerifier(validadorInput(ERegexValidadorInput.CUENTA.getTexto(),
                getViajeTextField().getToolTipText(), getViajeLabel().getText()));
        // método default de IJTextFieldFactory
        this.setCostoEfectivoTextField(this.setTextField(ancho, EToolTipTextTexto.SOLONUMEROS.getTexto(), this));
        // método default de IValidadorInput
        this.getCostoEfectivoTextField().setInputVerifier(validadorInput(ERegexValidadorInput.PRECIO.getTexto(),
                getCostoEfectivoTextField().getToolTipText(), getCostoEfectivoLabel().getText()));
        // método default de IJTextFieldFactory
        this.setCostoTestigoTextField(this.setTextField(ancho, "Costo testigo", this));
        this.getGuardarButton().addActionListener(this);
        this.getSalirButton().addActionListener(this);
        this.getGbc().gridx = 0;
        this.getGbc().gridy = 0;
        this.getPanelInput().add(this.getReferenciasLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getFechaLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getRendicionLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getViajeLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getCostoEfectivoLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getCostoTestigoLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getRecepcionistaLabel(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 1;
        this.getPanelInput().add(this.getFechaTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getRendicionTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getViajeTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getCostoEfectivoTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getCostoTestigoTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getRecepcionistasLista(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 10;
        this.getPanelInput().add(this.getGuardarButton(), this.getGbc());
        this.getGbc().anchor = GridBagConstraints.LINE_END;
        this.getPanelInput().add(this.getSalirButton(), this.getGbc());
        this.add(this.getPanelInput());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource().equals(getFechaTextField())) {
            if ((getFechaTextField().getText() != null) || (! getFechaTextField().getText().isEmpty())) {
                setFecha(getFechaTextField().getText());
            }
        }
        else if (e.getSource().equals(getRendicionTextField())) {
            if ((getRendicionTextField().getText() != null) || (! getRendicionTextField().getText().isEmpty())) {
                setRendicion(getRendicionTextField().getText());
            }
        }
        else if (e.getSource().equals(getViajeTextField())) {
            if ((getViajeTextField().getText() != null) || (! getViajeTextField().getText().isEmpty())) {
                setViaje(getViajeTextField().getText());
            }
        }
        else if (e.getSource().equals(getCostoEfectivoTextField())) {
            if ((getCostoEfectivoTextField().getText() != null) ||
                    (! getCostoEfectivoTextField().getText().isEmpty())) {
                setCostoEfectivo(getCostoEfectivoTextField().getText());
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getRecepcionistasLista())) {
            getGuardarButton().setEnabled(true);
        }
        else if (e.getSource().equals(getRecepcionistasLista().getSelectedItem())) {
            if ((getRecepcionistasLista().getSelectedItem().toString() != null) ||
                    (! getRecepcionistasLista().getSelectedItem().toString().isEmpty())) {
                setRecepcionista(getRecepcionistasLista().getSelectedItem().toString());
            }
        }
        else if (e.getSource().equals(getGuardarButton())) {
            CRendicion rendicion = new CRendicion();
            rendicion.setRecepcionista(new CEmpleado());
            rendicion.setFecha(this.getFecha());
            rendicion.setNumero(this.getRendicion());
            rendicion.setViajeNumero(this.getViaje());
            rendicion.setCostoEfectivo(this.getCostoEfectivo());
            rendicion.getRecepcionista().setDni(this.getRecepcionista());
        }
        else if (e.getSource().equals(getSalirButton())) {
            // método default de IJButtonSalir
            accionarSalirButton(e);
        }
    }

    public JLabel getCostoEfectivoLabel() { return this.costoEfectivoLabel; }

    public void setCostoEfectivoLabel(JLabel costoEfectivoLabel) { this.costoEfectivoLabel = costoEfectivoLabel; }

    public JLabel getCostoTestigoLabel() { return this.costoTestigoLabel; }

    public void setCostoTestigoLabel(JLabel costoTestigoLabel) { this.costoTestigoLabel = costoTestigoLabel; }

    public JLabel getRendicionLabel() { return this.rendicionLabel; }

    public void setRendicionLabel(JLabel rendicionLabel) { this.rendicionLabel = rendicionLabel; }

    public JLabel getViajeLabel() { return this.viajeLabel; }

    public void setViajeLabel(JLabel viajeLabel) { this.viajeLabel = viajeLabel; }

    public JTextField getCostoEfectivoTextField() { return this.costoEfectivoTextField; }

    public void setCostoEfectivoTextField(JTextField costoEfectivoTextField) {
        this.costoEfectivoTextField = costoEfectivoTextField;
    }

    public JTextField getCostoTestigoTextField() { return this.costoTestigoTextField; }

    public void setCostoTestigoTextField(JTextField costoTestigoTextField) {
        this.costoTestigoTextField = costoTestigoTextField;
    }

    public JTextField getRendicionTextField() { return this.rendicionTextField; }

    public void setRendicionTextField(JTextField rendicionTextField) { this.rendicionTextField = rendicionTextField; }

    public JTextField getViajeTextField() { return this.viajeTextField; }

    public void setViajeTextField(JTextField viajeTextField) { this.viajeTextField = viajeTextField; }

    public String getCostoEfectivo() { return this.costoEfectivo; }

    public void setCostoEfectivo(String costoEfectivo) { this.costoEfectivo = costoEfectivo; }

    public String getRendicion() { return this.rendicion; }

    public void setRendicion(String rendicion) { this.rendicion = rendicion; }

    public String getRecepcionista() { return this.recepcionista; }

    public void setRecepcionista(String recepcionista) { this.recepcionista = recepcionista; }

    public String getViaje() { return this.viaje; }

    public void setViaje(String viaje) { this.viaje = viaje; }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {

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
