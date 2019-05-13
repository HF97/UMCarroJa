import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public abstract class Veiculo implements Serializable {

    private String matricula;
    private double velmediakm;
    private double precokm;
    private double consumo;

    private int classificacao;
    private Coordenada coord;
    private int autonomia;
    private String proprietario;
    private List<Aluguer> histAlugVeic;
    private String estado;

    public Veiculo(){
        this.matricula = "";
        this.velmediakm = 0.0;
        this.precokm = 0.0;
        this.consumo = 0.0;
        this.classificacao = 0;
        this.coord = new Coordenada();
        this.autonomia = 0;
        this.proprietario = "";
        this.estado = "livre";
        this.histAlugVeic = new ArrayList<Aluguer>();
    }

    public Veiculo(String matricula, double velmediakm, double precokm, double consumo, int classificacao, Coordenada coord, int autonomia, String proprietario, String estado, Collection<Aluguer> histAlugVeic){
        this.matricula = matricula;
        this.velmediakm = velmediakm;
        this.precokm = precokm;
        this.consumo = consumo;
        this.classificacao = classificacao;
        this.coord = coord;
        this.autonomia = autonomia;
        this.proprietario = proprietario;
        this.estado = estado;
        for(Aluguer a : histAlugVeic){
            histAlugVeic.add(a);
        }
    }

    public Veiculo(Veiculo v){
        this.matricula = v.getMatricula();
        this.velmediakm = v.getVelmediakm();
        this.precokm = v.getPrecokm();
        this.consumo = v.getConsumo();
        this.classificacao = v.getClassificacao();
        this.coord = v.getCoord();
        this.autonomia = v.getAutonomia();
        this.proprietario = v.getProprietario();
        this.estado = v.getEstado();
        this.histAlugVeic = v.getHistAlugVeic();
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

    public int getClassificacao() {
        return classificacao;
    }

    public Coordenada getCoord() {
        return coord;
    }

    public int getAutonomia() {
        return autonomia;
    }

    public String getProprietario() {
        return proprietario;
    }

    public String getEstado() {
        return estado;
    }

    public List<Aluguer> getHistAlugVeic(){
        return this.histAlugVeic;
    }

    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public void setCoord(Coordenada coord) {
        this.coord = coord;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setHistAlugVeic(List<Aluguer> histAlugVeic) {
        this.histAlugVeic = histAlugVeic;
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
                v.getCoord().equals(coord) &&
                v.getAutonomia() == (autonomia) &&
                v.getProprietario().equals(proprietario) &&
                v.getEstado().equals(estado) &&
                v.getHistAlugVeic().equals(histAlugVeic);
    }

    public abstract Veiculo clone();

    public String toString(){
        StringBuilder sb = new StringBuilder("Matricula: ");
        sb.append(this.getMatricula());
        sb.append("Velocidade media por km: ");
        sb.append(this.getVelmediakm());
        sb.append("\nPreco por km: ");
        sb.append(this.getPrecokm());
        sb.append("\nConsumo: ");
        sb.append(this.getConsumo());
        sb.append("\nClassificacao: ");
        sb.append(this.getClassificacao());
        sb.append(this.getCoord());
        sb.append("\nAutonomia: ");
        sb.append(this.getAutonomia());
        sb.append("\nProprietario: ");
        sb.append(this.getProprietario());
        sb.append("\nEstado: ");
        sb.append(this.getEstado());
        sb.append("\nHistorico:");
        for(Aluguer a : this.getHistAlugVeic()){
            sb.append(sb.toString());
        }
        return sb.toString();
    }
}
