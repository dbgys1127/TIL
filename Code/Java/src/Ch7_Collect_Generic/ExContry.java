package Ch7_Collect_Generic;
import java.util.*;

public class ExContry {
	public static void main(String[]args) {
		Scanner Scan = new Scanner(System.in);
		HashMap<String,Integer> h = new HashMap<>();
		System.out.println("���� �̸��� �α��� �Է��ϼ���.");
		while(true) {
			System.out.print("���� �̸�, �α�>> ");
			String Key = Scan.next();
			if(Key.equals("�׸�"))break;
			int Value = Scan.nextInt();
			h.put(Key, Value);
		}

		while(true) {
			System.out.print("�α� �˻�>> ");
			String find = Scan.next();
			Integer how = h.get(find);
			if(find.equals("�׸�")) break;
			if(how==null) System.out.println(find+"�� �����ϴ�.");
			else {
				System.out.println(find+" �α� : "+ how);
			}
		}
	}
}
