import java.util.Scanner;

public class ScissorsApp {
	private Scanner Scan=new Scanner(System.in);
	private Scissors []SRP;
	public ScissorsApp() {
		SRP=new Scissors[2];
	}
	public void run() {
		while(true) {
			System.out.print("ö��[����(1), ����(2), ��(3), ������(4)]>>");
			int Select=Scan.nextInt();
			if(Select==4) {System.out.println("�����մϴ�.");break;}
			else {
				setSelect(Select);
				getResult();
			}
		}
	}
	public void setSelect(int User) {
		SRP[0]=new Scissors(User);
		int Com=(int)(Math.random()*3+1);
		SRP[1]=new Scissors(Com);
	}
	public void getResult() {
		String UserSelect=SRP[0].getSelect();
		String ComSelect=SRP[1].getSelect();
		if(UserSelect=="����") {
			System.out.print("ö��(����) : ");
			if(ComSelect=="����") {
				System.out.println(" ��ǻ��(����)");
				System.out.println("�����ϴ�.");
			}else if(ComSelect=="����") {
				System.out.println(" ��ǻ��(����)");
				System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
			}else {
				System.out.println(" ��ǻ��(��)");
				System.out.println("ö���� �̰���ϴ�.");
			}
		}else if(UserSelect=="����") {
			System.out.print("ö��(����) : ");
			if(ComSelect=="����") {
				System.out.println(" ��ǻ��(����)");
				System.out.println("ö���� �̰���ϴ�.");
			}else if(ComSelect=="����") {
				System.out.println(" ��ǻ��(����)");
				System.out.println("�����ϴ�.");
			}else {
				System.out.println(" ��ǻ��(��)");
				System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
			}
		}else{
			System.out.print("ö��(��) : ");
			if(ComSelect=="����") {
				System.out.println(" ��ǻ��(����)");
				System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
			}else if(ComSelect=="����") {
				System.out.println(" ��ǻ��(����)");
				System.out.println("ö���� �̰���ϴ�.");
			}else {
				System.out.println(" ��ǻ��(��)");
				System.out.println("�����ϴ�.");
			}
		}
	}
	public static void main(String[]args) {
		ScissorsApp Game = new ScissorsApp();
		Game.run();
	}
}
