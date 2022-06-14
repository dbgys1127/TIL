package Ch7_Collect_Generic;
import java.util.Vector;

public class ExVector {
	public static void main(String[]args) {
		Vector<Integer> v = new Vector<Integer>();
		v.add(Integer.valueOf(5));
		v.add(Integer.valueOf(4));
		v.add(-1);
		
		v.add(2,100);
		
		System.out.println("벡터 내 요소 개수 >> "+v.size());
		System.out.println("벡터 용량 >> "+v.capacity());
		
		for(int i=0;i<v.size();i++) {
			int n = v.get(i);
			System.out.print(n+" ");
		}
		System.out.println();
		for(int i=0;i<v.size();i++) {
			int m = v.elementAt(i);
			System.out.print(m+" ");
		}
		System.out.println();
		int sum=0;
		for(int i=0;i<v.size();i++) {
			int n=v.get(i);
			sum+=n;
		}
		System.out.println("전체 합>> "+sum);
	}
}
