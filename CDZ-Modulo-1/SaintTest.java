
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.security.InvalidParameterException;

public class SaintTest {
    
    @Test
    public void vestirArmaduraDeixaArmaduraVestida() throws Exception {
        // AAA
        // 1. Arrange - Montagem do cenario de teste 
        Saint jubileu = new GoldSaint("Jubileu", "Touro");
        
        // 2. Action - Invocar a ação a ser testada       
        jubileu.vestirArmadura();
        
        // 3. Assert - verificação dos resultados do teste
        assertEquals(true, jubileu.isArmaduraVestida());
    }
    
    @Test
    public void vestirArmaduraDeixaArmaduraNaoVestida() throws Exception {
        Saint jubileu = new BronzeSaint("Jubileu", "Touro");
        assertEquals(false, jubileu.isArmaduraVestida());
    }
    
    @Test
    public void aoCriarSaintGeneroENaoInformado() throws Exception {
        Saint saint = new GoldSaint("Shaka", "Touro");
        assertEquals(Genero.NAO_INFORMADO, saint.getGenero());
    }
    
    @Test
    public void aoInstanciarSaintStatusVivo() throws Exception {
        Saint saint = new GoldSaint("Shaka", "Touro");
        assertEquals(Status.VIVO, saint.getStatus());
    }
    
    @Test 
    public void testarSetGeneroSaint() throws Exception {
        Saint jubileu = new SilverSaint("Jubileu", "Touro");
        jubileu.setGenero(Genero.FEMININO);
        assertEquals(Genero.FEMININO, jubileu.getGenero());
    }
    
    @Test
    public void testarMetodoPerdeVida() throws Exception {
        Saint saint = new GoldSaint("Shaka", "Touro");
        saint.perderVida(60);
        assertEquals(40.0, saint.getVida(), 0.0001);
    }
    
    @Test
    public void aoInstanciarSaintVidaECem() throws Exception {
        Saint saint = new GoldSaint("Shaka", "Touro");
        assertEquals(100.0, saint.getVida(), 0);
    }
    
    @Test
    public void saintLeva100DeDano() throws Exception {
        Saint saint = new GoldSaint("Shaka", "Touro");
        saint.perderVida(100);
        assertEquals(0, saint.getVida(), 0.0001);
    }
    
    @Test(expected=InvalidParameterException.class)
    public void saintLevaMenos1000DeDano() throws Exception {
        Saint saint = new GoldSaint("Shaka", "Touro");
        saint.perderVida(-1000);
    }
    
    @Test
    public void aoInstanciarUmSaintBronzeCincoSentidosDespertados() throws Exception {
        Saint saint = new BronzeSaint("Shaka", "Touro");
        assertEquals(5, saint.getSentidosDespertados());
    }
    
    @Test
    public void aoInstanciarUmSaintPrataSeisSentidosDespertados() throws Exception {
        Saint saint = new SilverSaint("Shaka", "Touro");
        assertEquals(6, saint.getSentidosDespertados());
    }
    
    @Test
    public void aoInstanciarUmSaintOuroSeteSentidosDespertados() throws Exception {
        Saint saint = new GoldSaint("Shaka", "Touro");
        assertEquals(7, saint.getSentidosDespertados());
    }
    
    @Test(expected=Exception.class)
    public void constelacaoInvalidaDeOuroDeveLancarErro() throws Exception {
        new GoldSaint("Bernardo", "Teste");
    }
    
    @Test
    public void vidaSaintMenorUmStatusMorto() throws Exception {
        Saint saint = new GoldSaint("Shaka", "Touro");
        saint.perderVida(99);
        assertEquals(Status.VIVO, saint.getStatus());
        saint.perderVida(1);
        assertEquals(0, saint.getVida(), 0);
        assertEquals(Status.MORTO, saint.getStatus());
    }
    
    @Test
    public void saintComStatusMortoNaoPerdeVida() throws Exception {
        Saint saint = new GoldSaint("Shaka", "Touro");
        saint.perderVida(200);
        assertEquals(-100, saint.getVida(), 0);
        saint.perderVida(100);
        assertEquals(Status.MORTO, saint.getStatus());
        assertEquals(-100, saint.getVida(), 0);
    }
    
