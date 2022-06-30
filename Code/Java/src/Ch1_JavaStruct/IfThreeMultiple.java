package Ch1_JavaStruct;

import java.util.Scanner;

public class IfThreeMultiple 
{
	public static void main(String[] args) 
	{
		System.out.print("숫자를 입력하시오. : ");
		Scanner Number=new Scanner(System.in);
		
		int DividedNumber = Number.nextInt();
		
		if(DividedNumber%3==0)
		{
			System.out.println("3의 배수입니다.");
		}
		else
		{
			System.out.println("3의 배수가 아닙니다.");
		}
		Number.close();
	}	
}
