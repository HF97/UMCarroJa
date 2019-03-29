import java.io.Serializable;

public class Gasolina extends Veiculo implements Serializable {

    public Gasolina(){
        super();
    }

    public Gasolina(String matricula, double velmediakm, double precokm, double consumo, int classificacao, Coordenada coord, int autonomia) {
        super(matricula, velmediakm, precokm, consumo, classificacao, coord, autonomia);
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
