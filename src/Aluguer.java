import java.io.Serializable;
import java.time.LocalDate;

public class Aluguer implements Serializable {

    //TODO  mudar duracao para horas
    private int id;
    private Coordenada coord;
    private Veiculo veiculo;
    private LocalDate data;
    private int duracao;
    private String emailCliente;
    private String emailProprietario;
    private double custoTotal;
    private int classificacao;

    //TODO  resolver new veiculo
    public Aluguer() {
        this.id = 0;
        this.coord = new Coordenada();
        this.veiculo = new Veiculo();
        this.data = LocalDate.now();
        this.duracao = 0;
        this.emailCliente = "";
        this.emailProprietario = "";
        this.custoTotal = 0.0;
        this.classificacao = 0;
    }

    public Aluguer(int id, Coordenada coord, Veiculo veiculo, LocalDate data, int duracao, String emailCliente, String emailProprietario, double custoTotal, int classificacao){
        this.id = id;
        this.coord = coord;
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
        this.coord = al.getCoord();
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

    public Coordenada getCoord() {
        return coord;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public LocalDate getData() {
        return data;
    }

    public int getDuracao() {
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

    public int getClassificacao() {
        return classificacao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCoord(Coordenada coord) {
        this.coord = coord;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setData(LocalDate data){
        this.data = data;
    }

    public void setDuracao(int duracao) {
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

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public boolean equals (Object o){
        if (o==this) {return true;}
        if(o==null || o.getClass() != this.getClass()) {return false;}
        Aluguer al = (Aluguer) o;
        return id == al.getId() &&
                coord.equals(al.getCoord()) &&
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
        sb.append(this.getCoord().toString());
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
    }
}
