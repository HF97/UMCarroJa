import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Proprietario extends Utilizador implements Serializable {

    private double classificacao;
    private int contTotal;
    private int soma;
    private List<String> carros;

    public Proprietario(){
        super();
        this.classificacao = 0.0;
        this.contTotal = 0;
        this.soma = 0;
    }

    public Proprietario (String nome, int NIF, String email, String password, String morada, LocalDate datanasc, double classificacao, int contTotal, int soma){
        super(nome, NIF, email, password, morada, datanasc);
        this.classificacao = classificacao;
        this.contTotal = contTotal;
        this.soma = soma;
        this.carros = new ArrayList<String>();
    }

    public Proprietario (Proprietario p){
        super(p);
        this.classificacao = p.getClassificacao();
        this.contTotal = p.getContTotal();
        this.soma = p.getSoma();
    }

    public double getClassificacao(){
        return this.classificacao;
    }

    public int getContTotal() {return this.contTotal;}

    public int getSoma() {return this.soma;}

    public void setClassificacao(double c){
        this.classificacao = c;
    }

    public void setContTotal(int n) {this.contTotal = n;}

    public void setSoma(int t) {this.soma = t;}

    public boolean equals(Object o) {
        if (o==this) {return true;}
        if(o==null || o.getClass() != this.getClass()) {return false;}
        Proprietario p = (Proprietario) o;
        return  super.equals(p) &&
                p.getClassificacao() == (classificacao) &&
                p.getContTotal() == (contTotal) &&
                p.getSoma() == (soma);
    }

    public Proprietario clone(){
        return new Proprietario(this);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\nClassificacao: ");
        sb.append(this.getClassificacao());
        sb.append("\nNumero de classificacoes: ");
        sb.append(this.getContTotal());
        sb.append("\nTotal das classificacoes: ");
        sb.append(this.getSoma());
        return sb.toString();
    }
}
