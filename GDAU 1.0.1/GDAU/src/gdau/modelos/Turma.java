package gdau.modelos;

import gdau.funcionais.ListaAtividades;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Turma implements Serializable{
    
    protected final int DIAS = 6;
    private ListaAtividades lista;
    
    private int codigo;
    private int periodo;
    private String curso;
    public List<Professor> professores = new ArrayList();

    public Turma() {
        this.lista = new ListaAtividades();
    }
    
    public ListaAtividades getLista(){
        return this.lista;
    }
    
    public void setLista( ListaAtividades lista){
        this.lista = lista;
    }
    
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
    
    public String addLista(Atividade objeto){
        String msg;
        try{
            lista.cadastrarAtividade(objeto);
            msg = "Adicionado com sucesso";
        }catch(Exception ex){
            msg = ex.getMessage();
        }
        return msg;
    }
    
    public String getDados(){
        StringBuilder msg = new StringBuilder();
            
        msg.append("Código : ").append(this.getCodigo()).append ("\n")
                .append("Período: ").append (this.getPeriodo()).append("\n")
                .append ("Curso: ").append(this.getCurso()).append("\n");
        return msg.toString();
    }
}