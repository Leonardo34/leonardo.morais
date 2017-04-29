import java.security.InvalidParameterException;
import java.util.List;
import java.util.ArrayList;

public abstract class Saint {
    private static final double PORCENTAGEM_DANO_CONTRA_ATAQUE = 0.25;    
    private static int numeroSaints = 0;
    private static int acumuladorQtdSaints = 0;
    
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
    private int id;
    private boolean vaiContraAtacar;
    
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
        this.id = ++Saint.acumuladorQtdSaints;
        this.vaiContraAtacar = false;
    }
    
    @Override
    protected void finalize() {
        Saint.numeroSaints--;
    }

    public static int getQuantidadeSaints() {
        return numeroSaints;
    }
    
    public static int getAcumuladorSaints() {
        return acumuladorQtdSaints;
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
    
    public void perderVida(double dano, Saint golpeador) {
        if (vaiContraAtacar) {
            contraAtacar(golpeador);
        } else {
            perderVida(dano);
        }
    }
    
    private void contraAtacar(Saint golpeador) {
        golpeador.perderVida(PORCENTAGEM_DANO_CONTRA_ATAQUE * golpeador.getVida());
        vaiContraAtacar = false;
    }
    
    public void bloquearProximoAtaque() {
        vaiContraAtacar = true;
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

    public int getID() {
        return id;
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
    
    public int getMultiploDano() {
        return armaduraVestida ? 1 + getCategoria().getValor() : 1;
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
            if (mov.isMovimentoDeAtaque()) {
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
