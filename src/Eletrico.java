import java.io.Serializable;
import java.util.Collection;

public class Eletrico extends Veiculo implements Serializable {

    public Eletrico(){
        super();
    }

    public Eletrico(String matricula, double velmediakm, double precokm, double consumo, int classificacao, int soma, int contTotal, Coordenada coord, int autonomia, int capacidadeDeposito, String proprietario) {
        super(matricula, velmediakm, precokm, consumo, classificacao, soma, contTotal, coord, autonomia, capacidadeDeposito, proprietario);
    }

    public Eletrico(Eletrico e){
        super(e);
    }

    public Eletrico clone(){
        return new Eletrico(this);
    }

    public boolean equals (Object o){
        Eletrico e = (Eletrico) o;
        return super.equals(e);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder(super.toString());
        return sb.toString();
    }
}
