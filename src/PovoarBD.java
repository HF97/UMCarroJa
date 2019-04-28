import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PovoarBD {
    public static void povoarClientes(){
        List<Aluguer> histAlugUti = new ArrayList<Aluguer>();
        Coordenada coord1 = new Coordenada(0,0);
        Cliente c1 = new Cliente("Hugo Silva", 111111111, "hugosilva@gmail.com", "hugosilva", "Rua do Hugo", LocalDate.parse("11-11-1990"), coord1, histAlugUti);
        Coordenada coord2 = new Coordenada(3,3);
        Cliente c2 = new Cliente("Jose Alves", 222222222, "josealves@gmail.com", "josealves", "Rua do Jose", LocalDate.parse("22-01-1992"), coord2, histAlugUti);
        Coordenada coord3 = new Coordenada(0,7);
        Cliente c3 = new Cliente("Rui Miranda", 333333333, "ruimiranda@gmail.com", "ruimiranda", "Rua do Rui", LocalDate.parse("11-07-1980"), coord3, histAlugUti);
        Coordenada coord4 = new Coordenada(10,0);
        Cliente c4 = new Cliente("Antonio Fernades", 444444444, "antoniofernades@gmail.com", "antoniofernades", "Rua do Antonio", LocalDate.parse("22-01-1995"), coord4, histAlugUti);
        Coordenada coord5 = new Coordenada(3,6);
        Cliente c5 = new Cliente("Fernando Gomes", 555555555, "fernandogomes@gmail.com", "fernandogomes", "Rua do Fernando", LocalDate.parse("09-07-1985"), coord5, histAlugUti);
        Coordenada coord6 = new Coordenada(2,9);
        Cliente c6 = new Cliente("Leonardo Jardim", 666666666, "leonardojardim@gmail.com", "leonardojardim", "Rua do Leonardo", LocalDate.parse("11-12-1970"), coord6, histAlugUti);
        Coordenada coord7 = new Coordenada(6,6);
        Cliente c7 = new Cliente("Jose Mourinho", 777777777, "josemourinho@gmail.com", "josemourinho", "Rua do Mourinho", LocalDate.parse("10-08-1975"), coord7, histAlugUti);
        Coordenada coord8 = new Coordenada(1,4);
        Cliente c8 = new Cliente("David Silva", 888888888, "davidsilva@gmail.com", "davidsilva", "Rua do David", LocalDate.parse("18-11-1990"), coord8, histAlugUti);
        Coordenada coord9 = new Coordenada(9,2);
        Cliente c9 = new Cliente("Bernardo Ronaldo", 999999999, "bernardoronaldo@gmail.com", "bernardoronaldo", "Rua do Bernardo", LocalDate.parse("28-02-1988"), coord9, histAlugUti);
    }

    public static void povoarProprietarios(){
        List<Aluguer> histAlugUti = new ArrayList<Aluguer>();
        Proprietario c1 = new Proprietario("Joao Felix", 123123123, "joaofelix@gmail.com", "joaofelix", "Rua do Felix", LocalDate.parse("18-10-1970"), 0, histAlugUti);
        Proprietario c2 = new Proprietario("Ruben Dias", 234234234, "rubendias@gmail.com", "rubendias", "Rua do Ruben", LocalDate.parse("21-06-1982"), 0, histAlugUti);
        Proprietario c3 = new Proprietario("Andre Almeida", 345345345, "andrealmeida@gmail.com", "andrealmeida", "Rua do Almeida", LocalDate.parse("15-09-1986"), 0, histAlugUti);
        Proprietario c4 = new Proprietario("Renato Rodrigues", 456456456, "renatorodrigues@gmail.com", "renatorodrigues", "Rua do Renato", LocalDate.parse("12-02-1965"), 0, histAlugUti);
        Proprietario c5 = new Proprietario("Francisco Cervi", 567567567, "franciscocervi@gmail.com", "franciscocervi", "Rua do Francisco", LocalDate.parse("19-08-1995"), 0, histAlugUti);
        Proprietario c6 = new Proprietario("Lionel Messi", 678678678, "lionelmessi@gmail.com", "lionelmessi", "Rua do Messi", LocalDate.parse("12-04-1977"), 0, histAlugUti);
        Proprietario c7 = new Proprietario("Andre Ferro", 789789789, "andreferro@gmail.com", "andreferro", "Rua do Ferro", LocalDate.parse("14-02-1979"), 0, histAlugUti);
        Proprietario c8 = new Proprietario("Bruno Alves", 890890890, "brunoalves@gmail.com", "brunoalves", "Rua do Bruno", LocalDate.parse("21-10-1992"), 0, histAlugUti);
        Proprietario c9 = new Proprietario("Rui Patricio", 123456789, "ruipatricio@gmail.com", "ruipatricio", "Rua do Patricio", LocalDate.parse("22-05-1986"), 0, histAlugUti);
    }

    public static void povoarVeiculos(){
        List<Aluguer> histAlugUti = new ArrayList<Aluguer>();
        Coordenada coord1 = new Coordenada(0,0);
        Gasolina g1 = new Gasolina("11-aa-11", 50.0, 5.0, 5.7, 0, coord1, 800, "joaofelix@gmail.com", histAlugUti);


        public Veiculo(String matricula, double velmediakm, double precokm, double consumo, int classificacao, Coordenada coord, int autonomia, String proprietario, Collection<Aluguer> histAlugVeic)

    }
}
