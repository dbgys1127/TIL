package Ch1_JavaStruct;

import java.util.Scanner;

public class Clock {
	public static void main(String[] args) {
		System.out.println("�ʴ��� �ð��� �Է��Ͻÿ�.");
		Scanner Time = new Scanner(System.in);
		
		int TotalTime = Time.nextInt();
		int Hour, Minute, Seconds;
		Hour=TotalTime/3600;
		TotalTime=TotalTime%3600;
		
		Minute=TotalTime/60;
		Seconds=TotalTime%60;
		
		System.out.println(Hour+"��"+Minute+"��"+Seconds+"��");
		
		int x=2, y=10, z=0, s,p=8;
		z=x++*2+--y-5+x*(p%2);
		s=(p%2);
		System.out.println(z);
		System.out.println(s);
		System.out.println(8>>1);
		
		
		
	}

}
