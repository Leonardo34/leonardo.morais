package br.com.crescer2017.tema01;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
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
    @Test
    public void testarParcelamentoPrestacoes() throws ParseException {
        Parcelator parcelator = new Parcelator();
        SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
        Map<String, BigDecimal> parcelas = parcelator.calcular(new BigDecimal(100), 5, 1.1, dataFormat.parse("30/06/2016"));
        assertEquals(110.00, parcelas.get("30/06/2016").doubleValue(), 0.01);
        assertEquals(110.00, parcelas.get("30/07/2016").doubleValue(), 0.01);
        assertEquals(110.00, parcelas.get("30/08/2016").doubleValue(), 0.01);
    }
}
