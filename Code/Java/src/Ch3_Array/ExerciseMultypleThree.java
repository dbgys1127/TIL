package Ch3_Array;

import java.util.Scanner;

public class ExerciseMultypleThree {
	public static void main(String[] args) {
		Scanner ScanNum=new Scanner(System.in);
		int NumArray[]=new int [10];
		
		System.out.print("������ 10�� �Է��Ͻÿ� :");

		for(int i=0;i<NumArray.length;i++) {
			NumArray[i]=ScanNum.nextInt();
			}
		
		System.out.print("3�� ��� : ");
		
		for(int i=0;i<NumArray.length;i++) {
			if(NumArray[i]%3==0) {
				System.out.print(NumArray[i]+" ");
			}
		}
		ScanNum.close();
	}
}
