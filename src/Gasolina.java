import java.io.Serializable;
import java.util.Collection;

public class Gasolina extends Veiculo implements Serializable {

    public Gasolina(){
        super();
    }

    public Gasolina(String matricula, double velmediakm, double precokm, double consumo, int classificacao, int soma, int contTotal, Coordenada coord, int autonomia, int capacidadeDeposito, String proprietario) {
        super(matricula, velmediakm, precokm, consumo, classificacao, soma, contTotal, coord, autonomia, capacidadeDeposito, proprietario);
    }

    public Gasolina(Gasolina g){
        super(g);
    }

    public Gasolina clone(){
        return new Gasolina(this);
    }

    public boolean equals (Object o){
        Gasolina g = (Gasolina) o;
        return super.equals(g);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder(super.toString());
        return sb.toString();
    }
}
