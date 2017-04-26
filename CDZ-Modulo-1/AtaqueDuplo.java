
public class AtaqueDuplo implements Movimento {
    private Saint golpeador, golpeado;
    private Sorteador sorteador;
    private static final int PORC_CASO_ATAQUE_FALHE = 5;
    
    public AtaqueDuplo(Saint golpeador, Saint golpeado, Sorteador sorteador) {
        this.golpeador = golpeado;
        this.golpeado = golpeado;
        this.sorteador = sorteador;
    }
    
    @Override
    public void executar() {
        boolean dobroDano = sorteador.sortear() % 3 == 0;
        int multiploDano = golpeador.isArmaduraVestida() ? 
            1 + golpeador.getCategoria().getValor() : 1;
        try {    
            double vidaPerder = golpeador.getProximoGolpe().getFatorDano() * multiploDano;
            if (dobroDano) {
                golpeado.perderVida(vidaPerder * 2);
            } else {
                golpeado.perderVida(vidaPerder);
                golpeador.perderVida((PORC_CASO_ATAQUE_FALHE * 100) / golpeador.getVida());                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
