import java.util.Scanner;

public class ChangeSentanceVer2 {
	public static void main(String[]args) {
		Scanner Scan=new Scanner(System.in);
		System.out.print(">>");
		String origin = Scan.nextLine();
		StringBuffer sb=new StringBuffer(origin);
		while(true) {
			System.out.print("명령");
			String findStr=Scan.nextLine();
			String []st=findStr.split("!");
			if(findStr.equals("그만")) {
				System.out.println("종료합니다.");
				break;
			}
			if(st.length!=2) {
				System.out.println("잘못된 명령입니다.");
			}else {
				if(st[0].length()==0||st[1].length()==0) {
					System.out.println("잘못된 명령입니다.");
					continue;
				}
				int findAt = sb.indexOf(st[0]);
				if(findAt==-1) {
				System.out.println("찾을 수 없습니다.");
				}else {
				System.out.println(sb.replace(findAt, findAt+st[0].length(), st[1]));
				}
			}
		}
	}
}
