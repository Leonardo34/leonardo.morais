import java.util.List;
import java.util.ArrayList;

public abstract class ExercitoDeSaints {
    protected List<Saint> exercito;
    
    public ExercitoDeSaints() {
        exercito = new ArrayList<>();
    }
    
    public void alistar(Saint saint) {
        exercito.add(saint);
    }
    
    public boolean estaVazio() {
        return exercito.isEmpty();
    }
    
    public abstract Saint getProximoSaint() throws ExercitoVazioException;
}
