package Ch1_JavaStruct;

import java.util.Scanner;

public class SwitchGrade 
{
	public static void main(String[] args)
	{
		System.out.print("������ �Է��Ͻÿ�. :");
		Scanner ScanScore = new Scanner(System.in);
		
		int Score=ScanScore.nextInt();
		char Grade;
		
		switch(Score/10)
		{
			case 10 :
			case 9:
				Grade='A';
				break;
			case 8:	
				Grade='B';
				break;
			case 7:	
				Grade='C';
				break;
			case 6:	
				Grade='D';
				break;
			default:
				Grade='F';
		}
		System.out.println("���� : "+Grade);
		ScanScore.close();
	}
}
