
public class Saint {
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero;
    private Status status;
    private double hp;
    protected int qtdSentidosDespertados;
    
    public Saint(String nome, Armadura armadura) throws Exception {
        this.nome = nome;
        this.armadura = armadura;
        this.genero = Genero.NAO_INFORMADO;
        this.status = Status.VIVO;
        this.hp = 100;
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
    
    public void perderVida(double dano) {
        hp -= dano;
    }
    
    public Status getStatus() {
        return status;
    }
    
    public double getVida() {
        return hp;
    }
    
    public Categoria getCategoria() {
        return armadura.getCategoria();
    }
    
    public int getSentidosDespertados() {
        return qtdSentidosDespertados;
    }
}
