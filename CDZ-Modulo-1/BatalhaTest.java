

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest {
    
    @Test
    public void iniciarBatalhaComSaintDeMaiorCategoria() {
        Saint jubileu = new Saint("Jubileu", new Armadura("Cisnei", Categoria.BRONZE));
        Saint irineu = new Saint("Irineu", new Armadura("Virgem", Categoria.OURO));
        Batalha batalha = new Batalha(jubileu, irineu);
        batalha.iniciar();
        assertEquals(90.0, jubileu.getLife(), 0.0001);
    }
}
