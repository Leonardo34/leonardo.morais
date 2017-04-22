import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest {
    
    @Test
    public void iniciarBatalhaComSaintDeMaiorCategoria() throws Exception {
        Saint jubileu = new BronzeSaint("Jubileu", "Cisnei");
        Saint irineu = new GoldSaint("Irineu", "Touro");
        Batalha batalha = new Batalha(jubileu, irineu);
        batalha.iniciar();
        assertEquals(90.0, jubileu.getVida(), 0.0001);
        assertEquals(100, irineu.getVida(), 0.0001);
    }
    
    @Test
    public void categoriasIguaisIniciarComPrimeiroSaint() throws Exception {
        Saint jubileu = new GoldSaint("Jubileu", "Touro");
        Saint irineu = new GoldSaint("Irineu", "Touro");
        Batalha batalha = new Batalha(irineu, jubileu);
        batalha.iniciar();
        assertEquals(90.0, jubileu.getVida(), 0);
        assertEquals(100, irineu.getVida(), 0);
    }
}
