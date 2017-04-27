
public class Golpear implements Movimento {
    private Saint golpeador, golpeado;
    
    public Golpear(Saint golpeador, Saint golpeado) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }
    
    @Override
    public void executar() {
        int multiploDano = golpeador.getMultiploDano();
        try {
            double vidaPerder = golpeador.getProximoGolpe().getFatorDano() * multiploDano;
            golpeado.perderVida(vidaPerder);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
