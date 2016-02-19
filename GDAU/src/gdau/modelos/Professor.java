package gdau.modelos;

public class Professor {
    
    public final int LIMITE = 5;
    
    private int codigo;
    private String Nome;
    private int disciplinas[] = new int[LIMITE];

    public int getCodigo() {
        return codigo;
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

    public int getDisciplina(int posicao) {
        return(disciplinas[posicao]);
    }

    public void setDisciplina(int[] disciplinas) {
        this.disciplinas = disciplinas;
    }
    
}