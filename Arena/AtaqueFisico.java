public class AtaqueFisico extends Ataque {
    private static final AtaqueFisico soco = new AtaqueFisico(10, Ataque.Tipo.SOCO);
    private static final AtaqueFisico chute = new AtaqueFisico(15, Ataque.Tipo.CHUTE);

    private final CalculoDano calculo;

    public AtaqueFisico(int dano, Ataque.Tipo tipo){
        super(dano, tipo);
        this.calculo = new CalculoDano();
    }

    @Override 
    public int dano(Personagem p, Ataque arma){
        return calculo.danoTotal(p, arma.getDano());
    }

    public static Ataque getSoco() {
        return soco;
    }

    public static Ataque getChute() {
        return chute;
    }


}
