import java.util.Scanner;

public class GambleAppVer2 {
	private static Scanner Scan=new Scanner(System.in);
	private GambleUser[] Gu;
	private static int Users;
	public GambleAppVer2(int Users) {
		Gu=new GambleUser[Users];
	}
	public void run() {
		for(int i=0;i<Gu.length;i++) {
			System.out.print(i+1+"번째 선수 이름 >>");
			Gu[i]=new GambleUser(Scan.next());
		}
		int i=0;
		while(true) {
			Scanner ScanEnter=new Scanner(System.in);
			System.out.println("["+Gu[i].getName()+"] : <Enter>");
			String Enter=ScanEnter.nextLine();
			int first =(int)(Math.random()*3+1);
			int second =(int)(Math.random()*3+1);
			int third =(int)(Math.random()*3+1);
			System.out.print("     "+first+" "+second+" "+third+" ");
			if(first==second&&first==third) {
				System.out.println(Gu[i].getName()+"님 승리!!!");
				break;
			}else {
				System.out.println("아쉽군요!!!");
				if(i==Users-1) i=0;
				else i++;
			}
		}
	}
	public static void main(String[]args) {
		System.out.print("참여 인원>>");
		Users=Scan.nextInt();
		GambleAppVer2 Game=new GambleAppVer2(Users);
		Game.run();
	}
}