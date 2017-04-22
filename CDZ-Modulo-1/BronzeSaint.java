

public class BronzeSaint extends Saint {
    public BronzeSaint(String nome, String constelacao) {
        super(nome, new Armadura(new Constelacao(constelacao), Categoria.BRONZE));
        this.qtdSentidosDespertados = 5;
    }
}
