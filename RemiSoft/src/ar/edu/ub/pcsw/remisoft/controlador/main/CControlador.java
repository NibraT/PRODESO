package ar.edu.ub.pcsw.remisoft.controlador.main;

import ar.edu.ub.pcsw.remisoft.tests.CTest;
import ar.edu.ub.pcsw.remisoft.vista.frame.CFrameRemisoft;

import java.util.Iterator;
import java.util.List;

public class CControlador {

    public static void main(String[] args) {

        CTest unitTest = new CTest("1");
        List<String> errores = unitTest.runUnitTests();
        if(errores.size() == 0) {
            CFrameRemisoft frame = new CFrameRemisoft();
        }
        else {
            Iterator<String> i = errores.iterator();
            while (i.hasNext()) {
                System.out.println(" " + i.next());
            }
        }
        //CFrameRemisoft frame = new CFrameRemisoft();
    }

}



