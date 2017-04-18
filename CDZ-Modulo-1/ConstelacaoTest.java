

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
    
    @Test 
    public void testarCorretoFuncionamentoAdicaoTresGolpes() {
        Constelacao constelacao = new Constelacao("Algum nome");
        Golpe[] golpes = new Golpe[3];
        golpes[0] = new Golpe("Kamehameha", 8001);
        golpes[1] = new Golpe("Rasengan", 5);
        golpes[2] = new Golpe("Raduken", 100);
        for (int i = 0; i < golpes.length; i++) {
            constelacao.adicionarGolpe(golpes[i]);
        }
        
        for (int i = 0; i < golpes.length; i++) {
            assertEquals(golpes[i], constelacao.getGolpes()[i]);
        }
        
        constelacao.adicionarGolpe(new Golpe("Espadada", 1));
        
        for (int i = 0; i < golpes.length; i++) {
            assertEquals(golpes[i], constelacao.getGolpes()[i]);
        }
    }
    
    @Test
    public void adicionarUmGolpeConstelacao() {
        Constelacao constelacao = new Constelacao("Algum nome");
        Golpe golpe = new Golpe("Kamehameha", 8001);
        constelacao.adicionarGolpe(golpe);
        assertEquals(golpe, constelacao.getGolpes()[0]);
        assertEquals(null, constelacao.getGolpes()[1]);
        assertEquals(null, constelacao.getGolpes()[2]);
    }
    
    @Test
    public void adicionarDoisGolpesConstelacao() {
        Constelacao constelacao = new Constelacao("Algum nome");
        Golpe goku = new Golpe("Kamehameha", 8001);
        Golpe naruto = new Golpe("Rasengan", 5);
        constelacao.adicionarGolpe(goku);
        constelacao.adicionarGolpe(naruto);
        assertEquals(goku, constelacao.getGolpes()[0]);
        assertEquals(naruto, constelacao.getGolpes()[1]);
        assertEquals(null, constelacao.getGolpes()[2]);
    }
    
    
}
