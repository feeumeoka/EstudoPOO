public class Arena{
    private boolean continuar;
    private Personagem p1;
    private Personagem p2;
    private int rodada;

    public static enum Rodada {
        CONTRA_ATACOU,
        DEFENDEU,
        ATACOU
    }

    public Arena(String nomeP1, String nomeP2){
        this.continuar = true;
        this.p1 = new Personagem(nomeP1);
        this.p2 = new Personagem(nomeP2);
        this.rodada = 1;
    }

    public void rodada(Personagem p1, Personagem p2){
        ValidacaoCombate validacao = new ValidacaoCombate(p1, p2);

        if(validacao.others()) {
            System.out.println("Ambos defenderam...");
            return;
        }
        if(validacao.acaoIgual()){
            switch(validacao.getAcao1()) {
                case Arena.Rodada.ATACOU: 
                    p1.atacar(p2);
                    p2.atacar(p1);
                    break;
                default:
                    System.out.println("Ambos defenderam...");
            }
        }
        else if(validacao.defesaP1()) {
            switch (validacao.getAcao1()) {
                case Arena.Rodada.DEFENDEU:
                    p1.defender(p2.escolherAtaque());
                    System.out.println("Mas " + p1.getNome() + " conseguiu defender o ataque do " + p2.getNome());
                    return;
                case Arena.Rodada.CONTRA_ATACOU:
                    p2.escolherAtaque();
                    p1.atacar(p2);
                    System.out.println("Mas " + p1.getNome() + " conseguiu defender perfeitamente o ataque do " + p2.getNome() + " e contra-atacou!");
                default:
            }
        }
        else if(validacao.defesaP2()){
            switch (validacao.getAcao2()){
                case Arena.Rodada.DEFENDEU:
                    p2.defender(p1.escolherAtaque());
                    System.out.println("Mas " + p2.getNome() + " conseguiu defender o ataque do " + p1.getNome());
                    return;
                case Arena.Rodada.CONTRA_ATACOU:
                    p1.escolherAtaque();
                    p2.atacar(p1);
                    System.out.println("Mas " + p2.getNome() + " conseguiu defender perfeitamente o ataque do " + p1.getNome() + " e contra-atacou!");
                default:
            }
        }
        else {
            System.out.println("Ambos defenderam...");
        }
    }

    public void resumo(Personagem p1, Personagem p2){
        System.out.println("\nResumo da rodada:");
        System.out.println(p1.getNome() + " Vida: " + p1.getStatus().getVida());
        System.out.println(p2.getNome() + " Vida: " + p2.getStatus().getVida());
        System.out.println("\n- - - - - - - - - -\n");

    }

    public void continuar(Personagem p1, Personagem p2){
        if(p1.getStatus().getVida() <= 0 && p2.getStatus().getVida() <= 0){
            continuar = false;
            System.out.println("A partida empatou!");
        }
        else if(p1.getStatus().getVida() <= 0) {
            continuar = false;
            System.out.println("O jogador: " + p2.getNome() + " Venceu!");
        }
        else if(p2.getStatus().getVida() <= 0){
            continuar = false;
            System.out.println("O jogador: " + p1.getNome() + " Venceu!");
        }
        
    }

    public static void main(String args[]){
        Arena arena = new Arena("Felipe", "Augusto");
        
        while(arena.continuar){
            System.out.println("Começando a rodada: " + arena.rodada);

            arena.rodada (arena.p1,arena.p2);
            arena.resumo(arena.p1, arena.p2);

            arena.rodada++;
            arena.continuar(arena.p1,arena.p2);
        }
    }
}