
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
    
    @Test
    public void buscarPorNomeSaintInseridoRetornaSaint() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint saint = new GoldSaint("Shaka", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint shuka = new GoldSaint("Shuka", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        lista.adicionar(saint);
        lista.adicionar(shuka);
        assertEquals(saint, lista.buscarPorNome("Shaka"));
        assertEquals(shuka, lista.buscarPorNome("Shuka"));
        assertEquals(null, lista.buscarPorNome("Zé"));
    }
}
