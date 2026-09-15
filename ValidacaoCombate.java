
public class ValidacaoCombate {
    private static Arena.Rodada acao2;
    private static Arena.Rodada acao1;

    public ValidacaoCombate(Personagem p1, Personagem p2){
        this.acao1 = p1.acao(p2);
        this.acao2 = p2.acao(p1);
    }

    public boolean acaoIgual(){
        return acao1.equals(acao2);
    }

    public boolean defesaP1(){
        return acao1 == Arena.Rodada.DEFENDEU || acao1 == Arena.Rodada.CONTRA_ATACOU;
    }

    public boolean defesaP2(){
        return (acao2 == Arena.Rodada.DEFENDEU && acao2 == Arena.Rodada.CONTRA_ATACOU);
    }

    public boolean others(){
        if (acao1 == Arena.Rodada.DEFENDEU && acao2 == Arena.Rodada.CONTRA_ATACOU) return true;
        return (acao1 == Arena.Rodada.CONTRA_ATACOU && acao2 == Arena.Rodada.DEFENDEU);
        
    }

    public Arena.Rodada getAcao1() {
        return acao1;
    }

    public Arena.Rodada getAcao2() {
        return acao2;
    }
}
