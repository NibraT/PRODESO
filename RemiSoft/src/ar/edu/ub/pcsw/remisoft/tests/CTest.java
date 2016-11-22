package ar.edu.ub.pcsw.remisoft.tests;

import ar.edu.ub.pcsw.remisoft.modelo.interfaces.ITemporizable;
import ar.edu.ub.pcsw.remisoft.vista.panel.ERegexValidadorInput;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class CTest implements ITemporizable {

    private CTestPerformance testPerformance;
    private List<String> listaCasos;
    private String fecha;
    private String nombreMetodo;
    private String nombreRegex;
    private String numero;
    private String reporteNoValidaInputEsperado;
    private String reporteValidaInputInesperado;
    private String testCase;
    public static int numeroDeTest = 0;

    /*
     * Constructor
     */
    public CTest() {
        this.setFecha(setFechaYHora());
        this.setListaCasos(new ArrayList<String>());
        this.setNumero(String.valueOf(numeroDeTest++));
        this.setTestPerformance(CTestPerformance.getInstance());
    }

    public String probarRegexApellido_InputEsperado() {
        getTestPerformance().startPerformanceTest();
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        setNombreRegex(getNombreMetodo().substring(11, getNombreMetodo().length() - 14).toUpperCase());
        getListaCasos().add("brandini");
        getListaCasos().add("Brandini");
        getListaCasos().add("ramírez");
        getListaCasos().add("Suárez");
        getListaCasos().add("Pérez");
        getListaCasos().add("martínez giménez");
        getListaCasos().add("Gómez");
        getListaCasos().add("Cúspide");
        getListaCasos().add("Ma");
        getListaCasos().add("malagaña");
        getListaCasos().add("Ñato");
        getListaCasos().add("Güer");
        getListaCasos().add("Über");
        getListaCasos().add("de la Huerta");
        return testerInputEsperado(ERegexValidadorInput.APELLIDO.getTexto());
    }

    public String probarRegexApellido_InputInesperado() {
        getTestPerformance().startPerformanceTest();
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        setNombreRegex(getNombreMetodo().substring(11, getNombreMetodo().length() - 16).toUpperCase());
        getListaCasos().add(" "); // ningún caracter
        getListaCasos().add("\n"); // line-break
        getListaCasos().add("d");
        getListaCasos().add("4");
        getListaCasos().add("#");
        getListaCasos().add("9chimo");
        getListaCasos().add("martínez costa estebecorena del río");
        getListaCasos().add("% chimo");
        getListaCasos().add("pérez-benítez");
        getListaCasos().add("martínez, gimenéz");
        getListaCasos().add("díaz.");
        return testerInputInesperado(ERegexValidadorInput.APELLIDO.getTexto());
    }

    public String probarRegexClave_InputEsperado() {
        getTestPerformance().startPerformanceTest();
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        setNombreRegex(getNombreMetodo().substring(11, getNombreMetodo().length() - 14).toUpperCase());
        getListaCasos().add("aaBB12$$");
        getListaCasos().add("aB1!#$%&()?¿");
        getListaCasos().add("aafBB11$$");
        getListaCasos().add("aafBBF11$$");
        getListaCasos().add("a_B$f4J%n0");
        getListaCasos().add("aafBBF110$$");
        getListaCasos().add("aaFBBf110$$%");
        return testerInputEsperado(ERegexValidadorInput.CLAVE.getTexto());
    }

    public String probarRegexClave_InputInesperado() {
        getTestPerformance().startPerformanceTest();
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        setNombreRegex(getNombreMetodo().substring(11, getNombreMetodo().length() - 16).toUpperCase());
        getListaCasos().add(" "); // ningún caracter
        getListaCasos().add("\n"); // line-break
        getListaCasos().add("a1B$f4J");
        getListaCasos().add("a1Bf4JnN");
        getListaCasos().add("a B$f4J%n0");
        getListaCasos().add("a1B$f4J%n0R&8");
        getListaCasos().add("12345678");
        getListaCasos().add("0");
        getListaCasos().add("-12345678");
        return testerInputInesperado(ERegexValidadorInput.CLAVE.getTexto());
    }

    public String probarRegexConsumo_InputEsperado() {
        getTestPerformance().startPerformanceTest();
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        setNombreRegex(getNombreMetodo().substring(11, getNombreMetodo().length() - 14).toUpperCase());
        getListaCasos().add("10");
        getListaCasos().add("99");
        return testerInputEsperado(ERegexValidadorInput.CONSUMO.getTexto());
    }

    public String probarRegexConsumo_InputInesperado() {
        getTestPerformance().startPerformanceTest();
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        setNombreRegex(getNombreMetodo().substring(11, getNombreMetodo().length() - 16).toUpperCase());
        getListaCasos().add(" "); // ningún caracter
        getListaCasos().add("\n"); // line-break
        getListaCasos().add("0");
        getListaCasos().add("100");
        getListaCasos().add("15.47");
        getListaCasos().add("10,25");
        getListaCasos().add("3 00");
        getListaCasos().add("-12");
        getListaCasos().add("k");
        getListaCasos().add("$");
        return testerInputInesperado(ERegexValidadorInput.CONSUMO.getTexto());
    }

    public String probarRegexCuenta_InputEsperado() {
        getTestPerformance().startPerformanceTest();
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        setNombreRegex(getNombreMetodo().substring(11, getNombreMetodo().length() - 14).toUpperCase());
        getListaCasos().add("100");
        getListaCasos().add("547");
        getListaCasos().add("999");
        return testerInputEsperado(ERegexValidadorInput.CUENTA.getTexto());
    }

    public String probarRegexCuenta_InputInesperado() {
        getTestPerformance().startPerformanceTest();
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        setNombreRegex(getNombreMetodo().substring(11, getNombreMetodo().length() - 16).toUpperCase());
        getListaCasos().add(" "); // ningún caracter
        getListaCasos().add("\n"); // line-break
        getListaCasos().add("0");
        getListaCasos().add("99");
        getListaCasos().add("1000");
        getListaCasos().add("5.47");
        getListaCasos().add("3 00");
        return testerInputInesperado(ERegexValidadorInput.CUENTA.getTexto());
    }

    public String probarRegexCuentaAdicional_InputEsperado() {
        getTestPerformance().startPerformanceTest();
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        setNombreRegex(getNombreMetodo().substring(11, getNombreMetodo().length() - 14).toUpperCase());
        getListaCasos().add("0");
        getListaCasos().add("1");
        getListaCasos().add("2");
        getListaCasos().add("3");
        getListaCasos().add("4");
        return testerInputEsperado(ERegexValidadorInput.CUENTAADICIONAL.getTexto());
    }

    public String probarRegexCuentaAdicional_InputInesperado() {
        getTestPerformance().startPerformanceTest();
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        setNombreRegex(getNombreMetodo().substring(11, getNombreMetodo().length() - 16).toUpperCase());
        getListaCasos().add(" "); // ningún caracter
        getListaCasos().add("\n"); // line-break
        getListaCasos().add("-1");
        getListaCasos().add("5");
        getListaCasos().add("10");
        return testerInputInesperado(ERegexValidadorInput.CUENTAADICIONAL.getTexto());
    }

    public String probarRegexDNI_InputEsperado() {
        getTestPerformance().startPerformanceTest();
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        setNombreRegex(getNombreMetodo().substring(11, getNombreMetodo().length() - 14).toUpperCase());
        getListaCasos().add("10000000");
        getListaCasos().add("99999999");
        return testerInputEsperado(ERegexValidadorInput.DNI.getTexto());
    }

    public String probarRegexDNI_InputInesperado() {
        getTestPerformance().startPerformanceTest();
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        setNombreRegex(getNombreMetodo().substring(11, getNombreMetodo().length() - 16).toUpperCase());
        getListaCasos().add(" "); // ningún caracter
        getListaCasos().add("\n"); // line-break
        getListaCasos().add("0");
        getListaCasos().add("9999999");
        getListaCasos().add("10.000.000");
        getListaCasos().add("10,000,000");
        getListaCasos().add("10 000 000");
        getListaCasos().add("100000000");
        getListaCasos().add("-12000000");
        getListaCasos().add("abcdefgh");
        return testerInputInesperado(ERegexValidadorInput.DNI.getTexto());
    }

    public String probarRegexDomicilio_InputEsperado() {
        getTestPerformance().startPerformanceTest();
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        setNombreRegex(getNombreMetodo().substring(11, getNombreMetodo().length() - 14).toUpperCase());
        getListaCasos().add("vera 1020 (C1425rgt) capital federal");
        getListaCasos().add("vera 1020 (C1425rgt) buenos aires");
        getListaCasos().add("calle 15 número 2071 Garín");
        getListaCasos().add("20 de Noviembre 688 CABA");
        return testerInputEsperado(ERegexValidadorInput.DOMICILIO.getTexto());
    }

    public String probarRegexDomicilio_InputInesperado() {
        getTestPerformance().startPerformanceTest();
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        setNombreRegex(getNombreMetodo().substring(11, getNombreMetodo().length() - 16).toUpperCase());
        getListaCasos().add(" "); // ningún caracter
        getListaCasos().add("\n"); // line-break
        getListaCasos().add("d");
        getListaCasos().add("4");
        getListaCasos().add("#");
        getListaCasos().add("vera 1020 -1425- CABA");
        getListaCasos().add("boulevard ejercito de los andes liberatador san martín 1040");
        return testerInputInesperado(ERegexValidadorInput.DOMICILIO.getTexto());
    }

    public String probarRegexFecha_InputEsperado() {
        getTestPerformance().startPerformanceTest();
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        setNombreRegex(getNombreMetodo().substring(11, getNombreMetodo().length() - 14).toUpperCase());
        getListaCasos().add("4/10/2016");
        getListaCasos().add("14/10/2016");
        getListaCasos().add("8/1/2017");
        getListaCasos().add("31/3/2018");
        getListaCasos().add("06/03/2018");
        getListaCasos().add("30/04/2018");
        getListaCasos().add("29/2/2016");
        getListaCasos().add("29/02/2020");
        return testerInputEsperado(ERegexValidadorInput.FECHA.getTexto());
    }

    public String probarRegexFecha_InputInesperado() {
        getTestPerformance().startPerformanceTest();
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        setNombreRegex(getNombreMetodo().substring(11, getNombreMetodo().length() - 16).toUpperCase());
        getListaCasos().add(" "); // ningún caracter
        getListaCasos().add("\n"); // line-break
        getListaCasos().add("/4/2016");
        getListaCasos().add("10//2016");
        getListaCasos().add("4/7/");
        getListaCasos().add("10-10-2016");
        getListaCasos().add("4:11:2016");
        getListaCasos().add("31/4/2017");
        getListaCasos().add("32/5/2017");
        getListaCasos().add("29/13/2018");
        return testerInputInesperado(ERegexValidadorInput.FECHA.getTexto());
    }

    public String probarRegexHora_InputEsperado() {
        getTestPerformance().startPerformanceTest();
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        setNombreRegex(getNombreMetodo().substring(11, getNombreMetodo().length() - 14).toUpperCase());
        getListaCasos().add("04:10");
        getListaCasos().add("21:00");
        getListaCasos().add("23:59");
        getListaCasos().add("0:00");
        getListaCasos().add("00:00");
        return testerInputEsperado(ERegexValidadorInput.HORA.getTexto());
    }

    public String probarRegexHora_InputInesperado() {
        getTestPerformance().startPerformanceTest();
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        setNombreRegex(getNombreMetodo().substring(11, getNombreMetodo().length() - 16).toUpperCase());
        getListaCasos().add(" "); // ningún caracter
        getListaCasos().add("\n"); // line-break
        getListaCasos().add(":20");
        getListaCasos().add("19:");
        getListaCasos().add("2 3:3 3");
        getListaCasos().add("25:10");
        getListaCasos().add("14:66");
        getListaCasos().add("-14:56");
        getListaCasos().add("a:56");
        getListaCasos().add("8:$");
        return testerInputInesperado(ERegexValidadorInput.HORA.getTexto());
    }

    public String probarRegexIdentificacion_InputEsperado() {
        getTestPerformance().startPerformanceTest();
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        setNombreRegex(getNombreMetodo().substring(11, getNombreMetodo().length() - 14).toUpperCase());
        getListaCasos().add("2323232"); // 7 caracteres numéricos
        getListaCasos().add("23232323"); // 8 caracteres numéricos
        getListaCasos().add("232323232"); // 9 carateres numéricos
        getListaCasos().add("2323232323"); // 10 caracteres numéricos
        getListaCasos().add("23232323232"); // 11 caracteres numéricos
        return testerInputEsperado(ERegexValidadorInput.IDENTIFICACION.getTexto());
    }

    public String probarRegexIdentificacion_InputInesperado() {
        getTestPerformance().startPerformanceTest();
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        setNombreRegex(getNombreMetodo().substring(11, getNombreMetodo().length() - 16).toUpperCase());
        getListaCasos().add(" "); // ningún caracter
        getListaCasos().add("\n"); // line-break
        getListaCasos().add("232323"); // 6 caracteres numéricos
        getListaCasos().add("232323232323"); // 12 caracteres numéricos
        getListaCasos().add("2 3 3 3 "); // caracteres numéricos y espacio
        getListaCasos().add("a"); // caracter alfabético
        getListaCasos().add("2a3b2c3"); // caracter alfanumérico
        return testerInputInesperado(ERegexValidadorInput.IDENTIFICACION.getTexto());
    }

    public String probarRegexKilometraje_InputEsperado() {
        getTestPerformance().startPerformanceTest();
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        setNombreRegex(getNombreMetodo().substring(11, getNombreMetodo().length() - 14).toUpperCase());
        getListaCasos().add("0");
        getListaCasos().add("999999");
        return testerInputEsperado(ERegexValidadorInput.KILOMETRAJE.getTexto());
    }

    public String probarRegexKilometraje_InputInesperado() {
        getTestPerformance().startPerformanceTest();
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        setNombreRegex(getNombreMetodo().substring(11, getNombreMetodo().length() - 16).toUpperCase());
        getListaCasos().add(" "); // ningún caracter
        getListaCasos().add("\n"); // line-break
        getListaCasos().add("-1");
        getListaCasos().add("1000000");
        getListaCasos().add("12.000");
        getListaCasos().add("1,000");
        getListaCasos().add("a");
        return testerInputInesperado(ERegexValidadorInput.KILOMETRAJE.getTexto());
    }

    public String probarRegexMarca_InputEsperado() {
        getTestPerformance().startPerformanceTest();
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        setNombreRegex(getNombreMetodo().substring(11, getNombreMetodo().length() - 14).toUpperCase());
        getListaCasos().add("chevrolet");
        getListaCasos().add("Nissan");
        getListaCasos().add("Renault");
        getListaCasos().add("bmw");
        return testerInputEsperado(ERegexValidadorInput.MARCA.getTexto());
    }

    public String probarRegexMarca_InputInesperado() {
        getTestPerformance().startPerformanceTest();
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        setNombreRegex(getNombreMetodo().substring(11, getNombreMetodo().length() - 16).toUpperCase());
        getListaCasos().add(" "); // ningún caracter
        getListaCasos().add("\n"); // line-break
        getListaCasos().add("b");
        getListaCasos().add("4ford");
        getListaCasos().add("#");
        getListaCasos().add("chevrolet ford renault citroen honda");
        return testerInputInesperado(ERegexValidadorInput.MARCA.getTexto());
    }

    public String probarRegexModelo_InputEsperado() {
        getTestPerformance().startPerformanceTest();
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        setNombreRegex(getNombreMetodo().substring(11, getNombreMetodo().length() - 14).toUpperCase());
        getListaCasos().add("Suran");
        getListaCasos().add("FOX");
        getListaCasos().add("Clio 2");
        getListaCasos().add("Fiesta Kinetic");
        getListaCasos().add("207 Compact");
        getListaCasos().add("307");
        getListaCasos().add("hr-v");
        return testerInputEsperado(ERegexValidadorInput.MODELO.getTexto());
    }

    public String probarRegexModelo_InputInesperado() {
        getTestPerformance().startPerformanceTest();
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        setNombreRegex(getNombreMetodo().substring(11, getNombreMetodo().length() - 16).toUpperCase());
        getListaCasos().add(" "); // ningún caracter
        getListaCasos().add("\n"); // line-break
        getListaCasos().add("d");
        getListaCasos().add("4");
        getListaCasos().add("#");
        getListaCasos().add("ford fiesta kinetic suran bora classic");
        return testerInputInesperado(ERegexValidadorInput.MODELO.getTexto());
    }

    public String probarRegexNombre_InputEsperado() {
        getTestPerformance().startPerformanceTest();
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        setNombreRegex(getNombreMetodo().substring(11, getNombreMetodo().length() - 14).toUpperCase());
        getListaCasos().add("mario");
        getListaCasos().add("Mariana");
        getListaCasos().add("Martín");
        getListaCasos().add("Gastón");
        getListaCasos().add("Andrés");
        getListaCasos().add("Néstor");
        getListaCasos().add("Cúspide");
        getListaCasos().add("Li");
        getListaCasos().add("malagaña");
        getListaCasos().add("Ñato");
        getListaCasos().add("Güer");
        getListaCasos().add("Über");
        getListaCasos().add("alfredo darío");
        return testerInputEsperado(ERegexValidadorInput.NOMBRE.getTexto());
    }

    public String probarRegexNombre_InputInesperado() {
        getTestPerformance().startPerformanceTest();
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        setNombreRegex(getNombreMetodo().substring(11, getNombreMetodo().length() - 16).toUpperCase());
        getListaCasos().add(" "); // ningún caracter
        getListaCasos().add("\n"); // line-break
        getListaCasos().add("d");
        getListaCasos().add("4");
        getListaCasos().add("#");
        getListaCasos().add("9fernando");
        getListaCasos().add("marcela fernanda micaela luisa");
        return testerInputInesperado(ERegexValidadorInput.NOMBRE.getTexto());
    }

    public String probarRegexNombreYApellidoORazonSocial_InputEsperado() {
        getTestPerformance().startPerformanceTest();
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        setNombreRegex(getNombreMetodo().substring(11, getNombreMetodo().length() - 14).toUpperCase());
        getListaCasos().add("WS SA");
        getListaCasos().add("WS S.A.");
        getListaCasos().add("empresa s.a.");
        getListaCasos().add("Servicios Empresarios SA");
        getListaCasos().add("Servicios Empresarios SRL");
        getListaCasos().add("Brandini");
        getListaCasos().add("ramírez");
        getListaCasos().add("Gómez");
        getListaCasos().add("Pérez Suárez");
        getListaCasos().add("martínez giménez");
        getListaCasos().add("Cúspide");
        getListaCasos().add("Ma");
        getListaCasos().add("malagaña");
        getListaCasos().add("Ñato");
        getListaCasos().add("Güer");
        getListaCasos().add("Über");
        getListaCasos().add("de la Huerta");
        return testerInputEsperado(ERegexValidadorInput.NOMBREYAPELLIDOORAZONSOCIAL.getTexto());
    }

    public String probarRegexNombreYApellidoORazonSocial_InputInesperado() {
        getTestPerformance().startPerformanceTest();
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        setNombreRegex(getNombreMetodo().substring(11, getNombreMetodo().length() - 16).toUpperCase());
        getListaCasos().add(" "); // ningún caracter
        getListaCasos().add("\n"); // line-break
        getListaCasos().add("d");
        getListaCasos().add("4");
        getListaCasos().add("#");
        getListaCasos().add("9chimo");
        getListaCasos().add("martínez costa estebecorena del río");
        getListaCasos().add("Servicios Empresarios S,A,");
        return testerInputInesperado(ERegexValidadorInput.NOMBREYAPELLIDOORAZONSOCIAL.getTexto());
    }

    public String probarRegexPatente_InputEsperado() {
        getTestPerformance().startPerformanceTest();
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        setNombreRegex(getNombreMetodo().substring(11, getNombreMetodo().length() - 14).toUpperCase());
        getListaCasos().add("AB 123 CD");
        getListaCasos().add("yt 344 gg");
        getListaCasos().add("ytr 344");
        return testerInputEsperado(ERegexValidadorInput.PATENTE.getTexto());
    }

    public String probarRegexPatente_InputInesperado() {
        getTestPerformance().startPerformanceTest();
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        setNombreRegex(getNombreMetodo().substring(11, getNombreMetodo().length() - 16).toUpperCase());
        getListaCasos().add(" "); // ningún caracter
        getListaCasos().add("\n"); // line-break
        getListaCasos().add("d");
        getListaCasos().add("4");
        getListaCasos().add("#");
        getListaCasos().add("ab ");
        getListaCasos().add("fgr 44");
        getListaCasos().add("9929 gghd 2222");
        return testerInputInesperado(ERegexValidadorInput.PATENTE.getTexto());
    }

    public String probarRegexPrecio_InputEsperado() {
        getTestPerformance().startPerformanceTest();
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        setNombreRegex(getNombreMetodo().substring(11, getNombreMetodo().length() - 14).toUpperCase());
        getListaCasos().add("100");
        getListaCasos().add("9999");
        return testerInputEsperado(ERegexValidadorInput.PRECIO.getTexto());
    }

    public String probarRegexPrecio_InputInesperado() {
        getTestPerformance().startPerformanceTest();
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        setNombreRegex(getNombreMetodo().substring(11, getNombreMetodo().length() - 16).toUpperCase());
        getListaCasos().add(" "); // ningún caracter
        getListaCasos().add("\n"); // line-break
        getListaCasos().add("0");
        getListaCasos().add("99");
        getListaCasos().add("10000");
        getListaCasos().add("2 3 3");
        getListaCasos().add("2.33");
        getListaCasos().add("24a");
        getListaCasos().add("$");
        getListaCasos().add("732#");
        getListaCasos().add("-732");
        return testerInputInesperado(ERegexValidadorInput.PRECIO.getTexto());
    }

    public String probarRegexTelefono_InputEsperado() {
        getTestPerformance().startPerformanceTest();
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        setNombreRegex(getNombreMetodo().substring(11, getNombreMetodo().length() - 14).toUpperCase());
        getListaCasos().add("1589762345");
        getListaCasos().add("47762345");
        return testerInputEsperado(ERegexValidadorInput.TELEFONO.getTexto());
    }

    public String probarRegexTelefono_InputInesperado() {
        getTestPerformance().startPerformanceTest();
        setNombreMetodo(new Object(){}.getClass().getEnclosingMethod().getName());
        setNombreRegex(getNombreMetodo().substring(11, getNombreMetodo().length() - 16).toUpperCase());
        getListaCasos().add(" "); // ningún caracter
        getListaCasos().add("\n"); // line-break
        getListaCasos().add("4778990");
        getListaCasos().add("477899045");
        getListaCasos().add("15567890232");
        getListaCasos().add("15 5678 4355");
        getListaCasos().add("4788.5699");
        getListaCasos().add("4788-5699");
        getListaCasos().add("15-5678-9023");
        getListaCasos().add("a15567890232");
        getListaCasos().add("a 15567890232");
        getListaCasos().add("-15567890232");
        getListaCasos().add("498%02345#");
        getListaCasos().add("tel");
        getListaCasos().add("cel.");
        return testerInputInesperado(ERegexValidadorInput.TELEFONO.getTexto());
    }

    public List<String> runUnitTests() {
        List<String> errores = new LinkedList<String>();
        detectarError(new CTest().probarRegexApellido_InputEsperado(), errores);
        detectarError(new CTest().probarRegexApellido_InputInesperado(), errores);
        detectarError(new CTest().probarRegexClave_InputEsperado(), errores);
        detectarError(new CTest().probarRegexClave_InputInesperado(), errores);
        detectarError(new CTest().probarRegexConsumo_InputEsperado(), errores);
        detectarError(new CTest().probarRegexConsumo_InputInesperado(), errores);
        detectarError(new CTest().probarRegexCuenta_InputEsperado(), errores);
        detectarError(new CTest().probarRegexCuenta_InputInesperado(), errores);
        detectarError(new CTest().probarRegexCuentaAdicional_InputEsperado(), errores);
        detectarError(new CTest().probarRegexCuentaAdicional_InputInesperado(), errores);
        detectarError(new CTest().probarRegexDNI_InputEsperado(), errores);
        detectarError(new CTest().probarRegexDNI_InputInesperado(), errores);
        detectarError(new CTest().probarRegexDomicilio_InputEsperado(), errores);
        detectarError(new CTest().probarRegexDomicilio_InputInesperado(), errores);
        detectarError(new CTest().probarRegexFecha_InputEsperado(), errores);
        detectarError(new CTest().probarRegexFecha_InputInesperado(), errores);
        detectarError(new CTest().probarRegexHora_InputEsperado(), errores);
        detectarError(new CTest().probarRegexHora_InputInesperado(), errores);
        detectarError(new CTest().probarRegexIdentificacion_InputEsperado(), errores);
        detectarError(new CTest().probarRegexIdentificacion_InputInesperado(), errores);
        detectarError(new CTest().probarRegexKilometraje_InputEsperado(), errores);
        detectarError(new CTest().probarRegexKilometraje_InputInesperado(), errores);
        detectarError(new CTest().probarRegexMarca_InputEsperado(), errores);
        detectarError(new CTest().probarRegexMarca_InputInesperado(), errores);
        detectarError(new CTest().probarRegexModelo_InputEsperado(), errores);
        detectarError(new CTest().probarRegexModelo_InputInesperado(), errores);
        detectarError(new CTest().probarRegexNombre_InputEsperado(), errores);
        detectarError(new CTest().probarRegexNombre_InputInesperado(), errores);
        detectarError(new CTest().probarRegexNombreYApellidoORazonSocial_InputEsperado(), errores);
        detectarError(new CTest().probarRegexNombreYApellidoORazonSocial_InputInesperado(), errores);
        detectarError(new CTest().probarRegexPatente_InputEsperado(), errores);
        detectarError(new CTest().probarRegexPatente_InputInesperado(), errores);
        detectarError(new CTest().probarRegexPrecio_InputEsperado(), errores);
        detectarError(new CTest().probarRegexPrecio_InputInesperado(), errores);
        detectarError(new CTest().probarRegexTelefono_InputEsperado(), errores);
        detectarError(new CTest().probarRegexTelefono_InputInesperado(), errores);
        return errores;
    }

    public void detectarError(String error, List<String> errores) {
        if (error != null) {
            errores.add(error);
        }
    }

    private String testerInputEsperado(String regex) {
        for (String caso : getListaCasos()) {
            if (! caso.matches(regex)) {
                setTestCase(caso);
                setReporteNoValidaInputEsperado();
                return getReporteNoValidaInputEsperado();
            }
        }
        return null;
    }

    private String testerInputInesperado(String regex) {
        for (String caso : getListaCasos()) {
            if (caso.matches(regex)) {
                setTestCase(caso);
                setReporteValidaInputInesperado();
                return getReporteValidaInputInesperado();
            }
        }
        return null;
    }

    public CTestPerformance getTestPerformance() { return this.testPerformance; }

    public void setTestPerformance(CTestPerformance testPerformance) { this.testPerformance = testPerformance; }

    public List<String> getListaCasos() { return this.listaCasos; }

    public void setListaCasos(List<String> listaCasos) { this.listaCasos = listaCasos; }

    public String getFecha() { return this.fecha; }

    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getNombreMetodo() { return this.nombreMetodo; }

    public void setNombreMetodo(String nombreMetodo) { this.nombreMetodo = nombreMetodo; }

    public String getNombreRegex() { return this.nombreRegex; }

    public void setNombreRegex(String nombreRegex) { this.nombreRegex = nombreRegex; }

    public String getNumero() { return this.numero; }

    public void setNumero(String numero) { this.numero = numero; }

    public String getReporteNoValidaInputEsperado() { return this.reporteNoValidaInputEsperado; }

    public void setReporteNoValidaInputEsperado() {
        this.reporteNoValidaInputEsperado = "Ejecución de Test " + getNumero() + " - " + getNombreMetodo() + " - " +
                getFecha() + ". ERROR: la regex " + getNombreRegex() + " no valida " + "input esperado (\"" +
                getTestCase() + "\").\n " + getTestPerformance().getPerformanceTestResult(getNombreMetodo());
    }

    public String getReporteValidaInputInesperado() { return this.reporteValidaInputInesperado; }

    public void setReporteValidaInputInesperado() {
        this.reporteValidaInputInesperado = "Ejecución de Test " + getNumero() + " - " + getNombreMetodo() + " - " +
                getFecha() + ". ERROR: la regex " + getNombreRegex() + " valida " + "input inesperado (\"" +
                getTestCase() + "\").\n " + getTestPerformance().getPerformanceTestResult(getNombreMetodo());
    }

    public String getTestCase() { return this.testCase; }

    public void setTestCase(String testCase) { this.testCase = testCase; }

    @Override
    public Calendar calcularTiempo() {
        return null;
    }

}