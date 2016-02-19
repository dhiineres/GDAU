package gdau.modelos;

import gdau.funcionais.ListaAtividades;

public class Turma {
    
    protected final int DIAS = 6;
    public ListaAtividades lista = new ListaAtividades();
    
    private int codigo;
    private int periodo;
    private String curso;
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
}