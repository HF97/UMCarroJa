import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Proprietario extends Utilizador implements Serializable {

    private double classificacao;
    private int numClass;
    private int total;
    private List<String> carros;

    public Proprietario(){
        super();
        this.classificacao = 0.0;
        this.numClass = 0;
        this.total = 0;
    }

    public Proprietario (String nome, int NIF, String email, String password, String morada, LocalDate datanasc, double classificacao, int numClass, int total){
        super(nome, NIF, email, password, morada, datanasc);
        this.classificacao = classificacao;
        this.numClass = numClass;
        this.total = total;
        this.carros = new ArrayList<String>();
    }

    public Proprietario (Proprietario p){
        super(p);
        this.classificacao = p.getClassificacao();
        this.numClass = p.getNumClass();
        this.total = p.getTotal();
    }

    public double getClassificacao(){
        return this.classificacao;
    }

    public int getNumClass() {return this.numClass;}

    public int getTotal() {return this.total;}

    public void setClassificacao(double c){
        this.classificacao = c;
    }

    public void setNumClass(int n) {this.numClass = n;}

    public void setTotal(int t) {this.total = t;}

    public boolean equals(Object o) {
        if (o==this) {return true;}
        if(o==null || o.getClass() != this.getClass()) {return false;}
        Proprietario p = (Proprietario) o;
        return  super.equals(p) &&
                p.getClassificacao() == (classificacao) &&
                p.getNumClass() == (numClass) &&
                p.getTotal() == (total);
    }

    public Proprietario clone(){
        return new Proprietario(this);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\nClassificacao: ");
        sb.append(this.getClassificacao());
        sb.append("\nNumero de classificacoes: ");
        sb.append(this.getNumClass());
        sb.append("\nTotal das classificacoes: ");
        sb.append(this.getTotal());
        return sb.toString();
    }
}
