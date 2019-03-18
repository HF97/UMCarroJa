import java.io.Serializable;
import java.time.LocalDate;

public class Proprietario extends Actor implements Serializable {

    //TODO  Fazer hash com os carros
    //TODO  Fazer hash com o historico

        private int classificacao;

    public Proprietario(){
        super();
        this.classificacao = 0;
    }

    public Proprietario (String nome, int NIF, String email, int password, String morada, LocalDate datanasc, int classificacao){
        super(nome, NIF, email, password, morada, datanasc);
        this.classificacao = classificacao;
    }

    public Proprietario (Proprietario p){
        super(p);
        this.classificacao = p.getClassificacao();
    }

    public int getClassificacao(){
        return this.classificacao;
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
        return sb.toString();
    }
}
