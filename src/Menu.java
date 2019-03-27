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
                "1 - Veiculo mais proximo\n" +
                "2 - Veiculo mais barato\n" +
                "3 - Veiculo mais barato a distancia a pe\n" +
                "4 - Veiculo especifico\n" +
                "5 - Veiculo com autonomia desejada\n" +
                "0 - Voltar\n"
        );
    }

    public static void menuOpcoesProprietario(){
        System.out.println(
                "1 - Veiculo disponivel\n" +
                "2 - Abastecer veiculo\n" +
                "3 - Adicionar veiculo\n" +
                "0 - Voltar\n"
        );
    }

    public static void tipoVeiculo(){
        System.out.println(
                "1 - Gasolina\n" +
                "2 - Hibrido\n" +
                "3 - Eletrico\n"
        );
    }
}
