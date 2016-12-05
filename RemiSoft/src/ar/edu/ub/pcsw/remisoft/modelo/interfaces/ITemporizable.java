package ar.edu.ub.pcsw.remisoft.modelo.interfaces;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public interface ITemporizable {

    default String setFechaYHora() {
        DateFormatSymbols simbolos = new DateFormatSymbols(new Locale("es", "ES"));
        String[] diasEnMayuscula = {"", "Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
        simbolos.setShortWeekdays(diasEnMayuscula);
        SimpleDateFormat sdf = new SimpleDateFormat("E d/MM/yyyy - hh:mm:ssa", simbolos);
        return sdf.format(Calendar.getInstance().getTime());
    }

    default String setFechaString(Calendar fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(fecha.getTime());
    }

    default String setFechaString() {
        SimpleDateFormat sdf = new SimpleDateFormat("d/MM/yyyy");
        return sdf.format(Calendar.getInstance().getTime());
    }

    default String setHoraString(Calendar fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(fecha.getTime());
    }

}