package Ch3_Array;

import java.util.Scanner;

public class Tree {
	public static void main(String[] args) {
		Scanner ScanNum = new Scanner(System.in);
		System.out.println("���ڸ� �Է��ϼ��� : ");
		int InputNum=ScanNum.nextInt();
		for(int i=InputNum;i>0;i--) {
			for(int j=InputNum;j>0;j--) {
				System.out.print("*");
			}
			InputNum--;
			System.out.println();
		}
		ScanNum.close();
	}
}
