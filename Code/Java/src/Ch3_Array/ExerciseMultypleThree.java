package Ch3_Array;

import java.util.Scanner;

public class ExerciseMultypleThree {
	public static void main(String[] args) {
		Scanner ScanNum=new Scanner(System.in);
		int NumArray[]=new int [10];
		
		System.out.print("정수를 10개 입력하시오 :");

		for(int i=0;i<NumArray.length;i++) {
			NumArray[i]=ScanNum.nextInt();
			}
		
		System.out.print("3의 배수 : ");
		
		for(int i=0;i<NumArray.length;i++) {
			if(NumArray[i]%3==0) {
				System.out.print(NumArray[i]+" ");
			}
		}
		ScanNum.close();
	}
}
