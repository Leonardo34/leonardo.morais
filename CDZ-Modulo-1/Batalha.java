
public class Batalha {
    private Saint saintUm, saintDois;
    
    public Batalha(Saint saintUm, Saint saintDois) {
        if (saintDois.getCategoria().getValor() > saintUm.getCategoria().getValor()) {
            this.saintUm = saintDois;
            this.saintDois = saintUm;
        } else {
            this.saintUm = saintUm;
            this.saintDois = saintDois;
        }
    }
    
    public void iniciar() throws Exception {
        if (saintUm.estaAptoBatalhar() && saintDois.estaAptoBatalhar()) {
            Saint saintAtaca = saintUm;
            while (saintUm.getStatus() != Status.MORTO && saintDois.getStatus() != Status.MORTO) {
                saintAtaca.getProximoMovimento().executar();
                saintAtaca = saintAtaca == saintUm ? saintDois : saintUm;
            }
        }    
    }
    
    public Saint getSaintUm() {
        return saintUm;
    }
    
    public Saint getSaintDois() {
        return saintDois;
    }
}
