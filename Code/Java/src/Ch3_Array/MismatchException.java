package Ch3_Array;

import java.util.Scanner;
import java.util.InputMismatchException;

public class MismatchException {
	public static void main(String[] args) {
		System.out.println("숫자 3개를 입력하시오.");
		Scanner ScanNum=new Scanner(System.in);
		int sum=0;
		for(int i=0;i<3;i++) {
			try {
				System.out.print(i+1+"번째 숫자 : ");
				int Num=ScanNum.nextInt();
				sum+=Num;
			}
			catch(InputMismatchException e) {
				System.out.println("숫자만 입력해야합니다. 다시 입력하세요.");
				ScanNum.nextLine();
				i--;
			}
		}
		System.out.print("입력한 수의 합 : "+sum);
	}
}
