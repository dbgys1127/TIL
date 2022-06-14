import java.util.Scanner;

public class ScissorsApp {
	private Scanner Scan=new Scanner(System.in);
	private Scissors []SRP;
	public ScissorsApp() {
		SRP=new Scissors[2];
	}
	public void run() {
		while(true) {
			System.out.print("철수[가위(1), 바위(2), 보(3), 끝내기(4)]>>");
			int Select=Scan.nextInt();
			if(Select==4) {System.out.println("종료합니다.");break;}
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
		if(UserSelect=="가위") {
			System.out.print("철수(가위) : ");
			if(ComSelect=="가위") {
				System.out.println(" 컴퓨터(가위)");
				System.out.println("비겼습니다.");
			}else if(ComSelect=="바위") {
				System.out.println(" 컴퓨터(바위)");
				System.out.println("컴퓨터가 이겼습니다.");
			}else {
				System.out.println(" 컴퓨터(보)");
				System.out.println("철수가 이겼습니다.");
			}
		}else if(UserSelect=="바위") {
			System.out.print("철수(바위) : ");
			if(ComSelect=="가위") {
				System.out.println(" 컴퓨터(가위)");
				System.out.println("철수가 이겼습니다.");
			}else if(ComSelect=="바위") {
				System.out.println(" 컴퓨터(바위)");
				System.out.println("비겼습니다.");
			}else {
				System.out.println(" 컴퓨터(보)");
				System.out.println("컴퓨터가 이겼습니다.");
			}
		}else{
			System.out.print("철수(보) : ");
			if(ComSelect=="가위") {
				System.out.println(" 컴퓨터(가위)");
				System.out.println("컴퓨터가 이겼습니다.");
			}else if(ComSelect=="바위") {
				System.out.println(" 컴퓨터(바위)");
				System.out.println("철수가 이겼습니다.");
			}else {
				System.out.println(" 컴퓨터(보)");
				System.out.println("비겼습니다.");
			}
		}
	}
	public static void main(String[]args) {
		ScissorsApp Game = new ScissorsApp();
		Game.run();
	}
}
