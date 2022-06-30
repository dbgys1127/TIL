package Ch4_ClassObject;

public class Circle {
	int radius;
	String name;
	public Circle() {
		radius=1; 
		name="";
	}
	public Circle(int r, String n) {
		radius=r; 
		name=n;
	}
	public double getArea() {
		return 3.14*radius*radius;
	}
	public static void main(String[] args) {
		Circle pizza;
		pizza=new Circle();
		pizza.name="Domino";
		System.out.println(pizza.name+"�� ���� >> "+pizza.getArea());
		
		Circle donut=new Circle(10,"Dunkin");
		System.out.println(donut.name+"�� ���� >> "+donut.getArea());
		
		
	}
}
