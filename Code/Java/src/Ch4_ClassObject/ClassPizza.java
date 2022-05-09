package Ch4_ClassObject;

public class ClassPizza {
	int radius;
	String name;
	
	public ClassPizza() {}
	
	public double getArea() {
		return 3.14*radius*radius;
	}
	
	public static void main(String[] args) {
		
		ClassPizza Pizza;
		Pizza=new ClassPizza();
		Pizza.radius=10;
		Pizza.name="Domino";
		double AreaPizza=Pizza.getArea();
		
		ClassPizza Donut=new ClassPizza();
		Donut.radius=100;
		Donut.name="Dunkin";
		double AreaDonut=Donut.getArea();
		
		System.out.println(Pizza.name+"의 면적 >> "+AreaPizza);
		System.out.println(Donut.name+"의 면적 >> "+AreaDonut);
		
	}
}
