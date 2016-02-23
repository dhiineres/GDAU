package gdau.funcionais;

import static gdau.Principal.listProf;
import gdau.modelos.Turma;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.io.Serializable;

public class ListaTurmas implements Serializable {
    private final int MAX = 100;
    private ArrayList<Turma> lista = new ArrayList();
    
    public int getSize(){
        return this.lista.size();
    }
    
    public int getIndex(int cod){
        if(!verificarListaVazia()){
            for(int i = 0; i < lista.size(); i++){
                if(lista.get(i).getCodigo() == cod){
                    return i;
                }
            }return -1;
        }else{
            return -1;
        }
    }
    
    public Turma getTurma(int index){
        return this.lista.get(index);
    }
    
    public ArrayList<Turma> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Turma> lista) {
        this.lista = lista;
    }
    
    public boolean verificarListaVazia() {
        return(lista.isEmpty());
    }
    
    public boolean verificarListaCheia() {
        return(lista.size() == MAX);
    }
    
    public void cadastrarTurma(Turma turma) throws Exception {
        if(verificarListaCheia()) {
            throw new Exception("A lista de turmas está cheia!");
        } else {
            lista.add(turma);
        }
    }
    
    public String exibeIndice(){
        StringBuilder msg = new StringBuilder();
        if(!verificarListaVazia()){
            msg.append("Lista de Turmas:\n");
            for(int i = 0; i < lista.size(); i++){
                msg.append(i + 1 +" - Curso: "+ lista.get(i).getCurso()
                +", "+lista.get(i).getPeriodo()+"º período\n");
            }
        }
        
        return msg.toString();
    }
    
    public boolean consultarExistencia(int codigo){
        for (Turma turma : lista) {
            if (codigo == turma.getCodigo()) {
                return true;
            }
        }
        
        return false;
    }
    
    public void removerTurma(Turma turma) throws Exception {
        if(verificarListaVazia()) {
            throw new Exception("Não há turmas cadastradas");
        } else {
            if(lista.contains(turma)) {
                lista.remove(turma);
                return;
            }
        }
        
        throw new Exception("Código inválido!");
    }

    public String exibirElemento(Turma turma) throws Exception {
        StringBuilder concat = new StringBuilder();
        
        if(lista.contains(turma)) {
            concat.append("\n\tCÓDIGO: ")
                    .append(turma.getCodigo())
                    .append("\n\tCURSO: ")
                    .append(turma.getCurso())
                    .append(" - PERIODO: ")
                    .append(turma.getPeriodo())
                    .append("º");
        } else {
            throw new Exception("Turma inexistente!");
        }
        
        return concat.toString();
    }
    
    public String exibirLista() throws Exception {
        StringBuilder concat = new StringBuilder(); 
        
        if(verificarListaVazia()) {
            throw new Exception("Não há turmas cadastradas!");
        } else {
            concat.append("Lista de turmas: \n ");
               
            for(Turma turma : lista) {
                concat.append(exibirElemento(turma) +"\n")
                        .append("======================================\n");
            }
        }
        
        return concat.toString();
    }
    
    
    public void salvaLista() throws Exception {
        try{
            FileInputStream fis = new FileInputStream("Turmas.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            lista = (ArrayList<Turma>) ois.readObject();
            ois.close();
            fis.close();
        }catch(IOException ioe){
            throw new Exception("Arquivo não encontrado!");
        }catch(ClassNotFoundException c){
            throw new Exception("Arquivo não encontrado!");
        }
    }
    
    public void recuperaLIsta() throws Exception{
        try{
            FileInputStream fis = new FileInputStream("Turmas.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            lista = (ArrayList<Turma>) ois.readObject();
            ois.close();
            fis.close();
        }catch(IOException ioe){
            throw new Exception("...");
        }catch(ClassNotFoundException c){
            throw new Exception("...");
        }
    }

    public void retornaTurma(int i, Turma turma) {
        lista.set(i, turma);
    }
}
