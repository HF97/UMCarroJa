import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Proprietario extends Utilizador implements Serializable {

    private int classificacao;
    private List<String> carros;

    public Proprietario(){
        super();
        this.classificacao = 0;
        List<Integer> carros = new ArrayList<Integer>();
    }

    public Proprietario (String nome, int NIF, String email, String password, String morada, LocalDate datanasc, int classificacao, Collection<String> carros){
        super(nome, NIF, email, password, morada, datanasc);
        this.classificacao = classificacao;
        this.carros = new ArrayList<String>();
        for(String s : carros){
            carros.add(s);
        }
    }

    public Proprietario (Proprietario p){
        super(p);
        this.classificacao = p.getClassificacao();
        this.carros = p.getCarros();
    }

    public int getClassificacao(){
        return this.classificacao;
    }

    public List<String> getCarros() {
        return carros;
    }

    public void setClassificacao(int c){
        this.classificacao = c;
    }

    public void setCarros(List<String> carros) {
        this.carros = carros;
    }

    public boolean equals(Object o) {
        if (o==this) {return true;}
        if(o==null || o.getClass() != this.getClass()) {return false;}
        Proprietario p = (Proprietario) o;
        return  super.equals(p) &&
                p.getClassificacao() == (classificacao);
    }

    public Proprietario clone(){
        return new Proprietario(this);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\nClassificacao: ");
        sb.append(this.getClassificacao());
        sb.append("\n");
        return sb.toString();
    }
}
