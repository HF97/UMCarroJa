import java.lang.ref.Cleaner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.lang.Exception;

//TODO  excepcoes
//TODO  EXCEPTIONS
//TODO  remover password...

public class Main {

    /**
     * Carrega a base da dados, executa o programa e quando saimos do programa guarda na base de dados
     * A base de dados para ja e um ficheiro
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        UMCarroJa p = new UMCarroJa();
        //Carrega base de dados
        try{
            p = p.carregaObjetoInformacao();
        }
        catch (Exception e){
            System.out.println("Erro a carregar");
        }
        //Executa programa
        executa(p);

        try{
            p.gravaObjetoInformacao();
        }catch(Exception e){
            System.out.println("Erro a guardar");
        }
    }

    /**
     * Funcao que permite fazer o login, registo ou sair do programa
     *
     * @param p
     * @throws Exception
     */
    private static void executa (UMCarroJa p) throws Exception{
        Scanner input = new Scanner(System.in);
        int x = -1;
        limparEcra();
        Menu.menuPrincipal();
        while(x<0 || x>2){
            x = input.nextInt();
            if(x<0 || x>2){
                System.out.print("(executa)     Opção Invalida\nOpção: ");
            }
        }
        limparEcra();
        switch(x){
            case (1):
                menuEntrar(p);
                break;
            case(2):
                registarUtilizador(p);
                break;
            case(0):
                break;
        }
    }

    /**
     * Funcao para login
     * Permite diferenciar o login de um utilizador ou do administrador
     *
     * @param p
     * @throws Exception
     */
    public static void menuEntrar (UMCarroJa p) throws Exception {
        Scanner input = new Scanner(System.in);
        int x = -1;
        limparEcra();

        Menu.menuEntrar();
        while(x<0 || x>2){
            x = input.nextInt();
            if(x<0 || x>2){
                System.out.print("(menuEntrar)     Opção Invalida\nOpção: ");
            }
        }
        limparEcra();

        boolean entrar = true;

        switch(x){
            case(1):
                while(entrar) {
                    try {
                        entrarUtilizador(p);
                        entrar = false;
                        return;
                    } catch (Exception e) {
                        System.out.println("Utilizador inexistente");
                        entrarUtilizador(p);
                        return;
                    }
                }
                break;
            case(2):
                while(entrar) {
                    try {
                        entrarAdmin(p);
                        return;
                    } catch (Exception e) {
                        System.out.println("Erro login admin");
                        entrarAdmin(p);
                        return;
                    }
                }
                break;
            case(0):
                limparEcra();
                executa(p);
                break;
        }
    }

    /**
     * Funcao de login de utilizadores
     * Diferencia clientes de proprietarios e chama a respetiva funcao de login
     * @param p
     * @throws Exception
     */
    public static void entrarUtilizador (UMCarroJa p) throws Exception {
        Scanner input = new Scanner(System.in);
        limparEcra();

        System.out.println("(entrarUtilizador)      Email: ");
        String email = "";
        email = input.next();
        if(email.equals("sair")){
            menuEntrar(p);
            return;
        }

        System.out.println("(entrarUtilizador)      Password: ");
        String pass = "";
        pass = input.next();
        if(pass.equals("sair")){
            menuEntrar(p);
            return;
        }

        Utilizador u = null;
        u = p.getUtilizador(email);

        boolean f = true;
        while (!(u.getPassword().equals(pass))) {
            System.out.println("(entrarUtilizador)      Password Incorreta\nPassword:");
            pass = input.next();
            if(pass.equals("sair")){
                menuEntrar(p);
                return;
            }
        }

        System.out.println(u.getClass().getSimpleName());

//        limparEcra();

        if (u.getClass().getSimpleName().equals("Cliente")) {
            opcoesCliente((Cliente) u, p);
            return;
        }

        if (u.getClass().getSimpleName().equals("Proprietario")) {
            opcoesProprietario((Proprietario) u, p);
            return;
        }
    }

    //TODO  aluguer
    //TODO  atencao ao idaluguer quando comecar de novo

