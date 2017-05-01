
public class AtaqueDuplo implements Movimento {
    private Saint golpeador, golpeado;
    private Sorteador sorteador;
    private static final double PORC_CASO_ATAQUE_FALHE = 0.05;
    
    public AtaqueDuplo(Saint golpeador, Saint golpeado, Sorteador sorteador) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;
        this.sorteador = sorteador;
    }
    
    @Override
    public void executar() {
        try {    
            double vidaPerder = golpeador.getProximoGolpe().getFatorDano() * golpeador.getMultiploDano();
            if (sorteador.sortear() % 3 == 0) {
                golpeado.perderVida(vidaPerder * 2, golpeador);
            } else {
                golpeado.perderVida(vidaPerder, golpeador);
                golpeador.perderVida(PORC_CASO_ATAQUE_FALHE * golpeador.getVida());                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());            
        }
    }
    
    @Override
    public boolean isMovimentoDeAtaque() {
        return true;
    }
}
