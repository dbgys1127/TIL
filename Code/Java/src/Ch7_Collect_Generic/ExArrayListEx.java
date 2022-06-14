package Ch7_Collect_Generic;
import java.util.*;

public class ExArrayListEx {
	public static void main(String[]args) {
		Scanner Scan=new Scanner(System.in);
		var A = new ArrayList<String>();
		
		for(int i=0;i<4;i++) {
			System.out.print("이름을 입력하세요>> ");
			String s=Scan.next();
			A.add(i,s);
		}
		for(int i=0;i<A.size();i++) {
			String s = A.get(i);
			System.out.print(s+" ");
		}
		System.out.println();
		int longestIndex=0;
		for(int i=1;i<A.size();i++) {
			if(A.get(longestIndex).length()<A.get(i).length()) {
				longestIndex=i;
			}
		}
		System.out.println("가장 긴 이름>>>"+A.get(longestIndex));
	}
}
