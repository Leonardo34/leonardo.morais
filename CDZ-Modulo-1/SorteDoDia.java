
public class SorteDoDia {
    private Sorteador sorteador;
    
    public SorteDoDia(Sorteador sorteador) {
        this.sorteador = sorteador;
    }
    
    public boolean estaComSorte() {
        int resultado = sorteador.sortear();
        return resultado % 2 == 0;
    }
}
