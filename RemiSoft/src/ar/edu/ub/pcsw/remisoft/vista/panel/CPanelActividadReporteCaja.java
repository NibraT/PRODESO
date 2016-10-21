package ar.edu.ub.pcsw.remisoft.vista.panel;

import java.awt.*;
import java.util.Calendar;

public class CPanelActividadReporteCaja extends CPanelActividadBase {

    public CPanelActividadReporteCaja() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.PINK);
        this.getNorteLabel().setText("REPORTE CAJA");
        this.add(getNorteLabel(), BorderLayout.NORTH);
        this.add(getSurLabel(), BorderLayout.SOUTH);
    }

    @Override
    public Calendar calcularTiempo() {
        return null;
    }
}
