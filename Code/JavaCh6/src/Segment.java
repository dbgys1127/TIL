import java.util.Scanner;
import java.util.StringTokenizer;
public class Segment {
	private Scanner Scan = new Scanner(System.in);
	private StringTokenizer St;
	private int count=0;
	public void run() {
		while(true) {
			System.out.print(">>>");
			String a = Scan.nextLine();
			if(a=="�׸�") break;
			String b[]=a.split(" ");
			System.out.println("���� ������ : "+b.length);
		}
	}
	public static void main(String[]args) {
		Segment Game=new Segment();
		Game.run();
	}
}
