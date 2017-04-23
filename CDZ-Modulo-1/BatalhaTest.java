import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest {
    
    @Test
    public void batalharAteAMorteComSaintsSemArmadura() throws Exception {
        Saint saintUm = new GoldSaint("Shaka", "Touro");
        Saint saintDois = new BronzeSaint("Seiya", "Pegasus");
        saintUm.aprenderGolpe(new Golpe("Chute", 5));
        saintUm.aprenderGolpe(new Golpe("MegaSoco", 20));
        saintDois.aprenderGolpe(new Golpe("Chidori", 50));
        saintUm.adicionarMovimento(new Golpear(saintUm, saintDois));
        saintDois.adicionarMovimento(new Golpear(saintDois, saintUm));
        Batalha batalha = new Batalha(saintDois, saintUm);
        batalha.iniciar();
        assertEquals(75, saintDois.getVida(), 0);
        assertEquals(0, saintUm.getVida(), 0);
        assertEquals(Status.VIVO, saintDois.getStatus());
        assertEquals(Status.MORTO, saintUm.getStatus());
    }
    
    @Test(expected=Exception.class)
    public void batalharComSaintSemMovimentoGeraException() throws Exception {
        Saint saintUm = new GoldSaint("Shaka", "Touro");
        Saint saintDois = new BronzeSaint("Seiya", "Pegasus");
        saintUm.aprenderGolpe(new Golpe("Chute", 5));
        saintUm.aprenderGolpe(new Golpe("MegaSoco", 20));
        saintDois.aprenderGolpe(new Golpe("Chidori", 50));
        saintUm.adicionarMovimento(new Golpear(saintUm, saintDois));
        Batalha batalha = new Batalha(saintDois, saintUm);
        batalha.iniciar();
    }
    
    @Test
    public void batalharAteAMorteComSaintsDeArmadura() throws Exception {
        Saint saintUm = new GoldSaint("Shaka", "Touro");
        Saint saintDois = new GoldSaint("Sasuke", "Áries");
        saintUm.aprenderGolpe(new Golpe("Chute", 5));
        saintUm.aprenderGolpe(new Golpe("MegaSoco", 7));
        saintDois.aprenderGolpe(new Golpe("Chidori", 10));
        saintUm.adicionarMovimento(new Golpear(saintUm, saintDois));
        saintDois.adicionarMovimento(new Golpear(saintDois, saintUm));
        saintUm.vestirArmadura();
        saintDois.vestirArmadura();
        Batalha batalha = new Batalha(saintDois, saintUm);
        batalha.iniciar();
        assertEquals(52, saintDois.getVida(), 0);
        assertEquals(-20, saintUm.getVida(), 0);
        assertEquals(Status.VIVO, saintDois.getStatus());
        assertEquals(Status.MORTO, saintUm.getStatus());
    }
}
