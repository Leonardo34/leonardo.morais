
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaSaintsTest {
    
    @Test
    public void buscarPorNomeNaoInseridoRetornaNull() {
        ListaSaints lista = new ListaSaints();
        assertEquals(null, lista.buscarPorNome("Zé"));
    }
}
