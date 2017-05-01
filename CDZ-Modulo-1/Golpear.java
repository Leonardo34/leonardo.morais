
public class Golpear implements Movimento {
    private Saint golpeador, golpeado;
    
    public Golpear(Saint golpeador, Saint golpeado) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }
    
    @Override
    public void executar() {
        try {
            double vidaPerder = golpeador.getProximoGolpe().getFatorDano() * golpeador.getMultiploDano();
            golpeado.perderVida(vidaPerder, golpeador);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public boolean isMovimentoDeAtaque() {
        return true;
    }
}
