package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJComboBoxFactory;
import ar.edu.ub.pcsw.remisoft.vista.reportes.CChartFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class CPanelActividadReporteOperativo extends CPanelActividadBase implements ActionListener, IJComboBoxFactory {

    private JButton verReporteAutosButton;
    private JButton verReporteClientesButton;
    private JButton verReporteEmpleadosButton;
    private JButton verReporteViajesButton;
    private JComboBox<String> categoriaAutosLista;
    private JComboBox<String> categoriaClientesLista;
    private JComboBox<String> categoriaEmpleadosLista;
    private JComboBox<String> categoriaViajesLista;
    private JLabel autosLabel;
    private JLabel categoriaLabel;
    private JLabel clientesLabel;
    private JLabel empleadosLabel;
    private JLabel label;
    private JLabel reporteLabel;
    private JLabel viajesLabel;
    private String reporteAutos;
    private String reporteClientes;
    private String reporteEmpleados;
    private String reporteViajes;
    private String[] autos = new String[] {" ", "Total autos", "Autos disponibles hoy", "Autos no disponibles hoy"};
    private String[] clientes = new String[] {" ", "Total clientes", "Total clientes particulares",
            "Total clientes corporativos", "Antiguedad clientes"};
    private String[] empleados = new String[] {" ", "Total empleados", "Total empleados choferes",
            "Total empleados administrativos", "Antigüedad empleados"};
    private String[] viajes = new String[] {" ", "Total viajes", "Total viajes a CABA", "Total viajes a GBA",
            "Total viajes por chofer", "Total viajes por recepcionista"};

    public CPanelActividadReporteOperativo() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(EColorPanel.REPORTES.getColor());
        this.getNorteLabel().setText("REPORTE " + ETextoButton.REPORTEOPERATIVO.getTexto().toUpperCase());
        this.add(getNorteLabel(), BorderLayout.NORTH);
        this.getSurLabel().setPreferredSize(new Dimension(this.getWidth(), 75));
        this.add(getSurLabel(), BorderLayout.SOUTH);
        this.getGbc().anchor = GridBagConstraints.LINE_START;
        this.getGbc().insets = new Insets (20, 0, 20, 0);
        this.setCategoriaLabel(new JLabel("Categoría", SwingConstants.CENTER));
        this.getCategoriaLabel().setPreferredSize(new Dimension(150, 15));
        this.setReporteLabel(new JLabel("Selección", SwingConstants.CENTER));
        this.getReporteLabel().setPreferredSize(new Dimension(375, 15));
        this.setAutosLabel(new JLabel("Autos"));
        this.getAutosLabel().setPreferredSize(new Dimension(150, 15));
        this.setClientesLabel(new JLabel("Clientes"));
        this.getClientesLabel().setPreferredSize(new Dimension(150, 15));
        this.setEmpleadosLabel(new JLabel("Empleados"));
        this.getEmpleadosLabel().setPreferredSize(new Dimension(150, 15));
        this.setViajesLabel(new JLabel("Viajes"));
        this.getViajesLabel().setPreferredSize(new Dimension(150, 15));
        this.setLabel(new JLabel());
        this.getLabel().setPreferredSize(new Dimension(180, 15));
        String reporteTexto = "Reporte";
        String reporteButtonTexto = "Ver Reporte";
        // método default de IJComboBoxFactory
        this.setCategoriaAutosLista(this.crearComboBox(this.getAutos(), 375, 20, Color.WHITE, EToolTipTextTexto.
                SELECCIONAR.getTexto() + reporteTexto, this));
        // método default de IJComboBoxFactory
        this.setCategoriaClientesLista(this.crearComboBox(this.getClientes(), 375, 20, Color.WHITE, EToolTipTextTexto.
                SELECCIONAR.getTexto() + reporteTexto, this));
        // método default de IJComboBoxFactory
        this.setCategoriaEmpleadosLista(this.crearComboBox(this.getEmpleados(), 375, 20, Color.WHITE, EToolTipTextTexto.
                SELECCIONAR.getTexto() + reporteTexto, this));
        // método default de IJComboBoxFactory
        this.setCategoriaViajesLista(this.crearComboBox(this.getViajes(), 375, 20, Color.WHITE, EToolTipTextTexto.
                SELECCIONAR.getTexto() + reporteTexto, this));
        this.setVerReporteAutosButton(new JButton(reporteButtonTexto));
        this.getVerReporteAutosButton().addActionListener(this);
        this.setVerReporteClientesButton(new JButton(reporteButtonTexto));
        this.getVerReporteClientesButton().addActionListener(this);
        this.setVerReporteEmpleadosButton(new JButton(reporteButtonTexto));
        this.getVerReporteEmpleadosButton().addActionListener(this);
        this.setVerReporteViajesButton(new JButton(reporteButtonTexto));
        this.getVerReporteViajesButton().addActionListener(this);
        this.getGbc().gridx = 0;
        this.getGbc().gridy = 0;
        this.getPanelInput().add(this.getCategoriaLabel(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 0;
        this.getGbc().anchor = GridBagConstraints.LINE_END;
        this.getPanelInput().add(this.getReporteLabel(), this.getGbc());
        this.getGbc().gridx = 2;
        this.getGbc().gridy = 0;
        this.getPanelInput().add(this.getLabel(), this.getGbc());
        this.getGbc().gridx = 0;
        this.getGbc().gridy = 1;
        this.getPanelInput().add(this.getAutosLabel(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 1;
        this.getPanelInput().add(this.getCategoriaAutosLista(), this.getGbc());
        this.getGbc().gridx = 2;
        this.getGbc().gridy = 1;
        this.getPanelInput().add(this.getVerReporteAutosButton(), this.getGbc());
        this.getGbc().gridx = 0;
        this.getGbc().gridy = 2;
        this.getPanelInput().add(this.getClientesLabel(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 2;
        this.getPanelInput().add(this.getCategoriaClientesLista(), this.getGbc());
        this.getGbc().gridx = 2;
        this.getGbc().gridy = 2;
        this.getPanelInput().add(this.getVerReporteClientesButton(), this.getGbc());
        this.getGbc().gridx = 0;
        this.getGbc().gridy = 3;
        this.getPanelInput().add(this.getEmpleadosLabel(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 3;
        this.getPanelInput().add(this.getCategoriaEmpleadosLista(), this.getGbc());
        this.getGbc().gridx = 2;
        this.getGbc().gridy = 3;
        this.getPanelInput().add(this.getVerReporteEmpleadosButton(), this.getGbc());
        this.getGbc().gridx = 0;
        this.getGbc().gridy = 4;
        this.getPanelInput().add(this.getViajesLabel(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 4;
        this.getPanelInput().add(this.getCategoriaViajesLista(), this.getGbc());
        this.getGbc().gridx = 2;
        this.getGbc().gridy = 4;
        this.getPanelInput().add(this.getVerReporteViajesButton(), this.getGbc());
        this.getGbc().gridx = 2;
        this.getGbc().gridy = 10;
        this.getGbc().anchor = GridBagConstraints.LINE_END;
        this.getPanelInput().add(this.getSalirButton(), this.getGbc());
        this.add(this.getPanelInput());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getVerReporteAutosButton())) {
            setReporteAutos(getCategoriaAutosLista().getSelectedItem().toString());
            CChartFrame reporte = new CChartFrame();
            for (int i = 1; i < getCategoriaAutosLista().getItemCount(); i++) {
                if (getReporteAutos().equals(getCategoriaAutosLista().getItemAt(i))) {
                    // método de CChartFrame
                    reporte.getReporte(getReporteAutos());
                }
            }
        }
        else if (e.getSource().equals(getVerReporteClientesButton())) {
            setReporteClientes(getCategoriaClientesLista().getSelectedItem().toString());
            CChartFrame reporte = new CChartFrame();
            for (int i = 1; i < getCategoriaClientesLista().getItemCount(); i++) {
                if (getReporteClientes().equals(getCategoriaClientesLista().getItemAt(i))) {
                    // método de CChartFrame
                    reporte.getReporte(getReporteClientes());
                }
            }
        }
        else if (e.getSource().equals(getVerReporteEmpleadosButton())) {
            setReporteEmpleados(getCategoriaEmpleadosLista().getSelectedItem().toString());
            CChartFrame reporte = new CChartFrame();
            for (int i = 1; i < getCategoriaEmpleadosLista().getItemCount(); i++) {
                if (getReporteEmpleados().equals(getCategoriaEmpleadosLista().getItemAt(i))) {
                    // método de CChartFrame
                    reporte.getReporte(getReporteEmpleados());
                }
            }
        }
        else if (e.getSource().equals(getVerReporteViajesButton())) {
            setReporteViajes(getCategoriaViajesLista().getSelectedItem().toString());
            CChartFrame reporte = new CChartFrame();
            for (int i = 1; i < getCategoriaViajesLista().getItemCount(); i++) {
                if (getReporteViajes().equals(getCategoriaViajesLista().getItemAt(i))) {
                    // método de CChartFrame
                    reporte.getReporte(getReporteViajes());
                }
            }
        }
    }

    public JButton getVerReporteAutosButton() { return this.verReporteAutosButton; }

    public void setVerReporteAutosButton(JButton verReporteAutosButton) {
        this.verReporteAutosButton = verReporteAutosButton;
    }

    public JButton getVerReporteClientesButton() { return this.verReporteClientesButton; }

    public void setVerReporteClientesButton(JButton verReporteClientesButton) {
        this.verReporteClientesButton = verReporteClientesButton;
    }

    public JButton getVerReporteEmpleadosButton() { return this.verReporteEmpleadosButton; }

    public void setVerReporteEmpleadosButton(JButton verReporteEmpleadosButton) {
        this.verReporteEmpleadosButton = verReporteEmpleadosButton;
    }

    public JButton getVerReporteViajesButton() { return this.verReporteViajesButton; }

    public void setVerReporteViajesButton(JButton verReporteViajesButton) {
        this.verReporteViajesButton = verReporteViajesButton;
    }

    public JComboBox<String> getCategoriaAutosLista() { return this.categoriaAutosLista; }

    public void setCategoriaAutosLista(JComboBox<String> categoriaAutosLista) {
        this.categoriaAutosLista = categoriaAutosLista;
    }

    public JComboBox<String> getCategoriaClientesLista() { return this.categoriaClientesLista; }

    public void setCategoriaClientesLista(JComboBox<String> categoriaClientesLista) {
        this.categoriaClientesLista = categoriaClientesLista;
    }

    public JComboBox<String> getCategoriaEmpleadosLista() { return this.categoriaEmpleadosLista; }

    public void setCategoriaEmpleadosLista(JComboBox<String> categoriaEmpleadosLista) {
        this.categoriaEmpleadosLista = categoriaEmpleadosLista;
    }

    public JComboBox<String> getCategoriaViajesLista() { return this.categoriaViajesLista; }

    public void setCategoriaViajesLista(JComboBox<String> categoriaViajesLista) {
        this.categoriaViajesLista = categoriaViajesLista;
    }

    public JLabel getAutosLabel() { return this.autosLabel; }

    public void setAutosLabel(JLabel autosLabel) { this.autosLabel = autosLabel; }

    public JLabel getCategoriaLabel() { return this.categoriaLabel; }

    public void setCategoriaLabel(JLabel categoriaLabel) { this.categoriaLabel = categoriaLabel; }

    public JLabel getClientesLabel() { return this.clientesLabel; }

    public void setClientesLabel(JLabel clientesLabel) { this.clientesLabel = clientesLabel; }

    public JLabel getEmpleadosLabel() { return this.empleadosLabel; }

    public void setEmpleadosLabel(JLabel empleadosLabel) { this.empleadosLabel = empleadosLabel; }

    public JLabel getLabel() { return this.label; }

    public void setLabel(JLabel label) { this.label = label; }

    public JLabel getReporteLabel() { return this.reporteLabel; }

    public void setReporteLabel(JLabel reporteLabel) { this.reporteLabel = reporteLabel; }

    public JLabel getViajesLabel() { return this.viajesLabel; }

    public void setViajesLabel(JLabel viajesLabel) { this.viajesLabel = viajesLabel; }

    public String getReporteAutos() { return this.reporteAutos; }

    public void setReporteAutos(String reporteAutos) { this.reporteAutos = reporteAutos; }

    public String getReporteClientes() { return this.reporteClientes; }

    public void setReporteClientes(String reporteClientes) { this.reporteClientes = reporteClientes; }

    public String getReporteEmpleados() { return this.reporteEmpleados; }

    public void setReporteEmpleados(String reporteEmpleados) { this.reporteEmpleados = reporteEmpleados; }

    public String getReporteViajes() { return this.reporteViajes; }

    public void setReporteViajes(String reporteViajes) { this.reporteViajes = reporteViajes; }

    public String[] getAutos() { return this.autos; }

    public void setAutos(String[] autos) { this.autos = autos; }

    public String[] getClientes() { return this.clientes; }

    public void setClientes(String[] clientes) { this.clientes = clientes; }

    public String[] getEmpleados() { return this.empleados; }

    public void setEmpleados(String[] empleados) { this.empleados = empleados; }

    public String[] getViajes() { return this.viajes; }

    public void setViajes(String[] viajes) { this.viajes = viajes; }

    @Override
    public Calendar calcularTiempo() {
        return null;
    }

}
