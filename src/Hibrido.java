import java.io.Serializable;

public class Hibrido extends Veiculo implements Serializable {

    public Hibrido(){
        super();
    }

    public Hibrido(String matricula, double velmediakm, double precokm, double consumo, int classificacao, Coordenada coord, int autonomia){
        super(matricula, velmediakm, precokm, consumo, classificacao, coord, autonomia);
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
