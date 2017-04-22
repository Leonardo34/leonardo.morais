

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VestirArmaduraTest {

    @Test
    public void executarDeveDeixarArmaduraDoSaintVestida() {
        Saint saint = new BronzeSaint("Seiya", "Pegasus");
        Movimento movimento = new VestirArmadura(saint);
        assertFalse(saint.isArmaduraVestida());
        movimento.executar();
        assertTrue(saint.isArmaduraVestida());
    }
}
