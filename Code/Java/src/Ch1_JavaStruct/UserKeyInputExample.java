package Ch1_JavaStruct;

import java.util.Scanner;

public class UserKeyInputExample {
	public static void main(String[] args) {
		System.out.println("정수 2개를 빈칸으로 분리하여 입력하세요.");
		Scanner TwoInteger = new Scanner(System.in);
		
		int FirstInt = TwoInteger.nextInt();
		System.out.println("FirstInt : "+FirstInt);
		
		int SecondInt = TwoInteger.nextInt();
		System.out.println("SecondInt : "+SecondInt);
		
		int Sum;
		Sum=FirstInt+SecondInt;
		
		System.out.println("Sum : "+Sum);
	}
}
