package gdau;

import gdau.funcionais.ListaAtividades;
import gdau.funcionais.ListaProfessores;
import gdau.funcionais.ListaTurmas;
import gdau.modelos.Administrador;
import gdau.modelos.Atividade;
import gdau.funcionais.ListaDiciplinas;
import gdau.funcionais.NivelDificuldade;
import gdau.modelos.Professor;
import gdau.modelos.Turma;
import gdau.modelos.TurnoIntegral;
import gdau.modelos.TurnoSimples;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {
    
    public static Scanner input = new Scanner(System.in);
    public static ListaAtividades listAtvd = new ListaAtividades();
    public static ListaProfessores listProf = new ListaProfessores();
    public static ListaTurmas listTurma = new ListaTurmas();
    
    public static void main(String[] args) {
        
        Professor adm = new Administrador();
        
        if(listProf.verificarListaVazia()) {
            cadastrarAdmin((Administrador) adm);
        }
        
        int opcao;
        
        do {
            System.out.print(menuInicial());
            opcao = Integer.parseInt(input.nextLine());

            switch(opcao) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 0:
                    System.out.println("Aplicação finalizada com êxito!");
                    break;

                default:
                    System.out.println(" Entrada Inválida!");
            }
        } while(opcao > 0);
        
    }
    
    public static String menuInicial() {
        return(""
            + " ================= MENU ================\n"
            + "|      1. ENTRAR COMO PROFESSOR         |\n"
            + "|      2. ENTRAR COMO ADMINISTRADOR     |\n"
            + "|      0. SAIR                          |\n"
            + " =======================================\n\n"
            + " Digite o número da opção escolhida: ");
    }
    
    public static String menuAtividade() {
        return(""
            + " =======================================\n"
            + "|      1. CADASTRAR NOVA ATIVIDADE      |\n"
            + "|      2. EDITAR ATIVIDADE              |\n"
            + "|      3. REMOVER ATIVIDADE             |\n"
            + "|      4. LISTAR ATIVIDADES             |\n"
            + "|      0. VOLTAR                        |\n"
            + " =======================================\n\n"
            + " Digite o número da opção escolhida: ");
    }
    
    public static String menuProfessor() {
        return(""
            + " =======================================\n"
            + "|      1. CADASTRAR NOVO PROFESSOR      |\n"
            + "|      2. EDITAR DADOS DO PROFESSOR     |\n"
            + "|      3. REMOVER PROFESSOR             |\n"
            + "|      4. LISTAR PROFESSORES OPERANTES  |\n"
            + "|      0. VOLTAR                        |\n"
            + " =======================================\n\n"
            + " Digite o número da opção escolhida: ");
    }
    
    public static String menuTurma() {
        return(""
            + " =======================================\n"
            + "|      1. CADASTRAR NOVA TURMA          |\n"
            + "|      2. EDITAR DADOS DA TURMA         |\n"
            + "|      3. REMOVER TURMA                 |\n"
            + "|      4. LISTAR TURMAS ATUAIS          |\n"
            + "|      0. VOLTAR                        |\n"
            + " =======================================\n\n"
            + " Digite o número da opção escolhida: ");
    }
    
    public static String menuAdministrador() {
        return(""
            + " =======================================\n"
            + "|      1. MENU DE ATIVIDADES            |\n"
            + "|      2. MENU DE PROFESSORES           |\n"
            + "|      3. MENU DE TURMAS                |\n"
            + "|      0. VOLTAR                        |\n"
            + " =======================================\n\n"
            + " Digite o número da opção escolhida: ");
    }
    
    public static void cadastrarAdmin(Administrador adm) {
        lerProfessor(adm);
        adm.setSenha("trololo1234");
    }
    
    public static void lerProfessor(Professor prof) {
        int codigo;
        boolean valido = false;
        
        do {
            System.out.print(""
                    + "==================== CADASTRO ====================\n"
                    + " Nome: ");
            prof.setNome(input.nextLine());
            System.out.print(" Código: ");
            codigo = Integer.parseInt(input.nextLine());

            if(codigo > 0) {
                prof.setCodigo(codigo);
            }

            System.out.println(""
                    + "==================================================\n");

            try {
                listProf.cadastrarProfessor(prof);
                valido = true;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } while(valido == false);
    }
    
    public static void lerAtividade(Atividade porf) {
        int dia, mes, ano;
        int codigoTurma;
        String descricao;
        String nome;
        int codigo, codProfessor, dificuldade;
        
        boolean valido = false;
        
        do {
            System.out.print(""
                    + "==================== CADASTRO ====================\n"
                    + " Nome: ");
            
            
            System.out.println(""
                    + "==================================================\n");
        } while(valido == false);
    }
    
    public static void abrirFuncoesProf() {
        int opcao;
        
        do {
            System.out.print(menuInicial());
            opcao = Integer.parseInt(input.nextLine());
            
            switch(opcao) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 0:
                    
                    break;
                    
                default:
                    
            }
        } while(opcao > 0);
    }
    
    public static void abrirFuncoesAdmin() {
        // blablabla
    }
    
}