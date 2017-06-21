package br.com.crescer2017.tema01;

import java.util.Calendar;
import java.util.Date;

public class CalendarUtils implements ICalendarUtils {
    @Override
    public DiaSemana diaSemana(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        return DiaSemana.values()[day - 1];       
    }
    
    @Override
    public String tempoDecorrido(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return null;
    }
}
