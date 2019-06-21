public class Menu {

    public static void menuPrincipal(){
        System.out.println("\n"+
               "1 - Entrar\n" +
               "2 - Registar\n\n"+
               "0 - Sair"
        );
        System.out.print("\nOpção: ");
    }

    public static void menuEntrar(){
        System.out.println("\n"+
                "1 - Entrar Utilizador\n" +
                "2 - Entrar Administrador\n\n" +
                "0 - Voltar"
        );
    }

    public  static void menuRegistar(){
        System.out.println("\n"+
               "1 - Registar utilizador\n" +
               "2 - Registar proprietario\n\n" +
               "0 - Voltar"
        );
        System.out.print("\nOpção: ");
    }

    public static void menuOpcoesCliente(){
        System.out.println("\n"+
                "1 - Veiculo mais proximo\n" +
                "2 - Veiculo mais barato\n" +
                "3 - Veiculo mais barato a distancia a pe\n" +
                "4 - Veiculo especifico\n" +
                "5 - Veiculo com autonomia desejada\n\n" +
                "0 - Voltar\n"
        );
        System.out.print("\nOpção: ");
    }

    public static void menuOpcoesProprietario(){
        System.out.println("\n"+
                "1 - Veiculo disponivel\n" +
                "2 - Abastecer veiculo\n" +
                "3 - Adicionar veiculo\n" +
                "4 - Lista de carros\n\n" +
                "0 - Voltar\n"
        );
        System.out.print("\nOpção: ");
    }

    public static void tipoVeiculo(){
        System.out.println("\n"+
                "1 - Gasolina\n" +
                "2 - Hibrido\n" +
                "3 - Eletrico\n"
        );
        System.out.print("\nOpção: ");
    }

    public static void menuOpcoesAdmin(){
        System.out.println("\n"+
                "1 - Lista de utilizadores\n"+
                "2 - Lista de clientes\n"+
                "3 - Lista de proprietarios\n"+
                "4 - Lista de veiculos\n"+
                "5 - Lista de veiculos livres\n"+
                "6 - Lista de veiculos ocupados\n"+
                "7 - Remover utilizador\n"+
                "8 - Remover todos utilizadores\n"+
                "9 - Remover veiculo\n"+
                "10 - Remover todos veiculos\n"+
                "11 - Apagar base dados\n"+
                "12 - Povoar BD utilizadores\n"+
                "13 - Povoar BD veiculos\n"+
                "14 - Imprimir para ficheiro\n"+
                "0 - Voltar\n"
        );
        System.out.print("\nOpção: ");
    }
}
