import java.util.Scanner;

public class GambleApp {
	private Scanner Scan=new Scanner(System.in);
	private GambleUser[] Gu;
	public GambleApp() {
		Gu=new GambleUser[2];
	}
	public void run() {
		for(int i=0;i<Gu.length;i++) {
			System.out.print(i+1+"��° ���� �̸� >>");
			Gu[i]=new GambleUser(Scan.nextLine());
		}
		int i=0;
		while(true) {
			System.out.println("["+Gu[i].getName()+"] : <Enter>");
			String Enter=Scan.nextLine();
			int first =(int)(Math.random()*3+1);
			int second =(int)(Math.random()*3+1);
			int third =(int)(Math.random()*3+1);
			System.out.print("     "+first+" "+second+" "+third+" ");
			if(first==second&&first==third) {
				System.out.println(Gu[i].getName()+"�� �¸�!!!");
				break;
			}else {
				System.out.println("�ƽ�����!!!");
				if(i==1) i=0;
				else i=1;
			}
		}
	}
	public static void main(String[]args) {
		GambleApp Game=new GambleApp();
		Game.run();
	}
}
