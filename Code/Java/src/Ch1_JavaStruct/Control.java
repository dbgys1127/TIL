package Ch1_JavaStruct;

import java.util.Scanner;

public class Control {
	public static void main(String [] args) 
	{
		System.out.print("�г�� ������ �������� �����Ͽ� �Է��Ͻÿ�. : ");
		
		Scanner ScanScore = new Scanner(System.in);
		
		int Class = ScanScore.nextInt();
		int Score = ScanScore.nextInt();
		
			if(Class<4) 
			{
				if(Score>=60)
				{
					System.out.println("��");
				}
				else 
				{
					System.out.println("��");
				}
			}
			else
			{
				if(Score>=70)
				{
					System.out.println("��");
				}
				else 
				{
					System.out.println("��");
				}
			}
		
		ScanScore.close();
	}
}
