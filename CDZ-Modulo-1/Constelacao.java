
public class Constelacao {
    private String nome;
    private Golpe[] golpes;
    private int qtdGolpes;
    private static final int MAX_GOLPES = 3;
    
    public Constelacao(String nome) {
        this.nome = nome;
        this.golpes = new Golpe[MAX_GOLPES];
        this.qtdGolpes = 0;
    }
    
    public String getNome() {
        return nome;
    }
    
    public Golpe[] getGolpes() {
        return golpes;
    }
    
    public void adicionarGolpe(Golpe golpe) {
        if (qtdGolpes < golpes.length) {
            golpes[qtdGolpes++] = golpe;
        }
    }
}
