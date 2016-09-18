package ar.edu.ub.pcsw.remisoft.controlador.main;

import ar.edu.ub.pcsw.remisoft.modelo.clientes.CCliente;
import ar.edu.ub.pcsw.remisoft.vista.frame.CFrameRemisoft;

public class CControlador {

    public static void main(String[] args) {
        //CFrameRemisoft frame = new CFrameRemisoft();
        CCliente cliente = new CCliente("Juan Perez", "1234", "Sarandí 1221 (B2475ERD) Buenos Aires", "344556");
        cliente.agregarCuenta(cliente.activarCuenta());
        System.out.println(cliente.toString());
    }

}



