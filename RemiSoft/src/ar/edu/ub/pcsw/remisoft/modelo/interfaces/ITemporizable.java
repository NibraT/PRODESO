package ar.edu.ub.pcsw.remisoft.modelo.interfaces;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public interface ITemporizable {

    public Calendar calcularTiempo();

    public default String setFechaYHora() {
        DateFormatSymbols simbolos = new DateFormatSymbols(new Locale("es", "ES"));
        String[] diasEnMayuscula = {"", "Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
        simbolos.setShortWeekdays(diasEnMayuscula);
        SimpleDateFormat sdf = new SimpleDateFormat("E d/MM/yyyy - hh:mm:ssa", simbolos);
        return sdf.format(Calendar.getInstance().getTime());
    }

}
