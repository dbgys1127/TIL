package Ch1_JavaStruct;

import java.util.Scanner;

public class Control {
	public static void main(String [] args) 
	{
		System.out.print("학년과 성적을 공백으로 구분하여 입력하시오. : ");
		
		Scanner ScanScore = new Scanner(System.in);
		
		int Class = ScanScore.nextInt();
		int Score = ScanScore.nextInt();
		
			if(Class<4) 
			{
				if(Score>=60)
				{
					System.out.println("합");
				}
				else 
				{
					System.out.println("불");
				}
			}
			else
			{
				if(Score>=70)
				{
					System.out.println("합");
				}
				else 
				{
					System.out.println("불");
				}
			}
		
		ScanScore.close();
	}
}
