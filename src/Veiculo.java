import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public abstract class Veiculo implements Serializable {

    private String matricula;
    private double velmediakm;
    private double precokm;
    //consumo l/100
    private double consumo;
    private double classificacao;
    private int soma;
    private int contTotal;
    private Coordenada coord;
    //autonomia de 0 a 100
    private int autonomia;
    private int capacidadeDeposito;
    private String proprietario;
    private String estado;

    public Veiculo(){
        this.matricula = "";
        this.velmediakm = 0.0;
        this.precokm = 0.0;
        this.consumo = 0.0;
        this.classificacao = 0.0;
        this.soma = 0;
        this.contTotal = 0;
        this.coord = new Coordenada();
        this.autonomia = 0;
        this.capacidadeDeposito = 0;
        this.proprietario = "";
        this.estado = "livre";
    }

    public Veiculo(String matricula, double velmediakm, double precokm, double consumo, int classificacao, int soma, int contTotal, Coordenada coord, int autonomia, int capacidadeDeposito, String proprietario, String estado){
        this.matricula = matricula;
        this.velmediakm = velmediakm;
        this.precokm = precokm;
        this.consumo = consumo;
        this.classificacao = classificacao;
        this.soma = soma;
        this.contTotal = contTotal;
        this.coord = coord;
        this.autonomia = autonomia;
        this.capacidadeDeposito = capacidadeDeposito;
        this.proprietario = proprietario;
        this.estado = estado;
    }

    public Veiculo(Veiculo v){
        this.matricula = v.getMatricula();
        this.velmediakm = v.getVelmediakm();
        this.precokm = v.getPrecokm();
        this.consumo = v.getConsumo();
        this.classificacao = v.getClassificacao();
        this.soma = v.getSoma();
        this.contTotal = v.getContTotal();
        this.coord = v.getCoord();
        this.autonomia = v.getAutonomia();
        this.capacidadeDeposito = v.getCapacidadeDeposito();
        this.proprietario = v.getProprietario();
        this.estado = v.getEstado();
    }

    public String getMatricula() {
        return matricula;
    }

    public double getVelmediakm() {
        return velmediakm;
    }

    public double getPrecokm() {
        return precokm;
    }

    public double getConsumo() {
        return consumo;
    }

    public double getClassificacao() {
        return classificacao;
    }

    public int getSoma() {return soma;}

    public int getContTotal() {return contTotal;}

    public Coordenada getCoord() {
        return coord;
    }

    public int getAutonomia() {
        return autonomia;
    }

    public int getCapacidadeDeposito() {
        return capacidadeDeposito;
    }

    public String getProprietario() {
        return proprietario;
    }

    public String getEstado() {
        return estado;
    }

    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }

    public void setClassificacao(double classificacao) {
        this.classificacao = classificacao;
    }

    public void setSoma(int s) {this.soma = s;}

    public void setContTotal(int c) {this.contTotal = c;}

    public void setCoord(Coordenada coord) {
        this.coord = coord;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean equals(Object o) {
        if (o==this) {return true;}
        if (o==null || o.getClass() != this.getClass()) {return false;}
        Veiculo v = (Veiculo) o;
        return v.getMatricula().equals(matricula) &&
                v.getVelmediakm() == velmediakm &&
                v.getPrecokm() == precokm &&
                v.getConsumo() == consumo &&
                v.getClassificacao() == classificacao &&
                v.getSoma() == soma &&
                v.getContTotal() == contTotal &&
                v.getCoord().equals(coord) &&
                v.getAutonomia() == (autonomia) &&
                v.getProprietario().equals(proprietario) &&
                v.getEstado().equals(estado);
    }

    public abstract Veiculo clone();

    public String toString(){
        StringBuilder sb = new StringBuilder("Matricula: ");
        sb.append(this.getMatricula());
        sb.append("\nVelocidade media por km: ");
        sb.append(this.getVelmediakm());
        sb.append("\nPreco por km: ");
        sb.append(this.getPrecokm());
        sb.append("\nConsumo: ");
        sb.append(this.getConsumo());
        sb.append("\nClassificacao: ");
        sb.append(this.getClassificacao());
        sb.append("\nSoma: ");
        sb.append(this.getSoma());
        sb.append("\nContador total: ");
        sb.append(this.getContTotal());
        sb.append(this.getCoord());
        sb.append("\nAutonomia: ");
        sb.append(this.getAutonomia());
        sb.append("\nProprietario: ");
        sb.append(this.getProprietario());
        sb.append("\nEstado: ");
        sb.append(this.getEstado());
        return sb.toString();
    }
}
