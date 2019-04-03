import java.io.Serializable;

public class Eletrico extends Veiculo implements Serializable {

    public Eletrico(){
        super();
    }

    public Eletrico(String matricula, double velmediakm, double precokm, double consumo, int classificacao, Coordenada coord, int autonomia, String proprietario) {
        super(matricula, velmediakm, precokm, consumo, classificacao, coord, autonomia, proprietario);
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
        StringBuilder sb = new StringBuilder(this.getClass().getSimpleName());
        sb.append(super.toString());
        return sb.toString();
    }
}
