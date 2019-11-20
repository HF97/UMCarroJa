import java.io.Serializable;
import java.time.LocalDate;
import java.time.Duration;

public class Aluguer implements Serializable {

    private int id;
    private Coordenada coordI;
    private Coordenada coordF;
    private Veiculo veiculo;
    private LocalDate data;
    private Duration duracao;
    private String emailCliente;
    private String emailProprietario;
    private double custoTotal;
    private double classificacao;

    public Aluguer() {
        this.id = 0;
        this.coordI = new Coordenada();
        this.coordF = new Coordenada();
        this.veiculo = new Gasolina();
        this.data = LocalDate.now();
        this.duracao = Duration.ZERO;
        this.emailCliente = "";
        this.emailProprietario = "";
        this.custoTotal = 0.0;
        this.classificacao = 0.0;
    }

    public Aluguer(int id, Coordenada coordI, Coordenada coordF, Veiculo veiculo, LocalDate data, Duration duracao, String emailCliente, String emailProprietario, double custoTotal, double classificacao){
        this.id = id;
        this.coordI = coordI;
        this.coordF = coordF
        this.veiculo = veiculo;
        this.data = data;
        this.duracao = duracao;
        this.emailCliente = emailCliente;
        this.emailProprietario = emailProprietario;
        this.custoTotal = custoTotal;
        this.classificacao = classificacao;
    }

    public Aluguer(Aluguer al){
        this.id = al.getId();
        this.coordI = al.getCoordI();
        this.coordF = al.getCoordF();
        this.veiculo = al.getVeiculo();
        this.data = al.getData();
        this.duracao = al.getDuracao();
        this.emailCliente = al.getEmailCliente();
        this.emailProprietario = al.getEmailProprietario();
        this.custoTotal = al.getCustoTotal();
        this.classificacao = al.getClassificacao();
    }

    public int getId() {
        return id;
    }

    public Coordenada getCoordI() {return coordI;}

    public Coordenada getCoordF() {
        return coordF;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public LocalDate getData() {
        return data;
    }

    public Duration getDuracao() {
        return duracao;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public String getEmailProprietario() {
        return emailProprietario;
    }

    public double getCustoTotal() {
        return custoTotal;
    }

    public double getClassificacao() {
        return classificacao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCoordI(Coordenada coordI) {
        this.coordI = coordI;
    }

    public void setCoordF

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setData(LocalDate data){
        this.data = data;
    }

    public void setDuracao(Duration duracao) {
        this.duracao = duracao;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public void setEmailProprietario(String emailProprietario) {
        this.emailProprietario = emailProprietario;
    }

    public void setCustoTotal(double custoTotal) {
        this.custoTotal = custoTotal;
    }

    public void setClassificacao(double classificacao) {
        this.classificacao = classificacao;
    }

    public boolean equals (Object o){
        if (o==this) {return true;}
        if(o==null || o.getClass() != this.getClass()) {return false;}
        Aluguer al = (Aluguer) o;
        return id == al.getId() &&
                coordI.equals(al.getCoordI()) &&
                coordF.equals(al.coordF()) &&
                veiculo.equals(al.getVeiculo()) &&
                data.equals(al.getData()) &&
                duracao == al.getDuracao() &&
                emailCliente.equals(al.getEmailCliente()) &&
                emailProprietario.equals(al.getEmailProprietario()) &&
                custoTotal == al.getCustoTotal() &&
                classificacao == al.getClassificacao();
    }

    public Aluguer clone(){
        return new Aluguer(this);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("Id: ");
        sb.append(this.getId());
        sb.append("Coordenada de Inicio: ");
        sb.append(this.getCoordI().toString());
        sb.append("Coordenada de Fim: ");
        sb.append(this.getCoordF().toString());
        sb.append(this.getVeiculo().toString());
        sb.append(this.getData().toString());
        sb.append("Duracao: ");
        sb.append(this.getDuracao());
        sb.append("Email do cliente: ");
        sb.append(this.getEmailCliente());
        sb.append("Email do proprietario: ");
        sb.append(this.getEmailProprietario());
        sb.append("Custo total: ");
        sb.append(this.getCustoTotal());
        sb.append("Classificacao: ");
        sb.append(this.getClassificacao());
        return sb.toString();
    }
}
