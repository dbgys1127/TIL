package Ch2_Loop;

import java.util.Scanner;

public class ExampleOfContinue {
	public static void main(String[] args) {
		Scanner ScanInputNum = new Scanner(System.in);
		int Sum=0;
		
		for(int i=0;i<5;i++) {
			System.out.print(i+1+"번째 수 : ");
			int Num = ScanInputNum.nextInt();
			if(Num>0) 
				Sum+=Num;
			else
				continue;
		}
		System.out.println("합 : "+Sum);
	}
}
