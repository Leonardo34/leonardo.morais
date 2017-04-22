

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GolpearTest {
    
    @Test
    public void golpearComGoldSaintSemArmadura() throws Exception {
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
    public void golpearComGoldSaintComArmaduraVestida() throws Exception {
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
    
    @Test
    public void golpearComSaintSemGolpes() throws Exception {
        Saint saint = new GoldSaint("Goku", "Touro");
        Saint saintApanha = new BronzeSaint("Seiya", "Pegasus");
        Movimento movimento = new Golpear(saint, saintApanha);
        movimento.executar();
        assertEquals(100, saintApanha.getVida(), 0);
    }
    
    @Test
    public void golpearComSaintPrataSemArmadura() {
        Saint saint = new SilverSaint("Goku", "Touro");
        saint.aprenderGolpe(new Golpe("Kamehameha", 20));
        Saint saintApanha = new BronzeSaint("Seiya", "Pegasus");
        Movimento movimento = new Golpear(saint, saintApanha);
        movimento.executar();
        assertEquals(80, saintApanha.getVida(), 0);
        movimento.executar();
        assertEquals(60, saintApanha.getVida(), 0);
        saint.aprenderGolpe(new Golpe("Soco", 5));
        movimento.executar();
        assertEquals(55, saintApanha.getVida(), 0);
    }
    
    @Test
    public void golpearComSaintPrataComArmadura() {
        Saint saint = new SilverSaint("Goku", "Touro");
        saint.aprenderGolpe(new Golpe("Kamehameha", 20));
        Saint saintApanha = new BronzeSaint("Seiya", "Pegasus");
        Movimento movimento = new Golpear(saint, saintApanha);
        Movimento vestirArmadura = new VestirArmadura(saint);
        movimento.executar();
        assertEquals(80, saintApanha.getVida(), 0);
        vestirArmadura.executar();
        movimento.executar();
        assertEquals(20, saintApanha.getVida(), 0);
        saint.aprenderGolpe(new Golpe("Rasteira", 5));
        movimento.executar();
        assertEquals(5, saintApanha.getVida(), 0);
        movimento.executar();
        assertEquals(Status.MORTO, saintApanha.getStatus());
    }
    
    @Test
    public void golpearComSaintBronzeSemArmadura() {
        Saint saint = new BronzeSaint("Goku", "Touro");
        saint.aprenderGolpe(new Golpe("Kamehameha", 20));
        saint.aprenderGolpe(new Golpe("Chute", 5));
        saint.aprenderGolpe(new Golpe("Soco", 5));
        Saint saintApanha = new BronzeSaint("Seiya", "Pegasus");
        Movimento movimento = new Golpear(saint, saintApanha);
        movimento.executar();
        assertEquals(80, saintApanha.getVida(), 0);
        movimento.executar();
        assertEquals(75, saintApanha.getVida(), 0);
        movimento.executar();
        assertEquals(70, saintApanha.getVida(), 0);
        movimento.executar();
        assertEquals(50, saintApanha.getVida(), 0);
        saint.aprenderGolpe(new Golpe("Chidori", 10));
        movimento.executar();
        assertEquals(45, saintApanha.getVida(), 0);
        movimento.executar();
        assertEquals(40, saintApanha.getVida(), 0);
        movimento.executar();
        assertEquals(30, saintApanha.getVida(), 0);
        movimento.executar();
        assertEquals(10, saintApanha.getVida(), 0);
        movimento.executar();
    }
    
    @Test
    public void golpearComSaintBronzeComArmadura() {
        Saint saint = new BronzeSaint("Goku", "Touro");
        saint.aprenderGolpe(new Golpe("Kamehameha", 20));
        saint.aprenderGolpe(new Golpe("Chute", 5));
        saint.aprenderGolpe(new Golpe("Soco", 5));
        Saint saintApanha = new BronzeSaint("Seiya", "Pegasus");
        Movimento movimento = new Golpear(saint, saintApanha);
        movimento.executar();
        assertEquals(80, saintApanha.getVida(), 0);
        Movimento vestirArmadura = new VestirArmadura(saint);
        vestirArmadura.executar();
        movimento.executar();
        assertEquals(70, saintApanha.getVida(), 0);
        movimento.executar();
        assertEquals(60, saintApanha.getVida(), 0);
        movimento.executar();
        assertEquals(20, saintApanha.getVida(), 0);
    }
}
