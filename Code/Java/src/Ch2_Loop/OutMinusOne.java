package Ch2_Loop;

import java.util.Scanner;

public class OutMinusOne 
{
	public static void main(String[] args)
	{
		Scanner ScanInput = new Scanner(System.in);
		int sum = 0;
		int i=0;
		double Average;
		System.out.println("1��° �� �Է� : ");
		int Input = ScanInput.nextInt();
		while(Input!=-1)
		{

			sum+=Input;
			i++;
			System.out.println(i+1+"��° �� �Է� : ");
			Input = ScanInput.nextInt();
		}
		Average=sum/i;
		System.out.println("�� : "+sum);
		System.out.print("��� : "+Average);
		
	}
}
