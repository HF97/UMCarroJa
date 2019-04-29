import java.io.Serializable;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;

public class UMCarroJa implements Serializable{
    int numeroCarro;
    private Map<String, Utilizador> utilizadores;
    private Map<String, Veiculo> veiculos;
    private Map<Integer, Aluguer> alugueres;
    private List<String> livres;
    private List<String> ocupados;

    public UMCarroJa(){
        numeroCarro = 0;
        this.utilizadores = new HashMap<String, Utilizador>();
        this.veiculos = new HashMap<String, Veiculo>();
        this.alugueres = new HashMap<Integer, Aluguer>();
        this.livres = new ArrayList<String>();
        this.ocupados = new ArrayList<String>();
    }

    public UMCarroJa(int numeroCarro, Collection<Utilizador> u, Collection<Veiculo> v, Collection<Aluguer> al, Collection<String> liv, Collection<String> ocu){
        this.numeroCarro = numeroCarro;
        this.utilizadores = new HashMap<String, Utilizador>(u.size());
        for(Utilizador a : u){
            this.utilizadores.put(a.getEmail(), a.clone());
        }
        this.veiculos = new HashMap<String, Veiculo>(v.size());
        for(Veiculo a : v){
            this.veiculos.put(a.getMatricula(), a.clone());
        }
        this.alugueres = new HashMap<Integer, Aluguer>();
        for(Aluguer a : al){
            this.alugueres.put(a.getId(), a.clone());
        }
        this.livres = new ArrayList<String>();
        for(String a : liv){
            this.livres.add(a);
        }
        this.ocupados = new ArrayList<String>();
        for(String a : ocu){
            this.ocupados.add(a);
        }
    }

    public UMCarroJa(UMCarroJa p){
        this.numeroCarro = p.getNumeroCarro();
        this.utilizadores = p.getUtilizadores();
        this.veiculos = p.getVeiculos();
        this.alugueres = p.getAlugueres();
        this.livres = p.getLivres();
        this.ocupados = p.getOcupados();
    }

    public int getNumeroCarro() {
        return this.numeroCarro;
    }

    public Map<String, Utilizador> getUtilizadores() {
        return this.utilizadores;
    }

    public Map<String, Veiculo> getVeiculos() {
        return this.veiculos;
    }

    public Map<Integer, Aluguer> getAlugueres() {
        return this.alugueres;
    }

    public List<String> getLivres(){
        return this.livres;
    }

    public List<String> getOcupados() {
        return ocupados;
    }

    public void setNumeroCarro(int numeroCarro) {
        this.numeroCarro = numeroCarro;
    }

    public void adicionaUtilizador (Utilizador u){
        this.utilizadores.put(u.getEmail(), u.clone());
    }

    public void adicionaVeiculo (Veiculo v){
        this.veiculos.put(v.getMatricula(), v.clone());
    }

    public void adicionaAluguer (Aluguer al){
        this.alugueres.put(al.getId(), al.clone());
    }

    public Utilizador getUtilizador(String email){
        return this.utilizadores.get(email);
    }

    public void removeUtilizador(){
        Scanner input = new Scanner(System.in);
        System.out.print("Email do utilizador: ");
        String email = input.next();
        this.utilizadores.remove(email);
    }

    public void removeTodosUtilizadores(){
        this.utilizadores.clear();
    }

    public void removeVeiculo(){
        Scanner input = new Scanner(System.in);
        System.out.print("Matricula do veiculo: ");
        String matricula = input.next();
        this.utilizadores.remove(matricula);
    }

    public void removeTodosVeiculos(){
        this.veiculos.clear();
    }

    public void apagarTudo(){
        this.utilizadores.clear();
        this.veiculos.clear();
        this.alugueres.clear();
        this.livres.clear();
        this.ocupados.clear();
    }

    public void setUtilizadores(Map<String, Utilizador> utilizadores) {
        this.utilizadores = utilizadores;
    }

