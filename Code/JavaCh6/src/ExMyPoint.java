
public class ExMyPoint {
	private int x,y;
	public ExMyPoint(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public String toString() {
		return "Point("+x+","+y+")";
	}
	public boolean equals(Object obj) {
		ExMyPoint p=(ExMyPoint)obj;
		if(x==p.x&&y==p.y) {
			return true;
		}else {
			return false;
		}
	}
	public static void main(String[]args) {
		ExMyPoint p=new ExMyPoint(3,50);
		ExMyPoint q=new ExMyPoint(4,50);
		System.out.println(p);
		if(p.equals(q)) {
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
	}
}
