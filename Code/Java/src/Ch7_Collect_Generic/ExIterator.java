package Ch7_Collect_Generic;
import java.util.*;

public class ExIterator {
	public static void main(String[]args) {
		Vector<Integer> v = new Vector<>();
		v.add(5);
		v.add(Integer.valueOf(4));
		v.add(-1);
		v.add(2,100);
		
		Iterator<Integer> it = v.iterator();
		while(it.hasNext()) {
			int n = it.next();
			System.out.print(n+" ");
		}
		System.out.println();
		
		int sum=0;
		it = v.iterator();
		while(it.hasNext()) {
			int n = it.next();
			sum+=n;
		}
		System.out.println("гу >> "+sum);
	}
}