    public void setVeiculos(Map<String, Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public void setAlugueres(Map<Integer, Aluguer> alugueres) {
        this.alugueres = alugueres;
    }

    public void setLivres(List<String> livres) {
        this.livres = livres;
    }

    public void setOcupados(List<String> ocupados) {
        this.ocupados = ocupados;
    }

    //    -----------------
//    Guardar basedados
//    -----------------
    public static UMCarroJa carregaObjetoInformacao() throws IOException, ClassNotFoundException, FileNotFoundException
    {
        FileInputStream carregaFicheiro = new FileInputStream("basedados");
        if (carregaFicheiro == null) {
            throw new FileNotFoundException("");
        } else {
            ObjectInputStream obj = new ObjectInputStream(carregaFicheiro);
            if (obj == null) {
                throw new IOException("");
            } else {
                UMCarroJa p = (UMCarroJa) obj.readObject();
                if (p == null) {
                    throw new ClassNotFoundException("");
                } else {
                    obj.close();
                    return p;
                }
            }
        }
    }

    /**
     * Guarda num ficheiro um objecto da classe Informacao (esse ficheiro tem sempre o nome BaseDados)
     */
    public void gravaObjetoInformacao() throws IOException, FileNotFoundException
    {
        FileOutputStream guardaFicheiro = new FileOutputStream("basedados");
        if (guardaFicheiro == null) {
            throw new FileNotFoundException("");
        } else {
            ObjectOutputStream objeto = new ObjectOutputStream(guardaFicheiro);
            if (objeto == null) {
                throw new IOException("");
            } else {
                objeto.writeObject(this);
                objeto.flush();
                objeto.close();
            }
        }
    }

    //--------------
    //OPCOES Cliente
    //--------------
    public Veiculo veiculoMaisProximo(Utilizador u){
        Scanner input = new Scanner(System.in);
        System.out.println("Indique as coordenadas do lugar que se encontra: ");
        System.out.println("X: ");
        int coordX = input.nextInt();
        System.out.println("Y: ");
        int coordY = input.nextInt();
        Coordenada coordCliente = new Coordenada(coordX, coordY);
        Iterator<Map.Entry<String, Veiculo>> it = this.veiculos.entrySet().iterator();
        Veiculo v = it.next().getValue().clone();
        while(it.hasNext()){
            if(it.next().getValue().getCoord().distancia(coordCliente) < v.getCoord().distancia(coordCliente)){
                v = it.next().getValue().clone();
            }
        }
        return v;
    }

    //TODO  nao e preciso dar utilizador
    public Veiculo veiculoMaisBarato(Utilizador u){
        Scanner input = new Scanner(System.in);
        Veiculo v = this.veiculos.get(this.livres.get(0)).clone();
        for(String s : this.livres){
            if(this.veiculos.get(s).getPrecokm() < v.getPrecokm()){
                v = this.veiculos.get(s);
            }
        }
        return v;
    }

    //TODO  nao e preciso dar utilizador
    //TODO  fica o mais barato mais perto (compare ???)
//    public Veiculo veiculoMaisBaratoPe(Utilizador u){
//
//    }

    //TODO  meter uma exception
    public Veiculo veiculoEspecifico(Utilizador u){
        Scanner input = new Scanner(System.in);
        System.out.println("Matricula do veiculo especifico: ");
        String matricula = input.next();
        Iterator<Map.Entry<String, Veiculo>> it = this.veiculos.entrySet().iterator();
        while(it.hasNext()){
            if(it.next().getValue().getMatricula().equals(matricula)){
                return it.next().getValue();
            }
        }
        return null;
    }

    //RETORNA SET COM TODOS OS CARROS COM A AUTONOMIA
    public Set<Veiculo> veiculoAutonomiaDesejada(Utilizador u){
        Scanner input = new Scanner(System.in);
        System.out.println("Autonomia desejada: ");
        int autonomia = input.nextInt();
        Set<Veiculo> veic = new HashSet<Veiculo>();
        Iterator<Map.Entry<String, Veiculo>> it = this.veiculos.entrySet().iterator();
        while(it.hasNext()){
            if(it.next().getValue().getAutonomia() == autonomia){
                veic.add(it.next().getValue());
            }
        }
        return veic;
    }





    //-------------------
    //OPCOES PROPRIETARIO
    //-------------------

    public List<Veiculo> listaCarros(Proprietario u){
        List<Veiculo> veicProp = new ArrayList<Veiculo>();
        Iterator<Map.Entry<String, Veiculo>> it = this.veiculos.entrySet().iterator();
        while(it.hasNext()){
            if(it.next().getValue().getProprietario().equals(u.getEmail())){
                veicProp.add(it.next().getValue());
            }
        }
        return veicProp;
    }


    public void veiculoDisponivel(Proprietario u){
        Scanner input = new Scanner(System.in);
        System.out.println("Matricula do veiculo: ");
        String matricula = input.next();
        this.livres.add(this.veiculos.get(matricula).getMatricula());
        System.out.println("Veiculo com matricula " + matricula + " está livre");
    }


//    //TODO  problema, nao aparece o getClassificacao
//    public int verClassificacao(Proprietario u){
//        return this.utilizadores.get(u.getEmail());
//    }


    //TODO  caso a soma da percentagem com o que tem no deposito ser maior que 100 tem de ser corrigido
    public void abastecerVeiculo(Proprietario u){
        Scanner input = new Scanner(System.in);
        System.out.println("Matricula do veiculo: ");
        String matricula = input.next();
        System.out.println("Ate que percentagem de deposito deseja encher: ");
        int percentagem = input.nextInt();
        Iterator<Map.Entry<String, Veiculo>> it = this.veiculos.entrySet().iterator();
        int auto = 0;
        while(it.hasNext()){
            if(it.next().getValue().getMatricula().equals(matricula)){
                it.next().getValue().setAutonomia(it.next().getValue().getAutonomia() + percentagem);
                auto = it.next().getValue().getAutonomia();
            }
        }
        System.out.println("Veiculo de matricula " + matricula + " agora tem " + auto + " de autonomia");
    }


    //TODO  veiculo info do proprietario
    public void adicionarVeiculo(Proprietario u){
        Scanner input = new Scanner(System.in);
        System.out.println("Matricula: ");
        String matricula = input.next();
        System.out.println("Velocidade media por km: ");
        double velmedkm = input.nextDouble();
        System.out.println("Preco por km: ");
        double precokm = input.nextDouble();
        System.out.println("Consumo: ");
        double consumo = input.nextDouble();
        int classificacao = 0;
        System.out.println("Indique as coordenadas do lugar que se encontra: ");
        System.out.println("X: ");
        int coordX = input.nextInt();
        System.out.println("Y: ");
        int coordY = input.nextInt();
        Coordenada coord = new Coordenada(coordX, coordY);
        System.out.println("Autonomia: ");
        int autonomia = input.nextInt();
        String prop = u.getEmail();
        List<Aluguer> histAlugVeic = new ArrayList<Aluguer>();
        System.out.println("Tipo de veiculo: ");
        Menu.tipoVeiculo();
        int x = input.nextInt();
        while(x!=1 && x!=2 && x!=3){
            System.out.println("Tipo incorreto");
        }
        switch (x){
            case(1):
                Gasolina gas = new Gasolina(matricula, velmedkm, precokm, consumo, classificacao, coord, autonomia, prop, histAlugVeic);
                adicionaVeiculo(gas.clone());

            case(2):
                Hibrido hib = new Hibrido(matricula, velmedkm, precokm, consumo, classificacao, coord, autonomia, prop, histAlugVeic);
                adicionaVeiculo(hib.clone());
            case(3):
                Eletrico ele = new Eletrico(matricula, velmedkm, precokm, consumo, classificacao, coord, autonomia, prop, histAlugVeic);
                adicionaVeiculo(ele.clone());
        }
    }




    //------------
    //OPCOES ADMIN
    //------------
    public List<Utilizador> listaUtilizadores(){
        List<Utilizador> uti = new ArrayList<Utilizador>();
        Iterator<Map.Entry<String, Utilizador>> it = this.utilizadores.entrySet().iterator();
        while(it.hasNext()){
            uti.add(it.next().getValue());
        }
        return uti;
    }

    public List<Utilizador> listaClientes(){
        List<Utilizador> uti = new ArrayList<Utilizador>();
        Iterator<Map.Entry<String, Utilizador>> it = this.utilizadores.entrySet().iterator();
        while(it.hasNext()){
            if(it.next().getClass().getSimpleName().equals("Cliente")){
                uti.add(it.next().getValue());
            }
        }
        return uti;
    }

    public List<Utilizador> listaProprietarios(){
        List<Utilizador> uti = new ArrayList<Utilizador>();
        Iterator<Map.Entry<String, Utilizador>> it = this.utilizadores.entrySet().iterator();
        while(it.hasNext()){
            if(it.next().getClass().getSimpleName().equals("Proprietario")){
                uti.add(it.next().getValue());
            }
        }
        return uti;
    }

    public List<Veiculo> listaVeiculos(){
        List<Veiculo> vei = new ArrayList<Veiculo>();
        Iterator<Map.Entry<String, Veiculo>> it = this.veiculos.entrySet().iterator();
        while(it.hasNext()){
            vei.add(it.next().getValue());
        }
        return vei;
    }

    public List<Veiculo> listaLivres(){
        List<Veiculo> liv = new ArrayList<Veiculo>();
        for(String s : this.livres){
            liv.add(this.veiculos.get(s));
        }
        return liv;
    }

    public List<Veiculo> listaOcupados(){
        List<Veiculo> ocu = new ArrayList<Veiculo>();
        for(String s : this.ocupados){
            ocu.add(this.veiculos.get(s));
        }
        return ocu;
    }



    public UMCarroJa clone(){
        return new UMCarroJa(this);
    }
}
