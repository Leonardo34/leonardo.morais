

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest {
    
    @Test
    public void iniciarBatalhaComSaintDeMaiorCategoria() throws Exception {
        Saint jubileu = new Saint("Jubileu", new Armadura("Cisnei", Categoria.BRONZE));
        Saint irineu = new Saint("Irineu", new Armadura("Touro", Categoria.OURO));
        Batalha batalha = new Batalha(jubileu, irineu);
        batalha.iniciar();
        assertEquals(90.0, jubileu.getVida(), 0.0001);
        assertEquals(100, irineu.getVida(), 0.0001);
    }
    
    @Test
    public void categoriasIguaisIniciarComPrimeiroSaint() throws Exception {
        Saint jubileu = new Saint("Jubileu", new Armadura("Touro", Categoria.OURO));
        Saint irineu = new Saint("Irineu", new Armadura("Touro", Categoria.OURO));
        Batalha batalha = new Batalha(irineu, jubileu);
        batalha.iniciar();
        assertEquals(90.0, jubileu.getVida(), 0);
        assertEquals(100, irineu.getVida(), 0);
    }
}
