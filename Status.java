import java.util.Random;

public class Status {
    private int vida;
    private int dano;
    private Random rand;
    private double critico;
    private double esquiva;

    public Status() {
        this.vida = 100;
        this.dano = 10;
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
    
    public int getDano(){
        return dano;
    }

    public void receberDano(int dano){
        int chance = rand.nextInt(100);
        if(chance < critico) {
            System.out.println("Acerto crítico!");
            vida -= dano * 2;
            return;
        }
        vida -= dano;
    }

    public boolean esquiva(){
        int chance = rand.nextInt(100);
        return chance <= esquiva;
    }

    public void contraAtaque(){
        vida -= dano/2;
    }

    
    public boolean defender(){

        vida -= (dano/2);
        return false;
    }

    

    

}
