import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArmaduraTest {
    
    @Test
    public void testarCriacaoObjetoArmadura() {
        Armadura armadura = new Armadura(new Constelacao("Touro"), Categoria.OURO);
        assertEquals("Touro", armadura.getConstelacao().getNome());
        assertEquals(Categoria.OURO, armadura.getCategoria());
    }
}
