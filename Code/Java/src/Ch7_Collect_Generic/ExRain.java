package Ch7_Collect_Generic;
import java.util.*;

public class ExRain {
	public static void main(String[]args) {
		Scanner Scan = new Scanner(System.in);
		Vector<Integer> v = new Vector<>();

		while(true) {
			double sum=0;
			double avg;
			System.out.print("������ �Է�(0 �Է� �� ����)>> ");
			int n= Scan.nextInt();
			if(n==0) break;
			v.add(n);
			for(int i=0;i<v.size();i++) {
				System.out.print(v.get(i)+" ");
				sum+=v.get(i);
			}
			System.out.println();
			avg=sum/v.size();
			System.out.println("���� ��� >> "+avg);
		}
	}
}
