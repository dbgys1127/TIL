package Ch3_Array;

import java.util.Scanner;

public class Exception {
	public static void main(String[] args) {
		Scanner ScanNum=new Scanner(System.in);
		while(true){
			System.out.print("�������� �Է��Ͻÿ�. :");
			int dividend=ScanNum.nextInt();
		
			System.out.print("�������� �Է��Ͻÿ�. :");
			int divisor=ScanNum.nextInt();
			try {
			System.out.print(dividend+"�� "+divisor+"�� ���� ���� "+dividend/divisor);
			break;
			}
			catch(ArithmeticException e){
			System.out.print("0���� ���� �� �����ϴ�.");
			}
		}
		ScanNum.close();
	}
	
}
