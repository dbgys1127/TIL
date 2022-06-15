package Ch7_Collect_Generic;
import java.util.*;

public class ExHashMapDic {
	public static void main(String[]args) {
		HashMap<String,String> dic = new HashMap<String,String>();
		
		dic.put("baby", "아기");
		dic.put("love", "사랑");
		dic.put("apple", "사과");
		
		Scanner Scan=new Scanner(System.in);
		while(true) {
			System.out.print("찾을 단어>>");
			String find = Scan.next();
			String Get=dic.get(find);
			if(find.equals("exit")) {System.out.println("종료합니다."); break;}
			else if(Get==null) {System.out.println(find+"는 없는 단어입니다."); continue;}
			else {
				System.out.println(find+"는 "+Get);
			}
		}
		Scan.close();
	}
}
