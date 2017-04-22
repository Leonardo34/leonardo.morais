

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GolpeTest {
    
    @Test
    public void testarConstrucaoObjetoGolpe() {
        Golpe golpe = new Golpe("kamehameha", 8001);
        assertEquals("kamehameha", golpe.getNome());
        assertEquals(8001, golpe.getFatorDano(), 0);
    }
}
