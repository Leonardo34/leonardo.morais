import java.util.List;
import java.util.ArrayList;

public class ListaSaints {
    private List<Saint> saints;
    
    public ListaSaints() {
        this.saints = new ArrayList<>();
    }
    
    public void adicionar(Saint saint) {
        saints.add(saint);
    }
    
    public Saint get(int indice) {
        return saints.get(indice);
    }
    
    public List<Saint> todos() {
        return saints;
    }
    
    public void remove(Saint saint) {
        saints.remove(saint);
    }
    
    public Saint buscarPorNome(String nome) {
        for (Saint saint : saints) {
            if (saint.getNome().equals(nome)) {
                return saint;
            }
        }
        return null;
    }
    
    public List<Saint> buscarPorCategoria(Categoria categoria) {
        List<Saint> retorno = new ArrayList<>();
        for (Saint saint : saints) {
            if (saint.getCategoria() == categoria) {
                retorno.add(saint);
            }
        }
        return retorno;
    }
    
    public List<Saint> buscarPorStatus(Status status) {
        List<Saint> retorno = new ArrayList<>();
        for (Saint saint : saints) {
            if (saint.getStatus() == status) {
                retorno.add(saint);
            }
        }
        return retorno;
    }
    
    public Saint getSaintMaiorVida() {
        if (saints.isEmpty()) {
            return null;
        }
        Saint saintMaiorVida = saints.get(0);
        for (Saint saint : saints) {
            if (saint.getVida() > saintMaiorVida.getVida()) {
                saintMaiorVida = saint;
            }
        }
        return saintMaiorVida;
    }
    
    public Saint getSaintMenorVida() {
        if (saints.isEmpty()) {
            return null;
        }
        Saint saintMenorVida = saints.get(0);
        for (Saint saint : saints) {
            if (saint.getVida() < saintMenorVida.getVida()) {
                saintMenorVida = saint;
            }
        }
        return saintMenorVida;
    }
    
    public void ordenar() {
        // Inserction Sort O(n^2)
        for (int i = 1; i < saints.size(); i++) {
            int j = i;
            Saint aux = saints.get(i);
            while ((j > 0) && (saints.get(j - 1).getVida() > aux.getVida())) {
                saints.set(j, saints.get(j - 1));
                j--;
            }
            saints.set(j, aux);
        }
    }
}
