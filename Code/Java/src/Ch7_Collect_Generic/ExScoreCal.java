package Ch7_Collect_Generic;
import java.util.*;

public class ExScoreCal {
	public static void main(String[]args) {
		Scanner Scan = new Scanner(System.in);
		System.out.print("6개 학점을 빈칸으로 분리 입력>>> ");
		ArrayList <Character> c = new ArrayList<>();
		for(int i=0; i<6;i++) {
			String str = Scan.next();
			char ch = str.charAt(0);
			c.add(ch);
		}
		Iterator<Character> it =c.iterator();
		double sum=0,avg;
		while(it.hasNext()) {
			char ch = it.next();
			double Score;
			switch(ch) {
			case 'A': Score=4.0; sum+=Score; break;
			case 'B': Score=3.0; sum+=Score;break;
			case 'C': Score=2.0; sum+=Score;break;
			case 'D': Score=1.0; sum+=Score;break;
			case 'F': Score=0; sum+=Score;break;
			}
		}
		avg=sum/6;
		System.out.println(avg);
	}
}
