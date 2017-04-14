
public class Batalha {
    private Saint saintUm, saintDois;
    
    public Batalha(Saint saintUm, Saint saintDois) {
        this.saintUm = saintUm;
        this.saintDois = saintDois;
    }
    
    public void iniciar() {
        if (saintDois.getCategoria().getValor() > saintUm.getCategoria().getValor()) {
            saintUm.perderVida(10);
        } else {
            saintDois.perderVida(10);
        }
    }
}
