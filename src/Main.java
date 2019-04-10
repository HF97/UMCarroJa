import java.lang.ref.Cleaner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public static void menuEntrar (UMCarroJa p) throws Exception {
        Scanner input = new Scanner(System.in);
        int x = -1;
        limparEcra();
        Menu.menuEntrar();
        while(x!=0 && x!=1 && x!=2 && x!=3){
            x = input.nextInt();
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
    private static void opcoesCliente (Utilizador u, UMCarroJa p) throws Exception {
        Scanner input = new Scanner(System.in);
        limparEcra();
        int x = -1;
        int y = -1;
        Menu.menuOpcoesCliente();
        x = input.nextInt();
        while(x!=0 && x!=1 && x!=2 && x!=3 && x!=4 && x!=5){
            System.out.println("Opcao incorreta");
            x = input.nextInt();
        }
        switch(x){
            case(1):
                p.veiculoMaisProximo(u).toString();
                System.out.println("0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
            case(2):
                p.veiculoMaisBarato(u).toString();
                System.out.println("0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
            case(3):
//                p.veiculoMaisBaratoPe(u).toString();
                System.out.println("0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
            case(4):
                p.veiculoEspecifico(u).toString();
                System.out.println("0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
            case(5):
                p.veiculoAutonomiaDesejada(u).toString();
                System.out.println("0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
            case(0):
                executa(p);
                break;
        }
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
            case(2):
                p.abastecerVeiculo(u);
                System.out.println("0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
            case(3):
                p.adicionarVeiculo(u);
                System.out.println("0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
            case(4):
                for(Veiculo v : p.listaCarros(u)){
                    v.toString();
                }
                System.out.println("0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
            case(5):
//                p.verClassificacao(u);
//                System.out.println("0 - retroceder");
//                while(y != 0){
//                    y = input.nextInt();
//                }
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
    private static void opcoesAdmin (UMCarroJa p) throws Exception {
        Scanner input = new Scanner(System.in);
        limparEcra();
        int x = -1;
        int y = -1;
        Menu.menuOpcoesAdmin();
        x = input.nextInt();
        while(x!=0 && x!=1 && x!=2 && x!=3 && x!=4 && x!=5 && x!=6){
            System.out.println("Opcao incorreta");
            System.out.print("Opcão: ");
            x = input.nextInt();
        }
        switch(x){
            case(1):
                for(Utilizador u : p.listaUtilizadores()){
                    u.toString();
                while(y != 0){
                    y = input.nextInt();
                }

                }
                System.out.println("0 - retroceder");
            case(2):
                for(Utilizador u : p.listaClientes()){
                    u.toString();
                }
                System.out.println("0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
            case(3):
                for(Utilizador u : p.listaProprietarios()){
                    u.toString();
                }
                System.out.println("0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
            case(4):
                for(Veiculo v : p.listaVeiculos()){
                    v.toString();
                }
                System.out.println("0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
            case(5):
                for(Veiculo v : p.listaLivres()){
                    v.toString();
                }
                System.out.println("0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
            case(6):
                for(Veiculo v : p.listaOcupados()){
                    v.toString();
                }
                System.out.println("0 - retroceder");
                while(y != 0){
                    y = input.nextInt();
                }
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
                Cliente c = new Cliente(nome, NIF, email, password, morada, datanasc, coord);
                p.adicionaUtilizador(c.clone());
                break;
            case(2):
                int classificacao = 0;
                Proprietario prop = new Proprietario(nome, NIF, email, password, morada, datanasc, classificacao);
                p.adicionaUtilizador(prop.clone());
                break;
        }
        executa(p);
    }

    private static void limparEcra(){
        System.out.print('\f');
    }
}