
public class ContraAtaque implements Movimento {
    private Saint golpeador, golpeado;
    
    public ContraAtaque(Saint golpeador, Saint golpeado) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }
    
    @Override
    public void executar() {
    }
    
    @Override
    public boolean isMovimentoDeAtaque() {
        return false;
    }
}
