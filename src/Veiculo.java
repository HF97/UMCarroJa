import java.io.DataOutput;
import java.io.Serializable;

public abstract class Veiculo implements Serializable {

    private double velmediakm;
    private double precokm;
    private double consumo;

    //TODO  Hash com historico

    private int classificacao;
    private Coordenada coord;
    private int autonomia;

    public Veiculo(){
        this.velmediakm = 0.0;
        this.precokm = 0.0;
        this.consumo = 0.0;
        this.classificacao = 0;
        this.coord = new Coordenada();
        this.autonomia = 0;
    }

    public Veiculo(double velmediakm, double precokm, double consumo, int classificacao, Coordenada coord, int autonomia){
        this.velmediakm = velmediakm;
        this.precokm = precokm;
        this.consumo = consumo;
        this.classificacao = classificacao;
        this.coord = coord;
        this.autonomia = autonomia;
    }

    public Veiculo(Veiculo v){
        this.velmediakm = v.getVelmediakm();
        this.precokm = v.getPrecokm();
        this.consumo = v.getConsumo();
        this.classificacao = v.getClassificacao();
        this.coord = v.getCoord();
        this.autonomia = v.getAutonomia();
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

    public int getClassificacao() {
        return classificacao;
    }

    public Coordenada getCoord() {
        return coord;
    }

    public int getAutonomia() {
        return autonomia;
    }

    public boolean equals(Object o) {
        if (o==this) {return true;}
        if (o==null || o.getClass() != this.getClass()) {return false;}
        Veiculo v = (Veiculo) o;
        return v.getVelmediakm() == velmediakm &&
                v.getPrecokm() == precokm &&
                v.getConsumo() == consumo &&
                v.getClassificacao() == classificacao &&
                v.getCoord().equals(coord) &&
                v.getAutonomia() == (autonomia);
    }

    public abstract Veiculo clone();

    public String toString(){
        StringBuilder sb = new StringBuilder("Velocidade media por km: ");
        sb.append(this.getVelmediakm());
        sb.append("\nPreco por km: ");
        sb.append(this.getPrecokm());
        sb.append("\nConsumo: ");
        sb.append(this.getConsumo());
        sb.append("\nClassificacao: ");
        sb.append(this.getClassificacao());
        sb.append(this.getCoord());
        sb.append("Autonomia: ");
        sb.append(this.getAutonomia());
        return sb.toString();
    }
}
