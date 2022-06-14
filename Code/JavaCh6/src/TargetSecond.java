import java.util.Calendar;
import java.util.Scanner;
import app.User;
public class TargetSecond {
	private Scanner Scan = new Scanner(System.in);
	private User [] setup;
	private int i=0;
	public TargetSecond() {
		setup = new User[2];
		setup[0]=new User("황기태");
		setup[1]=new User("이재문");
	}
	public void run() {
		System.out.println("10초에 가까운 사람이 이기는 게임입니다.");
		input();
		System.out.println(setup[0].getName()+"의 결과"+setup[0].getSub());
		System.out.println(setup[1].getName()+"의 결과"+setup[1].getSub());
		
		if(setup[0].getResult()<setup[1].getResult()) System.out.println(setup[0].getName()+" 승리");
		else System.out.println(setup[1].getName()+" 승리");
	}
	public void input() {
		while(i!=2) {
		System.out.println(setup[i].getName()+" 시작 <Enter>키");
		String Enter=Scan.nextLine();
		nowSecond();
		System.out.println("10초 예상 후 <Enter>키");
		Enter=Scan.nextLine();
		finishSecond();
		}
	}
	public void nowSecond() {
		Calendar c = Calendar.getInstance();
		int startsecond = c.get(Calendar.SECOND);
		setup[i].setStart(startsecond);
		System.out.println("현재 초 시간 = "+startsecond);
	}
	public void finishSecond() {
		Calendar c = Calendar.getInstance();
		int finishsecond = c.get(Calendar.SECOND);
		setup[i].setfinish(finishsecond);
		System.out.println("현재 초 시간 = "+finishsecond);
		i++;
	};
	public static void main(String[]args) {
		TargetSecond Game = new TargetSecond();
		Game.run();
	}
}
