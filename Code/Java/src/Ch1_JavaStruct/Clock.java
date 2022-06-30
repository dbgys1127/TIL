package Ch1_JavaStruct;

import java.util.Scanner;

public class Clock {
	public static void main(String[] args) {
		System.out.println("초단위 시간을 입력하시오.");
		Scanner Time = new Scanner(System.in);
		
		int TotalTime = Time.nextInt();
		int Hour, Minute, Seconds;
		Hour=TotalTime/3600;
		TotalTime=TotalTime%3600;
		
		Minute=TotalTime/60;
		Seconds=TotalTime%60;
		
		System.out.println(Hour+"시"+Minute+"분"+Seconds+"초");
		
		int x=2, y=10, z=0, s,p=8;
		z=x++*2+--y-5+x*(p%2);
		s=(p%2);
		System.out.println(z);
		System.out.println(s);
		System.out.println(8>>1);
		
		
		
	}

}
