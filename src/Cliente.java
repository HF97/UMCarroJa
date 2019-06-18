import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

public class Cliente extends Utilizador implements Serializable {

    private Coordenada coord;

    public Cliente(){
        super();
        coord = new Coordenada();
    }

    public Cliente(String nome, int NIF, String email, String password, String morada, LocalDate datanasc, Coordenada coord, Collection<Integer> histAlugUti){
        super(nome, NIF, email, password, morada, datanasc, histAlugUti);
        this.coord = coord;
    }

    public Cliente (Cliente c){
        super(c);
        this.coord = c.getCoord();
    }

    public Coordenada getCoord() {
        return this.coord;
    }

    public boolean equals(Object o) {
        if (o==this) {return true;}
        if(o==null || o.getClass() != this.getClass()) {return false;}
        Cliente c = (Cliente) o;
        return  super.equals(c) &&
                c.getCoord().equals(coord);
    }

    public Cliente clone(){
        return new Cliente(this);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(this.getCoord());
        sb.append("\n");
        return sb.toString();
    }
}
