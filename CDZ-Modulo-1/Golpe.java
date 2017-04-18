
public class Golpe {
    private String nome;
    private int fatorDano;

    public Golpe(String nome, int fatorDano) {
        this.nome = nome;
        this.fatorDano = fatorDano;
    }

    public String getNome() {
        return nome;
    }

    public int getFatorDano() {
        return fatorDano;
    }

    @Override
    public boolean equals(Object object) {
        if (this.getClass() != object.getClass()) {
            return false;
        }
        Golpe other = (Golpe) object;
        if (this.nome != other.nome) {
            return false;
        }
        if (this.fatorDano != other.fatorDano) {
            return false;
        }
        return true;
    }
}
