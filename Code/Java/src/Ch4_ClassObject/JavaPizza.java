package Ch4_ClassObject;

public class JavaPizza {
	int radius;
	String name;
	
	public double getArea() {
		return 3.14*radius*radius;
	}
	
	public static void main(String[] args) {
		JavaPizza Pizza;
		Pizza=new JavaPizza(); 
		Pizza.name="�ڹ�����";
		Pizza.radius=10;
		double Cicle=Pizza.getArea();
		System.out.println(Pizza.name+"�� ���� : "+Cicle);
		
		JavaPizza Donut;
		Donut=new JavaPizza();
		Donut.name="�ڹٵ���";
		Donut.radius=100;
		Cicle=Donut.getArea();
		System.out.println(Donut.name+"�� ���� : "+Cicle);
		
	}
}
