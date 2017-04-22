

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GolpearTest {
    
    @Test
    public void GolpearComGoldSaintSemArmadura() throws Exception {
        Saint saint = new GoldSaint("Goku", "Touro");
        saint.aprenderGolpe(new Golpe("Kamehameha", 10));
        Saint saintApanha = new BronzeSaint("Seiya", "Pegasus");
        Movimento movimento = new Golpear(saint, saintApanha);
        movimento.executar();
        assertEquals(90, saintApanha.getVida(), 0);
        movimento.executar();
        assertEquals(80, saintApanha.getVida(), 0);
    }
    
    @Test
    public void GolpearComGoldSaintComArmaduraVestida() throws Exception {
        Saint saint = new GoldSaint("Goku", "Touro");
        saint.aprenderGolpe(new Golpe("Kamehameha", 10));
        Saint saintApanha = new BronzeSaint("Seiya", "Pegasus");
        Movimento movimento = new Golpear(saint, saintApanha);
        Movimento vestirArmadura = new VestirArmadura(saint);
        movimento.executar();
        assertEquals(90, saintApanha.getVida(), 0);
        vestirArmadura.executar();
        saint.aprenderGolpe(new Golpe("Chute", 2));
        movimento.executar();
        assertEquals(82, saintApanha.getVida(), 0);
        movimento.executar();
        assertEquals(42, saintApanha.getVida(), 0);
    }
}
