
public class ExercitoQueAtacaEmOrdemAlternada extends ExercitoDeSaints {
    private Categoria categoriaAtual;
    
    public ExercitoQueAtacaEmOrdemAlternada() {
        super();
        this.categoriaAtual = Categoria.BRONZE;
    }
    
    @Override
    public Saint getProximoSaint() throws ExercitoVazioException {
        if (estaVazio()) {
            throw new ExercitoVazioException();
        } 
        Saint proxSaint = null;
        for (Saint saint : exercito) {
            if (saint.getCategoria() == categoriaAtual) {
                proxSaint = saint;
                break;
            }
        }
        proximaCategoria();
        if (proxSaint == null) {
            return getProximoSaint();
        }
        exercito.remove(proxSaint);
        return proxSaint;
    }
    
    private void proximaCategoria() {
        if (categoriaAtual == Categoria.BRONZE) {
            categoriaAtual = Categoria.PRATA;
        } else if (categoriaAtual == Categoria.PRATA) {
            categoriaAtual = Categoria.OURO;
        } else {
            categoriaAtual = Categoria.BRONZE;
        }
    }
}
