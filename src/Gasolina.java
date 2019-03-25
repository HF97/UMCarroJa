import java.io.Serializable;

public class Gasolina extends Veiculo implements Serializable {

    //TODO  acabar classes dos veiculos

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
