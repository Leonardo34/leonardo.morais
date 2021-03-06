
public class VestirArmadura implements Movimento {
    private Saint saint;
    
    public VestirArmadura(Saint saint) {
        this.saint = saint;
    }
    
    @Override
    public void executar() {
        saint.vestirArmadura();
    }
    
    @Override
    public boolean isMovimentoDeAtaque() {
        return false;
    }
}
