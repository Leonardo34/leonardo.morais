
public enum Categoria {
    OURO(3), 
    PRATA(2), 
    BRONZE(3);
    
    private int valor;
    
    private Categoria(int valor) {
        this.valor = valor;
    }
    
    public int getValor() {
        return valor;
    }
}
