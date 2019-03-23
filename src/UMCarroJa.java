import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UMCarroJa {

    public void main() throws Exception {
        Programa p = new Programa();
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
            return;
        }
    }

    private void executa (Programa p) throws Exception {
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

    public void menuEntrar (Programa p) throws Exception {
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
                    entrarProprietario(p);
                }
                catch (Exception e){
                    System.out.println("NIF ou Password errado(a).");
                    entrarProprietario(p);
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

    public void entrarUtilizador (Programa p) throws Exception {
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
    private void opcoesCliente (Cliente u, Programa p) throws Exception {
        Scanner input = new Scanner(System.in);
        limparEcra();
        int x = -1;
        System.out.println("Indique as coordenadas do lugar que se encontra: ");
        System.out.println("X: ");
        int coordX = input.nextInt();
        System.out.println("Y: ");
        int coordY = input.nextInt();
        Coordenada coordCliente = new Coordenada(coordX, coordY);
        Menu.menuOpcoesCliente();
        x = input.nextInt();
        while(x!=0 && x!=1 && x!=2 && x!=3 && x!=4 && x!=5){
            System.out.println("Opcao incorreta");
            x = input.nextInt();
        }
        switch(x){
            case(1):

            case(2):

            case(3):

            case(4):

            case(5):

            case(0):
                executa(p);
                break;
        }
    }

    //TODO  acabar funcao opcoesProprietario
    private void opcoesProprietario (Proprietario u, Programa p) throws Exception {
        Scanner input = new Scanner(System.in);
        limparEcra();
        int x = -1;
        Menu.menuOpcoesProprietario();
        x = input.nextInt();
        while(x!=0 && x!=1 && x!=2){
            System.out.println("Opcao incorreta");
            x = input.nextInt();
        }
        switch(x){
            case(1):

            case(2):

            case(0):
                executa(p);
                break;
        }
    }

    private void entrarAdmin (Programa p) throws Exception {
        Scanner input = new Scanner(System.in);
        int x = 0;
        limparEcra();
        System.out.println("Password: ");
        while(x != 12345){
            System.out.println("Password Incorreta\nPassword:");
            x = input.nextInt();
        }
        limparEcra();
        opcoesAdmin(p);
    }

    //TODO  acabar funcao opcoesAdmin
    private void opcoesAdmin (Programa p) throws Exception {

    }


    private void registarUtilizador (Programa p) throws Exception {
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
                    p.adicionaUtilizador(c);
                    break;
                case(2):
                    int classificacao = 0;
                    Proprietario c = new Proprietario(nome, NIF, email, password, morada, datanasc, classificacao);
                    p.adicionaUtilizador(c);
                    break;
            }
        }
        executa(p);
    }

    private void limparEcra(){
        System.out.print('\f');
    }
}
