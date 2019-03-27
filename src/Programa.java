import jdk.jshell.execution.Util;

import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.*;


public class Programa implements Serializable {

    int numeroCarro;
    private Map<String, Utilizador> utilizadores;
    private Map<String, Veiculo> veiculos;
    private Map<Integer, Aluguer> alugueres;

    public Programa(){
        numeroCarro = 0;
        this.utilizadores = new HashMap<String, Utilizador>();
        this.veiculos = new HashMap<String, Veiculo>();
        this.alugueres ) new HashMap<Integer, Aluguer>();
    }

    public Programa(int numeroCarro, Collection<Utilizador> u, Collection<Veiculo> v, Collection<Aluguer> al){
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
    }

    public Programa(Programa p){
        this.numeroCarro = p.getNumeroCarro();
        this.utilizadores = p.getUtilizadores();
        this.veiculos = p.getVeiculos();
        this.alugueres = p.getAlugueres();
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

//    -----------------
//    Guardar basedados
//    -----------------
    public static Programa carregaObjetoInformacao() throws IOException, ClassNotFoundException, FileNotFoundException
    {
        FileInputStream carregaFicheiro = new FileInputStream("basedados");
        if (carregaFicheiro == null) {
            throw new FileNotFoundException("");
        } else {
            ObjectInputStream obj = new ObjectInputStream(carregaFicheiro);
            if (obj == null) {
                throw new IOException("");
            } else {
                Programa p = (Programa) obj.readObject();
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
    public Veiculo veiculoMaisProximo(){
        Scanner input = new Scanner(System.in);
        System.out.println("Indique as coordenadas do lugar que se encontra: ");
        System.out.println("X: ");
        int coordX = input.nextInt();
        System.out.println("Y: ");
        int coordY = input.nextInt();
        Coordenada coordCliente = new Coordenada(coordX, coordY);

    }

    public Veiculo veiculoMaisBarato(){

    }

    public Veiculo veiculoMaisBaratoPe(){

    }

    public Veiculo veiculoEspecifico(){

    }


    //RETORNA SET COM TODOS OS CARROS COM A AUTONOMIA
    public Set<Veiculo> veiculoAutonomiaDesejada(){
        Scanner input = new Scanner(System.in);
        System.out.println("Autonomia desejada: ");
        int autonomia = input.nextInt();
        Set<Veiculo> veic = new HashSet<Veiculo>();
        Iterator<Map.Entry<Integer, Veiculo>> it = this.veiculos.entrySet().iterator();
        for(it.hasNext()){
            if(it.next().getValue().getAutonomia() == autonomia){
                veic.add(it.next().getValue());
            }
        }
        return veic;
    }





    //-------------------
    //OPCOES PROPRIETARIO
    //-------------------





    public Programa clone(){
        return new Programa(this);
    }
}
