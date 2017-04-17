
public class Constelacao {
    private String nome;
    private Golpe[] golpes;
    private static final int MAX_GOLPES = 3;
    
    public Constelacao(String nome) {
        this.nome = nome;
        golpes = new Golpe[MAX_GOLPES];
    }
    
    public String getNome() {
        return nome;
    }
    
    public Golpe[] getGolpes() {
        return golpes;
    }
}
