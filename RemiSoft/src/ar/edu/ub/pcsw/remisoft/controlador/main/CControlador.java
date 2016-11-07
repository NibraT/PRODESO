package ar.edu.ub.pcsw.remisoft.controlador.main;

import ar.edu.ub.pcsw.remisoft.tests.CTest;
import ar.edu.ub.pcsw.remisoft.tests.CTestPerformance;
import ar.edu.ub.pcsw.remisoft.vista.frame.CFrameRemisoft;

import java.util.Iterator;
import java.util.List;

public class CControlador {

    public static void main(String[] args) {

        CTest unitTest = new CTest();
        String nombreMetodo = new Object(){}.getClass().getEnclosingMethod().getName();
        List<String> errores = unitTest.runUnitTests();
        if(errores.size() == 0) {
            CTestPerformance testPerformance = CTestPerformance.getInstance();
            testPerformance.startPerformanceTest();
            CFrameRemisoft frame = new CFrameRemisoft();
            System.out.println(testPerformance.getPerformanceTestResult(nombreMetodo));
        }
        else {
            CTestPerformance testPerformance = CTestPerformance.getInstance();
            testPerformance.startPerformanceTest();
            Iterator<String> i = errores.iterator();
            while (i.hasNext()) {
                System.out.println(" " + i.next());
            }
            System.out.println(testPerformance.getPerformanceTestResult(nombreMetodo));
        }
    }

}



