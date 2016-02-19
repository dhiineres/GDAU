package gdau.funcionais;

import gdau.modelos.Professor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.List;

public class ListaProfessores implements Serializable {
    
    private final int MAX = 100;
    private List<Professor> lista = new ArrayList();

    public List<Professor> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Professor> lista) {
        this.lista = lista;
    }
    
    public boolean verificarListaVazia() {
        return(lista.isEmpty());
    }
    
    public boolean verificarListaCheia() {
        return(lista.size() == MAX);
    }
    
    public int getIndexProf(int cod){
        if (this.verificarListaVazia()){
            return -1;
        }else{
            for (int i = 0; i < lista.size(); i++){
                if(lista.get(i).getCodigo() == cod){
                    return i;
                }
            }
        }
        return -1;
    }
    
    public Professor getProfessor(int index){
        return this.lista.get(index);
    }
    
    public void cadastrarProfessor(Professor prof) {
        lista.add(prof);
    }
    
    public boolean consultarExistencia(int codigo){
        for (Professor prof : lista) {
            if (codigo == prof.getCodigo()) {
                return true;
            }
        }
        
        return false;
    }
    
    public int getSize(){
        return this.lista.size();
    }
    
    public void removerProfessor(int codigo) throws Exception {
        int index;
        
        if(lista.get(codigo).isAdm()) {
            throw new Exception("Não é possível remover o administrador!");
        } else {
            if(verificarListaVazia()) {
                throw new Exception("Não há professores cadastrados");
            } else {
                index = getIndexCodigo(codigo);
                if(index != -1) {
                    lista.remove(index);
                    return;
                }
            }

            throw new Exception("Código inválido!");
        }
    }

    public String exibirElemento(Professor prof) throws Exception {
        StringBuilder concat = new StringBuilder();
        
        if(lista.contains(prof)) {
            concat.append("\n\tCÓDIGO: ")
                    .append(prof.getCodigo())
                    .append("\n\tNOME: ")
                    .append(prof.getNome())
                    .append("\n\tLista de disciplinas lecionadas: \n");
            
            for(int i = 0; i < prof.LIMITE; i++) {
                concat.append(prof.getDisciplina(i))
                        .append("\n");
            }
        } else {
            throw new Exception("Professor inexistente!");
        }
        
        return concat.toString();
    }
    
    public String exibirListaAdm() {
        StringBuilder concat = new StringBuilder(); 
        
        if(verificarListaVazia()) {
            concat.append("Lista vazia!");
        } else {
            concat.append("Lista de professores operantes: \n ");
               
            for(int i = 0; i < lista.size(); i++) {
                concat.append(lista.get(i).getDadosAdm())
                        .append("\n======================================\n");
            }
        }
        
        return concat.toString();
    }
    
    public int getIndexCodigo(int codigo){
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).getCodigo() == codigo)
                return i;
        }   
        return -1;
    }
    
    public String exibirLista(){
        StringBuilder concat = new StringBuilder(); 
        
        if(verificarListaVazia()) {
            concat.append("Lista vazia!");
        } else {
            concat.append("Lista de professores operantes: \n ");
               
            for(int i = 0; i < lista.size(); i++) {
                concat.append(lista.get(i).getDadosStd())
                        .append("\n======================================\n");
            }
        }
        
        return concat.toString();
    }
    
    public void retornaProfessor(Professor prof, int index){
        lista.add(index, prof);
    }
    
    public void salvaLista() throws Exception{
        try{
            FileInputStream fis = new FileInputStream("Professores.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            lista = (ArrayList<Professor>) ois.readObject();
            ois.close();
            fis.close();
        }catch(IOException | ClassNotFoundException ioe){
            throw new Exception("...");
        }
    }
    
    public void recuperaLIsta() throws Exception{
        try{
            FileInputStream fis = new FileInputStream("Professores.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            lista = (ArrayList<Professor>) ois.readObject();
            ois.close();
            fis.close();
        }catch(IOException | ClassNotFoundException ioe){
            throw new Exception("...");
        }
    }
}