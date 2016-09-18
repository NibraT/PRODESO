package ar.edu.ub.pcsw.remisoft.vista.label;

import javax.swing.*;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Timer;

public class CReloj {

    public JLabel time = new JLabel();
    private int currentSecond;

    private void reset(){
        currentSecond = getFecha().get(Calendar.SECOND);
    }

    public void start(){
        reset();
        Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate( new TimerTask(){
            public void run(){
                if(currentSecond == 60) {
                    reset();
                }
                time.setText(mostrarFechaYHora());
                currentSecond++;
            }
        }, 0, 1000 );
    }

    private Calendar getFecha() {
        return Calendar.getInstance();
    }

    private String mostrarFechaYHora() {
        Date fecha = getFecha().getTime();
        DateFormatSymbols simbolos = new DateFormatSymbols(new Locale("es", "ES"));
        String[] diasEnMayuscula = {"", "Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
        simbolos.setShortWeekdays(diasEnMayuscula);
        SimpleDateFormat sdf = new SimpleDateFormat("E d/MM/yyyy - hh:mm:ssa", simbolos);
        return sdf.format(fecha);
    }

}


