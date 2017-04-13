
public class Saint {
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero;
    
    public Saint(String nome, Armadura armadura) {
        this.nome = nome;
        this.armadura = armadura;
        this.genero = Genero.NAO_INFORMADO;
    }
    
    public void vestirArmadura() {
        armaduraVestida = true;
    }
    
    public boolean isArmaduraVestida() {
        return armaduraVestida;
    }
    
    public Genero getGenero() {
        return genero;
    }
    
    public void setGenero(Genero genero) {
        this.genero = genero;
    } 
}
