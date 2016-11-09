package ar.edu.ub.pcsw.remisoft.controlador.main;

import ar.edu.ub.pcsw.remisoft.tests.CTest;
import ar.edu.ub.pcsw.remisoft.tests.CTestPerformance;
import ar.edu.ub.pcsw.remisoft.vista.frame.CFrameRemisoft;

import java.util.Iterator;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CControlador {

    private static FileHandler archivoLog;
    private static final Logger logger = Logger.getLogger(CControlador.class.getName());

    private static void setArchivoLog() {
        try {
            CControlador.archivoLog = new FileHandler("RemiSoft1.0-" + CControlador.class.getName() + "-log.%u.%g.txt",
                    1024 * 1024, 10);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static FileHandler getArchivoLog() {
        setArchivoLog();
        return archivoLog;
    }

    public static void main(String[] args) {
        String nombreClase = "CControlador";
        String nombreMetodo = new Object(){}.getClass().getEnclosingMethod().getName();
        logger.entering(nombreClase, nombreMetodo);
        CTest unitTest = new CTest();
        List<String> errores = unitTest.runUnitTests();
        if (errores.size() == 0) {
            CTestPerformance testPerformance = CTestPerformance.getInstance();
            testPerformance.startPerformanceTest();
            CFrameRemisoft frame = new CFrameRemisoft();
            if (testPerformance.setPerformanceTestResult() > 1) {
                logger.addHandler(getArchivoLog());
                logger.log(Level.INFO, testPerformance.getPerformanceTestResult(nombreMetodo));
            }
        }
        else {
            Iterator<String> i = errores.iterator();
            while (i.hasNext()) {
                System.out.println(" " + i.next());
            }
        }
        logger.exiting(nombreClase, nombreMetodo);
    }

}



