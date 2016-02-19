    package gdau.modelos;

import java.util.ArrayList;
import java.util.List;

public class Professor {
    
    public final int LIMITE = 5;
    
    private boolean adm;
    private int codigo;
    private String senha;
    private String Nome;
    public List<String> disciplinas = new ArrayList();

    public boolean isAdm() {
        return adm;
    }

    public void setAdm(boolean adm) {
        this.adm = adm;
    }

    public int getCodigo() {
        return codigo;
    }
    
    public void setSenha(String senha){
        if (!("".equals(senha)) && senha != null ){
            this.senha = senha;
        }
    }
    
    public String getSenha(){
        return this.senha;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getDisciplina(int index) {
        return(disciplinas.get(index));
    }
    
    public void setDisciplina(String disciplina) throws Exception{
        if (disciplina != null && disciplina != ""){
            if (!isFull())
                disciplinas.add(disciplina);
            else{
                throw new Exception ("Lista cheia!");
            }
        }else{
            throw new Exception("Nome inválido!");
        }
    }
    
    public String getDadosAdm(){
        StringBuilder msg = new StringBuilder();
        
        msg.append("CÓDIGO: ").append(this.getCodigo())
                .append("\nNOME: ").append(this.getNome())
                .append("\nDISCIPLINAS: \n");
        for (String disciplina : disciplinas) {
            msg.append(" - ").append(disciplina).append("\n");
        }
        msg.append("SENHA: ").append(this.getSenha());
        
        return msg.toString();
    }
    
    public String getDadosStd(){
        StringBuilder msg = new StringBuilder();
        
        msg.append("CÓDIGO: ").append(this.getCodigo())
                .append("\nNOME: ").append(this.getNome())
                .append("\n")
                .append("DISCIPLINAS: \n");
        for (String disciplina : disciplinas) {
            msg.append(" - ").append(disciplina).append("\n");
        }
        
        return msg.toString();
    }
    
    public List<String> getLista(){
        return this.disciplinas;
    }
    
    public void removeDisciplina(int index){
        if (index < disciplinas.size()){
            disciplinas.remove(index);
        }
    }
    
    public boolean isFull(){
        return (disciplinas.size() == LIMITE);
    }
    public String getDisciplinas(){
        StringBuilder msg = new StringBuilder();
        if(disciplinas.isEmpty()){
            for (int i = 0; i < disciplinas.size(); i++){
                msg.append(i + 1)
                        .append(" - ").append(disciplinas.get(i)).append("\n");
            }
        } else {
            msg.append("Lista Vazia!");
        }
        return msg.toString();
    }
    
    public int getQtdDisciplinas(){
        return disciplinas.size();
    }
}