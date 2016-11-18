package ar.edu.ub.pcsw.remisoft.tests;

import java.util.concurrent.TimeUnit;

public class CTestPerformance {

    public static CTestPerformance instance;
    private static long start;

    /*
    Constructor
     */
    private CTestPerformance() {

    }

    public static synchronized CTestPerformance getInstance() {
        if (instance == null) {
            instance = new CTestPerformance();
        }
        return instance;
    }

    public long startPerformanceTest() {
        setStart(System.nanoTime());
        return start;
    }

    public double setPerformanceTestResult() {
        long tiempoEstimado = System.nanoTime() - getStart();
        double tiempoEnSegundos = TimeUnit.SECONDS.convert(tiempoEstimado, TimeUnit.NANOSECONDS);
        return tiempoEnSegundos;
    }

    public String getPerformanceTestResult(String nombreMetodo) {
        return "Ejecución del método " + nombreMetodo + " duró " +
                String.format("%.3f", setPerformanceTestResult()) + " segundos.";
    }

    public static long getStart() { return start; }

    public static void setStart(long start) { CTestPerformance.start = start; }

}