import java.lang.ref.Cleaner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Exception;

//TODO  excepcoes, ver se deixar ou remover break
//TODO  funcao para retroceder

public class Main {

    public static void main(String[] args) throws Exception{
        UMCarroJa p = new UMCarroJa();
        try{
            p = p.carregaObjetoInformacao();
        }
        catch (Exception e){
            System.out.println("Erro a carregar");
        }
        executa(p);
        try{
            p.gravaObjetoInformacao();
        }catch(Exception e){
            System.out.println("Erro a guardar");
        }
    }

    //TODO  passar as duas para uma funcao so
    private static void executa (UMCarroJa p) throws Exception{
        Scanner input = new Scanner(System.in);
        int x = -1;
        limparEcra();
        Menu.menuPrincipal();
        while(x!=0 && x!=1 && x!=2){
            x = input.nextInt();
            if(x!=0 && x!=1 && x!=2){
                System.out.print("Opção Invalida\nOpção: ");
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

    //TODO  passar as duas para uma funcao so
    public static void menuEntrar (UMCarroJa p) throws Exception {
        Scanner input = new Scanner(System.in);
        int x = -1;
        limparEcra();
        Menu.menuEntrar();
        while(x!=0 && x!=1 && x!=2){
            x = input.nextInt();
            if(x!=0 && x!=1 && x!=2){
                System.out.print("Opção Invalida\nOpção: ");
            }
        }
        limparEcra();
        switch(x){
            case(1):
                try{
                    entrarUtilizador(p);
                }
                catch (Exception e){
                    //TODO  a funcao pode falhar e nao ser problema do nif ou pass
                    System.out.println("NIF ou Password errado(a).");
                    entrarUtilizador(p);
                }
                break;
            case(2):
                try{
                    entrarAdmin(p);
                }
                catch (Exception e){
                    System.out.println("Password errada.");
                    entrarAdmin(p);
                }
                break;
            case(0):
                limparEcra();
                executa(p);
                break;
        }
    }

    //TODO  retroceder
    public static void entrarUtilizador (UMCarroJa p) throws Exception {
        Scanner input = new Scanner(System.in);
        limparEcra();
        System.out.println("0 - Retroceder");
        System.out.println("Email: ");
        String email = "";
        Utilizador u = null;
        email = input.next();
        u = p.getUtilizador(email);
        System.out.println(u);
        System.out.println("Password: ");
        String pass = "";
        pass = input.next();
        while (!(u.getPassword().equals(pass))) {
            System.out.println("Password Incorreta\nPassword:");
            pass = input.next();
        }
        limparEcra();
        if (u.getClass().getSimpleName().equals("Cliente")) {
            opcoesCliente((Cliente) u, p);
        }
        if (u.getClass().getSimpleName().equals("Proprietario")) {
            opcoesProprietario((Proprietario) u, p);
        }
    }

    //TODO  acabar funcaoCliente
    private static void opcoesCliente (Cliente u, UMCarroJa p) throws Exception {
        Scanner input = new Scanner(System.in);
        limparEcra();
        int x = -1;
        int y = -1;
        Menu.menuOpcoesCliente();
        x = input.nextInt();
        Coordenada coordInicio = u.getCoord();
        System.out.println("Coordenadas de destino:");
        System.out.print("X: ");
        int x = input.nextInt();
        System.out.print(" Y: ");
        int y = input.nextInt();
        Coordenada coordFim = new Coordenada(x,y);
        Menu.menuOpcoesCliente();
        int opcao = -1;
        while(opcao!=1 && opcao!=2 && opcao!=3 && opcao!=4 && opcao!=5){
            System.out.println("Opcao incorreta");
            opcao = input.nextInt();
        Veiculo v = new Gasolina();
        switch (opcao){
            case(1):
                v = p.veiculoMaisProximo(coordInicio);
            case(2):
                v = p.veiculoMaisBarato();
            case(3):
                v = p.veiculoMaisBaratoPe(u);
            case(4):
                v = p.veiculoEspecifico();
            case(5):
                v = p.veiculoAutonomiaDesejada();
        }



        int id = p.getIdAluguer();
        p.setIdAluguer(id+1);

//        Aluguer al = new Aluguer(id, v, LocalDate.now(), duracao, u.getEmail(), v.getProprietario(), custoTotal, classificacao);
    }

    //TODO  acabar funcao opcoesProprietario
    //TODO  Adicionar veiculo
    private static void opcoesProprietario (Proprietario u, UMCarroJa p) throws Exception {
        Scanner input = new Scanner(System.in);
        limparEcra();
        int x = -1;
        int y = -1;
        Menu.menuOpcoesProprietario();
        x = input.nextInt();
        while(x!=0 && x!=1 && x!=2 && x!=3){
            System.out.println("Opcao incorreta");
            x = input.nextInt();
        }
        switch(x){
            case(1):
                p.veiculoDisponivel(u);
                System.out.println("0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                break;
            case(2):
                p.abastecerVeiculo(u);
                System.out.println("0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                break;
            case(3):
                p.adicionarVeiculo(u);
                System.out.println("0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                break;
            case(4):
                for(Veiculo v : p.listaCarros(u)){
                    v.toString();
                }
                System.out.println("0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                break;
            case(5):
//                p.verClassificacao(u);
//                System.out.println("0 - retroceder");
//                while(y != 0){
//                    y = input.nextInt();
//                }
//                break;
            case(0):
                executa(p);
                break;
        }
    }

    private static void entrarAdmin (UMCarroJa p) throws Exception {
        Scanner input = new Scanner(System.in);
        int x = 0;
        limparEcra();
        System.out.print("Password: ");
        x = input.nextInt();
        if(x !=12345){
            while(x != 12345){
                System.out.print("Password Incorreta\nPassword:");
                x = input.nextInt();
            }
        }
        limparEcra();
        opcoesAdmin(p);
    }

    //TODO  acabar funcao opcoesAdmin
    //TODO  a funcao da o utilizador mas sai imediatamente
    //TODO  esta em loop com opcoesadmin e executa
    //TODO  resolver problema por ser static e nao static
    private static void opcoesAdmin (UMCarroJa p) throws Exception {
        Scanner input = new Scanner(System.in);
        limparEcra();
        int x = -1;
        int y = -1;
        Menu.menuOpcoesAdmin();
        x = input.nextInt();
        while(x!=0 && x!=1 && x!=2 && x!=3 && x!=4 && x!=5 && x!=6 && x!=7 && x!=8 && x!=9 && x!=10 && x!=11){
            System.out.println("Opcao incorreta");
            System.out.print("Opcão: ");
            x = input.nextInt();
        }
        switch(x){
            case(1):
                for(Utilizador u : p.listaUtilizadores()){
                    System.out.println(u.toString());
                }
                System.out.println("0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                opcoesAdmin(p);
            case(2):
                for(Utilizador u : p.listaClientes()){
                    System.out.println(u.toString());
                }
                System.out.println("0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                opcoesAdmin(p);
            case(3):
                for(Utilizador u : p.listaProprietarios()){
                    System.out.println(u.toString());
                }
                System.out.println("0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                opcoesAdmin(p);
            case(4):
                for(Veiculo v : p.listaVeiculos()){
                    System.out.println(v.toString());
                }
                System.out.println("0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                opcoesAdmin(p);
            case(5):
                for(Veiculo v : p.listaLivres()){
                    System.out.println(v.toString());
                }
                System.out.println("0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                opcoesAdmin(p);
            case(6):
                for(Veiculo v : p.listaOcupados()){
                    System.out.println(v.toString());
                }
                System.out.println("0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
                opcoesAdmin(p);
            case(7):
                p.removeUtilizador();
                opcoesAdmin(p);
            case(8):
                p.removeTodosUtilizadores();
                opcoesAdmin(p);
            case(9):
                p.removeVeiculo();
                opcoesAdmin(p);
            case(10):
                p.removeTodosVeiculos();
                opcoesAdmin(p);
            case(11):
                p.apagarTudo();
                opcoesAdmin(p);
            case(12):
                UMCarroJa.setUtilizadores(PovoarBD.povoarClientes());
                opcoesAdmin(p);
            case(13):
                UMCarroJa.setVeiculos(PovoarBD.povoarVeiculos());
                opcoesAdmin(p);
            case(0):
                executa(p);
                break;
        }
    }

    //TODO  data invalida se meter muitas letras na morada ou noutro atributo, nao tenho certeza
    //TODO  se meter um /n antes da data imprime dois e da duas vezes data errada
    private static void registarUtilizador (UMCarroJa p) throws Exception {
        Scanner input = new Scanner(System.in);
        limparEcra();
        Menu.menuRegistar();
        int x = input.nextInt();
        if(x == 0){
            executa(p);
        }
        while(x!=1 && x!=2){
            System.out.print("Opção errada!\nOpção: ");
            x = input.nextInt();
        }
        limparEcra();
        System.out.println("Nome: ");
        String nome = input.next();
        System.out.println("NIF: ");
        int NIF = input.nextInt();
        System.out.println("Email: ");
        String email = input.next();
        System.out.println("Password: ");
        String password = input.next();
        System.out.println("Morada:" );
        String morada = input.next();
        System.out.println("Data de nascimento (dd-mm-yyyy: ");
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
            catch(Exception e){System.out.println("Data invalida.");}
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
    }

    private static void limparEcra(){
        System.out.print('\f');
    }
}