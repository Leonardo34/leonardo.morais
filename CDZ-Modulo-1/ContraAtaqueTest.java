

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ContraAtaqueTest {
    
    @Test
    public void executarMovimentoContraAtaqueBloqueiaProximoGolpe() {
        Saint golpeado = new BronzeSaint("Seiya", "Pegasus");
        Saint golpeador = new SilverSaint("Naruto", "Konoha");
        Movimento contraAtaque = new ContraAtaque(golpeador, golpeado, new Sorteador() {
            @Override
            public int sortear() {
                return 1;
            }
        });
        contraAtaque.executar();
        golpeado.perderVida(60, golpeador);
        assertEquals(40, golpeado.getVida(), 0);
        contraAtaque.executar();
        golpeado.perderVida(60, golpeador);
        assertEquals(40, golpeado.getVida(), 0);
        assertEquals(75, golpeador.getVida(), 0);
    }
}
