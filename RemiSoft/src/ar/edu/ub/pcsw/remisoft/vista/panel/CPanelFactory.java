package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IPanelFactory;

import javax.swing.*;

public class CPanelFactory implements IPanelFactory {

    public JPanel crearPanel(CButtonSelectorPanel jButton) {
        if (jButton.getText().equals(ETextoButton.VIAJES.getTexto())) {
            return new CPanelMenuViajes();
        }
        else if (jButton.getText().equals(ETextoButton.CLIENTES.getTexto())) {
            return new CPanelMenuClientes();
        }
        else if (jButton.getText().equals(ETextoButton.AUTOS.getTexto())) {
            return new CPanelMenuAutos();
        }
        else if (jButton.getText().equals(ETextoButton.EMPLEADOS.getTexto())) {
            return new CPanelMenuEmpleados();
        }
        else if (jButton.getText().equals(ETextoButton.REPORTES.getTexto())) {
            return new CPanelMenuReportes();
        }
        else if (jButton.getText().equals(ETextoButton.TOMARVIAJE.getTexto())) {
            return new CPanelActividadTomarViaje();
        }
        else if (jButton.getText().equals(ETextoButton.RENDIRVIAJE.getTexto())) {
            return new CPanelActividadRendirViaje();
        }
        else if (jButton.getText().equals(ETextoButton.ALTACLIENTE.getTexto())) {
            return new CPanelActividadAltaCliente();
        }
        else if (jButton.getText().equals(ETextoButton.BAJACLIENTE.getTexto())) {
            return new CPanelActividadBajaCliente();
        }
        else if (jButton.getText().equals(ETextoButton.ALTAAUTO.getTexto())) {
            return new CPanelActividadAltaAuto();
        }
        else if (jButton.getText().equals(ETextoButton.BAJAAUTO.getTexto())) {
            return new CPanelActividadBajaAuto();
        }
        else if (jButton.getText().equals(ETextoButton.ALTAEMPLEADO.getTexto())) {
            return new CPanelActividadAltaEmpleado();
        }
        else if (jButton.getText().equals(ETextoButton.BAJAEMPLEADO.getTexto())) {
            return new CPanelActividadBajaEmpleado();
        }
        else if (jButton.getText().equals(ETextoButton.REPORTEGESTION.getTexto())) {
            return new CPanelActividadReporteGestion();
        }
        else if (jButton.getText().equals(ETextoButton.REPORTECAJA.getTexto())) {
            return new CPanelActividadReporteCaja();
        }
        else if (jButton.getText().equals(ETextoButton.SALIR.getTexto())) {
            return new CPanelFondo("src/data/mapaGarin.jpg", 1100, 587);
            //return new CPanelMenu();
        }
        return null;
    }

}
