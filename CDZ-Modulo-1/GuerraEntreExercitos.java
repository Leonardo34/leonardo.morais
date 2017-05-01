
public class GuerraEntreExercitos {
    private ExercitoDeSaints exercitoUm, exercitoDois;
    
    public GuerraEntreExercitos(ExercitoDeSaints exercitoUm, ExercitoDeSaints exercitoDois) {
        this.exercitoUm = exercitoUm;
        this.exercitoDois = exercitoDois;
    }
    
    public void iniciar() throws Exception {
        while (!exercitoUm.estaVazio() && !exercitoDois.estaVazio()) {
            Saint saintUm = exercitoUm.getProximoSaint();
            Saint saintDois = exercitoDois.getProximoSaint();
            Batalha batalha = new Batalha(saintUm, saintDois);
            batalha.iniciar();
        }
    }
}
