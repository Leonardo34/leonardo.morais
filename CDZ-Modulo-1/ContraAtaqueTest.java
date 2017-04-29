

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
    
    @Test
    public void contraAtaqueComArmaduraVestidaNaoAcontece() {
        Saint golpeado = new BronzeSaint("Seiya", "Pegasus");
        Saint golpeador = new SilverSaint("Naruto", "Konoha");
        Movimento contraAtaque = new ContraAtaque(golpeador, golpeado, new Sorteador() {
            @Override
            public int sortear() {
                return 1;
            }
        });
        golpeado.perderVida(70);
        golpeado.vestirArmadura();
        contraAtaque.executar();
        golpeado.perderVida(10, golpeador);
        assertEquals(20, golpeado.getVida(), 0);
        assertEquals(100, golpeador.getVida(), 0);
    }
    
    @Test
    public void contraAtacarSomenteFuncionaComVidaMenor50EArmaduraNaoVestida() {
        Saint golpeado = new BronzeSaint("Seiya", "Pegasus");
        Saint golpeador = new SilverSaint("Naruto", "Konoha");
        Movimento contraAtaque = new ContraAtaque(golpeador, golpeado, new Sorteador() {
            @Override
            public int sortear() {
                return 1;
            }
        });
        contraAtaque.executar();
        golpeado.perderVida(60);
        assertEquals(40, golpeado.getVida(), 0);
        assertEquals(100, golpeador.getVida(), 0);
        contraAtaque.executar();
        golpeado.perderVida(10, golpeador);
        assertEquals(40, golpeado.getVida(), 0);
        assertEquals(75, golpeador.getVida(), 0);
        golpeado.vestirArmadura();
        contraAtaque.executar();
        golpeado.perderVida(10, golpeador);
        assertEquals(30, golpeado.getVida(), 0);
        assertEquals(75, golpeador.getVida(), 0);
    }
}
