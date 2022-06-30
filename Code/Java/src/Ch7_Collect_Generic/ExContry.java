package Ch7_Collect_Generic;
import java.util.*;

public class ExContry {
	public static void main(String[]args) {
		Scanner Scan = new Scanner(System.in);
		HashMap<String,Integer> h = new HashMap<>();
		System.out.println("나라 이름과 인구를 입력하세요.");
		while(true) {
			System.out.print("나라 이름, 인구>> ");
			String Key = Scan.next();
			if(Key.equals("그만"))break;
			int Value = Scan.nextInt();
			h.put(Key, Value);
		}

		while(true) {
			System.out.print("인구 검색>> ");
			String find = Scan.next();
			Integer how = h.get(find);
			if(find.equals("그만")) break;
			if(how==null) System.out.println(find+"는 없습니다.");
			else {
				System.out.println(find+" 인구 : "+ how);
			}
		}
	}
}
