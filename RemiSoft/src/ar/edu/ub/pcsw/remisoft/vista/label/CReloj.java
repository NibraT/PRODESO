package ar.edu.ub.pcsw.remisoft.vista.label;

import javax.swing.*;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Timer;

public class CReloj {

    public JLabel time = new JLabel();
    private int currentSecond;

    public void start(){
        reset();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask(){
            public void run(){
                if(currentSecond == 60) {
                    reset();
                }
                time.setText(getFechaYHora());
                currentSecond++;
            }
        }, 0, 1000 );
    }

    private void reset(){
        currentSecond = Calendar.getInstance().get(Calendar.SECOND);
    }

    private String getFechaYHora() {
        DateFormatSymbols simbolos = new DateFormatSymbols(new Locale("es", "ES"));
        String[] diasEnMayuscula = {"", "Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
        simbolos.setShortWeekdays(diasEnMayuscula);
        SimpleDateFormat sdf = new SimpleDateFormat("E d/MM/yyyy - hh:mm:ssa", simbolos);
        return sdf.format(Calendar.getInstance().getTime());
    }

}


