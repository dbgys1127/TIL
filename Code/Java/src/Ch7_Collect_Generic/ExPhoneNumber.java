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
		
		map.put("������", new Student(1,"010-3582-1127"));
		map.put("������", new Student(2,"010-8602-8648"));
		map.put("��ƺ�", new Student(3,"010-3546-1834"));
		
		Scanner Scan=new Scanner(System.in);
		while(true) {
			System.out.print("�˻��� �̸� >> ");
			String name = Scan.next();
			Student student = map.get(name);
			if(name.equals("�׸�")) {System.out.println("�����մϴ�."); break;}
			else if(student==null) {System.out.println(name+"�� �˻����� �ʽ��ϴ�."); continue;}
			else {
				System.out.println("Id : "+student.getId()+" tel : "+student.getTel());
			}
		}
		Scan.close();
	}
}
