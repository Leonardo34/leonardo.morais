
public class ExercitoQueAtacaEmOrdemHierarquica extends ExercitoDeSaints {
    
    @Override
    public Saint getProximoSaint() throws ExercitoVazioException {
        if (estaVazio()) {
            throw new ExercitoVazioException();
        }
        Saint proxSaint = exercito.get(0);
        for (Saint saint : exercito) {
            if (saint.getCategoria().getValor() < proxSaint.getCategoria().getValor()) {
                proxSaint = saint;
            }
        }
        exercito.remove(proxSaint);
        return proxSaint;
    }
}
