package br.com.crescer2017.tema01;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static java.util.Calendar.MONTH;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
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
public class ParcelatorTest {
    private static final Calendar CALENDAR = Calendar.getInstance();
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    private final Parcelator parcelator;

    public ParcelatorTest() {
        this.parcelator = new Parcelator();
    }
    
    @Test
    public void testarParcelamentoPrestacoes() throws ParseException {
        Parcelator parcelator = new Parcelator();
        SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
        Map<String, BigDecimal> parcelas = parcelator.calcular(new BigDecimal(100), 5, 1.1, dataFormat.parse("30/06/2016"));
        assertEquals(110.00, parcelas.get("30/06/2016").doubleValue(), 0.01);
        assertEquals(110.00, parcelas.get("30/07/2016").doubleValue(), 0.01);
        assertEquals(110.00, parcelas.get("30/08/2016").doubleValue(), 0.01);
    }
    
    @Test
    public void testCalcular() {
        CALENDAR.set(2017, 5, 18);
        
        final BigDecimal valor = BigDecimal.valueOf(1000l);
        final BigDecimal total = valor.multiply(BigDecimal.valueOf(10).divide(BigDecimal.valueOf(100)).add(BigDecimal.ONE)).setScale(2, RoundingMode.HALF_UP);

        final Map<String, BigDecimal> parcelas = parcelator.calcular(valor, 3, 1.1, CALENDAR.getTime());

        assertEquals(3, parcelas.size());
        
        parcelas.entrySet().forEach(e -> {
            assertEquals(DATE_FORMAT.format(CALENDAR.getTime()), e.getKey()); 
            CALENDAR.add(MONTH, 1);
        });
        assertEquals(total.multiply(new BigDecimal(3)).doubleValue(), parcelas.entrySet().stream()
                .map(Entry::getValue)
                .collect(Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)).doubleValue(), 0.01);
    }
}