    /**
     * Permite ao cliente escolher o que quer fazer na app
     * @param u cliente
     * @param p
     * @throws Exception
     */
    private static void opcoesCliente (Cliente u, UMCarroJa p) throws Exception {
        Scanner input = new Scanner(System.in);
        limparEcra();
        int y = -1;

        Coordenada coordInicio = u.getCoord();
        System.out.println("(opcoesCliente)     Coordenadas de destino:");
        System.out.print("(opcoesCliente)     X: ");
        int coordX = input.nextInt();
        System.out.print("(opcoesCliente)     Y: ");
        int coordY = input.nextInt();
        Coordenada coordFim = new Coordenada(coordX, coordY);

        Menu.menuOpcoesCliente();
        int opcao = -1;
        while(opcao!=1 && opcao!=2 && opcao!=3 && opcao!=4 && opcao!=5) {
            System.out.println("(opcoesCliente)     Opcao incorreta");
            opcao = input.nextInt();
        }

        Veiculo v = new Gasolina();
        switch (opcao){
            case(1):
                v = p.veiculoMaisProximo(coordInicio);
                System.out.println("(opcoesCliente)     0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                opcoesCliente(u,p);
                break;

            case(2):
                v = p.veiculoMaisBarato();
                System.out.println("(opcoesCliente)     0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                opcoesCliente(u,p);
                break;

            case(3):
                v = p.veiculoMaisBaratoPe(u);
                System.out.println("(opcoesCliente)     0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                opcoesCliente(u,p);
                break;

            case(4):
                v = p.veiculoEspecifico();
                System.out.println("(opcoesCliente)     0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                opcoesCliente(u,p);
                break;

            case(5):
                v = p.veiculoAutonomiaDesejada();
                System.out.println("(opcoesCliente)     0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                opcoesCliente(u,p);
                break;
        }

        int id = p.getIdAluguer();
        p.setIdAluguer(id+1);

//        Aluguer al = new Aluguer(id, v, LocalDate.now(), duracao, u.getEmail(), v.getProprietario(), custoTotal, classificacao);
    }

    //TODO  Adicionar veiculo

    /**
     * Permite ao proprietario escolher o que fazer na app
     *
     * @param u
     * @param p proprietario
     * @throws Exception
     */
    private static void opcoesProprietario (Proprietario u, UMCarroJa p) throws Exception {
        Scanner input = new Scanner(System.in);
        limparEcra();
        int x = -1;
        int y = -1;
        Menu.menuOpcoesProprietario();
        x = input.nextInt();
        while(x!=0 && x!=1 && x!=2 && x!=3 && x!=4 && x!=5){
            System.out.println("(opcoesProprietario)    Opcao incorreta");
            x = input.nextInt();
        }

        switch(x){
            case(1):
                p.veiculoDisponivel(u);
                System.out.println("(opcoesProprietario)    0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                opcoesProprietario(u,p);
                break;

//            case(2):
//                p.abastecerVeiculo(u);
//                System.out.println("(opcoesProprietario)    0 - retroceder");
//                while(y != 0){
//                    y = input.nextInt();
//                }
//            opcoesProprietario(u,p);
//                break;

            case(3):
                p.adicionarVeiculo(u);
                System.out.println("(opcoesProprietario)    0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                opcoesProprietario(u,p);
                break;

            case(4):
//                System.out.println("dentro4");
                for(Veiculo v : p.listaCarros(u)){
                    v.toString();
//                    System.out.println("dentrociclo4");

                }
//                System.out.println("foraciclo4");

                System.out.println("(opcoesProprietario)    0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                opcoesProprietario(u,p);
                break;

            case(5):
                p.verClassificacao(u);
                System.out.println("(opcoesProprietario)    0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                opcoesProprietario(u,p);
                break;

            case(0):
                executa(p);
                break;
        }
    }

    /**
     * Funcao de login do administrador
     * A password esta predefinida sendo 12345
     * @param p
     * @throws Exception
     */
    private static void entrarAdmin (UMCarroJa p) throws Exception {
        Scanner input = new Scanner(System.in);
        int x = 0;
        limparEcra();

        if(x !=12345){
            System.out.print("(entrarAdmin)     Password (0 para retroceder): ");
            x = input.nextInt();
            if(x==0){
                menuEntrar(p);
                return;
            }
            while(x != 12345){
                System.out.print("(entrarAdmin)     Password Incorreta (0 para sair)\nPassword:");
                x = input.nextInt();
                if(x == 0){
                    menuEntrar(p);
                    return;
                }
            }
        }




        limparEcra();
        opcoesAdmin(p);
    }

    /**
     * Permite ao administrador escolher o que quer fazer na app
     *
     * @param p
     * @throws Exception
     */
    private static void opcoesAdmin (UMCarroJa p) throws Exception {
        Scanner input = new Scanner(System.in);
        limparEcra();
        int x = -1;
        int y = -1;

        Menu.menuOpcoesAdmin();
        x = input.nextInt();
        while(!(x>=0 && x<=14)){
            System.out.println("(opcoesAdmin)   Opcao incorreta");
            System.out.print("(opcoesAdmin)   Opcão: ");
            x = input.nextInt();
        }

        switch(x){
            case(1):
                for(Utilizador u : p.listaUtilizadores()){
                    System.out.println(u.getClass().getSimpleName() + "--------------------");
                    System.out.println(u.toString());
                }

                System.out.println("(opcoesAdmin)   0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }

                opcoesAdmin(p);
                break;

            case(2):
                //lista de clientes
                for(Utilizador u : p.listaUtilizadores()){
                    if(u.getClass().getSimpleName().equals("Cliente")){
                        System.out.println(u.getClass().getSimpleName() + "-----------------------");
                        System.out.println(u.toString());
                    }
                }

                System.out.println("(opcoesAdmin)   0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }

                opcoesAdmin(p);
                break;

            case(3):
                //lista de proprietarios
                for(Utilizador u : p.listaUtilizadores()){
                    if(u.getClass().getSimpleName().equals("Proprietario")){
                        System.out.println(u.getClass().getSimpleName() + "-----------------------");
                        System.out.println(u.toString());
                    }
                }

                System.out.println("(opcoesAdmin)   0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }

                opcoesAdmin(p);
                break;

            case(4):
                System.out.println("Numero de veiculos registados: " + p.getVeiculos().size());
                System.out.println("Numero de veiculos aqui mostrados: " + p.listaVeiculos().size());

                for(Veiculo v : p.listaVeiculos()){
                    System.out.println(v.toString());
                }

                System.out.println("(opcoesAdmin)   0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }

                opcoesAdmin(p);
                break;

            case(5):
                for(Veiculo v : p.listaLivres()){
                    System.out.println(v.toString());
                }
                System.out.println("(opcoesAdmin)   0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                opcoesAdmin(p);
                break;

            case(6):
                for(Veiculo v : p.listaOcupados()){
                    System.out.println(v.toString());
                }
                System.out.println("(opcoesAdmin)   0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                opcoesAdmin(p);
                break;

            case(7):
                p.removeUtilizador();
                System.out.println("(opcoesAdmin)   0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                opcoesAdmin(p);
                break;

            case(8):
                p.removeTodosUtilizadores();
                System.out.println("(opcoesAdmin)   0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                opcoesAdmin(p);
                break;

            case(9):
                p.removeVeiculo();
                System.out.println("(opcoesAdmin)   0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                opcoesAdmin(p);
                break;

            case(10):
                p.removeTodosVeiculos();
                System.out.println("(opcoesAdmin)   0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                opcoesAdmin(p);
                break;

            case(11):
                p.apagarTudo();
                System.out.println("(opcoesAdmin)   0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                opcoesAdmin(p);
                break;

            case(12):
//                UMCarroJa.setUtilizadores(PovoarBD.povoarClientes());
                opcoesAdmin(p);

            case(13):
//                UMCarroJa.setVeiculos(PovoarBD.povoarVeiculos());
                System.out.println("(opcoesAdmin)   0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                opcoesAdmin(p);
                break;

                //TODO  meter funcao a funcionar, apenas imprime titulo
            case(14):
                System.out.print("1 - Clientes\n2 - Proprietarios\n3 - Veiculos\n\nOpcao: ");
                int opcao = input.nextInt();
                p.escreveEmFicheiroTxt("bd" ,opcao);
                System.out.println("(opcoesAdmin)   0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                opcoesAdmin(p);
                break;

            case(0):
                executa(p);
                break;
        }
    }

    /**
     * Permite registar utilizadores, sejam clientes ou proprietarios
     *
     * @param p
     * @throws Exception
     */
    //TODO  se meter NIF invalido da exception NIF ou password errado
    private static void registarUtilizador (UMCarroJa p) throws Exception {
        Scanner input = new Scanner(System.in);
        limparEcra();
        Menu.menuRegistar();
        int x = input.nextInt();
        if(x == 0){
            executa(p);
            return;
        }
        while(x!=1 && x!=2){
            System.out.print("Opção errada!\nOpção: ");
            x = input.nextInt();
        }
        limparEcra();
        System.out.print("Email: ");
        String email = input.next();

        System.out.print("Password: ");
        String password = input.next();

        System.out.print("Nome: ");
        String nome = input.next();

        System.out.print("NIF: ");
        int NIF = input.nextInt();

        input.nextLine(); //para receber o \n

        System.out.print("Morada:" );
        String morada = input.nextLine();

        System.out.print("Data de nascimento (dd-mm-yyyy: ");
        LocalDate datanasc = null;
        List<Integer> histAlugUti = new ArrayList<Integer>();
        boolean f = true;
        do{
            try{
                String dataDespesaInput = input.next();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                datanasc = LocalDate.parse(dataDespesaInput, formatter);
                f=false;
            }
            catch(Exception e){System.out.print("Data invalida. (dd-mm-yyyy)");}
        }while(f);

        switch (x){
            case(1):
                Coordenada coord = new Coordenada();
                Cliente c = new Cliente(nome, NIF, email, password, morada, datanasc, coord, histAlugUti);
                p.adicionaUtilizador(c.clone());
                break;
            case(2):
                int classificacao = 0;
                List<String> carros = new ArrayList<String>();
                Proprietario prop = new Proprietario(nome, NIF, email, password, morada, datanasc, classificacao, histAlugUti, carros);
                p.adicionaUtilizador(prop.clone());
                break;
        }
        executa(p);
        return;
    }

    /**
     * Limpa o ecra
     */
    private static void limparEcra(){
        System.out.print('\f');
    }
}