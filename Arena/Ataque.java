
public abstract class Ataque {
    private final int dano;
    private final Tipo arma;
    
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

    public abstract int dano(Personagem p, Ataque arma);

}
