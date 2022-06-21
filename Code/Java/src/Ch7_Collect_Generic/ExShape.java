package Ch7_Collect_Generic;

abstract public class ExShape {
    public ExShape(){}
    public void paint(){draw();}
    abstract public void draw();
}
class Line extends ExShape{
    @Override
    public void draw(){
        System.out.println("Line");
    }
}
class Rect extends ExShape{
    @Override
    public void draw(){
        System.out.println("Rect");
    }
}
class Circle extends ExShape{
    @Override
    public void draw(){
        System.out.println("Circle");
    }
}