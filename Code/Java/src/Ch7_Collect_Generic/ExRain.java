package Ch7_Collect_Generic;
import java.util.*;

public class ExRain {
	public static void main(String[]args) {
		Scanner Scan = new Scanner(System.in);
		Vector<Integer> v = new Vector<>();

		while(true) {
			double sum=0;
			double avg;
			System.out.print("강수랑 입력(0 입력 시 종료)>> ");
			int n= Scan.nextInt();
			if(n==0) break;
			v.add(n);
			for(int i=0;i<v.size();i++) {
				System.out.print(v.get(i)+" ");
				sum+=v.get(i);
			}
			System.out.println();
			avg=sum/v.size();
			System.out.println("현재 평균 >> "+avg);
		}
	}
}
