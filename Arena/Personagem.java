import java.util.Random; 

public class Personagem {
    private String nome;
    private final Ataque[] ataques = new Ataque[3];
    private Ataque ataqueAtual;
    private Status status;
    private final Random rand;

    public Status getStatus() {
        return status;
    }
    public String getNome() {
        return nome;
    }
    public void mudarNome(String nome) {
        if(nome.equals("")) return;
        this.nome = nome;
    }
    public void setAtaques(Ataque ataques) {
        this.ataques[2] = ataques;
    }
    public Ataque[] getAtaques() {
        return ataques;
    }

    public Personagem(String nome) {
        this.nome = nome;
        this.ataques[0] = AtaqueFisico.getSoco();
        this.ataques[1] = AtaqueFisico.getChute();
        this.status = new Status();
        this.rand = new Random();
    }
    
    public Personagem(String nome, Ataque ataque) {
        this.nome = nome;
        this.ataques[0] = AtaqueFisico.getSoco();
        this.ataques[1] = AtaqueFisico.getChute();
        this.ataques[2] = ataque;
        this.status = new Status();
        this.rand = new Random();
    }  

    public void receberDano(int dano){
        status.receberDano(dano);
    }


    public void atacar(Personagem p){
        p.receberDano(escolherAtaque().dano(p, ataqueAtual));
    }


    public Ataque escolherAtaque(){
        if(ataques[2] == null){
            int tipo = rand.nextInt(2);
            if(tipo == 1){
                System.out.println(this.getNome() + " Realizou um soco!");
                return ataqueAtual = ataques[0];
            }
            else {
                System.out.println(this.getNome() + " Realizou um chute!");
                return ataqueAtual = ataques[1];
            }
        }
        else {
            return ataqueAtual = ataques[2];
        }
    }

    public void defender(Ataque ataque){
        if (ataques[2] != null ) {
            status.defender(ataque.dano(this, ataque));
        } else {
            return;
        }
    }
    public boolean esquivar(){
        return status.esquiva();
    }

    public Arena.Rodada acao(Personagem p){
        int decisao = rand.nextInt(2);
        if(decisao == 1) {
            return Arena.Rodada.ATACOU;
        }

        else {
            if(esquivar()){
                return Arena.Rodada.CONTRA_ATACOU;
            }
            return Arena.Rodada.DEFENDEU;
        }
    }
}