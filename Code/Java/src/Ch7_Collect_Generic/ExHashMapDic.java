package Ch7_Collect_Generic;
import java.util.*;

public class ExHashMapDic {
	public static void main(String[]args) {
		HashMap<String,String> dic = new HashMap<String,String>();
		
		dic.put("baby", "�Ʊ�");
		dic.put("love", "���");
		dic.put("apple", "���");
		
		Scanner Scan=new Scanner(System.in);
		while(true) {
			System.out.print("ã�� �ܾ�>>");
			String find = Scan.next();
			String Get=dic.get(find);
			if(find.equals("exit")) {System.out.println("�����մϴ�."); break;}
			else if(Get==null) {System.out.println(find+"�� ���� �ܾ��Դϴ�."); continue;}
			else {
				System.out.println(find+"�� "+Get);
			}
		}
		Scan.close();
	}
}