    @Test
    public void golpesAprendidosPorSaintDevemSerSalvos() throws Exception {
        Saint saint = new GoldSaint("Shaka", "Touro");
        Golpe[] golpes = new Golpe[3];
        golpes[0] = new Golpe("Kamehameha", 8001);
        golpes[1] = new Golpe("Rasengan", 5);
        golpes[2] = new Golpe("Raduken", 100);
       
        for (int i = 0; i < golpes.length; i++) {
            saint.aprenderGolpe(golpes[i]);
        }
        
        saint.aprenderGolpe(new Golpe("Não lembro de CDZ", 10000));
        
        for (int i = 0; i < golpes.length; i++) {
            assertEquals(golpes[i], saint.getGolpes().get(i));
        }
    }
    
    @Test
    public void testarMetodoProximoGolpeSaint() throws Exception {
        Saint saint = new GoldSaint("Shaka", "Touro");
        Golpe[] golpes = new Golpe[3];
        golpes[0] = new Golpe("Kamehameha", 8001);
        golpes[1] = new Golpe("Rasengan", 5);
        golpes[2] = new Golpe("Raduken", 100);
        
        for (int i = 0; i < golpes.length; i++) {
            saint.aprenderGolpe(golpes[i]);
        }
        
        assertEquals(golpes[0], saint.getProximoGolpe());
        assertEquals(golpes[1], saint.getProximoGolpe());
        assertEquals(golpes[2], saint.getProximoGolpe());
        assertEquals(golpes[0], saint.getProximoGolpe());
    }
    
    @Test
    public void testarMetodoProximoGolpe() throws Exception {
        Saint saint = new GoldSaint("Shaka", "Touro");
        Golpe[] golpes = new Golpe[3];
        golpes[0] = new Golpe("Kamehameha", 8001);
        golpes[1] = new Golpe("Rasengan", 5);
        golpes[2] = new Golpe("Raduken", 100);
        
        saint.aprenderGolpe(golpes[0]);     
        assertEquals(golpes[0], saint.getProximoGolpe());
        assertEquals(golpes[0], saint.getProximoGolpe());
        saint.aprenderGolpe(golpes[1]);
        assertEquals(golpes[1], saint.getProximoGolpe());
        assertEquals(golpes[0], saint.getProximoGolpe());
        saint.aprenderGolpe(golpes[2]);
        assertEquals(golpes[1], saint.getProximoGolpe());
        assertEquals(golpes[2], saint.getProximoGolpe());
    }
    
    @Test(expected=Exception.class)
    public void aoAcessarProximoGolpeDeSaintSemGolpeException() throws Exception {
        Saint saint = new GoldSaint("Shaka", "Touro");
        saint.getProximoGolpe();
    }
    
    @Test
    public void aoInstanciarBronzeSaintArmaduraDeveSerBronze() {
        Saint saint = new BronzeSaint("Shaka", "Touro");
        assertEquals(saint.getCategoria(), Categoria.BRONZE);
    }
    
    @Test
    public void aoInstanciarSilverSaintArmaduraDeveSerPrata() {
        Saint saint = new SilverSaint("Marin", "Aguia");
        assertEquals(saint.getCategoria(), Categoria.PRATA);
    }
    
    @Test
    public void aoInstanciarGoldSaintArmaduraDeveSerOuro() throws Exception {
        Saint saint = new GoldSaint("Shaka", "Touro");
        assertEquals(saint.getCategoria(), Categoria.OURO);
    }
    
    @Test(expected=Exception.class)
    public void pegarMovimentoDeSaintSemMovimentoGeraException() throws Exception {
        Saint saint = new GoldSaint("Shaka", "Touro");
        saint.getProximoMovimento();
    }
    
    @Test
    public void pegarProximoMovimentoComMovimentosAdicionados() throws Exception {
        Saint saint = new GoldSaint("Shaka", "Touro");
        Movimento vestirArmadura = new VestirArmadura(saint);
        saint.adicionarMovimento(vestirArmadura);
        assertEquals(saint.getProximoMovimento(), vestirArmadura);
        assertEquals(saint.getProximoMovimento(), vestirArmadura);
        Movimento golpear = new Golpear(saint, new SilverSaint("Goku", "Aries"));
        saint.adicionarMovimento(golpear);
        assertEquals(saint.getProximoMovimento(), golpear);
        assertEquals(saint.getProximoMovimento(), vestirArmadura);
        assertEquals(saint.getProximoMovimento(), golpear);
        assertEquals(saint.getProximoMovimento(), vestirArmadura);
    }
}
