package Ch1_JavaStruct;

import java.util.Scanner;

public class IfThreeMultiple 
{
	public static void main(String[] args) 
	{
		System.out.print("���ڸ� �Է��Ͻÿ�. : ");
		Scanner Number=new Scanner(System.in);
		
		int DividedNumber = Number.nextInt();
		
		if(DividedNumber%3==0)
		{
			System.out.println("3�� ����Դϴ�.");
		}
		else
		{
			System.out.println("3�� ����� �ƴմϴ�.");
		}
		Number.close();
	}	
}
