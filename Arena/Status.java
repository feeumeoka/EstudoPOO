import java.util.Random;

public class Status {
    private int vida;
    private final Random rand;
    private double critico;
    private double esquiva;

    public Status() {
        this.vida = 100;
        this.critico = 5.0;
        this.esquiva = 15.0;
        this.rand = new Random();
    }
    public double getCritico() {
        return critico;
    }

    public double getEsquiva() {
        return esquiva;
    }
    public int getVida(){
        return vida;
    }

    public void receberDano(int dano){
        vida -= dano;
        if(vida < 0) vida = 0;
    }

    public boolean esquiva(){
        int chance = rand.nextInt(100);
        return chance <= esquiva;
    }
    
    public void defender(int dano){

        vida -= (dano/2);
    }
}
