import java.io.Serializable;
import java.time.LocalDate;

public class Cliente implements Serializable {

    private Coordenada coord;

    // -TODO    fazer hash com o historial do cliente

    public Cliente(){
        super();
        coord = new Coordenada(0,0);
    }

    public Cliente(String nome, int NIF, String email, int password, String morada, LocalDate datanasc, Coordenada coord){
        super(nome, NIF, email, password, morada, datanasc);
        this.coord = coord;
    }

    public Cliente (Cliente c){
        super(c);
        this.coord = c.getCoord();
    }

}
