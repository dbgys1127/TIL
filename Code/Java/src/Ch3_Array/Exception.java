package Ch3_Array;

import java.util.Scanner;

public class Exception {
	public static void main(String[] args) {
		Scanner ScanNum=new Scanner(System.in);
		while(true){
			System.out.print("나뉨수를 입력하시오. :");
			int dividend=ScanNum.nextInt();
		
			System.out.print("나눗수를 입력하시오. :");
			int divisor=ScanNum.nextInt();
			try {
			System.out.print(dividend+"와 "+divisor+"를 나눈 값은 "+dividend/divisor);
			break;
			}
			catch(ArithmeticException e){
			System.out.print("0으로 나눌 수 없습니다.");
			}
		}
		ScanNum.close();
	}
	
}
