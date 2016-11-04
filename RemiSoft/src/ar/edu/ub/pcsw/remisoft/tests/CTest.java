package ar.edu.ub.pcsw.remisoft.tests;

import ar.edu.ub.pcsw.remisoft.vista.panel.ERegexValidadorInput;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class CTest {

    private String numero;
    private Date fecha;

    /**
     * Constructor
     */
    public CTest(String numero) {
        this.setNumero(numero);
    }

    public String probarREGEXIdentificacion() {
        List<String> listaCasosInvalidos = new ArrayList<String>();
        listaCasosInvalidos.add(" ");
        listaCasosInvalidos.add("\n");
        listaCasosInvalidos.add("232323");
        listaCasosInvalidos.add("232323232323");
        listaCasosInvalidos.add("2 3");
        listaCasosInvalidos.add("a");
        for (String string : listaCasosInvalidos) {
            if (string.matches(ERegexValidadorInput.IDENTIFICACION.getTexto())) {
                return "Prueba del método validarNombreOApellido. ERROR: el método valida " +
                        "input inesperado (\"" + string + "\")\n";
            }
        }
        return null;
    }

    public List<String> runUnitTests() {
        List<String> errores = new LinkedList<String>();
        detectarError(probarREGEXIdentificacion(), errores);
        return errores;
    }

    public void detectarError(String error, List<String> errores) {
        if(error != null) {
            errores.add(error);
        }
    }

    public String getNumero() { return this.numero; }

    public void setNumero(String numero) { this.numero = numero; }

    public Date getFecha() { return this.fecha; }

    public void setFecha(Date fecha) { this.fecha = fecha; }

}
