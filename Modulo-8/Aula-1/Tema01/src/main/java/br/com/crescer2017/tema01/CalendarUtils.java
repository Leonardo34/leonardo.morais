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
        Calendar agora = Calendar.getInstance();
        Calendar data = Calendar.getInstance();
        data.setTime(date);
        int anos = agora.get(Calendar.YEAR) - data.get(Calendar.YEAR);
        int meses = agora.get(Calendar.MONTH) - data.get(Calendar.MONTH);
        int dias = agora.get(Calendar.DAY_OF_MONTH) - data.get(Calendar.DAY_OF_MONTH);
        if (dias < 0) {
            dias += 30;
            meses--;
        }
        if (meses < 0) {
            meses += 12;
            anos--;
        }
        return String.format("%d ano(s), %d mes(es) e %d dia(s)", anos, meses, dias);
    }
}
