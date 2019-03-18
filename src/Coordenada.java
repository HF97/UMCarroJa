import java.io.Serializable;

public class Coordenada implements Serializable
{
    private double x;
    private double y;

    public Coordenada(double x, double y){
        this.x=x;
        this.y=y;
    }

    public Coordenada(){
        this.x=0;
        this.y=0;
    }

    public Coordenada(Coordenada c){
        this.x=c.getX();
        this.y=c.getY();
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public Coordenada clone(){
        return new Coordenada(this);
    }

    public boolean equals(Object o){
        if(o==this) return true;
        if((o==null) || (o.getClass()!=this.getClass())) return false;
        Coordenada a = (Coordenada) o;
        return this.x==a.getX() && this.y==a.getY();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("Coordenada{x:");
        sb.append(this.getX());
        sb.append(", y:");
        sb.append(this.getY());
        sb.append("}");
        return sb.toString();
    }

}
