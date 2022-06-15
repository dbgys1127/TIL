package Ch7_Collect_Generic;
import java.util.*;

public class ExFindMax {
	public static void main(String[]args) {
		Scanner Scan=new Scanner(System.in);
		var V = new Vector<Integer>();
		System.out.print("정수를 입력하시오.(-1입력시 종료됨) >>");
		while(true) {
			int enter=Scan.nextInt();
			if(enter==-1) break;
			V.add(enter);
		}
		int Max = Collections.max(V);
		System.out.println(Max);
	}
}
