package Ch3_Array;

import java.util.Scanner;

public class ArrayAverage {
	public static void main(String[] args) {
		System.out.println("정수 5개를 입력하시오. : ");
		Scanner ScanInt=new Scanner(System.in);
		int sum=0;
		int IntArray[];
		IntArray=new int[5];
		
		
		for(int i=0;i<IntArray.length;i++) {
			IntArray[i]=ScanInt.nextInt();
			sum+=IntArray[i];
		}
		double Avg=(double)sum/IntArray.length;
		System.out.print(Avg);
		ScanInt.close();
	}
}
