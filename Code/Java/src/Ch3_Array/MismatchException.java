package Ch3_Array;

import java.util.Scanner;
import java.util.InputMismatchException;

public class MismatchException {
	public static void main(String[] args) {
		System.out.println("���� 3���� �Է��Ͻÿ�.");
		Scanner ScanNum=new Scanner(System.in);
		int sum=0;
		for(int i=0;i<3;i++) {
			try {
				System.out.print(i+1+"��° ���� : ");
				int Num=ScanNum.nextInt();
				sum+=Num;
			}
			catch(InputMismatchException e) {
				System.out.println("���ڸ� �Է��ؾ��մϴ�. �ٽ� �Է��ϼ���.");
				ScanNum.nextLine();
				i--;
			}
		}
		System.out.print("�Է��� ���� �� : "+sum);
	}
}
