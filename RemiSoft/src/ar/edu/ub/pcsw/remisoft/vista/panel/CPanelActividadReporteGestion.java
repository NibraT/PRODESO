package ar.edu.ub.pcsw.remisoft.vista.panel;

import java.awt.*;
import java.util.Calendar;

public class CPanelActividadReporteGestion extends CPanelActividadBase {

    public CPanelActividadReporteGestion() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.PINK);
        this.getNorteLabel().setText("REPORTE GESTION");
        this.add(getNorteLabel(), BorderLayout.NORTH);
        this.add(getSurLabel(), BorderLayout.SOUTH);
    }

    @Override
    public Calendar calcularTiempo() {
        return null;
    }
}
