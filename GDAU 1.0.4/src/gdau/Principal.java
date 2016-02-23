package gdau;

import gdau.funcionais.Verificadores;
import gdau.funcionais.ListaAtividades;
import gdau.funcionais.ListaProfessores;
import gdau.funcionais.ListaTurmas;
import gdau.modelos.Administrador;
import gdau.modelos.Atividade;
import gdau.modelos.Professor;
import gdau.modelos.Turma;

import java.util.Scanner;

public class Principal {
    
    public static Scanner input = new Scanner(System.in);
    public static ListaAtividades listAtvd = new ListaAtividades();
    public static ListaProfessores listProf = new ListaProfessores();
    public static ListaTurmas listTurma = new ListaTurmas();
    
    public static void main(String[] args) {
        
        boolean verify;
        Professor adm = new Administrador();
        Professor usuario;
        adm.setAdm(true);
        
//        try{
//            listProf.recuperaLIsta();
//        }catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }try{
//            listTurma.recuperaLIsta();
//        }catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }

        
        if(listProf.verificarListaVazia()){
            try{
                listProf.cadastrarProfessor(adm); 
             }catch(Exception ex){
                 System.out.println(ex.getMessage());
             }
        }
        
        
        
        int opcao;
        
        do {
            System.out.print(menuInicial());
            opcao = Integer.parseInt(input.nextLine());

            switch(opcao) {
                case 1:
                    usuario = validaSenhaProf(listProf);
                    if (usuario != null){
                        System.out.println("Bem vindo, "+ usuario.getNome());
                        acessaAtvdTurma(listTurma, usuario);
                    }else{
                        System.out.println("USUÁRIO OU SENHA INVÁLIDOS!");
                    }
                    break;
                case 2:
                    verify = validaSenhaAdmin(adm);
                    if (verify){
                        System.out.println("Bem vindo, administrador");
                        abrirFuncoesAdmin(adm);
                    }else{
                        System.out.println("SENHA INVÁLIDA!");
                    }
                    break;
                case 0:
                    try{
                        listProf.salvaLista();
                    }catch(Exception ex){
                        System.out.println(ex.getMessage());
                    }try{
                        listTurma.salvaLista();
                    }catch(Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    System.out.println("Aplicação finalizada com êxito!");
                    break;

                default:
                    System.out.println(" Entrada Inválida!");
            }
            limpaTela(3);
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
    
    public static String menuAlteraProf(){
        return(""
            + " =======================================\n"
            + "|      1. ALTERAR NOME                  |\n"
            + "|      2. ALTERAR SENHA                 |\n"
            + "|      3. ADICIONAR DISCIPLINA          |\n"
            + "|      4. REMOVER DISCIPLINA            |\n"
            + "|      5. CONFIRMAR ALTERAÇÕES          |\n"
            + "|      0. CANCELAR                      |\n"
            + " =======================================\n\n"
            + " Digite o número da opção escolhida: ");
    }
    
    public static String menuAlteraTurma(){
        return(""
            + " =======================================\n"
            + "|      1. ALTERAR CURSO                 |\n"
            + "|      2. ALTERAR PERIODO               |\n"
            + "|      3. CONFIRMAR                     |\n"
            + "|      0. CANCELAR                      |\n"
            + " =======================================\n\n"
            + " Digite o número da opção escolhida: ");
    }
    
    public static String menuAlteraAtvd(){
        return(""
            + " =======================================\n"
            + "|      1. ALTERAR NOME                  |\n"
            + "|      2. ALTERAR DESCRIÇÃO             |\n"
            + "|      3. ALTERAR DATA                  |\n"
            + "|      4. ALTERAR DIFICULDADE           |\n"
            + "|      5. CONFIRMAR ALTERAÇÕES          |\n"
            + "|      0. CANCELAR                      |\n"
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
            + "|      4. ACESSA LISTA DE PROFESSORES   |\n"
            + "|      0. VOLTAR                        |\n"
            + " =======================================\n\n"
            + " Digite o número da opção escolhida: ");
    }
    
    public static void cadastrarTurma(ListaTurmas lista){
        int opcao;
        int ano;
        Turma aux = new Turma();
        Turma turma = new Turma();
        
         System.out.print(""
                    + "==================== CADASTRO ====================\n"
                    + " Período: ");
         turma.setPeriodo(Integer.parseInt(input.nextLine()));
         System.out.print("Curso: ");
         turma.setCurso(input.nextLine());
         System.out.print("Ano: ");
         ano = Integer.parseInt(input.nextLine());
         if (!lista.verificarListaVazia()){
            aux = lista.getTurma(lista.getSize() - 1);
        }else{
            aux.setCodigo((ano * 1000) + 0);
        }
         aux.setCodigo(ano * 1000 + (aux.getCodigo()% 1000
                 ));
         turma.setCodigo(aux.getCodigo() + 1);
         System.out.println(""
                    + "==================================================\n");
         
         System.out.println(turma.getDados());
         System.out.println("Confirma?\n\t1. Sim;\n\t2. Não.");
         System.out.print("Opção: ");
         opcao = Integer.parseInt(input.nextLine());
         
         if (opcao == 1){
             try{
                 lista.cadastrarTurma(turma);
             }catch(Exception ex){
                 System.out.println(ex.getMessage());
             }
         }else{
             System.out.println("Cadastro Cancelado");
         }
    }
    
    public static void cadastrarAdmin(Administrador adm) {
        listProf.cadastrarProfessor(adm);
    }
    
    public static void acessaAtvdTurma(ListaTurmas lista, Professor prof){
        Turma turma;
        int codigo;
        int teste;
        try{
            System.out.println(lista.exibirLista());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        if(!lista.verificarListaVazia()){
            System.out.println("Entre com o código da turma a ser acessada:");
            System.out.print("Código: ");
            codigo = Integer.parseInt(input.nextLine());
            teste = lista.getIndex(codigo);
            if(teste >= 0){
                turma = lista.getTurma(teste);
                abrirFuncoesAtvd(turma, prof);
            }else{
                System.out.println("Código não encontrado!");
            }
            
        }else{
            System.out.println("Não é possivel acessar o menu de atividades\n"
                               +"   Cadastre uma turma previamente");
        }
    }
    
    public static void lerProfessor() {
        Professor prof = new Professor();
        Professor aux = new Professor();
        int op;
        String senha;
        
        System.out.print(""
                + "==================== CADASTRO ====================\n"
                + " Nome: ");
        prof.setNome(input.nextLine());
        System.out.print(" Senha: ");
        senha = input.nextLine();
        prof.setSenha(senha);

        if(!listProf.verificarListaVazia()){
            aux = (listProf.getProfessor(listProf.getSize()-1));
        }else{
            aux.setCodigo(0);
        }
        
        prof.setCodigo(aux.getCodigo()+1);

        System.out.println(""
                + "==================================================\n");
        
        System.out.println(prof.getDadosAdm());
        System.out.println("Confirma?\n\t1.Sim\n\t2.Não");
        System.out.print(" - ");
        op = Integer.parseInt(input.nextLine());
        if(op == 1){
            listProf.cadastrarProfessor(prof);
        }
    }
    
    // ok
    public static void alteraProfessor(ListaProfessores lista){
        Professor prof, aux;
        int codigo, opcao, in;
        int index;
        String entrada;
        System.out.println("Entre com o código do professor a ser alterado:");
        codigo = Integer.parseInt(input.nextLine());
        index = lista.getIndexProf(codigo);
        if (index >= 0&& index < lista.getSize()){
            prof = lista.getProfessor(index);
            aux = prof;
            do{
                System.out.println(prof.getDadosAdm()+"\n");
                System.out.println(menuAlteraProf());
                opcao = Integer.parseInt(input.nextLine());
                
                switch(opcao){
                    case 1:
                        System.out.println("Entre com o novo nome:");
                        entrada = input.nextLine();
                        prof.setNome(entrada);
                        break;
                    case 2:
                       System.out.println("Entra com a nova senha:");
                       entrada = input.nextLine();
                       prof.setSenha(entrada);
                       break;
                    case 3:
                        System.out.println("Entre com a nova disciplina: ");
                        entrada = input.nextLine();
                        try{
                            prof.setDisciplina(entrada);
                        }catch(Exception ex){
                            System.out.println(ex.getMessage());
                        }                        
                        break;
                    case 4:
                        entrada = prof.getDisciplinas();
                        System.out.println(entrada);
                        if(!(entrada.equals("Lista vazia!"))){
                            System.out.println("Entre com o índice da disciplina"
                                    + "a ser removida: ");
                            in = Integer.parseInt(input.nextLine());
                            if(in > 0 && in <= prof.getQtdDisciplinas()){
                                prof.removeDisciplina(in - 1);
                            }else{
                                System.out.println("Entrada inválida!");
                            }
                        }
                        break;
                    case 5:
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Entrada inválida!");
                        
                }
                limpaTela(3);
            }while (opcao != 0 && opcao != 5);
            
            if(opcao == 0){
                lista.retornaProfessor(aux, index);
            }else{
                lista.retornaProfessor(prof, index);
            }
        }else{
            System.out.println("Código inexistente!");
        }
    }
    
    public static void alteraAtividade(ListaAtividades lista){
        Verificadores verifica = new Verificadores();
        Atividade atvd, aux;
        int opcao, in;
        int dia, mes, ano;
        int index;
        String entrada;
        String teste;
        System.out.println(lista.exibeListaNomes());
        teste = lista.exibeListaNomes();
        if(!(teste.equals("Lista vazia!"))){
            System.out.println("Entre com o índice da atividade a ser alterada:");
            index = Integer.parseInt(input.nextLine());
            if (index > 0 && index <= lista.getSize()){
                atvd = lista.getAtvd(index - 1);
                aux = atvd;

                do{
                    System.out.println(atvd.getDados());
                    System.out.println(menuAlteraAtvd());
                    opcao = Integer.parseInt(input.nextLine());

                    switch(opcao){
                        case 1:
                            System.out.println("Entre com o novo nome:");
                            entrada = input.nextLine();
                            atvd.setNome(entrada);
                            break;
                        case 2:
                           System.out.println("Entra com a nova descrição:");
                           entrada = input.nextLine();
                           atvd.setDescricao(entrada);
                           break;
                        case 3:
                            System.out.println("Entre com a nova data: ");
                            System.out.print("Dia: ");
                            dia = Integer.parseInt(input.nextLine());
                            System.out.print("Mês: ");
                            mes = Integer.parseInt(input.nextLine());
                            System.out.print("Ano: ");
                            ano = Integer.parseInt(input.nextLine());
                            
                            if(verifica.verificaData(dia, mes, ano)){
                                atvd.setData(dia, mes, ano);
                            }else{
                                System.out.println("Data inválida!");
                            }                       
                            break;
                        case 4:
                            System.out.println("Entre com a nova dificuldade:");
                            in = Integer.parseInt(input.nextLine());
                            atvd.setDificuldade(in);
                            break;
                        case 5:
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Entrada inválida!");

                    }
                    limpaTela(3);
                }while (opcao != 0 && opcao != 5);

                if(opcao == 0){
                    lista.retornaAtividade(aux, index - 1);
                }else{
                    lista.retornaAtividade(atvd, index - 1 );
                }
            }   
            
        }
    }
    
    public static void removeProfessor(ListaProfessores lista){
        Professor prof;
        int opcao, codigo;
        int index;
        boolean adm;
        System.out.println("Entre com o código do professor a ser removido:");
        codigo = Integer.parseInt(input.nextLine());
        index = lista.getIndexProf(codigo);
        adm = lista.getProfessor(index).isAdm();
        if ((index >= 0) && adm == false) {
            prof = lista.getProfessor(index);
            System.out.println(prof.getDadosStd());
            System.out.println("Confirmar remoção:\n\t1. Sim\n\t2. Não");
            opcao = Integer.parseInt(input.nextLine());
            
            if(opcao == 1){
                try{
                    lista.removerProfessor(codigo);
                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
                
            }else{
                System.out.println("Remoção cancelada!");
            }
        }else{
            if(adm) {
                System.out.println("O administrador não pode ser removido!");
            } else {
                System.out.println("Código inexistente!");
            }
        }
    }
    
    public static void removeAtividade(ListaAtividades lista){
        Atividade atvd;
        int opcao;
        int index;
        String teste;
        System.out.println(lista.exibeListaNomes());
        teste = lista.exibeListaNomes();
        if(!(teste.equals("Lista vazia!"))){
            System.out.println("Entre com o índice da atividade a ser alterada:");
            index = Integer.parseInt(input.nextLine());
            if (index > 0 && index <= lista.getSize()){
                atvd = lista.getAtvd(index - 1);

                System.out.println(atvd.getDados());
                System.out.println("Confirmar Remoção: \n\t1. Sim; 2. Não.");
                System.out.print(" - ");
                opcao = Integer.parseInt(input.nextLine());
                switch (opcao) {
                    case 1:
                        try{
                            lista.removerAtividade(atvd.getCodigo());
                        }catch(Exception ex){
                            System.out.println(ex.getMessage());
                        }   break;
                    case 2:
                        System.out.println("Remoção cancelada!");
                        break;
                    default:
                        System.out.println("Entrada inválida!");
                        break;
                }
            }else{
                System.out.println("Índice não encontrado!");
            }
        }
    }
    
    public static void lerAtividade(Turma turma, Professor prof) {
        Atividade atvd = new Atividade();
        int opcao;
        Atividade aux = new Atividade();
        ListaAtividades lista;
        int dia, mes, ano;

        
        lista = turma.getLista();
        
        if(!lista.verificarListaVazia()){
            aux = lista.getAtvd(lista.getSize() - 1);
        }else{
            aux.setCodigo(0);
        }
        
        boolean valido = false;
        
        do {
            System.out.print(""
                    + "==================== CADASTRO ====================\n"
                    + " Nome: ");
            atvd.setNome(input.nextLine());
            System.out.println(" Descrição: ");
            atvd.setDescricao(input.nextLine());
            System.out.println(" Dificuldade (1-3): ");
            atvd.setDificuldade(Integer.parseInt(input.nextLine()));
            System.out.println(" Data de entrega: ");
            System.out.print("Dia: ");
            dia = Integer.parseInt(input.nextLine());
            System.out.print("Mes: ");
            mes = Integer.parseInt(input.nextLine());
            System.out.print("Ano: ");
            ano = Integer.parseInt(input.nextLine()); 
            atvd.setData(dia, mes, ano);
            
            atvd.setCodigo(aux.getCodigo() + 1);
            atvd.setCodProfessor(prof.getCodigo());
            atvd.setCodigoTurma(turma.getCodigo());
            
            System.out.println(""
                    + "==================================================\n");
            
            System.out.println(atvd.getDados());
            System.out.println("Confirma: \n\t 1. Sim;\n\t2. Não.");
            System.out.print(" - ");
            opcao = Integer.parseInt(input.nextLine());
            if(opcao == 1){
                valido = true;
            }
            limpaTela(3);
        } while(valido == false);
        if (!turma.getLista().verificarListaCheia()){
            turma.addLista(atvd);
        }else{
            System.out.println("A lista de atividades já se encontra lotada!");
        }
        
    }
    
    public static Professor validaSenhaProf(ListaProfessores lista){
        int cod;
        String senha;
        int index;
        Professor prof;
        
        System.out.println("Entre com o código de Professor:");
        
        try {
            cod = Integer.parseInt(input.nextLine());
            index = lista.getIndexProf(cod);
            
            if(index >= 0){
                System.out.println("Entre com a senha do Professor:");
                senha = (input.nextLine());
                prof = lista.getProfessor(lista.getIndexProf(cod));
                if(prof.getSenha().equals(senha)){
                    return prof;
                }else{
                    return null;
                }
            }
        } catch(Exception ex) {
            System.out.println("Entrada inválida!");
        }
        
        return null;
    }
    
    public static boolean validaSenhaAdmin(Professor adm){
        String senha;
        System.out.println("Entre com a senha do administrador:");
        System.out.print("Senha: ");
        senha = input.nextLine();
        return senha.equals(adm.getSenha());
    }
    
    public static void abrirFuncoesAtvd(Turma turma, Professor prof){
        int opc;
        do{
            System.out.println(menuAtividade());
            opc = Integer.parseInt(input.nextLine());
            
            switch(opc){
                case 1:
                    lerAtividade(turma, prof);
                    break;
                case 2:
                    alteraAtividade(turma.getLista());
                    break;
                case 3:
                    removeAtividade(turma.getLista());
                    break; 
                case 4:
                    try{
                        System.out.println(turma.getLista().exibirLista());
                    }catch(Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                default:
                    System.out.println("Entrada Inválida!");
            }
            limpaTela(3);
        }while(opc != 0);
    }
    
    public static void abrirFuncoesProf(Professor prof) {
        Professor aux = new Professor();
        int opcao;
        
        do {
            System.out.print(menuProfessor());
            opcao = Integer.parseInt(input.nextLine());
            
            switch(opcao) {
                case 1:
                    lerProfessor();
                    break;
                case 2:
                    alteraProfessor(listProf);
                    break;
                case 3:
                    removeProfessor(listProf);
                    break;
                case 4:
                    System.out.println(listProf.exibirLista());
                    break;
                case 0:
                    try{
                        listProf.salvaLista();
                    }catch(Exception ex){
                        System.out.println(ex.getMessage());
                    }try{
                        listTurma.salvaLista();
                    }catch(Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                default:
                    System.out.println("Entrada inválida!");
            }
            limpaTela(3);
        } while(opcao > 0);
        
    }
    
    public static void abrirFuncoesTurma(ListaTurmas lista){
        Turma turma;
        int opc;
        
        do{
            System.out.println(menuTurma());
            opc = Integer.parseInt(input.nextLine());
            switch (opc){
                case 1:
                    cadastrarTurma(lista);
                    break;
                case 2:
                    alteraTurma(lista);
                    break;
                case 3:
                    removeTurma(lista);
                    break;
                case 4:
                    try{
                        System.out.println(lista.exibirLista());
                    }catch(Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    
                    break;
                case 0:
                    break;
                    
                default:
                    System.out.println("Entrada inválida!");
            }
            limpaTela(3);
        }while (opc != 0);
    }
    
    public static void abrirFuncoesAdmin(Professor prof) {
        int opc;
        do{
            System.out.println(menuAdministrador());
            opc = Integer.parseInt(input.nextLine());
            
            switch(opc){
                case 1:
                    acessaAtvdTurma(listTurma, prof);
                    break;
                case 2:
                    abrirFuncoesProf(prof);
                    break;
                case 3:
                    abrirFuncoesTurma(listTurma);
                    break;
                case 4:
                    System.out.println(listProf.exibirListaAdm());
                    break;
                case 0:
                    try{
                        listProf.salvaLista();
                    }catch(Exception ex){
                        System.out.println(ex.getMessage());
                    }try{
                        listTurma.salvaLista();
                    }catch(Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                default:
                    System.out.println("Entrada inválida!");
                    break;
            }
            limpaTela(3);
        }while (opc != 0);
    }    
    
    
    
    public static void limpaTela(int linhas){
        for(int i = 0; i <= linhas; i++){
            System.out.println("");
        }
    }

    public static void alteraTurma(ListaTurmas lista) {
        String teste, entrada;
        Turma turma, aux;
        int index, opc, periodo;
        if(!lista.verificarListaVazia()){
            
            teste = (lista.exibeIndice());
            System.out.println(teste);
            if(!(teste.equals("Lista vazia!"))){
                System.out.println("Entre com o índice da turma a ser alterada: ");
                System.out.print("Índice: ");
                index = Integer.parseInt(input.nextLine());
                if(index > 0 && index <= lista.getSize()){
                    turma = lista.getTurma(index - 1);
                    aux = turma;
                    try{
                        lista.removerTurma(turma);
                    }catch(Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    
                    do{
                        System.out.println(turma.getDados());
                        System.out.println(menuAlteraTurma());
                        opc = Integer.parseInt(input.nextLine());
                        
                        switch (opc) {
                            case 1:
                                System.out.println("Entre com o novo curso");
                                entrada = input.nextLine();
                                turma.setCurso(entrada);
                                break;
                            case 2:
                                System.out.println("Entre com o novo período");
                                periodo = Integer.parseInt(input.nextLine());
                                turma.setPeriodo(periodo);
                                break;
                            case 3:
                                break;  
                            case 0:
                                break;
                            default:
                                System.out.println("Entrada inválida!");
                        }
                    }while (opc != 0 && opc != 3);
                    
                    if(opc == 0){
                        lista.retornaTurma(index - 1, aux);
                        
                    }else{
                        lista.retornaTurma(index - 1, turma);
                    }
                    
                }else{
                    System.out.println("Índice indisponível!");
                }
            }
        }else{
            System.out.println("Não há turmas cadastradas!");
        }
    }

    private static void removeTurma(ListaTurmas lista) {
        int codigo, index;
        if(!lista.verificarListaVazia()){
            try{
                System.out.println(lista.exibirLista());
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            
            System.out.println("Entre com o código da turma a ser removida: ");
            codigo = Integer.parseInt(input.nextLine());
            
            index = lista.getIndex(codigo);
            try{
                lista.removerTurma(lista.getTurma(index));
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        
    }        
    
}