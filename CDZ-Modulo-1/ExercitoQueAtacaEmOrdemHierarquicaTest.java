
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercitoQueAtacaEmOrdemHierarquicaTest {
    
    @Test
    public void alistarTresSaintsCategoriasDiferentesDeveRetornarMaisFracosAntes() throws Exception {
        Saint bronze = new BronzeSaint("Seiya", "Pegasus");
        Saint prata = new SilverSaint("Naruto", "Libra");
        Saint ouro = new GoldSaint("Goku", "Touro");
        ExercitoDeSaints exercito = new ExercitoQueAtacaEmOrdemHierarquica();
        exercito.alistar(bronze);
        exercito.alistar(prata);
        exercito.alistar(ouro);
        assertEquals(bronze, exercito.getProximoSaint());
        assertEquals(prata, exercito.getProximoSaint());
        assertEquals(ouro, exercito.getProximoSaint());
        assertTrue(exercito.estaVazio());
    }
    
    @Test(expected = ExercitoVazioException.class)
    public void proximoSaintDeExercitoVazioGeraException() throws ExercitoVazioException {
        ExercitoDeSaints exercito = new ExercitoQueAtacaEmOrdemHierarquica();
        exercito.getProximoSaint();
    }
    
    @Test
    public void adicionarDiversosSaintsEmOrdemAleatoriaAoExercito() throws Exception {
        Saint bronze = new BronzeSaint("Seiya", "Pegasus");
        Saint prata = new SilverSaint("Naruto", "Libra");
        Saint ouro = new GoldSaint("Goku", "Touro");
        Saint bronze2 = new BronzeSaint("Sasuke", "Pegasus");
        Saint prata2 = new SilverSaint("Jiraya", "Libra");
        Saint ouro2 = new GoldSaint("Goham", "Touro");
        ExercitoDeSaints exercito = new ExercitoQueAtacaEmOrdemHierarquica();
        exercito.alistar(prata);
        exercito.alistar(ouro);
        exercito.alistar(bronze);
        exercito.alistar(ouro2);
        exercito.alistar(prata2);
        exercito.alistar(bronze2);
        assertEquals(bronze, exercito.getProximoSaint());
        assertEquals(bronze2, exercito.getProximoSaint());
        assertEquals(prata, exercito.getProximoSaint());
        assertEquals(prata2, exercito.getProximoSaint());
        assertEquals(ouro, exercito.getProximoSaint());
        assertEquals(ouro2, exercito.getProximoSaint());
        assertTrue(exercito.estaVazio());
    }
}
