
public class AtaqueDuplo implements Movimento {
    private Saint golpeador, golpeado;
    private Sorteador sorteador;
    private static final int PORC_CASO_ATAQUE_FALHE = 5;
    
    public AtaqueDuplo(Saint golpeador, Saint golpeado, Sorteador sorteador) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;
        this.sorteador = sorteador;
    }
    
    @Override
    public void executar() {
        boolean dobroDano = sorteador.sortear() % 3 == 0;
        int multiploDano = golpeador.getMultiploDano();
        try {    
            double vidaPerder = golpeador.getProximoGolpe().getFatorDano() * multiploDano;
            if (dobroDano) {
                golpeado.perderVida(vidaPerder * 2);
            } else {
                golpeado.perderVida(vidaPerder);
                golpeador.perderVida((PORC_CASO_ATAQUE_FALHE * golpeador.getVida()) / 100);                
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
