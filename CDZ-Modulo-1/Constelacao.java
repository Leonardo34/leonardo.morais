import java.util.List;
import java.util.ArrayList;

public class Constelacao {
    private String nome;
    private List<Golpe> golpes;
    
    public Constelacao(String nome) {
        this.nome = nome;
        this.golpes = new ArrayList<>();
    }
    
    public String getNome() {
        return nome;
    }
    
    public List<Golpe> getGolpes() {
        return golpes;
    }
    
    public void adicionarGolpe(Golpe golpe) {
        golpes.add(golpe);
    }
    
    public int getQuantidadeGolpes() {
        return golpes.size();
    }
}
