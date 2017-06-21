package br.com.crescer2017.tema01;

import br.com.crescer2017.tema01.ICalendarUtils.DiaSemana;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Leonardo
 */
public class CalendarUtilsTest {
    @Test
    public void testarDiaSemana() throws ParseException {
        CalendarUtils utils = new CalendarUtils();
        SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
        DiaSemana dia = utils.diaSemana(dataFormat.parse("21/06/2017"));
        assertEquals(DiaSemana.QUARTA_FEIRA, dia);
    }
    
    @Test
    public void testarDiaSemanaUmAnoAtras() throws ParseException {
        CalendarUtils utils = new CalendarUtils();
        SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
        DiaSemana dia = utils.diaSemana(dataFormat.parse("21/06/2016"));
        assertEquals(DiaSemana.TERCA_FEIRA, dia);
    }
}
