import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Utilizador implements Serializable {

    private String nome;
    private int NIF;
    private String email;
    private String password;
    private String morada;
    private LocalDate datanasc;
    private List<Integer> histAlugUti;

    public Utilizador(){
        this.nome = "";
        this.NIF = 0;
        this.email = "";
        this.password = "";
        this.morada = "";
        this.datanasc = LocalDate.now();
        this.histAlugUti = new ArrayList<Integer>();
    }

    public Utilizador(String nome, int NIF, String email, String password, String morada, LocalDate datanasc){
        this.nome = nome;
        this.NIF = NIF;
        this.email = email;
        this.password = password;
        this.morada = morada;
        this.datanasc = datanasc;
        this.histAlugUti = new ArrayList<Integer>();
    }

    public Utilizador(Utilizador a){
        this.nome = a.getNome();
        this.NIF = a.getNIF();
        this.email = a.getEmail();
        this.password = a.getPassword();
        this.morada = a.getMorada();
        this.datanasc = a.getDatanasc();
        this.histAlugUti = a.getHistAlugUti();
    }

    public String getNome(){
        return this.nome;
    }

    public int getNIF(){
        return this.NIF;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getMorada() {
        return this.morada;
    }

    public LocalDate getDatanasc() {
        return this.datanasc;
    }

    public List<Integer> getHistAlugUti(){
        return this.histAlugUti;
    }

    @Override
    public boolean equals(Object o) {
        if (o==this) {return true;}
        if (o==null || o.getClass() != this.getClass()) {return false;}
        Utilizador a = (Utilizador) o;
        return a.getNome().equals(nome) &&
                a.getNIF() == NIF &&
                a.getEmail().equals(email) &&
                a.getPassword() == password &&
                a.getMorada().equals(morada) &&
                a.getDatanasc().equals(datanasc);
    }

    public abstract Utilizador clone();

    public String toString(){
        StringBuilder sb = new StringBuilder("Email: ");
        sb.append(this.getEmail());
        sb.append("\nPassword: ");
        sb.append(this.getPassword());
        sb.append("\nNome: ");
        sb.append(this.getNome());
        sb.append("\nNIF: ");
        sb.append(this.getNIF());
        sb.append("\nMorada: ");
        sb.append(this.getMorada());
        sb.append("\nData de nascimento: ");
        sb.append(this.getDatanasc());
        sb.append("\nHistorico: ");
        return sb.toString();
    }
}