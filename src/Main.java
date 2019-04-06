import java.lang.ref.Cleaner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public void main() throws Exception {
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

    private void executa (UMCarroJa p) throws Exception {
        Scanner input = new Scanner(System.in);
        int x = -1;
        limparEcra();
        Menu.menuPrincipal();
        while(x!=0 && x!=1 && x!=2){
            x = input.nextInt();
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

    public void menuEntrar (UMCarroJa p) throws Exception {
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
                    System.out.println("NIF ou Password errado(a).");
                    entrarUtilizador(p);
                }
                break;
            case(2):
                try{
                    entrarUtilizador(p);
                }
                catch (Exception e){
                    System.out.println("NIF ou Password errado(a).");
                    entrarUtilizador(p);
                }
                break;
            case(3):
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

    public void entrarUtilizador (UMCarroJa p) throws Exception {
        Scanner input = new Scanner(System.in);
        limparEcra();
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
    private void opcoesCliente (Utilizador u, UMCarroJa p) throws Exception {
        Scanner input = new Scanner(System.in);
        limparEcra();
        int x = -1;
        Menu.menuOpcoesCliente();
        x = input.nextInt();
        while(x!=0 && x!=1 && x!=2 && x!=3 && x!=4 && x!=5){
            System.out.println("Opcao incorreta");
            x = input.nextInt();
        }
        switch(x){
            case(1):
                p.veiculoMaisProximo(u);
            case(2):
                p.veiculoMaisBarato(u);
            case(3):
//                p.veiculoMaisBaratoPe(u);
            case(4):
                p.veiculoEspecifico(u);
            case(5):
                p.veiculoAutonomiaDesejada(u);
            case(0):
                executa(p);
                break;
        }
    }

    //TODO  acabar funcao opcoesProprietario
    //TODO  Adicionar veiculo
    private void opcoesProprietario (Proprietario u, UMCarroJa p) throws Exception {
        Scanner input = new Scanner(System.in);
        limparEcra();
        int x = -1;
        Menu.menuOpcoesProprietario();
        x = input.nextInt();
        while(x!=0 && x!=1 && x!=2 && x!=3){
            System.out.println("Opcao incorreta");
            x = input.nextInt();
        }
        switch(x){
            case(1):
                p.veiculoDisponivel(u);
            case(2):
                p.abastecerVeiculo(u);
            case(3):
                p.adicionarVeiculo(u);
            case(4):
                p.listaCarros(u);
            case(5):
//                p.verClassificacao(u);
            case(0):
                executa(p);
                break;
        }
    }

    private void entrarAdmin (UMCarroJa p) throws Exception {
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
    private void opcoesAdmin (UMCarroJa p) throws Exception {
        Scanner input = new Scanner(System.in);
        limparEcra();
        int x = -1;
        Menu.menuOpcoesAdmin();
        x = input.nextInt();
        while(x!=0 && x!=1 && x!=2 && x!=3 && x!=4 && x!=5 && x!=6){
            System.out.println("Opcao incorreta");
            x = input.nextInt();
        }
        switch(x){
            case(1):
                for(Utilizador u : p.listaUtilizadores()){
                    u.toString();
                }
            case(2):
                for(Utilizador u : p.listaClientes()){
                    u.toString();
                }
            case(3):
                for(Utilizador u : p.listaProprietarios()){
                    u.toString();
                }
            case(4):
                for(Veiculo v : p.listaVeiculos()){
                    v.toString();
                }
            case(5):
                for(Veiculo v : p.listaLivres()){
                    v.toString();
                }
            case(6):
                for(Veiculo v : p.listaOcupados()){
                    v.toString();
                }
        }
    }


    private void registarUtilizador (UMCarroJa p) throws Exception {
        Scanner input = new Scanner(System.in);
        limparEcra();
        Menu.menuRegistar();
        int x = input.nextInt();
        if(x == 0){
            executa(p);
        }
        if(x==1 || x==2){
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
        }
        else{
            while(x!=1 || x!=2){
                System.out.println("Opcao errada!\nNova opcao: ");
            }
        }
        executa(p);
    }

    private void limparEcra(){
        System.out.print('\f');
    }
}