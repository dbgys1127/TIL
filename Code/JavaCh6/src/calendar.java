import java.util.Calendar;

public class calendar {
	public static void main(String[]args) {
		Calendar now = Calendar.getInstance();
		int AMPM=now.get(Calendar.AM_PM);
		int hour = now.get(Calendar.HOUR);
		int minute=now.get(Calendar.MINUTE);
		String ampm;
		if(AMPM==Calendar.AM) ampm="����";
		else ampm="����";
		System.out.println("���� �ð��� "+ampm+hour+"�� "+minute+"�� �Դϴ�.");
		if(ampm=="����"&&hour>=4&&hour<=11) System.out.println("Good Morning");
		else if(ampm=="����"&&hour<=5) System.out.println("Good Afternoon");
		else if(ampm=="����"&&hour<=9) System.out.println("Good Evening");
		else System.out.println("Good Night");
	}
}
