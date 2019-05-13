import java.io.Serializable;
import java.util.Collection;

public class Gasolina extends Veiculo implements Serializable {

    public Gasolina(){
        super();
    }

    public Gasolina(String matricula, double velmediakm, double precokm, double consumo, int classificacao, Coordenada coord, int autonomia, String proprietario, String estado, Collection<Aluguer> histAlugVeic) {
        super(matricula, velmediakm, precokm, consumo, classificacao, coord, autonomia, proprietario, estado, histAlugVeic);
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
        StringBuilder sb = new StringBuilder(this.getClass().getSimpleName());
        sb.append(super.toString());
        return sb.toString();
    }
}
