package gdau.modelos;

public class Administrador extends Professor {
    
    private String senha;

    public Administrador(){
        this.setCodigo(1);
        this.setNome("Administrador");
        this.setSenha("quinta");
    }
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
