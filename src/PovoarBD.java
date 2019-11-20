//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class PovoarBD {
//    public Map<String,Utilizador> povoarClientes(){
//        Map<String,Utilizador> utilizadores = new HashMap<String, Utilizador>();
//        List<Integer> histAlugUti = new ArrayList<Integer>();
//        List<String> carros = new ArrayList<String>();
//        Coordenada coord1 = new Coordenada(0,0);
//        Cliente c1 = new Cliente("Hugo Silva", 111111111, "hugosilva@gmail.com", "hugosilva", "Rua do Hugo", LocalDate.parse("11-11-1990"), coord1, histAlugUti);
//        utilizadores.put("hugosilva@gmail.com", c1.clone());
//        Coordenada coord2 = new Coordenada(3,3);
//        Cliente c2 = new Cliente("Jose Alves", 222222222, "josealves@gmail.com", "josealves", "Rua do Jose", LocalDate.parse("22-01-1992"), coord2, histAlugUti);
//        utilizadores.put("josealves@gmail.com", c2.clone());
//        Coordenada coord3 = new Coordenada(0,7);
//        Cliente c3 = new Cliente("Rui Miranda", 333333333, "ruimiranda@gmail.com", "ruimiranda", "Rua do Rui", LocalDate.parse("11-07-1980"), coord3, histAlugUti);
//        utilizadores.put("ruimiranda@gmail.com", c3.clone());
//        Coordenada coord4 = new Coordenada(10,0);
//        Cliente c4 = new Cliente("Antonio Fernades", 444444444, "antoniofernades@gmail.com", "antoniofernades", "Rua do Antonio", LocalDate.parse("22-01-1995"), coord4, histAlugUti);
//        utilizadores.put("antoniofernandes@gmail.com", c4.clone());
//        Coordenada coord5 = new Coordenada(3,6);
//        Cliente c5 = new Cliente("Fernando Gomes", 555555555, "fernandogomes@gmail.com", "fernandogomes", "Rua do Fernando", LocalDate.parse("09-07-1985"), coord5, histAlugUti);
//        utilizadores.put("fernandogomes@gmail.com", c5.clone());
//        Coordenada coord6 = new Coordenada(2,9);
//        Cliente c6 = new Cliente("Leonardo Jardim", 666666666, "leonardojardim@gmail.com", "leonardojardim", "Rua do Leonardo", LocalDate.parse("11-12-1970"), coord6, histAlugUti);
//        utilizadores.put("leonardojardim@gmail.com", c6.clone());
//        Coordenada coord7 = new Coordenada(6,6);
//        Cliente c7 = new Cliente("Jose Mourinho", 777777777, "josemourinho@gmail.com", "josemourinho", "Rua do Mourinho", LocalDate.parse("10-08-1975"), coord7, histAlugUti);
//        utilizadores.put("josemouriinho@gmail.com", c7.clone());
//        Coordenada coord8 = new Coordenada(1,4);
//        Cliente c8 = new Cliente("David Silva", 888888888, "davidsilva@gmail.com", "davidsilva", "Rua do David", LocalDate.parse("18-11-1990"), coord8, histAlugUti);
//        utilizadores.put("davidsilva@gmail.com", c8.clone());
//        Coordenada coord9 = new Coordenada(9,2);
//        Cliente c9 = new Cliente("Bernardo Ronaldo", 999999999, "bernardoronaldo@gmail.com", "bernardoronaldo", "Rua do Bernardo", LocalDate.parse("28-02-1988"), coord9, histAlugUti);
//        utilizadores.put("bernardoronaldo@gmail.com", c9.clone());
//        Proprietario p1 = new Proprietario("Joao Felix", 123123123, "joaofelix@gmail.com", "joaofelix", "Rua do Felix", LocalDate.parse("18-10-1970"), 0, histAlugUti, carros);
//        utilizadores.put("joaofelix@gmail.com", p1.clone());
//        Proprietario p2 = new Proprietario("Ruben Dias", 234234234, "rubendias@gmail.com", "rubendias", "Rua do Ruben", LocalDate.parse("21-06-1982"), 0, histAlugUti, carros);
//        utilizadores.put("rebundias@gmail.com", p2.clone());
//        Proprietario p3 = new Proprietario("Andre Almeida", 345345345, "andrealmeida@gmail.com", "andrealmeida", "Rua do Almeida", LocalDate.parse("15-09-1986"), 0, histAlugUti, carros);
//        utilizadores.put("andrealmeida@gmail.com", p3.clone());
//        Proprietario p4 = new Proprietario("Renato Rodrigues", 456456456, "renatorodrigues@gmail.com", "renatorodrigues", "Rua do Renato", LocalDate.parse("12-02-1965"), 0, histAlugUti, carros);
//        utilizadores.put("renatorodrigues@gmail.com", p4.clone());
//        Proprietario p5 = new Proprietario("Francisco Cervi", 567567567, "franciscocervi@gmail.com", "franciscocervi", "Rua do Francisco", LocalDate.parse("19-08-1995"), 0, histAlugUti, carros);
//        utilizadores.put("franciscocervi@gmail.com", p5.clone());
////        Proprietario c6 = new Proprietario("Lionel Messi", 678678678, "lionelmessi@gmail.com", "lionelmessi", "Rua do Messi", LocalDate.parse("12-04-1977"), 0, histAlugUti);
////        Proprietario c7 = new Proprietario("Andre Ferro", 789789789, "andreferro@gmail.com", "andreferro", "Rua do Ferro", LocalDate.parse("14-02-1979"), 0, histAlugUti);
////        Proprietario c8 = new Proprietario("Bruno Alves", 890890890, "brunoalves@gmail.com", "brunoalves", "Rua do Bruno", LocalDate.parse("21-10-1992"), 0, histAlugUti);
////        Proprietario c9 = new Proprietario("Rui Patricio", 123456789, "ruipatricio@gmail.com", "ruipatricio", "Rua do Patricio", LocalDate.parse("22-05-1986"), 0, histAlugUti);
//        return utilizadores;
//    }
//
//    public Map<String,Veiculo> povoarVeiculos(){
//        Map<String,Veiculo> veiculos = new HashMap<String, Veiculo>();
//        List<Integer> histAlugUti = new ArrayList<Integer>();
//        Coordenada coord1 = new Coordenada(0,0);
//        Gasolina g1 = new Gasolina("11-aa-11", 50.0, 5.0, 5.7, 0, coord1, 800, "joaofelix@gmail.com", "livre", histAlugUti);
//        veiculos.put("joaofelix@gmail.com", g1.clone());
//        Gasolina g2 = new Gasolina("22-bb-22", 70.0, 8.0, 8.7, 0, coord1, 700, "rubendias@gmail.com", "livre", histAlugUti);
//        veiculos.put("rubendias@gmail.com", g2.clone());
//        Gasolina g3 = new Gasolina("33-cc-33", 85.0, 8.0, 6.7, 0, coord1, 1100, "andrealmeida@gmail.com", "livre", histAlugUti);
//        veiculos.put("andrealmeida@gmail.com", g3.clone());
//        Eletrico e1 = new Eletrico("44-dd-44", 55.0, 2.0, 3.0, 0, coord1, 550, "renatorodrigues@gmail.com", "livre", histAlugUti);
//        veiculos.put("renatorodrigues@gmail.com", e1.clone());
//        Eletrico e2 = new Eletrico("55-ee-55", 40.0, 3.0, 2.5, 0, coord1, 600, "franciscocervi@gmail.com", "livre", histAlugUti);
//        veiculos.put("franciscocervi@gmail.com", e2.clone());
//        Eletrico e3 = new Eletrico("66-ff-66", 45.0, 4.0, 4.0, 0, coord1, 660, "joaofelix@gmail.com", "livre", histAlugUti);
//        veiculos.put("joaofelix@gmail.com", e3.clone());
//        Hibrido h1 = new Hibrido("77-gg-77", 30.0, 3.5, 2.1, 0, coord1, 450, "andrealmeida@gmail.com", "livre", histAlugUti);
//        veiculos.put("andrealmeida@gmail.com", h1.clone());
//        Hibrido h2 = new Hibrido("88-hh-88", 45.0, 4.0, 3.7, 0, coord1, 600, "renatorodrigues@gmail.com", "livre", histAlugUti);
//        veiculos.put("renatorodrigues@gmail.com", h2.clone());
//        Hibrido h3 = new Hibrido("99-ii-99", 25.0, 2.0, 1.7, 0, coord1, 500, "joaofelix@gmail.com", "livre", histAlugUti);
//        veiculos.put("joaofelix@gmail.com", h3.clone());
//        return veiculos;
//    }
//}
