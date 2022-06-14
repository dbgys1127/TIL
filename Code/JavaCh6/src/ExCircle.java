public class ExCircle {
	private int x,y,radius;
	public ExCircle(int x, int y, int radius) {
		this.x=x;
		this.y=y;
		this.radius=radius;
	}
	public String toString() {
		return "Circle("+x+","+y+") 반지름"+radius;
	}
	public boolean equals(Object obj) {
		ExCircle p = (ExCircle)obj;
		if(x==p.x && y==p.y) return true;
		else return false;
	}
	public static void main(String[]args) {
		ExCircle a=new ExCircle(2,3,5);
		ExCircle b=new ExCircle(2,3,30);
		System.out.println("원 a : "+a);
		System.out.println("원 b : "+b);
		if(a.equals(b)) System.out.println("같음");
		else System.out.println("다름");
	}
}
