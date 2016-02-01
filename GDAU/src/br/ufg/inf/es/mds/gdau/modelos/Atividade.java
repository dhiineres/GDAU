package br.ufg.inf.es.mds.gdau.modelos;

/**
 * Classe que define as atividades que serão controladas pelo professor;
 */
public class Atividade {

    private int dia, mes, ano;
    private int codigoTurma;
    private String descricao;
    private int codigoAtividade;

    public Atividade(int d, int m, int a, int codT, int codA, String descricao) {

        this.descricao = descricao;
        this.dia = d;
        this.mes = m;
        this.ano = a;
        this.codigoAtividade = codA;
        this.codigoTurma = codT;
    }
}
