
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class ListaSaintsTest {
    
    @Test
    public void buscarPorNomeNaoInseridoRetornaNull() {
        ListaSaints lista = new ListaSaints();
        assertNull(lista.buscarPorNome("Zé"));
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
        assertNull(lista.buscarPorNome("Zé"));
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
        assertNull(lista.buscarPorNome("Zé"));
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
    
    @Test
    public void buscarPorSaintsVivosRetornaTodosSaintsVivos() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint shaka = new GoldSaint("Shaka", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint cafe = new GoldSaint("Cafe", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        lista.adicionar(shaka);
        lista.adicionar(cafe);
        List<Saint> listaSaintsVivos = lista.buscarPorStatus(Status.VIVO);
        assertEquals(listaSaintsVivos.get(0), shaka);
        assertEquals(listaSaintsVivos.get(1), cafe);
        shaka.perderVida(200);
        listaSaintsVivos = lista.buscarPorStatus(Status.VIVO);
        assertEquals(1, listaSaintsVivos.size());
        assertEquals(cafe, listaSaintsVivos.get(0));
        cafe.perderVida(100);
        listaSaintsVivos = lista.buscarPorStatus(Status.VIVO);
        assertEquals(true, listaSaintsVivos.isEmpty());
    }
    
    @Test
    public void garantirFuncionamentoMetodoGetSaintMaiorVida() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint shaka = new GoldSaint("Shaka", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint cafe = new GoldSaint("Cafe", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        assertNull(lista.getSaintMaiorVida());
        lista.adicionar(shaka);
        lista.adicionar(cafe);        
        assertEquals(shaka, lista.getSaintMaiorVida());
        shaka.perderVida(10);
        assertEquals(cafe, lista.getSaintMaiorVida());
        cafe.perderVida(5);
        assertEquals(cafe, lista.getSaintMaiorVida());
        cafe.perderVida(50);
        assertEquals(shaka, lista.getSaintMaiorVida());
        shaka.perderVida(90);
        assertEquals(cafe, lista.getSaintMaiorVida());
    }
    
    @Test
    public void garantirFuncionamentoMetodoGetSaintMenorVida() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint shaka = new GoldSaint("Shaka", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint cafe = new GoldSaint("Cafe", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        assertNull(lista.getSaintMenorVida());
        lista.adicionar(shaka);
        lista.adicionar(cafe);        
        assertEquals(shaka, lista.getSaintMenorVida());
        shaka.perderVida(10);
        assertEquals(shaka, lista.getSaintMenorVida());
        cafe.perderVida(5);
        assertEquals(shaka, lista.getSaintMenorVida());
        cafe.perderVida(50);
        assertEquals(cafe, lista.getSaintMenorVida());
        shaka.perderVida(90);
        assertEquals(shaka, lista.getSaintMenorVida());
    }
    
    @Test
    public void saintsDevemSerOrdenadosPorVida() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint shaka = new GoldSaint("Shaka", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint cafe = new GoldSaint("Cafe", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint cafezao = new GoldSaint("Cafezao", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        lista.adicionar(shaka);
        lista.adicionar(cafe); 
        lista.adicionar(cafezao);
        cafe.perderVida(50);
        lista.ordenar();
        List<Saint> listaOrdenadaVida = lista.todos();
        assertEquals(cafe, listaOrdenadaVida.get(0));
        assertEquals(shaka, listaOrdenadaVida.get(1));
        assertEquals(cafezao, listaOrdenadaVida.get(2));
        shaka.perderVida(20);
        cafezao.perderVida(100);
        lista.ordenar();
        listaOrdenadaVida = lista.todos();
        assertEquals(cafezao, listaOrdenadaVida.get(0));
        assertEquals(cafe, listaOrdenadaVida.get(1));
        assertEquals(shaka, listaOrdenadaVida.get(2));
    }
}
