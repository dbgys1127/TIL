import java.util.Calendar;

public class calendar {
	public static void main(String[]args) {
		Calendar now = Calendar.getInstance();
		int AMPM=now.get(Calendar.AM_PM);
		int hour = now.get(Calendar.HOUR);
		int minute=now.get(Calendar.MINUTE);
		String ampm;
		if(AMPM==Calendar.AM) ampm="오전";
		else ampm="오후";
		System.out.println("현재 시간은 "+ampm+hour+"시 "+minute+"분 입니다.");
		if(ampm=="오전"&&hour>=4&&hour<=11) System.out.println("Good Morning");
		else if(ampm=="오후"&&hour<=5) System.out.println("Good Afternoon");
		else if(ampm=="오후"&&hour<=9) System.out.println("Good Evening");
		else System.out.println("Good Night");
	}
}
