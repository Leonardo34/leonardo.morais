
public class Batalha {
    private Saint saintUm, saintDois;
    private static final double DANO = 10;
    
    public Batalha(Saint saintUm, Saint saintDois) {
        this.saintUm = saintUm;
        this.saintDois = saintDois;
    }
    
    public void iniciar() {
        if (saintDois.getCategoria().getValor() > saintUm.getCategoria().getValor()) {
            saintUm.perderVida(DANO);
        } else {
            saintDois.perderVida(DANO);
        }
    }
    
    public Saint getSaintUm() {
        return saintUm;
    }
    
    public Saint getSaintDois() {
        return saintDois;
    }
}
