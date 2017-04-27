
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AtaqueDuploTest {
    
    @Test
    public void ataqueDuploComSucessoDeveCausarDobroDano() throws Exception {
        Saint saint = new GoldSaint("Goku", "Touro");
        saint.aprenderGolpe(new Golpe("Kamehameha", 10));
        Saint saintApanha = new BronzeSaint("Seiya", "Pegasus");
        Movimento movimento = new AtaqueDuplo(saint, saintApanha, new Sorteador() {
            @Override
            public int sortear() {
                return 6;
            }
        });
        movimento.executar();
        assertEquals(100, saint.getVida(), 0);
        assertEquals(80, saintApanha.getVida(), 0);
        movimento.executar();
        assertEquals(60, saintApanha.getVida(), 0);
        assertEquals(100, saint.getVida(), 0);
    }
    
    @Test
    public void ataqueDuploComFalhaGeraAtaqueNormalEDescontoDeCincoPorcento() throws Exception {
        Saint saint = new GoldSaint("Goku", "Touro");
        saint.aprenderGolpe(new Golpe("Kamehameha", 10));
        Saint saintApanha = new BronzeSaint("Seiya", "Pegasus");
        Movimento movimento = new AtaqueDuplo(saint, saintApanha, new Sorteador() {
            @Override
            public int sortear() {
                return 5;
            }
        });
        movimento.executar();
        assertEquals(95, saint.getVida(), 0);
        assertEquals(90, saintApanha.getVida(), 0);
        movimento.executar();
        assertEquals(80, saintApanha.getVida(), 0);
        assertEquals(90.25, saint.getVida(), 0);
    }
}
