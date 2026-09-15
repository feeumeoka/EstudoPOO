
public abstract class Ataque {
    private int dano;
    private Tipo arma;
    
    public static enum Tipo {
        SOCO,
        CHUTE,
        ESPADA
        // . . .
    }

    public Ataque(int dano, Tipo arma) {
        this.dano = dano;
        this.arma = arma;
    }

    public int getDano() {
        return dano;
    }

    public Tipo getArma() {
        return arma;
    }

    public abstract void dano(Personagem p, Ataque arma);

}
