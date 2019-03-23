import java.io.Serializable;

public class Hibrido extends Veiculo implements Serializable {

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
