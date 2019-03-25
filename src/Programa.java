import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class Programa implements Serializable {

    int numeroCarro;
    private Map<String, Utilizador> utilizadores;
    private Map<Integer, Veiculo> veiculos;

    public Programa(){
        numeroCarro = 0;
        this.utilizadores = new HashMap<String, Utilizador>();
        this.veiculos = new HashMap<Integer, Veiculo>();
    }

    public Programa(int numeroCarro, Collection<Utilizador> u, Collection<Veiculo> v){
        this.numeroCarro = numeroCarro;
        this.utilizadores = new HashMap<String, Utilizador>(u.size());
        for(Utilizador a : u){
            this.utilizadores.put(a.getEmail(), a.clone());
        }
        this.veiculos = new HashMap<Integer, Veiculo>(v.size());
        for(Veiculo a : v){
            this.veiculos.put(a.getId(), a.clone());
        }
    }

    public Programa(Programa p){
        this.numeroCarro = p.getNumeroCarro();
        this.utilizadores = p.getUtilizadores();
        this.veiculos = p.getVeiculos();
    }

    public int getNumeroCarro() {
        return this.numeroCarro;
    }

    public Map<String, Utilizador> getUtilizadores() {
        return this.utilizadores;
    }

    public Map<Integer, Veiculo> getVeiculos() {
        return this.veiculos;
    }

    public void setNumeroCarro(int numeroCarro) {
        this.numeroCarro = numeroCarro;
    }

    public void adicionaUtilizador (Utilizador u){
        this.utilizadores.put(u.getEmail(), u.clone());
    }

    public void adicionaVeiculo (Veiculo v){
        this.veiculos.put(v.getId(), v.clone());
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











    public Programa clone(){
        return new Programa(this);
    }
}
