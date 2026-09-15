import java.util.Random; 

public class CalculoDano {
    private final Random rand = new Random();

public int danoTotal(Personagem p, int dano){
    int chance = rand.nextInt(100);
    if(chance <= p.getStatus().getCritico()){
        return dano * 2;
    }
    return dano;
    }
}
