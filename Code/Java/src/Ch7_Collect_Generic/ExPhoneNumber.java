package Ch7_Collect_Generic;
import java.util.*;

class Student{
	private int id;
	private String tel;
	public Student(int id, String tel) {
		this.id=id;
		this.tel=tel;
	}
	public int getId() {return id;}
	public String getTel() {return tel;}
}

public class ExPhoneNumber {
	public static void main(String[]args) {
		var map = new HashMap<String,Student>();
		
		map.put("김유현", new Student(1,"010-3582-1127"));
		map.put("박현아", new Student(2,"010-8602-8648"));
		map.put("울아빠", new Student(3,"010-3546-1834"));
		
		Scanner Scan=new Scanner(System.in);
		while(true) {
			System.out.print("검색할 이름 >> ");
			String name = Scan.next();
			Student student = map.get(name);
			if(name.equals("그만")) {System.out.println("종료합니다."); break;}
			else if(student==null) {System.out.println(name+"는 검색되지 않습니다."); continue;}
			else {
				System.out.println("Id : "+student.getId()+" tel : "+student.getTel());
			}
		}
		Scan.close();
	}
}
