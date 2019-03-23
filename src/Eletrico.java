import java.io.Serializable;

public class Eletrico extends Veiculo implements Serializable {

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
