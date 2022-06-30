import java.util.Scanner;
public class ReverseSentance {
	private Scanner Scan=new Scanner(System.in);
	public String ToString(char c) {
		return Character.toString(c);
	}
	public void run() {
		System.out.println("문자열을 입력하세요. 빈칸이나 있어도 되고 영어 한글 모두 됩니다.");
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
