import java.util.*;

public class ChangeSentance {
	private Scanner Scan=new Scanner(System.in);
	private String originStr[],findStr[];
	public void run() {
		String origin=originalStr();
		findChangeStr(origin);
	}
	public String originalStr() {
		System.out.print("�������� �Է��ϼ���>>>");
		String origin=Scan.nextLine();
		return origin;
	}
	public void findChangeStr(String origin) {
		originStr=origin.split(" ");
		while(true) {
			int TF=0;
			System.out.print("���");
			String find=Scan.nextLine();
			findStr=find.split("!");
			if(find.equals("�׸�")) {System.out.println("�����մϴ�."); break;}
			for(int i=0;i<originStr.length;i++) {
				if(findStr[0].equals(originStr[i])) {
					originStr[i]=findStr[1];
					//System.out.println("@");
					TF=1;
					break;
				}
			}
			if(find.charAt(0)=='!')System.out.println("�߸��� ����Դϴ�.");
			else if(TF==0) System.out.println("ã�� �� �����ϴ�.");
			else {
				for(int j=0;j<originStr.length;j++) System.out.print(originStr[j]+" ");
				System.out.println();
			}
		}
	}
	public static void main(String[]args) {
		ChangeSentance Cs=new ChangeSentance();
		Cs.run();
	}
}
