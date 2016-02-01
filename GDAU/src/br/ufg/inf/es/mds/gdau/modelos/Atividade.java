package br.ufg.inf.es.mds.gdau.modelos;


/**
 * Classe que define as atividades que serão controladas pelo professor;
 */
public class Atividade {

    private int dia, mes, ano;
    private int codigoTurma;
    private String descricao;
    private String nome;
    private int codigoAtividade;
    private boolean noPrazo;

    public Atividade(int d, int m, int a, int codT, int codA, String descricao, String nome) {
        this.nome = nome;
        this.descricao = descricao;
        this.dia = d;
        this.mes = m;
        this.ano = a;
        this.codigoAtividade = codA;
        this.codigoTurma = codT;
        this.noPrazo = true;
    }

    public String getNome(){
        return this.nome;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public boolean isNoPrazo(){
        return this.noPrazo;
    }

    public int getCodigoTurma(){
        return this.codigoTurma;
    }

    public int getCodigoAtividade(){
        return this.codigoAtividade;
    }

    public String getDataEntrega(){
        String out;
        StringBuilder msg = new StringBuilder();
        msg.append("Atividade: " + this.nome + "\n");
        msg.append("Data de entrega: ");
        msg.append(this.dia + "/" + this.mes + "/" + this.ano);
        out = msg.toString();
        return out;
    }

    public static void main(String[] args){
        Atividade teste = new Atividade(2, 2, 2015, 15037, 10553, "apenas um teste", "Teste");

        System.out.print(teste.getDataEntrega());
    }
}
