package gdau.funcionais;

import gdau.modelos.Professor;
import java.util.ArrayList;

public class ListaProfessores {
    
    private final int MAX = 100;
    private ArrayList<Professor> lista = new ArrayList();

    public ArrayList<Professor> getLista() {
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
    
    public void cadastrarProfessor(Professor prof) throws Exception {
        if(verificarListaCheia()) {
            throw new Exception("A lista de professores está cheia!");
        } else {
            for(int i = 0; i < lista.size(); i++) {
                if(consultarExistencia(prof.getCodigo())) {
                    lista.add(prof);
                } else {
                    throw new Exception("Código inválido!");
                }
            }
        }
    }
    
    public boolean consultarExistencia(int codigo){
        for (Professor prof : lista) {
            if (codigo == prof.getCodigo()) {
                return true;
            }
        }
        
        return false;
    }
    
    public void removerProfessor(int codigo) throws Exception {
        if(verificarListaVazia()) {
            throw new Exception("Não há professores cadastrados");
        } else {
            if(consultarExistencia(codigo)) {
                lista.remove(lista.get(codigo));
                return;
            }
        }
        
        throw new Exception("Código inválido!");
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
    
    public String exibirLista() throws Exception {
        StringBuilder concat = new StringBuilder(); 
        
        if(verificarListaVazia()) {
            throw new Exception("Não há professores cadastrados!");
        } else {
            concat.append("Lista de professores operantes: \n ");
               
            for(Professor prof : lista) {
                concat.append(exibirElemento(prof))
                        .append("======================================\n");
            }
        }
        
        return concat.toString();
    }
    
}