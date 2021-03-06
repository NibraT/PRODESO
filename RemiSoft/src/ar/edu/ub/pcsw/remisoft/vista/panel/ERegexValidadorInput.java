package ar.edu.ub.pcsw.remisoft.vista.panel;

public enum ERegexValidadorInput {

    /*Explicación de la regex APELLIDO
      (?!.*([a-bd-fh-koqu-yA-BD-FH-KOQU-Y]) # excluye 2 letras consecutivas iguales salvo c, g, l, m, n, p, r, s, t, z
      ([a-zA-Z\\p{L}]  # sólo consonantes y/o vocales (con/sin acento) mayúsculas y/o minúsculas (éstas últimas
                       #   excepto vocales con acento) del alfabeto latino
      {1,20})          # no menos de 2 ni más de 27 caracteres
      |                # disyunción no exclusiva
    */
    APELLIDO("(?!.*([a-bd-fh-koqu-yA-BD-FH-KOQU-Y])\\1)([^0-9!#$%&/()=?¡)\\.,;:-][a-zA-Z\\p{L}]{1,20})|" +
            "([a-zA-Z\\p{L}]{2,20}[\\s]{1,2}[a-zA-Z\\p{L}]{2,20})|" +
            "([a-zA-Z\\p{L}]{2,20}[\\s]{1,2}[a-zA-Z\\p{L}]{2,20}[\\s]{1,2}[a-zA-Z\\p{L}]{1,20})|" +
            "([a-zA-Z\\p{L}]{2,20}[\\s]{1,2}[a-zA-Z\\p{L}]{2,20}[\\s]{1,2}[a-zA-Z\\p{L}]{2,20}[\\s]" +
            "{1,2}[a-zA-Z\\p{L}]{1,20})"),
    /*Explicación de la regex CLAVE
      (?=.*[a-z])     # al menos 1 letra minúscula
      (?=.*[A-Z])     # al menos 1 letra mayúscula
      (?=.*[0-9])     # al menos 1 dígito
      (?=.*[#$%_])    # al menos 1 símbolo #, $, %, _
      [^\\.][^\\s]    # sin ningún punto ni espacio en blanco
      .{6,10}         # no menos de 8 ni más de 12 caracteres
    */
    CLAVE("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[#$%_!&()])[^\\.][^\\s].{6,10})"),
    /*Explicación de la regex CONSUMO
      ([1-9])       # sólo numeros entre 1 y 9
      \d{0}         # sólo 2 caracteres
      ([^\.]|[^\s]) # sin puntos ni espacios en blanco
    */
    CONSUMO("((([1-9])\\d{0})([^\\.]|[^\\s]))"),
    /*Explicación de la regex CUENTA
      ([1-9][0-9])  # sólo numeros entre 1 y 9 (primer dígito) y 0 y 9 (demás dígitos)
      \d{0}         # sólo 3 caracteres
      ([^\.]|[^\s]) # sin puntos ni espacios en blanco
    */
    CUENTA("(([1-9][0-9])\\d{0})([^\\.]|[^\\s])"),
    /*Explicación de la regex CUENTAADICIONAL
      0|1|2|3|4  # sólo 0 y números enteros entre 1 y 4
    */
    CUENTAADICIONAL("0|1|2|3|4"),
    /*Explicación de la regex DNI
      (((([1-9][0-9])          # sólo numeros entre 1 y 9 (primer dígito) y 0 y 9 (demás dígitos)
      \d{2}                    # 8 caracteres
      [^\.][^\s][^a-zA-Z][^,]  # sin ningún punto, espacio en blanco, letra del alfabeto latino ni coma
    */
    DNI("((([1-9][0-9])\\d{2})[^\\.][^\\s][^a-zA-Z][^,])"),
    /*Explicación de la regex DOMICILIO
      (?!.*([a-bd-fh-koqu-yA-BD-FH-KOQU-Y]) # excluye 2 letras consecutivas iguales salvo c, g, l, m, n, p, r, s, t, z
      ([a-zA-Z\\p{L}]     # sólo consonantes y/o vocales (con/sin acento) mayúsculas y/o minúsculas (éstas últimas
                          #   excepto vocales con acento) del alfabeto latino
      \d+                 # al menos uno o más caracteres numéricos
      \(?\)?              # paréntesis de apertura y cierre opcionales
      \s{2,5}             # no menos de 2 ni más de 5 espacios en blanco
      {2,45})             # no menos de 2 ni más de 47 caracteres
    */
    DOMICILIO("(?!.*([a-bd-fh-koqu-yA-BD-FH-KOQU-Y])\\1)[a-zA-Z\\p{L}\\d+\\(?\\)?\\s{2,5}]{2,45}"),
    /*Explicación de la regex FECHA
      (((([1-9][0-9])    # sólo numeros entre 1 y 9 (primer dígito) y 0 y 9 (demás dígitos)
      \d{2}              # no menos de 7 caracteres
      [^\.][^\s][^a-z])  # sin letras del alfabeto latino
      \d{4}              # sólo 10 caracteres
      |                  # disyunción no exclusiva
    */
    FECHA("((0?[1-9]|[12][0-9]|3[01])/(0?[13578]|1[02])/(18|19|20|21)[0-9]{2})|" +
            "((0?[1-9]|[12][0-9]|30)/(0?[469]|11)/(18|19|20|21)[0-9]{2})|" +
            "((0?[1-9]|1[0-9]|2[0-8])/(0?2)/(18|19|20|21)[0-9]{2})|(29/(0?2)/" +
            "(((18|19|20|21)(04|08|[2468][048]|[13579][26]))|2000))"),
    /*Explicación de la regex HORA
      ([0-1]?[0-9])  # sólo números entre 0 (opcional) y 19
      |              # disyunción no exclusiva
      (2[0-3])       # sólo números entre 20 y 23
      :              # dos puntos
      [0-5][0-9]     # sólo números entre 00 (obligatorio) y 59
    */
    HORA("(([0-1]?[0-9])|(2[0-3])):[0-5][0-9]"),
    /*Explicación de la regex IDENTIFICACION
      ([1-9][0-9])      # sólo numeros entre 1 y 9 (primer dígito) y 0 y 9 (demás dígitos)
      \d{2}             # no menos de 7 caracteres
      [^\.][^\s][^a-z]) # sin puntos, espacios en blanco ni letras del alfabeto latino,
      \d{6}             # no más de 11 caracteres
      |                 # disyunción no exclusiva
    */
    IDENTIFICACION("(((([1-9][0-9])\\d{2})[^\\.][^\\s][^a-z])|" +
            "((([1-9][0-9])\\d{3})[^\\.][^\\s][^a-z])|((([1-9][0-9])\\d{4})[^\\.][^\\s][^a-z])|" +
            "((([1-9][0-9])\\d{5})[^\\.][^\\s][^a-z])|((([1-9][0-9])\\d{6})[^\\.][^\\s][^a-z]))"),
    /*Explicación de la regex KILOMETRAJE
      ([0-9])       # sólo numeros entre 0 y 9
      \d{0,4}       # hasta 6 caracteres
      ([^\.]|[^\s]) # sin puntos ni espacios en blanco
    */
    KILOMETRAJE("([0-9])|(([0-9])\\d{0,4})([^\\.]|[^\\s])"),
    /*Explicación de la regex MARCA
      (?!.*([a-bd-fh-koqu-yA-BD-FH-KOQU-Y]) # excluye 2 letras consecutivas iguales salvo c, g, l, m, n, p, r, s, t, z
      ([a-zA-Z\\p{L}]     # sólo consonantes y/o vocales (con/sin acento) mayúsculas y/o minúsculas (éstas últimas
                          #   excepto vocales con acento) del alfabeto latino
      {2,20})             # no menos de 2 ni más de 27 caracteres
      |                   # disyunción no exclusiva
    */
    MARCA("(?!.*([a-bd-fh-koqu-yA-BD-FH-KOQU-Y])\\1)([a-zA-Z\\p{L}]{2,20})|([a-zA-Z\\p{L}]{2,20}[\\s]{1,2}[a-zA-Z\\p{L}]{2,20})|" +
            "([a-zA-Z\\p{L}]{2,20}[\\s]{1,2}[a-zA-Z\\p{L}]{2,20}[\\s]{1,2}[a-zA-Z\\p{L}]{1,20})"),
    /*Explicación de la regex MODELO
      (?!.*([a-bd-fh-koqu-yA-BD-FH-KOQU-Y]) # excluye 2 letras consecutivas iguales salvo c, g, l, m, n, p, r, s, t, z
      ([a-zA-Z\\p{L}]     # sólo consonantes y/o vocales (con/sin acento) mayúsculas y/o minúsculas (éstas últimas
                          #   excepto vocales con acento) del alfabeto latino
      \d+                 # al menos uno o más caracteres numéricos
      \-?                 # un guión medio opcional
      \s{2,5}             # no menos de 2 ni más de 5 espacios en blanco
      {2,30})             # no menos de 2 ni más de 32 caracteres
    */
    MODELO("(?!.*([a-bd-fh-koqu-yA-BD-FH-KOQU-Y])\\1)[a-zA-Z\\p{L}\\d+\\-?\\s{2,5}]{2,30}"),
    /*Explicación de la regex NOMBRE
      (?!.*([a-bd-fh-koqu-yA-BD-FH-KOQU-Y]) # excluye 2 letras consecutivas iguales salvo c, g, l, m, n, p, r, s, t, z
      ([a-zA-Z\\p{L}]     # sólo consonantes y/o vocales (con/sin acento) mayúsculas y/o minúsculas (éstas últimas
                          #   excepto vocales con acento) del alfabeto latino
      {2,20})             # no menos de 2 ni más de 27 caracteres
      |                   # disyunción no exclusiva
    */
    NOMBRE("(?!.*([a-bd-fh-koqu-yA-BD-FH-KOQU-Y])\\1)([a-zA-Z\\p{L}]{2,20})|([a-zA-Z\\p{L}]{2,20}[\\s]{1,2}[a-zA-Z\\p{L}]{2,20})|" +
            "([a-zA-Z\\p{L}]{2,20}[\\s]{1,2}[a-zA-Z\\p{L}]{2,20}[\\s]{1,2}[a-zA-Z\\p{L}]{1,20})"),
    /*Explicación de la regex NOMBREYAPELLIDOORAZONSOCIAL
      (?!.*([a-bd-fh-koqu-yA-BD-FH-KOQU-Y]) # excluye 2 letras consecutivas iguales salvo c, g, l, m, n, p, r, s, t, z
      ([a-zA-Z\\p{L}]     # sólo consonantes y/o vocales (con/sin acento) mayúsculas y/o minúsculas (éstas últimas
                          #   excepto vocales con acento) del alfabeto latino
      (?!\.)              # con/sin uno o más puntos
      {2,30})             # no menos de 2 ni más de 40 caracteres
      |                   # disyunción no exclusiva
    */
    NOMBREYAPELLIDOORAZONSOCIAL("(?!.*([a-bd-fh-koqu-yA-BD-FH-KOQU-Y])\\1)([a-zA-Z\\p{L}]{2,30})|([a-zA-Z\\p{L}]{2,30}[\\s]" +
            "{1,2}(?!\\.)[a-zA-Z\\p{L}.]{2,30})|([a-zA-Z\\p{L}]{2,30}[\\s]{1,2}[a-zA-Z\\p{L}]{2,30}[\\s]" +
            "{1,2}[a-zA-Z\\p{L}]{2,30})|([a-zA-Z\\p{L}]{2,30}[\\s]{1,2}[a-zA-Z\\p{L}]{2,30}[\\s]" +
            "{1,2}[a-zA-Z\\p{L}]{2,30}[\\s]{1,2}[a-zA-Z\\p{L}]{2,30})"),
    /*Explicación de la regex NUMEROVIAJE
      ([1-9])       # sólo numeros
      \d{1,5}       # 1 a 5 dígitos
      ([^\.]|[^\s]) # sin puntos ni espacios en blanco
    */
    NUMEROVIAJE("((\\d){1,5})"),
    /*Explicación de la regex PATENTE
      ([a-zA-Z]     # sólo consonantes y/o vocales mayúsculas y/o minúsculas sin acento del alfabeto latino
      \d            # al menos uno o más caracteres numéricos
      \s{2,2}       # no menos de 2 ni más de 5 espacios en blanco
      {9})          # 9 caracteres en total
      |             # disyunción no exclusiva
    */
    PATENTE("((?!.*([0])\\2)([a-zA-Z\\d\\s{1,1}]{7}))|((?!.*([0])\\2)[a-zA-Z\\d\\s{2,2}]{9})"),
    /*Explicación de la regex PRECIO
      ([1-9][0-9])  # sólo numeros entre 1 y 9 (primer dígito) y 0 y 9 (demás dígitos)
      \d{0,1}       # no menos de 3 ni más de 4 caracteres
      [^\\.]        # sin puntos
    */
    PRECIO("([1-9][0-9])\\d{0,1}[^a-zA-Z\\p{L}\\.!#$%&/()?¡¿¨-]"),
    /*Explicación de la regex TELEFONO
      ([1-9][0-9])  # sólo numeros entre 1 y 9 (primer dígito) y 0 y 9 (demás dígitos)
      \d{4}         # sólo 8 caracteres numéricos
      \d{6}         # sólo 10 caracteres numéricos
      [^\.][^\s]    # sin puntos ni espacios en blanco
      |             # disyunción no exclusiva
    */
    TELEFONO("((([1-9][0-9])\\d{5})[^a-zA-Z\\p{L}\\.\\s!#$%&/()?¡¿¨-])|" +
            "((([1-9][0-9])\\d{7})[^a-zA-Z\\p{L}\\.\\s!#$%&/()?¡¿¨-])");

    private String texto;

    ERegexValidadorInput(String texto) {
        this.setTexto(texto);
    }

    public String getTexto() { return this.texto; }

    public void setTexto(String texto) { this.texto = texto; }

}