
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaintTest {
    
    @Test
    public void vestirArmaduraDeixaArmaduraVestida() {
        // AAA
        // 1. Arrange - Montagem do cenario de teste 
        Armadura touro = new Armadura("Touro", Categoria.OURO);
        Saint jubileu = new Saint("Jubileu", touro);
        
        // 2. Action - Invocar a ação a ser testada       
        jubileu.vestirArmadura();
        
        // 3. Assert - verificação dos resultados do teste
        assertEquals(true, jubileu.isArmaduraVestida());
    }
    
    @Test
    public void vestirArmaduraDeixaArmaduraNaoVestida() {
        Saint jubileu = new Saint("Jubileu", new Armadura("Cisnei", Categoria.BRONZE));
        assertEquals(false, jubileu.isArmaduraVestida());
    }
    
    @Test
    public void aoCriarSaintGeneroENaoInformado() {
        Saint saint = new Saint("Shaka", new Armadura("Virgem", Categoria.OURO));
        assertEquals(Genero.NAO_INFORMADO, saint.getGenero());
    }
}