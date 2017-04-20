
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
    public void saintsDevemSerOrdenadosPorVidaAscendente() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint shaka = new GoldSaint("Shaka", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint cafe = new GoldSaint("Cafe", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint cafezao = new GoldSaint("Cafezao", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        lista.adicionar(shaka);
        lista.adicionar(cafe); 
        lista.adicionar(cafezao);
        cafe.perderVida(50);
        lista.ordenar(TipoOrdenacao.ASCENDENTE);
        List<Saint> listaOrdenadaVida = lista.todos();
        assertEquals(cafe, listaOrdenadaVida.get(0));
        assertEquals(shaka, listaOrdenadaVida.get(1));
        assertEquals(cafezao, listaOrdenadaVida.get(2));
        shaka.perderVida(20);
        cafezao.perderVida(100);
        lista.ordenar(TipoOrdenacao.ASCENDENTE);
        listaOrdenadaVida = lista.todos();
        assertEquals(cafezao, listaOrdenadaVida.get(0));
        assertEquals(cafe, listaOrdenadaVida.get(1));
        assertEquals(shaka, listaOrdenadaVida.get(2));
    }
    
    @Test
    public void saintsDevemSerOrdenadosPorVidaDescendente() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint shaka = new GoldSaint("Shaka", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint cafe = new GoldSaint("Cafe", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint cafezao = new GoldSaint("Cafezao", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        lista.adicionar(shaka);
        lista.adicionar(cafe); 
        lista.adicionar(cafezao);
        cafe.perderVida(50);
        lista.ordenar(TipoOrdenacao.DESCENDENTE);
        List<Saint> listaOrdenadaVida = lista.todos();
        assertEquals(shaka, listaOrdenadaVida.get(0));
        assertEquals(cafezao, listaOrdenadaVida.get(1));
        assertEquals(cafe, listaOrdenadaVida.get(2));
        shaka.perderVida(20);
        cafezao.perderVida(100);
        lista.ordenar(TipoOrdenacao.DESCENDENTE);
        listaOrdenadaVida = lista.todos();
        assertEquals(shaka, listaOrdenadaVida.get(0));
        assertEquals(cafe, listaOrdenadaVida.get(1));
        assertEquals(cafezao, listaOrdenadaVida.get(2));
    }
    
    @Test
    public void ordenarListaCompletamenteDesordenada() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint shaka = new GoldSaint("Shaka", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint cafe = new GoldSaint("Cafe", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint cafezao = new GoldSaint("Cafezao", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        lista.adicionar(shaka);
        lista.adicionar(cafe); 
        lista.adicionar(cafezao);
        shaka.perderVida(30);
        cafe.perderVida(20);
        cafezao.perderVida(10);
        lista.ordenar(TipoOrdenacao.DESCENDENTE);
        List<Saint> listaOrdenadaDesc = lista.todos();
        assertEquals(cafezao, listaOrdenadaDesc.get(0));
        assertEquals(cafe, listaOrdenadaDesc.get(1));
        assertEquals(shaka, listaOrdenadaDesc.get(2));
        lista.ordenar(TipoOrdenacao.ASCENDENTE);
        assertEquals(shaka, listaOrdenadaDesc.get(0));
        assertEquals(cafe, listaOrdenadaDesc.get(1));
        assertEquals(cafezao, listaOrdenadaDesc.get(2));
    }
    
    @Test
    public void unirListaDeSaintsDiferentes() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint shaka = new GoldSaint("Shaka", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint cafe = new GoldSaint("Cafe", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint cafezao = new GoldSaint("Cafezao", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        lista.adicionar(shaka);
        lista.adicionar(cafe); 
        lista.adicionar(cafezao);
        ListaSaints listaDois = new ListaSaints();
        Saint mestre = new GoldSaint("Mestre Dos Magos", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint naruto = new GoldSaint("Naruto", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint goku = new GoldSaint("Goku", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        listaDois.adicionar(mestre);
        listaDois.adicionar(naruto); 
        listaDois.adicionar(goku);
        List<Saint> uniao = lista.unir(listaDois).todos();
        assertEquals(shaka, uniao.get(0));
        assertEquals(cafe, uniao.get(1));
        assertEquals(cafezao, uniao.get(2));
        assertEquals(mestre, uniao.get(3));
        assertEquals(naruto, uniao.get(4));
        assertEquals(goku, uniao.get(5));
    }
    
    @Test
    public void unirListaSaintsIguais() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint shaka = new GoldSaint("Shaka", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        lista.adicionar(shaka);
        ListaSaints listaDois = new ListaSaints();
        listaDois.adicionar(shaka);
        List<Saint> uniao = lista.unir(listaDois).todos();
        assertEquals(shaka, uniao.get(0));
        assertEquals(1, uniao.size());
    }
    
    @Test
    public void diffDeListaSaintsIguaisDeveSerVazia() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint shaka = new GoldSaint("Shaka", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        lista.adicionar(shaka);
        ListaSaints listaDois = new ListaSaints();
        listaDois.adicionar(shaka);
        List<Saint> diff = lista.diff(listaDois).todos();
        assertEquals(true, diff.isEmpty());
    }
    
    @Test
    public void diffDeListaSaintsDiferentes() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint shaka = new GoldSaint("Shaka", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint cafe = new GoldSaint("Cafe", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint cafezao = new GoldSaint("Cafezao", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        lista.adicionar(shaka);
        lista.adicionar(cafe); 
        lista.adicionar(cafezao);
        ListaSaints listaDois = new ListaSaints();
        Saint mestre = new GoldSaint("Mestre Dos Magos", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint naruto = new GoldSaint("Naruto", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint goku = new GoldSaint("Goku", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        listaDois.adicionar(mestre);
        listaDois.adicionar(naruto); 
        listaDois.adicionar(goku);
        listaDois.adicionar(shaka);
        List<Saint> diff = lista.diff(listaDois).todos();
        assertEquals(cafe, diff.get(0));
        assertEquals(cafezao, diff.get(1));
        assertEquals(2, diff.size());
    }
    
    @Test
    public void intersecaoDeListaDiferentesDeveSerVazia() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint shaka = new GoldSaint("Shaka", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint cafe = new GoldSaint("Cafe", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint cafezao = new GoldSaint("Cafezao", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        lista.adicionar(shaka);
        lista.adicionar(cafe); 
        lista.adicionar(cafezao);
        ListaSaints listaDois = new ListaSaints();
        Saint mestre = new GoldSaint("Mestre Dos Magos", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint naruto = new GoldSaint("Naruto", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint goku = new GoldSaint("Goku", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        listaDois.adicionar(mestre);
        listaDois.adicionar(naruto); 
        listaDois.adicionar(goku);
        List<Saint> intersecao = lista.intersec(listaDois).todos();
        assertEquals(true, intersecao.isEmpty());
    }
    
    @Test
    public void intersecaoDeListasIguaisDeveSerIgualAListaOriginal() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint shaka = new GoldSaint("Shaka", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint cafe = new GoldSaint("Cafe", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint cafezao = new GoldSaint("Cafezao", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        lista.adicionar(shaka);
        lista.adicionar(cafe); 
        lista.adicionar(cafezao);
        ListaSaints listaDois = new ListaSaints();
        listaDois.adicionar(shaka);
        listaDois.adicionar(cafe); 
        listaDois.adicionar(cafezao);
        assertEquals(lista.intersec(listaDois).todos(), lista.todos());
    }
    
    @Test
    public void garantirCorretaFormatacaoCSV() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        june.setGenero(Genero.FEMININO);
        june.perderVida(15.5);
        lista.adicionar(june);

        Saint dohko = new Saint("Dohko", new Armadura(new Constelacao("Dragao"), Categoria.OURO));
        dohko.perderVida(90);
        dohko.vestirArmadura();
        lista.adicionar(dohko);

        String csv = lista.getCSV();
        System.out.println(csv);
        assertEquals("June, 84.5, Camaleão, BRONZE, VIVO, FEMININO, false\nDohko, 10.0, Dragao, OURO, VIVO, NAO_INFORMADO, true\n", csv);
    }
}
