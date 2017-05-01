
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercitoQueAtacaEmOrdemAlternadaTest {
    
    @Test(expected = ExercitoVazioException.class)
    public void proximoSaintDeExercitoVazioGeraException() throws ExercitoVazioException {
        ExercitoDeSaints exercito = new ExercitoQueAtacaEmOrdemAlternada();
        exercito.getProximoSaint();
    }
    
    @Test
    public void alistarTresSaintsCategoriasDiferentesDeveRetornarAlternadamente() throws Exception {
        Saint bronze = new BronzeSaint("Seiya", "Pegasus");
        Saint prata = new SilverSaint("Naruto", "Libra");
        Saint ouro = new GoldSaint("Goku", "Touro");
        ExercitoDeSaints exercito = new ExercitoQueAtacaEmOrdemAlternada();
        exercito.alistar(ouro);
        exercito.alistar(prata);
        exercito.alistar(bronze);
        assertEquals(bronze, exercito.getProximoSaint());
        assertEquals(prata, exercito.getProximoSaint());
        assertEquals(ouro, exercito.getProximoSaint());
        assertTrue(exercito.estaVazio());
    }
    
    @Test
    public void adicionarDiversosSaintsEmOrdemAleatoriaAoExercito() throws Exception {
        Saint bronze = new BronzeSaint("Seiya", "Pegasus");
        Saint prata = new SilverSaint("Naruto", "Libra");
        Saint ouro = new GoldSaint("Goku", "Touro");
        Saint bronze2 = new BronzeSaint("Sasuke", "Pegasus");
        Saint prata2 = new SilverSaint("Jiraya", "Libra");
        Saint ouro2 = new GoldSaint("Goham", "Touro");
        ExercitoDeSaints exercito = new ExercitoQueAtacaEmOrdemAlternada();
        exercito.alistar(prata);
        exercito.alistar(ouro);
        exercito.alistar(bronze);
        exercito.alistar(ouro2);
        exercito.alistar(prata2);
        exercito.alistar(bronze2);
        assertEquals(bronze, exercito.getProximoSaint());
        assertEquals(prata, exercito.getProximoSaint());
        assertEquals(ouro, exercito.getProximoSaint());
        assertEquals(bronze2, exercito.getProximoSaint());
        assertEquals(prata2, exercito.getProximoSaint());
        assertEquals(ouro2, exercito.getProximoSaint());
        assertTrue(exercito.estaVazio());
    }
    
    @Test
    public void adicionarApenasUmGoldSaintRetornaEleMesmo() throws Exception {
        Saint ouro = new GoldSaint("Goku", "Touro");
        ExercitoDeSaints exercito = new ExercitoQueAtacaEmOrdemAlternada();
        exercito.alistar(ouro);
        assertEquals(ouro, exercito.getProximoSaint());
        assertTrue(exercito.estaVazio());
    }
    
    public void adicionarSilverEGoldSaintRetornaPrataDepoisOuro() throws Exception {
        Saint ouro = new GoldSaint("Goku", "Touro");
        Saint prata = new SilverSaint("Jiraya", "Libra");
        ExercitoDeSaints exercito = new ExercitoQueAtacaEmOrdemAlternada();
        exercito.alistar(ouro);
        exercito.alistar(prata);
        assertEquals(prata, exercito.getProximoSaint());
        assertEquals(ouro, exercito.getProximoSaint());
        assertTrue(exercito.estaVazio());
    }
}
