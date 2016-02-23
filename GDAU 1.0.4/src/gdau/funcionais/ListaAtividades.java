package gdau.funcionais;

import gdau.modelos.Atividade;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.List;

public class ListaAtividades implements Serializable {
    
    private final int MAX = 30; // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    private List<Atividade> lista = new ArrayList();
    
    public List<Atividade> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Atividade> lista) {
        this.lista = lista;
    }
    
    public int getSize(){
        return this.lista.size();
    }
    
    public Atividade getAtvd(int index){
        return this.lista.get(index);
    }
    
    public boolean verificarListaVazia() {
        return(lista.isEmpty());
    }
    
    public boolean verificarListaCheia() {
        return(lista.size() == MAX);
    }
    
    public void cadastrarAtividade(Atividade atvd) throws Exception {
        if(verificarListaCheia()) {
            throw new Exception("Limite de atividades atingido!");
        } else {
            lista.add(atvd);
        }
    }
    
    public boolean consultarExistencia(int codigo){
        for (Atividade atvd : lista) {
            if (codigo == atvd.getCodigo()) {
                return true;
            }
        }
        
        return false;
    }
    
    public void removerAtividade(int codigo) throws Exception {
        if(verificarListaVazia()) {
            throw new Exception("Não há atividades cadastradas");
        } else {
            if(consultarExistencia(codigo)) {
                lista.remove(lista.get(codigo));
                return;
            }
        }
        
        throw new Exception("Código inválido!");
    }

    public String exibirElemento(Atividade atvd) throws Exception {
        StringBuilder concat = new StringBuilder();
        
        if(lista.contains(atvd)) {
            concat.append("\n\tCÓDIGO: ")
                    .append(atvd.getCodigo())
                    .append("\n\tNOME: ")
                    .append(atvd.getNome())
                    .append(" - ENTREGA: ")
                    .append(atvd.getData())
                    .append("\n\tDESCRIÇÃO: ")
                    .append(atvd.getDescricao())
                    .append("\n\tGRAU DE DIFICULDADE: ")
                    .append(atvd.getDificuldade());
        } else {
            throw new Exception("Atividade inexistente!");
        }
        
        return concat.toString();
    }
    
    public String exibirLista() throws Exception {
        StringBuilder concat = new StringBuilder(); 
        
        if(verificarListaVazia()) {
            throw new Exception("Não há atividades cadastradas!");
        } else {
            concat.append("Lista de atividades: \n ");
               
            for(Atividade atvd : lista) {
                concat.append(exibirElemento(atvd))
                        .append("======================================\n");
            }
        }
        
        return concat.toString();
    }
    
    public String exibeNome(int index){
        return (lista.get(index).getNome());
    }
    
    public String exibeListaNomes() {
        StringBuilder msg = new StringBuilder();
        
        if(!verificarListaVazia()){
            msg.append("LISTA DE ATIVIDADES:\n");
            for(int i = 0; i < lista.size(); i++){
                msg.append(i + 1).append(" - ")
                        .append(lista.get(i).getNome()).append("\n");
            }
            msg.append("========================================");
        }else{
            msg.append("Lista vazia!");
        }
        return msg.toString();
    }
    
    public void retornaAtividade(Atividade atvd, int index){
        lista.set(index, atvd);
    }
}
