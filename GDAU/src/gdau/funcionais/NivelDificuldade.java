package gdau.funcionais;

public enum NivelDificuldade {
    
    FACIL(1),
    MEDIO(2),
    DIFICIL(3);
    
    private final int dificuldade;

    private NivelDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }

    public int getDificuldade() {
        return dificuldade;
    }
         
}    

