package gdau.modelos;

public class TurnoIntegral extends Turma {
    
    private final int AULAS = 8;
    
    private int[][] horario = new int[super.DIAS][AULAS];
    private int[][] disciplinas = new int[super.DIAS][AULAS];
    
    public TurnoIntegral(int codigo, int periodo, String curso) {
        super.setCodigo(codigo);
        super.setPeriodo(periodo);
        super.setCurso(curso);
    }

    public int[][] getHorario() {
        return horario;
    }

    public void setHorario(int[][] horario) {
        this.horario = horario;
    }

    public int[][] getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(int[][] disciplinas) {
        this.disciplinas = disciplinas;
    }
    
}
