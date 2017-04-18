import java.security.InvalidParameterException;

public class Saint {
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero;
    private Status status;
    private double hp;
    private int indiceGolpe;
    protected int qtdSentidosDespertados;
    
    public Saint(String nome, Armadura armadura) throws Exception {
        this.nome = nome;
        this.armadura = armadura;
        this.genero = Genero.NAO_INFORMADO;
        this.status = Status.VIVO;
        this.hp = 100;
        this.indiceGolpe = 0;
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
    
    public void perderVida(double dano) throws InvalidParameterException {
        if (dano < 0) {
            throw new InvalidParameterException();
        }
        if (status != Status.MORTO) {
            hp -= dano;
            atualizarStatus();
        }     
    }
    
    public Status getStatus() {
        return status;
    }
    
    private void atualizarStatus() {
        if (hp < 1) {
            status = Status.MORTO;
        }
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
    
    public Golpe[] getGolpes() {
        return armadura.getConstelacao().getGolpes();
    }
    
    public void aprenderGolpe(Golpe golpe) {
        armadura.getConstelacao().adicionarGolpe(golpe);
    }
    
    public Golpe getProximoGolpe() {
        Golpe golpe = getGolpes()[indiceGolpe++];
        if (indiceGolpe == getGolpes().length) {
            indiceGolpe = 0;
        }
        return golpe;
    }
}
