import java.util.StringTokenizer;
public class ExToken {
	public static void main(String[]args) {
		StringTokenizer St=new StringTokenizer("a=3,b=5,c=6","=,");
		int sum=0;
		while(St.hasMoreTokens()) {
			String next= St.nextToken();
			try {
				sum+=Integer.parseInt(next);
				System.out.println(next);
			}catch(NumberFormatException e) {
				System.out.println(next);
			}
		}
		System.out.println("гую╨ "+sum);
	}
}
