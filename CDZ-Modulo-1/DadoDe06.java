
public class DadoDe06 implements Sorteador {
    
    @Override
    public int sortear() {
        return 1 + (int) (Math.random() * 6);
    }
}
