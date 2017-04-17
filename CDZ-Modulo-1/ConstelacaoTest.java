

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConstelacaoTest {
    
    @Test
    public void testarCorretaInstanciacaoObjetoConstelacao() {
        Constelacao constelacao = new Constelacao("Algum nome");
        assertEquals("Algum nome", constelacao.getNome());
        Golpe[] golpes = constelacao.getGolpes();
        for (int i = 0; i < golpes.length; i++) {
            assertEquals(null, golpes[i]);
        }
    }
}
