import javax.print.DocFlavor;
import java.io.Serializable;
import java.time.LocalDate;

public class Cliente extends Actor implements Serializable {

    private Coordenada coord;

    //TODO    Fazer hash com o historial do cliente
    //TODO    Depois mudar o toString e equals

    public Cliente(){
        super();
        coord = new Coordenada();
    }

    public Cliente(String nome, int NIF, String email, int password, String morada, LocalDate datanasc, Coordenada coord){
        super(nome, NIF, email, password, morada, datanasc);
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
        return sb.toString();
    }
}
