import java.util.Scanner;

public class ChangeSentanceVer2 {
	public static void main(String[]args) {
		Scanner Scan=new Scanner(System.in);
		System.out.print(">>");
		String origin = Scan.nextLine();
		StringBuffer sb=new StringBuffer(origin);
		while(true) {
			System.out.print("���");
			String findStr=Scan.nextLine();
			String []st=findStr.split("!");
			if(findStr.equals("�׸�")) {
				System.out.println("�����մϴ�.");
				break;
			}
			if(st.length!=2) {
				System.out.println("�߸��� ����Դϴ�.");
			}else {
				if(st[0].length()==0||st[1].length()==0) {
					System.out.println("�߸��� ����Դϴ�.");
					continue;
				}
				int findAt = sb.indexOf(st[0]);
				if(findAt==-1) {
				System.out.println("ã�� �� �����ϴ�.");
				}else {
				System.out.println(sb.replace(findAt, findAt+st[0].length(), st[1]));
				}
			}
		}
	}
}
