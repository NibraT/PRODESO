package ar.edu.ub.pcsw.remisoft.vista.panel;

public enum ERegexValidadorInput {

    APELLIDO("([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20})|" +
            "([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20})|" +
            "([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]" +
            "{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{1,20})"),
    CUENTA("((([1-9][0-9])\\d{3})[^\\.][^\\s])"),
    CUENTAADICIONAL("0|1|2|3|4"),
    DNI("(((([1-9][0-9])\\d{2})[^\\.][^\\s][^a-z])|" +
            "((([1-9][0-9])\\d{3})[^\\.][^\\s][^a-z])|((([1-9][0-9])\\d{4})[^\\.][^\\s][^a-z]))"),
    DOMICILIO("([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20})|" +
            "([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20})|" +
            "([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]" +
            "{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{1,20})"),
    FECHA("(((([1-9][0-9])\\d{2})[^\\.][^\\s][^a-z])|" +
            "((([1-9][0-9])\\d{3})[^\\.][^\\s][^a-z])|((([1-9][0-9])\\d{4})[^\\.][^\\s][^a-z]))"),
    HORA("(((([1-9][0-9])\\d{2})[^\\.][^\\s][^a-z])|" +
            "((([1-9][0-9])\\d{3})[^\\.][^\\s][^a-z])|((([1-9][0-9])\\d{4})[^\\.][^\\s][^a-z]))"),
    IDENTIFICACION("(((([1-9][0-9])\\d{2})[^\\.][^\\s][^a-z])|" +
            "((([1-9][0-9])\\d{3})[^\\.][^\\s][^a-z])|((([1-9][0-9])\\d{4})[^\\.][^\\s][^a-z]))"),
    MARCA("([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20})|" +
            "([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20})|" +
            "([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]" +
            "{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{1,20})"),
    MODELO("([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20})|" +
            "([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20})|" +
            "([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]" +
            "{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{1,20})"),
    NOMBRE("([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20})|" +
            "([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20})|" +
            "([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]" +
            "{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{1,20})"),
    NOMBREYAPELLIDOORAZONSOCIAL("([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20})|" +
            "([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20})|" +
            "([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]" +
            "{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{1,20})"),
    PATENTE("([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20})|" +
            "([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20})|" +
            "([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]" +
            "{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{1,20})"),
    PRECIO("((([1-9][0-9])\\d{3})[^\\.][^\\s])"),
    TELEFONO("((([1-9][0-9])\\d{6})[^\\.][^\\s])");

    private String texto;

    ERegexValidadorInput(String texto) {
        this.setTexto(texto);
    }

    public String getTexto() { return this.texto; }

    public void setTexto(String texto) { this.texto = texto; }

}
