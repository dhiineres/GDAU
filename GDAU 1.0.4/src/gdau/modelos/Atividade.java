package gdau.modelos;

import gdau.modelos.NivelDificuldade;
import java.io.Serializable;

public class Atividade implements Serializable {
    
    private int dia, mes, ano;
    private int codigoTurma;
    private String descricao;
    private String nome;
    private int codigo;
    private int codProfessor;
    private int dificuldade;
    
    public Atividade() {
        dia = 01; mes = 01; ano = 2016;
        codigoTurma = 0;
        descricao = null;
        nome = null;
        codigo = 0;
        codProfessor = 0;
        dificuldade = 0;
    }
    
    public Atividade(int dia, int mes, int ano, int codigoTurma, 
            String descricao, String nome, int codigo, int codProfessor, 
            int dificuldade) {
        this.dia = dia; this.mes = mes; this.ano = ano;
        this.codigoTurma = codigoTurma;
        this.descricao = descricao;
        this.nome = nome;
        this.codigo = codigo;
        this.codProfessor = codProfessor;
        this.dificuldade = dificuldade;
    }
    
    public void setData(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    
    public String getData() {
        return(dia + "/" + mes + "/" + ano);
    }
    
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getCodigoTurma() {
        return codigoTurma;
    }

    public void setCodigoTurma(int codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodProfessor() {
        return codProfessor;
    }

    public void setCodProfessor(int codProfessor) {
        this.codProfessor = codProfessor;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }
    
    public String getDados(){
        StringBuilder msg = new StringBuilder();
        
        msg.append("Nome: ")
                .append(this.getNome())
                .append("\n")
                .append("Entrega: ")
                .append(this.getData())
                .append("\n")
                .append("Descrição: \n")
                .append(this.getDescricao())
                .append("\n")
                .append("Dificuldade: ")
                .append(this.getDificuldade())
                .append("\n");
        
        return msg.toString();
    }
}