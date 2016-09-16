package ar.edu.ub.pcsw.remisoft.modelo.reloj;

import javax.swing.*;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Timer;

public class CReloj {

    public JLabel time = new JLabel();
    private SimpleDateFormat sdf;
    private int currentSecond;
    private Calendar calendar;

    private void reset(){
        calendar = Calendar.getInstance();
        currentSecond = calendar.get(Calendar.SECOND);
    }

    public void start(){
        reset();
        Timer timer = new Timer();
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
        Calendar fecha = Calendar.getInstance();
        return fecha;
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
