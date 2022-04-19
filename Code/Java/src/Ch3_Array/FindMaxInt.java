package Ch3_Array;

import java.util.Scanner;

public class FindMaxInt {
	public static void main(String [] args) {
		System.out.println("서로 다른 숫자 5개를 입력하시오. : ");
		Scanner ScanInt=new Scanner(System.in);
		
		/*
		 * int intArray[]; intArray=new int[5];
		 * 
		 * for(int i=0;i<5;i++) { intArray[i]=ScanInt.nextInt(); } for(int i=0;i<5;i++)
		 * { for(int j=i+1;j<5;j++) { if(intArray[i]>intArray[j]) { int tmp
		 * =intArray[i]; intArray[i]=intArray[j]; intArray[j]=tmp; break; } } }
		 * System.out.println(intArray[4]); ScanInt.close();
		 */
		
		int intArray[]=new int[5];
		int max=0;
		
		for(int i=0;i<5;i++) {
			intArray[i]=ScanInt.nextInt();
			if(intArray[i]>max) {
				max=intArray[i];
			}
		}
		System.out.print(max);
	}
}
