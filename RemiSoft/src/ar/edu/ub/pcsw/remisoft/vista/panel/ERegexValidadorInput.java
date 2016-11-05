package ar.edu.ub.pcsw.remisoft.vista.panel;

public enum ERegexValidadorInput {

    /*Explicación de la regex APELLIDO
      ([a-zA-Záéíóú]  # sólo consonantes y/o vocales (con/sin acento) mayúsculas y/o minúsculas (éstas últimas
                      #   excepto vocales con acento) del alfabeto latino
      {2,20})         # no menos de 2 ni más de 20 caracteres
      |               # disyunción no exclusiva
    */
    APELLIDO("([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20})|" +
            "([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20})|" +
            "([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]" +
            "{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{1,20})"),
    /*Explicación de la regex CLAVE
      ^                # inicio de la cadena
      (?=.*[0-9])      # al menos 1 dígito
      (?=.*[a-z])      # al menos 1 letra minúscula
      (?=.*[A-Z])      # al menos 1 letra mayúscula
      (?=.*[@#$%^&+=]) # al menos 1 símbolo
      (?=\S+$)         # ningún espacio en blanco
      .{8,12}          # no menos de 8 ni más de 12 caracteres
      $                # fin de la cadena
    */
    CLAVE("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,12}$"),
    /*Explicación de la regex CUENTA
      ([1-9][0-9])  # sólo numeros entre 1 y 9 (primer dígito) y 0 y 9 (demás dígitos)
      \d{3}         # sólo 3 caracteres
      [^\.][^\s]    # sin puntos ni espacios en blanco
    */
    CUENTA("((([1-9][0-9])\\d{3})[^\\.][^\\s])"),
    /*Explicación de la regex CUENTAADICIONAL
      0|1|2|3|4  # sólo 0 y números enteros entre 1 y 4
    */
    CUENTAADICIONAL("0|1|2|3|4"),
    /*Explicación de la regex DNI
      (((([1-9][0-9])    # sólo numeros entre 1 y 9 (primer dígito) y 0 y 9 (demás dígitos)
      \d{2}              # no menos de 7 caracteres
      [^\.][^\s][^a-z])  # sin letras del alfabeto latino
      \d{4}              # no más de 9 caracteres
      |                  # disyunción no exclusiva
    */
    DNI("(((([1-9][0-9])\\d{2})[^\\.][^\\s][^a-z])|" +
            "((([1-9][0-9])\\d{3})[^\\.][^\\s][^a-z])|((([1-9][0-9])\\d{4})[^\\.][^\\s][^a-z]))"),
    /*Explicación de la regex DOMICILIO
      ([a-zA-Záéíóú]  # sólo consonantes y/o vocales (con/sin acento) mayúsculas y/o minúsculas (éstas últimas
                      #   excepto vocales con acento) del alfabeto latino
      {2,20})         # no menos de 2 ni más de 20 caracteres
      |               # disyunción no exclusiva
    */
    DOMICILIO("([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20})|" +
            "([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20})|" +
            "([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]" +
            "{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{1,20})"),
    /*Explicación de la regex FECHA
      (((([1-9][0-9])    # sólo numeros entre 1 y 9 (primer dígito) y 0 y 9 (demás dígitos)
      \d{2}              # no menos de 7 caracteres
      [^\.][^\s][^a-z])  # sin letras del alfabeto latino
      \d{4}              # no más de 9 caracteres
      |                  # disyunción no exclusiva
    */
    FECHA("((([1-9][0-9])\\d{2,4})[^\\.][^\\s])"),
    /*Explicación de la regex HORA
      ([0-1]?[0-9])  # sólo números entre 0 y 19
      |              # disyunción no exclusiva
      (2[0-3])       # sólo números entre 20 y 23
      [0-5][0-9]     # sólo números entre 0 y 59
    */
    HORA("(([0-1]?[0-9])|(2[0-3])):[0-5][0-9]"),
    /*Explicación de la regex IDENTIFICACION
      (((([1-9][0-9])    # sólo numeros entre 1 y 9 (primer dígito) y 0 y 9 (demás dígitos)
      \d{2}              # no menos de 7 caracteres
      [^\.][^\s][^a-z])  # sin letras del alfabeto latino
      \d{4}              # no más de 9 caracteres
      |                  # disyunción no exclusiva
    */
    IDENTIFICACION("(((([1-9][0-9])\\d{2})[^\\.][^\\s][^a-z])|" +
            "((([1-9][0-9])\\d{3})[^\\.][^\\s][^a-z])|((([1-9][0-9])\\d{4})[^\\.][^\\s][^a-z]))"),
    /*Explicación de la regex MARCA
      ([a-zA-Záéíóú]  # sólo consonantes y/o vocales (con/sin acento) mayúsculas y/o minúsculas (éstas últimas
                      #   excepto vocales con acento) del alfabeto latino
      {2,20})         # no menos de 2 ni más de 20 caracteres
      |               # disyunción no exclusiva
    */
    MARCA("([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20})|" +
            "([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20})|" +
            "([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]" +
            "{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{1,20})"),
    /*Explicación de la regex MODELO
      ([a-zA-Záéíóú]  # sólo consonantes y/o vocales (con/sin acento) mayúsculas y/o minúsculas (éstas últimas
                      #   excepto vocales con acento) del alfabeto latino
      {2,20})         # no menos de 2 ni más de 20 caracteres
      |               # disyunción no exclusiva
    */
    MODELO("([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20})|" +
            "([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20})|" +
            "([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]" +
            "{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{1,20})"),
    /*Explicación de la regex NOMBRE
      ([a-zA-Záéíóú]  # sólo consonantes y/o vocales (con/sin acento) mayúsculas y/o minúsculas (éstas últimas
                      #   excepto vocales con acento) del alfabeto latino
      {2,20})         # no menos de 2 ni más de 20 caracteres
      |               # disyunción no exclusiva
    */
    NOMBRE("([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20})|" +
            "([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20})|" +
            "([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]" +
            "{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{1,20})"),
    /*Explicación de la regex NOMBREYAPELLIDOORAZONSOCIAL
      ([a-zA-Záéíóú]  # sólo consonantes y/o vocales (con/sin acento) mayúsculas y/o minúsculas (éstas últimas
                      #   excepto vocales con acento) del alfabeto latino
      {2,20})         # no menos de 2 ni más de 20 caracteres
      |               # disyunción no exclusiva
    */
    NOMBREYAPELLIDOORAZONSOCIAL("([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20})|" +
            "([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20})|" +
            "([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]" +
            "{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{1,20})"),
    /*Explicación de la regex PATENTE
      ([a-zA-Záéíóú]  # sólo consonantes y/o vocales (con/sin acento) mayúsculas y/o minúsculas (éstas últimas
                      #   excepto vocales con acento) del alfabeto latino
      {2,20})         # no menos de 2 ni más de 20 caracteres
      |               # disyunción no exclusiva
    */
    PATENTE("([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20})|" +
            "([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20})|" +
            "([a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{2,20}[\\s]" +
            "{1,2}[a-zA-Z\u00E1\u00E9\u00ED\u00F3\u00FA]{1,20})"),
    /*Explicación de la regex PRECIO
      ([1-9][0-9])  # sólo numeros entre 1 y 9 (primer dígito) y 0 y 9 (demás dígitos)
      \d{2,4}       # no menos de 2 ni más de 4 caracteres
      [^\.][^\s]    # sin puntos ni espacios en blanco
    */
    PRECIO("((([1-9][0-9])\\d{2,4})[^\\.][^\\s])"),
    /*Explicación de la regex CUENTA
      ([1-9][0-9])  # sólo numeros entre 1 y 9 (primer dígito) y 0 y 9 (demás dígitos)
      \d{6}         # sólo 6 caracteres adicionales
      [^\.][^\s]    # sin puntos ni espacios en blanco
    */
    TELEFONO("((([1-9][0-9])\\d{6})[^\\.][^\\s])");

    private String texto;

    ERegexValidadorInput(String texto) {
        this.setTexto(texto);
    }

    public String getTexto() { return this.texto; }

    public void setTexto(String texto) { this.texto = texto; }

}
