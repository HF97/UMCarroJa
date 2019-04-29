import java.io.Serializable;
import java.util.Collection;

public class Hibrido extends Veiculo implements Serializable {

    public Hibrido(){
        super();
    }

    public Hibrido(String matricula, double velmediakm, double precokm, double consumo, int classificacao, Coordenada coord, int autonomia, String proprietario, Collection<Aluguer> histAlugVeic){
        super(matricula, velmediakm, precokm, consumo, classificacao, coord, autonomia, proprietario, histAlugVeic);
    }

    public Hibrido(Hibrido h){
        super(h);
    }

    public Hibrido clone(){
        return new Hibrido(this);
    }

        public boolean equals (Object o){
        Hibrido h = (Hibrido) o;
        return super.equals(h);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder(this.getClass().getSimpleName());
        sb.append(super.toString());
        return sb.toString();
    }
}
