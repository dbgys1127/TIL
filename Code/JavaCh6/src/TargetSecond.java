import java.util.Calendar;
import java.util.Scanner;
import app.User;
public class TargetSecond {
	private Scanner Scan = new Scanner(System.in);
	private User [] setup;
	private int i=0;
	public TargetSecond() {
		setup = new User[2];
		setup[0]=new User("Ȳ����");
		setup[1]=new User("���繮");
	}
	public void run() {
		System.out.println("10�ʿ� ����� ����� �̱�� �����Դϴ�.");
		input();
		System.out.println(setup[0].getName()+"�� ���"+setup[0].getSub());
		System.out.println(setup[1].getName()+"�� ���"+setup[1].getSub());
		
		if(setup[0].getResult()<setup[1].getResult()) System.out.println(setup[0].getName()+" �¸�");
		else System.out.println(setup[1].getName()+" �¸�");
	}
	public void input() {
		while(i!=2) {
		System.out.println(setup[i].getName()+" ���� <Enter>Ű");
		String Enter=Scan.nextLine();
		nowSecond();
		System.out.println("10�� ���� �� <Enter>Ű");
		Enter=Scan.nextLine();
		finishSecond();
		}
	}
	public void nowSecond() {
		Calendar c = Calendar.getInstance();
		int startsecond = c.get(Calendar.SECOND);
		setup[i].setStart(startsecond);
		System.out.println("���� �� �ð� = "+startsecond);
	}
	public void finishSecond() {
		Calendar c = Calendar.getInstance();
		int finishsecond = c.get(Calendar.SECOND);
		setup[i].setfinish(finishsecond);
		System.out.println("���� �� �ð� = "+finishsecond);
		i++;
	};
	public static void main(String[]args) {
		TargetSecond Game = new TargetSecond();
		Game.run();
	}
}
