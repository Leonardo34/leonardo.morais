import java.security.InvalidParameterException;
import java.util.List;
import java.util.ArrayList;

public abstract class Saint {
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero;
    private Status status;
    private double hp;
    private int indiceGolpe;
    protected int qtdSentidosDespertados;
    private List<Movimento> movimentos;
    private int indiceMovimento;
	private static int numeroSaints = 0;
    
    public Saint(String nome, Armadura armadura) {
        this.nome = nome;
        this.armadura = armadura;
        this.genero = Genero.NAO_INFORMADO;
        this.status = Status.VIVO;
        this.hp = 100;
        this.indiceGolpe = 0;
        this.movimentos = new ArrayList<>();
        this.indiceMovimento = 0;
		Saint.numeroSaints++;
    }

	public static int getQuantidadeSaints() {
		return numeroSaints;
	}
    
    public String getNome() {
        return nome;
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
    
    public List<Golpe> getGolpes() {
        return armadura.getConstelacao().getGolpes();
    }
    
    public void aprenderGolpe(Golpe golpe) {
        armadura.getConstelacao().adicionarGolpe(golpe);
    }
    
    public Golpe getProximoGolpe() throws Exception {
        if (getGolpes().isEmpty()) {
            throw new Exception("Nenhum Golpe foi aprendido por este Saint");
        }
        if (indiceGolpe == armadura.getConstelacao().getQuantidadeGolpes()) {
            indiceGolpe = 0;
        }
        return getGolpes().get(indiceGolpe++);
    }
    
    public void adicionarMovimento(Movimento movimento) {
        movimentos.add(movimento);
    }
    
    public Movimento getProximoMovimento() throws Exception {
        if (movimentos.isEmpty()) {
            throw new Exception("Este Saint não possui nenhum Movimento");
        }
        if (indiceMovimento == movimentos.size()) {
            indiceMovimento = 0;
        }
        return movimentos.get(indiceMovimento++);
    }
    
    public boolean estaAptoBatalhar() {
        if (getGolpes().isEmpty()) {
            return false;
        }
        for (Movimento mov : movimentos) {
            if (mov instanceof Golpear) {
                return true;
            }
        }
        return false;
    }
    
    @Override 
    public String toString() {
        return nome + "," + 
                    hp + "," + 
                    armadura.getConstelacao().getNome() + "," + 
                    getCategoria() + "," + 
                    status + "," + 
                    genero + "," + 
                    armaduraVestida;
    }
}
