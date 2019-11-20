import java.lang.ref.Cleaner;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.lang.Exception;

//TODO  excepcoes
//TODO  EXCEPTIONS

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
            System.out.println("Erro a carregar/Base de dados inexistente");
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
            entrarCliente((Cliente) u, p);
            return;
        }

        if (u.getClass().getSimpleName().equals("Proprietario")) {
            opcoesProprietario((Proprietario) u, p);
            return;
        }
    }

    private static void entrarCliente(Cliente u, UMCarroJa p) throws Exception{
        Scanner input = new Scanner(System.in);
        limparEcra();

        System.out.println("(opcoesCliente)     Coordenadas onde se encontra:");
        System.out.print("(opcoesCliente)     X: ");
        int coordXI = input.nextInt();
        System.out.print("(opcoesCliente)     Y: ");
        int coordYI = input.nextInt();
        Coordenada coordI = new Coordenada(coordXI, coordYI);

        System.out.println("(opcoesCliente)     Coordenadas de destino:");
        System.out.print("(opcoesCliente)     X: ");
        int coordXF = input.nextInt();
        System.out.print("(opcoesCliente)     Y: ");
        int coordYF = input.nextInt();
        Coordenada coordF = new Coordenada(coordXF, coordYF);

        viagem(u,p,coordF,coordI);
    }

    /**
     * Permite ao cliente escolher o que quer fazer na app
     * @param u cliente
     * @param p
     * @throws Exception
     */
    private static void viagem (Cliente u, UMCarroJa p, Coordenada coordF, Coordenada coordI) throws Exception {
        Scanner input = new Scanner(System.in);
        limparEcra();
        int y = -1;
        int classi;

        Menu.menuOpcoesCliente();
        int opcao = -1;
        opcao = input.nextInt();
        while(opcao!=1 && opcao!=2 && opcao!=3 && opcao!=4 && opcao!=5 && opcao!=0) {
            System.out.println("(Viagem)     Opcao incorreta");
            opcao = input.nextInt();
        }
        if(opcao==0) return;

        Veiculo v = new Gasolina();
        switch (opcao){
            case(1):
                v = p.veiculoMaisProximo(coordF);
                break;

            case(2):
                v = p.veiculoMaisBarato();
                break;

            case(3):
                v = p.veiculoMaisBaratoPe(u);
                break;

            case(4):
                v = p.veiculoEspecifico();
                break;

            case(5):
                v = p.veiculoAutonomiaDesejada();
                break;
        }

        if(p.temAutonomia(v, coordI, coordF) == 0){
            System.out.println("Veiculo nao tem autonomia para a viagem");
            viagem(u, p, coordF, coordI);
            return;
        }
        else {
            int id = p.getIdAluguer();
            p.setIdAluguer(id + 1);

            double distancia = coordI.distancia(coordF);
            Duration duracao = Duration.ofMinutes((int)(2 * distancia));

            double custoTotal = distancia * v.getPrecokm();

            System.out.println("classificacao(0 a 5): ");
            classi = input.nextInt();

            v.setContTotal(v.getContTotal() + 1);
            v.setSoma(v.getSoma() + classi);
            v.setClassificacao(v.getSoma() / v.getContTotal());

            Proprietario propr = (Proprietario)p.getUtilizadores().get(v.getProprietario());
            propr.setContTotal(propr.getSoma() + 1);
            propr.setSoma(propr.getSoma() + classi);
            propr.setClassificacao(propr.getSoma() / propr.getContTotal());

            Aluguer al = new Aluguer(id, coordI, coordF, v, LocalDate.now(), duracao, u.getEmail(), v.getProprietario(), custoTotal, classi);

            List<Integer> l = new ArrayList<Integer>();
            if(p.getHistCli().get(u.getEmail())==null){
                l.add(id);
                p.getHistCli().put(u.getEmail(),l);
                l.clear();
            }
            else{
                p.getHistCli().get(u.getEmail()).add(id);
            }

            if(p.getHistProp().get(v.getProprietario())==null){
                l.add(id);
                p.getHistProp().put(v.getProprietario(),l);
                l.clear();
            }
            else {
                p.getHistProp().get(v.getProprietario()).add(id);
            }

            if(p.getHistVeic().get(v.getMatricula())==null){
                l.add(id);
                p.getHistProp().put(v.getMatricula(),l);
                l.clear();
            }
            else {
                p.getHistVeic().get(v.getMatricula()).add(id);
            }
            System.out.println("Bom dia");
        }
    }

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

            case(2):
                p.abastecerVeiculo(u);
                System.out.println("(opcoesProprietario)    0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
            opcoesProprietario(u,p);
                break;

            case(3):
                p.adicionarVeiculo(u);
                System.out.println("(opcoesProprietario)    0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                opcoesProprietario(u,p);
                break;

            case(4):
//                Lista de carros
                System.out.println("Numero de veiculos aqui mostrados: " + p.listaVeiculosProp(u).size() + "\n");
                for(Veiculo v : p.listaVeiculosProp(u)){
                    System.out.println(v.getClass().getSimpleName() + "--------------------");
                    System.out.println(v.toString());
                }

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
                System.out.println("Numero de utilizadores registados: " + p.listaUtilizadores().size() +"\n");

                for(Utilizador u : p.listaUtilizadores()){
                    System.out.println(u.getClass().getSimpleName() + "--------------------");
                    System.out.println(u.toString());
                }

                System.out.println("\n(opcoesAdmin)   0 - retroceder");
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

                System.out.println("\n(opcoesAdmin)   0 - retroceder");
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

                System.out.println("\n(opcoesAdmin)   0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }

                opcoesAdmin(p);
                break;

            case(4):
                //Lista todos veiculos
                System.out.println("Numero de veiculos registados: " + p.getVeiculos().size());
                System.out.println("Numero de veiculos aqui mostrados: " + p.listaVeiculos().size() + "\n");

                for(Veiculo v : p.listaVeiculos()){
                    System.out.println(v.getClass().getSimpleName() + "--------------------");
                    System.out.println(v.toString());
                }

                System.out.println("\n(opcoesAdmin)   0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }

                opcoesAdmin(p);
                break;

            case(5):
                //Lista veiculos livres
                for(Veiculo v : p.listaLivres()){
                    System.out.println(v.toString());
                }
                System.out.println("\n(opcoesAdmin)   0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                opcoesAdmin(p);
                break;

            case(6):
                //lista veiculos ocupados
                for(Veiculo v : p.listaOcupados()){
                    System.out.println(v.toString());
                }
                System.out.println("\n(opcoesAdmin)   0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                opcoesAdmin(p);
                break;

            case(7):
                //remove utilizador
                p.removeUtilizador();
                System.out.println("\n(opcoesAdmin)   0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                opcoesAdmin(p);
                break;

            case(8):
                //remove todos utilizadores
                p.removeTodosUtilizadores();
                System.out.println("\n(opcoesAdmin)   0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                opcoesAdmin(p);
                break;

            case(9):
                //remove veiculo
                p.removeVeiculo();
                System.out.println("\n(opcoesAdmin)   0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                opcoesAdmin(p);
                break;

            case(10):
                //remove todos veiculos
                p.removeTodosVeiculos();
                System.out.println("\n(opcoesAdmin)   0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                opcoesAdmin(p);
                break;

            case(11):
                //apaga base dados
                p.apagarTudo();
                System.out.println("\n(opcoesAdmin)   0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                opcoesAdmin(p);
                break;

            case(12):
//                UMCarroJa.setUtilizadores(PovoarBD.povoarClientes());
                System.out.println("\n(opcoesAdmin)   0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                opcoesAdmin(p);
                break;

            case(13):
//                UMCarroJa.setVeiculos(PovoarBD.povoarVeiculos());
                System.out.println("\n(opcoesAdmin)   0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                opcoesAdmin(p);
                break;

            case(14):
                System.out.print("1 - Utilizadores\n2 - Veiculos\n\nOpcao: ");
                int opcao = input.nextInt();
                p.escreveEmFicheiroTxt("bd", opcao);

                System.out.println("\n(opcoesAdmin)   0 - retroceder");
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

        System.out.print("Data de nascimento (dd-mm-yyyy): ");
        LocalDate datanasc = null;
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
                Cliente c = new Cliente(nome, NIF, email, password, morada, datanasc, coord);
                p.adicionaUtilizador(c.clone());
                break;
            case(2):
                double classificacao = 0.0;
                int numClass = 0;
                int total = 0;
                List<String> carros = new ArrayList<String>();
                Proprietario prop = new Proprietario(nome, NIF, email, password, morada, datanasc, classificacao, numClass, total);
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