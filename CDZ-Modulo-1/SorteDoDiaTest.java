

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SorteDoDiaTest {
    
    @Test
    public void estouComSorteDeveTer50PorCentoDeSortes() {
        SorteDoDia sorteDoDia = new SorteDoDia(new DadoDe06());
        final int NUM_ITERACOES = 0xFFFFFF;
        int totalSortes = 0;
        for (int i = 0; i < NUM_ITERACOES; i++) {
            if (sorteDoDia.estaComSorte()) {
                totalSortes++;
            }
        }
        System.out.println(totalSortes + " " + (NUM_ITERACOES - totalSortes));
        double porcentagemSortes = (totalSortes * 100) / NUM_ITERACOES;
        assertEquals(50, porcentagemSortes, 2);
    }
}
