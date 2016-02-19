package gdau.modelos;

public enum ListaDiciplinas {
    
    MDS("METODOS DE DESENVOLVIMENTO DE SOFTWARE"),
    BD("BANCO DE DADOS"),
    AED("ALGORITMOS E ESTRUTURA DE DADOS"),
    ADC("ARQUITETURA DE COMPUTADORES"),
    POO("PROGRAMAÇÃO ORIENTADA A OBJETOS");
    
   
    private final String diciplina;

    private ListaDiciplinas(String diciplina) {
        this.diciplina = diciplina;
    }

    public String getDiciplina() {
        return diciplina;
    }
    
}

