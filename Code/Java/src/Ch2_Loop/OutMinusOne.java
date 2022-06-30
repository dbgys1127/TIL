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
		System.out.println("1번째 수 입력 : ");
		int Input = ScanInput.nextInt();
		while(Input!=-1)
		{

			sum+=Input;
			i++;
			System.out.println(i+1+"번째 수 입력 : ");
			Input = ScanInput.nextInt();
		}
		Average=sum/i;
		System.out.println("합 : "+sum);
		System.out.print("평균 : "+Average);
		
	}
}
