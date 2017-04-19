
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

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
    
    @Test
    public void saintsComNomesIguaisRetornarPrimeiroInserido() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint saint = new GoldSaint("Shaka", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint saintDois = new GoldSaint("Shaka", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint shuka = new GoldSaint("Shuka", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        lista.adicionar(saint);
        lista.adicionar(saintDois);
        lista.adicionar(shuka);
        assertEquals(saint, lista.buscarPorNome("Shaka"));
        assertEquals(shuka, lista.buscarPorNome("Shuka"));
        assertEquals(null, lista.buscarPorNome("Zé"));
        assertEquals(saint, lista.buscarPorNome("Shaka"));
    }
    
    @Test
    public void buscarSaintPorCategoriaSemNenhumMembroListaVazia() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint saint = new GoldSaint("Shaka", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint saintDois = new GoldSaint("Shaka", new Armadura(new Constelacao("Touro"), Categoria.PRATA));
        lista.adicionar(saint);
        lista.adicionar(saintDois);
        assertEquals(true, lista.buscarPorCategoria(Categoria.BRONZE).isEmpty());
    }
    
    @Test
    public void adicionarDoisSaintsOuroBuscarPorOuro() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint saintOuroUm = new GoldSaint("Shaka", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint saintPrata = new GoldSaint("Shaka", new Armadura(new Constelacao("Touro"), Categoria.PRATA));
        Saint saintOuroDois = new GoldSaint("Shaka", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint saintBronze = new GoldSaint("Shaka", new Armadura(new Constelacao("Touro"), Categoria.BRONZE));
        lista.adicionar(saintOuroUm);
        lista.adicionar(saintPrata);
        lista.adicionar(saintBronze);
        lista.adicionar(saintOuroDois);
        List<Saint> listaSaintsOuro = lista.buscarPorCategoria(Categoria.OURO);
        assertEquals(saintOuroUm, listaSaintsOuro.get(0));
        assertEquals(saintOuroDois, listaSaintsOuro.get(1));
    }
}
