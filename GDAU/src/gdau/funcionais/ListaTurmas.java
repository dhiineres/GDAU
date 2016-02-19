package gdau.funcionais;

import gdau.modelos.Turma;
import java.util.ArrayList;

public class ListaTurmas {
    private final int MAX = 100;
    private ArrayList<Turma> lista = new ArrayList();

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
    
    public void cadastrarAtividade(Turma turma) throws Exception {
        if(verificarListaCheia()) {
            throw new Exception("A lista de turmas está cheia!");
        } else {
            for(int i = 0; i < lista.size(); i++) {
                if(consultarExistencia(turma.getCodigo())) {
                    lista.add(turma);
                } else {
                    throw new Exception("Código inválido!");
                }
            }
        }
    }
    
    public boolean consultarExistencia(int codigo){
        for (Turma turma : lista) {
            if (codigo == turma.getCodigo()) {
                return true;
            }
        }
        
        return false;
    }
    
    public void removerAtividade(int codigo) throws Exception {
        if(verificarListaVazia()) {
            throw new Exception("Não há turmas cadastradas");
        } else {
            if(consultarExistencia(codigo)) {
                lista.remove(lista.get(codigo));
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
                concat.append(exibirElemento(turma))
                        .append("======================================\n");
            }
        }
        
        return concat.toString();
    }
    
}
