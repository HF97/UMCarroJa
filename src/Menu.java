public class Menu {

    public static void menuPrincipal(){
        System.out.println(
               "1 - Entrar\n" +
               "2 - Registar\n\n"+
               "0 - Sair"
        );
    }

    public static void menuEntrar(){
        System.out.println(
                "1 - Entrar Utilizador\n" +
                "2 - Entrar Proprietario\n" +
                "3 - Entrar Administrador\n\n" +
                "0 - Voltar"
        );
    }

    public  static void menuRegistar(){
        System.out.println(
               "1 - Registar utilizador\n" +
               "2 - Registar proprietario\n\n" +
               "0 - Voltar"
        );
    }

    public static void menuOpcoesCliente(){
        System.out.println(
                "1 - Carro\n" +
                "2 - \n" +
                "0 - Voltar\n"

        );
    }

    public static void menuOpcoesProprietario(){
        System.out.println(
                "1 - \n" +
                "0 - Voltar\n"
        );
    }
}
