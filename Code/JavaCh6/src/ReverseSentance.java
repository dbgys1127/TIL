import java.util.Scanner;
public class ReverseSentance {
	private Scanner Scan=new Scanner(System.in);
	public String ToString(char c) {
		return Character.toString(c);
	}
	public void run() {
		System.out.println("���ڿ��� �Է��ϼ���. ��ĭ�̳� �־ �ǰ� ���� �ѱ� ��� �˴ϴ�.");
		String a= Scan.nextLine();
		String b;
		char c;
		for(int i=0;i<a.length();i++) {
			b=a.substring(1);
			c=a.charAt(0);
			a=b.concat(ToString(c));
			System.out.println(a);
		}
	}
	
	public static void main(String[]args) {
		ReverseSentance Rs=new ReverseSentance();
		Rs.run();
	}
}
