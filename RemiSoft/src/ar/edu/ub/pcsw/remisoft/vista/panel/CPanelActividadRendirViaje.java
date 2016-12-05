package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.controlador.main.*;
import ar.edu.ub.pcsw.remisoft.modelo.empleados.CEmpleado;
import ar.edu.ub.pcsw.remisoft.modelo.interfaces.ITemporizable;
import ar.edu.ub.pcsw.remisoft.modelo.rendiciones.CRendicion;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJComboBoxFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJTextFieldFactory;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IValidadorInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import static java.lang.Integer.parseInt;

public class CPanelActividadRendirViaje extends CPanelActividadBase implements ActionListener, FocusListener,
        IJComboBoxFactory, IJTextFieldFactory, ITemporizable, IValidadorInput, KeyListener {

    private JComboBox<String> choferesLista;
    private JLabel choferLabel;
    private JLabel costoEfectivoLabel;
    private JLabel costoTestigoLabel;
    private JLabel rendicionLabel;
    private JLabel viajeLabel;
    private JTextField costoEfectivoTextField;
    private JTextField costoTestigoTextField;
    private JTextField rendicionTextField;
    private JTextField viajeTextField;

    public CPanelActividadRendirViaje() {
        super(3.0);
        this.inicializar();
    }

    private void inicializar() {
        this.getNorteLabel().setText(ETextoButton.RENDIRVIAJE.getTexto().toUpperCase());
        this.getNorteLabel().setPreferredSize(new Dimension(this.getWidth(), 65));
        this.add(getNorteLabel(), BorderLayout.NORTH);
        this.getSurLabel().setPreferredSize(new Dimension(this.getWidth(), 55));
        this.add(getSurLabel(), BorderLayout.SOUTH);
        this.getGbc().anchor = GridBagConstraints.LINE_START;
        this.getGbc().insets = new Insets (10, 0, 10, 0);
        this.getReferenciasLabel().setText("<html><font color='red'>rojo</font> indica campo obligatorio</html>");
        this.getFechaLabel().setText("Fecha de la rendición");
        this.getFechaLabel().setPreferredSize(new Dimension(175, 15));
        this.setRendicionLabel(new JLabel("Rendición número"));
        this.setChoferLabel(new JLabel("Chofer"));
        this.getChoferLabel().setForeground(Color.RED);
        this.setViajeLabel(new JLabel("Viaje número"));
        this.getViajeLabel().setForeground(Color.RED);
        this.setCostoEfectivoLabel(new JLabel("Costo efectivo"));
        this.getCostoEfectivoLabel().setForeground(Color.RED);
        this.setCostoTestigoLabel(new JLabel("Costo testigo"));
        this.getFechaTextField().setToolTipText(getFechaLabel().getText());
        // método default de IJTextFieldFactory
        this.setRendicionTextField(this.setTextField(getAnchoTextField(), "Número de la rendición", this));
        this.getRendicionTextField().setEditable(false);
        this.getRendicionTextField().addFocusListener(this);
        // método default de IJTextFieldFactory
        this.setViajeTextField(this.setTextField(getAnchoTextField(), EToolTipTextTexto.NUMEROVIAJE.getTexto(), this));
        this.getViajeTextField().setEditable(false);
        //método default de IValidadorInput
        this.getViajeTextField().setInputVerifier(validadorInput(ERegexValidadorInput.NUMEROVIAJE.getTexto(),
                getViajeTextField().getToolTipText(), getViajeLabel().getText()));
        // método default de IJComboBoxFactory
        this.setChoferesLista(this.crearComboBox(new CSelectSQL().selectRecursoEmpleado("Dni", 0, 1), 333, 20,
                Color.WHITE, EToolTipTextTexto.SELECCIONAR.getTexto() + getChoferLabel().getText(), this));
        this.getChoferesLista().setEnabled(false);
        this.getChoferesLista().addFocusListener(this);
        // método default de IValidadorInput
        this.validadorInput(getChoferesLista(), getChoferesLista().getToolTipText(), getChoferLabel().getText());
        // método default de IJTextFieldFactory
        this.setCostoEfectivoTextField(this.setTextField(getAnchoTextField(), EToolTipTextTexto.PRECIO.getTexto(), this));
        this.getCostoEfectivoTextField().setEditable(false);
        // método default de IValidadorInput
        this.getCostoEfectivoTextField().setInputVerifier(validadorInput(ERegexValidadorInput.PRECIO.getTexto(),
                getCostoEfectivoTextField().getToolTipText(), getCostoEfectivoLabel().getText()));
        // método default de IJTextFieldFactory
        this.setCostoTestigoTextField(this.setTextField(getAnchoTextField(), "Costo testigo", this));
        this.getCostoTestigoTextField().setEditable(false);
        this.getCostoTestigoTextField().addFocusListener(this);
        this.getGuardarButton().setText("Aceptar");
        this.getGuardarButton().addActionListener(this);
        this.getHabilitarButton().addActionListener(this);
        this.getGbc().gridx = 0;
        this.getGbc().gridy = 0;
        this.getPanelInput().add(this.getReferenciasLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getFechaLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getRendicionLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getChoferLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getViajeLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getCostoEfectivoLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getCostoTestigoLabel(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getRecepcionistaLabel(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 0;
        this.getGbc().anchor = GridBagConstraints.CENTER;
        this.getPanelInput().add(getHabilitarButton(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 1;
        this.getPanelInput().add(this.getFechaTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getRendicionTextField(), this.getGbc());
        this.getGbc().gridy++;
        this.getPanelInput().add(this.getChoferesLista(), this.getGbc());
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
        this.getGbc().anchor = GridBagConstraints.LINE_START;
        this.getPanelInput().add(this.getGuardarButton(), this.getGbc());
        this.getGbc().anchor = GridBagConstraints.CENTER;
        JButton rechazarButton = new JButton("Rechazar");
        rechazarButton.setPreferredSize(new Dimension(100, 30));
        this.getPanelInput().add(rechazarButton, this.getGbc());
        this.getGbc().gridy++;
        this.getGbc().anchor = GridBagConstraints.LINE_END;
        this.getPanelInput().add(this.getSalirButton(), this.getGbc());
        this.add(this.getPanelInput());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getHabilitarButton())) {
            getChoferesLista().setEnabled(true);
            getCostoEfectivoTextField().setEditable(true);
            getRecepcionistasLista().setEnabled(true);
        }
        else if (e.getSource().equals(getRecepcionistasLista())) {
            getGuardarButton().setEnabled(true);
        }
        else if (e.getSource().equals(getGuardarButton())) {
            if ((getChoferesLista().getSelectedItem().toString().isEmpty()) ||
                    (getChoferesLista().getSelectedItem().toString() == null) ||
                    (getChoferesLista().getSelectedItem().toString().equals(" ")) ||
                    (getCostoEfectivoTextField().getText().isEmpty()) ||
                    (getCostoEfectivoTextField().getText() == null) ||
                    (getCostoEfectivoTextField().getText().equals(" ")) ||
                    (getCostoTestigoTextField().getText().isEmpty()) ||
                    (getCostoTestigoTextField().getText() == null) ||
                    (getCostoTestigoTextField().getText().equals(" ")) ||
                    (getRecepcionistasLista().getSelectedItem().toString().isEmpty()) ||
                    (getRecepcionistasLista().getSelectedItem().toString() == null) ||
                    (getRecepcionistasLista().getSelectedItem().toString().equals(" "))) {
                JOptionPane.showMessageDialog(null, getMensajeErrorActividad(),
                        "Error en " + getNorteLabel().getText(), JOptionPane.ERROR_MESSAGE);
            }
            else {
                CRendicion rendicion = new CRendicion();
                rendicion.setRecepcionista(new CEmpleado());
                rendicion.setFecha(getFechaTextField().getText());
                rendicion.setViajeNumero(getViajeTextField().getText());
                rendicion.setCostoEfectivo(getCostoEfectivoTextField().getText());
                rendicion.setCostoTestigo(getCostoTestigoTextField().getText());
                rendicion.getRecepcionista().setDni(getRecepcionistasLista().getSelectedItem().toString().substring(0,7));
                new CInsertSQL().insertarViajeRendicion(rendicion);
                CUpdateSQL update = new CUpdateSQL();
                update.updateTabla(ETablas.VEHICULO, "disponible", "Patente",
                        new CSelectSQL().selectRecurso("viaje", "", "patente", "",
                                parseInt(getViajeTextField().getText())), 1);
                update.updateTabla(ETablas.EMPLEADO, "disponible", "Dni",
                        new CSelectSQL().selectRecurso("viaje", "", "dni", "",
                                parseInt(getViajeTextField().getText())), 1);
                CDataBase.hacerBackUpBaseDatos();
            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource().equals(getRendicionTextField())) {
            getRendicionTextField().setText(new CSelectSQL().selectCantidadFilasRendicion());
        }
        else if (e.getSource().equals(getCostoTestigoTextField())) {
            double costoEfectivo = Double.parseDouble(getCostoEfectivoTextField().getText());
            if (costoEfectivo < 399) {
                double costoTestigo = (Double.parseDouble(getCostoEfectivoTextField().getText()) * ((new Random().nextInt((100 - 90) + 1) + 90))) / 100;
                getCostoTestigoTextField().setText(Double.toString(costoTestigo));
            }
            else if (costoEfectivo > 400 && costoEfectivo < 699) {
                double costoTestigo = (Double.parseDouble(getCostoEfectivoTextField().getText()) * ((new Random().nextInt((100 - 80) + 1) + 80))) / 100;
                getCostoTestigoTextField().setText(Double.toString(costoTestigo));
            }
            else if (costoEfectivo > 700 && costoEfectivo < 999) {
                double costoTestigo = (Double.parseDouble(getCostoEfectivoTextField().getText()) * ((new Random().nextInt((90 - 70) + 1) + 70))) / 100;
                getCostoTestigoTextField().setText(Double.toString(costoTestigo));
            }
            else {
                double costoTestigo = (Double.parseDouble(getCostoEfectivoTextField().getText()) * ((new Random().nextInt((80 - 60) + 1) + 60))) / 100;
                getCostoTestigoTextField().setText(Double.toString(costoTestigo));
            }
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        this.getViajeTextField().setText(new CSelectSQL().selectRecurso("viaje",
                getChoferesLista().getSelectedItem().toString(), "Numero", "", 2));
    }

    public JComboBox<String> getChoferesLista() { return this.choferesLista; }

    public void setChoferesLista(JComboBox<String> choferesLista) { this.choferesLista = choferesLista; }

    public JLabel getChoferLabel() { return this.choferLabel; }

    public void setChoferLabel(JLabel choferLabel) { this.choferLabel = choferLabel; }

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

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

}