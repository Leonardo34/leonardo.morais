
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DadoDe06Test {
    
    @Test
    public void dadoDeSeisDeveRetornarValoresEntreUmESeis() {
        Sorteador sorteador = new DadoDe06();
        int i = sorteador.sortear();
        assertTrue(i >= 1 && i <= 6);
    }
}
