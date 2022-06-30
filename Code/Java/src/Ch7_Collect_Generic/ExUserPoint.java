package Ch7_Collect_Generic;

public class ExUserPoint {
    private String name;
    private int Point;
    public ExUserPoint(String name, int Point){
        this.name=name;
        this.Point=Point;
    }
    public void setPoint(int Point){
        this.Point+=Point;
    }
    public int getPoint(){
        return Point;
    }
    public String getName(){
        return name;
    }
}
