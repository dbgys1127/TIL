package Ch1_JavaStruct;

import java.util.Scanner;

public class RockPaperScissors 
{

	
	public static void main(String[] args)
	{
		System.out.println("����, ����, �� �߿� �Է��ϼ���.");
		
		System.out.print("ö�� >> ");
		Scanner ScanChul  = new Scanner(System.in);
		String Chul=ScanChul.nextLine();	
		System.out.print("���� >> ");
		Scanner ScanYoung  = new Scanner(System.in);
		String Young=ScanYoung.nextLine();
		
		if(Chul.equals("����"))
		{
			if(Young.equals("����"))
			{
				System.out.println("�����ϴ�.");
			}
			else if(Young.equals("����"))
			{
				System.out.println("���� ��");
			}
			else
			{
				System.out.println("ö�� ��");
			}
		}
		else if(Chul.equals("����"))
		{
			if(Young.equals("����"))
			{
				System.out.println("ö�� ��");
			}
			else if(Young.equals("����"))
			{
				System.out.println("�����ϴ�.");
			}
			else
			{
				System.out.println("���� ��");
			}
		}
		else
		{
			if(Young.equals("����"))
			{
				System.out.println("���� ��");
			}
			else if(Young.equals("����"))
			{
				System.out.println("ö�� ��");
			}
			else
			{
				System.out.println("�����ϴ�.");
			}
		}
		
		ScanChul.close();
		ScanYoung.close();
	}
}
