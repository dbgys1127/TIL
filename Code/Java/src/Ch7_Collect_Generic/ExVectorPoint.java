package Ch7_Collect_Generic;
import java.util.Vector;

class ExPoint {
	private int x,y;
	public ExPoint(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public String toString() {
		return "("+x+","+y+")";
	}
}

public class ExVectorPoint {
	public static void main(String[]args) {
		var v = new Vector<ExPoint>();
		v.add(new ExPoint(2,3));
		v.add(new ExPoint(-5,-20));
		v.add(new ExPoint(30,-8));
		
		v.remove(1);
		
		for(int i=0;i<v.size();i++) {
			ExPoint p = v.get(i);
			System.out.println(p);
		}
	}
}
