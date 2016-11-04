package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IJComboBoxFactory;
import ar.edu.ub.pcsw.remisoft.vista.reportes.CReporteFactory;
import org.jfree.chart.ChartFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class CPanelActividadReporteFinanciero extends CPanelActividadBase  implements ActionListener,
        IJComboBoxFactory {

    private JButton verReporteActivosButton;
    private JButton verReportePasivosButton;
    private JComboBox<String> categoriaActivosLista;
    private JComboBox<String> categoriaPasivosLista;
    private JLabel activosLabel;
    private JLabel categoriaLabel;
    private JLabel label;
    private JLabel pasivosLabel;
    private JLabel reporteLabel;
    private String[] activos = new String[] {" ", "Total activo", "Cuentas a cobrar", "Otros activos"};
    private String[] pasivos = new String[] {" ", "Total pasivo", "Cuentas a pagar", "Otros pasivos"};

    public CPanelActividadReporteFinanciero() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(EColorPanel.REPORTES.getColor());
        this.getNorteLabel().setText("REPORTE " + ETextoButton.REPORTEFINANCIERO.getTexto().toUpperCase());
        this.getNorteLabel().setPreferredSize(new Dimension(this.getWidth(), 150));
        this.add(getNorteLabel(), BorderLayout.NORTH);
        this.getSurLabel().setPreferredSize(new Dimension(this.getWidth(), 150));
        this.add(getSurLabel(), BorderLayout.SOUTH);
        this.getGbc().anchor = GridBagConstraints.LINE_START;
        this.getGbc().insets = new Insets (20, 0, 20, 0);
        this.setCategoriaLabel(new JLabel("Categoría", SwingConstants.CENTER));
        this.getCategoriaLabel().setPreferredSize(new Dimension(150, 15));
        this.setReporteLabel(new JLabel("Selección", SwingConstants.CENTER));
        this.getReporteLabel().setPreferredSize(new Dimension(375, 15));
        this.setActivosLabel(new JLabel("Activos"));
        this.getActivosLabel().setPreferredSize(new Dimension(150, 15));
        this.setPasivosLabel(new JLabel("Pasivos"));
        this.getPasivosLabel().setPreferredSize(new Dimension(150, 15));
        this.setLabel(new JLabel());
        this.getLabel().setPreferredSize(new Dimension(180, 15));
        String reporteTexto = "Reporte";
        String reporteButtonTexto = "Ver Reporte";
        // método default de IJComboBoxFactory
        this.setCategoriaActivosLista(this.crearComboBox(this.getActivos(), 375, 20, Color.WHITE, EToolTipTextTexto.
                SELECCIONAR.getTexto() + reporteTexto, this));
        // método default de IJComboBoxFactory
        this.setCategoriaPasivosLista(this.crearComboBox(this.getPasivos(), 375, 20, Color.WHITE, EToolTipTextTexto.
                SELECCIONAR.getTexto() + reporteTexto, this));
        this.setVerReporteActivosButton(new JButton(reporteButtonTexto));
        this.getVerReporteActivosButton().addActionListener(this);
        this.setVerReportePasivosButton(new JButton(reporteButtonTexto));
        this.getVerReportePasivosButton().addActionListener(this);
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
        this.getPanelInput().add(this.getActivosLabel(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 1;
        this.getPanelInput().add(this.getCategoriaActivosLista(), this.getGbc());
        this.getGbc().gridx = 2;
        this.getGbc().gridy = 1;
        this.getPanelInput().add(this.getVerReporteActivosButton(), this.getGbc());
        this.getGbc().gridx = 0;
        this.getGbc().gridy = 2;
        this.getPanelInput().add(this.getPasivosLabel(), this.getGbc());
        this.getGbc().gridx = 1;
        this.getGbc().gridy = 2;
        this.getPanelInput().add(this.getCategoriaPasivosLista(), this.getGbc());
        this.getGbc().gridx = 2;
        this.getGbc().gridy = 2;
        this.getPanelInput().add(this.getVerReportePasivosButton(), this.getGbc());
        this.getGbc().gridx = 2;
        this.getGbc().gridy = 10;
        this.getGbc().anchor = GridBagConstraints.LINE_END;
        this.getPanelInput().add(this.getSalirButton(), this.getGbc());
        this.add(this.getPanelInput());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox<String> lista = null;
        if (e.getSource().equals(getVerReporteActivosButton())) {
            lista = getCategoriaActivosLista();
        }
        else if (e.getSource().equals(getVerReportePasivosButton())) {
            lista = getCategoriaPasivosLista();
        }
        if (lista != null) {
            if (! lista.getSelectedItem().toString().equals(" ")) {
                CReporteFactory reporte = new CReporteFactory();
                ChartFrame frame = reporte.crear(lista.getSelectedItem().toString());
                frame.setVisible(true);
            }
        }
    }

    public JButton getVerReporteActivosButton() { return this.verReporteActivosButton; }

    public void setVerReporteActivosButton(JButton verReporteActivosButton) {
        this.verReporteActivosButton = verReporteActivosButton;
    }

    public JButton getVerReportePasivosButton() { return this.verReportePasivosButton; }

    public void setVerReportePasivosButton(JButton verReportePasivosButton) {
        this.verReportePasivosButton = verReportePasivosButton;
    }

    public JComboBox<String> getCategoriaActivosLista() { return this.categoriaActivosLista; }

    public void setCategoriaActivosLista(JComboBox<String> categoriaActivosLista) {
        this.categoriaActivosLista = categoriaActivosLista;
    }

    public JComboBox<String> getCategoriaPasivosLista() { return this.categoriaPasivosLista; }

    public void setCategoriaPasivosLista(JComboBox<String> categoriaPasivosLista) {
        this.categoriaPasivosLista = categoriaPasivosLista;
    }

    public JLabel getActivosLabel() { return this.activosLabel; }

    public void setActivosLabel(JLabel activosLabel) { this.activosLabel = activosLabel; }

    public JLabel getCategoriaLabel() { return this.categoriaLabel; }

    public void setCategoriaLabel(JLabel categoriaLabel) { this.categoriaLabel = categoriaLabel; }

    public JLabel getLabel() { return this.label; }

    public void setLabel(JLabel label) { this.label = label; }

    public JLabel getPasivosLabel() { return this.pasivosLabel; }

    public void setPasivosLabel(JLabel pasivosLabel) { this.pasivosLabel = pasivosLabel; }

    public JLabel getReporteLabel() { return this.reporteLabel; }

    public void setReporteLabel(JLabel reporteLabel) { this.reporteLabel = reporteLabel; }

    public String[] getActivos() { return this.activos; }

    public void setActivos(String[] activos) { this.activos = activos; }

    public String[] getPasivos() { return this.pasivos; }

    public void setPasivos(String[] pasivos) { this.pasivos = pasivos; }

    @Override
    public Calendar calcularTiempo() {
        return null;
    }

}
