package Ch1_JavaStruct;

import java.util.Scanner;

public class CoffeMachine 
{
	public static void main(String[] args)
	{
		System.out.print("�޴� ������! ����������, īǪġ��, ī���, �Ƹ޸�ī�� : ");
		Scanner ScanMenu = new Scanner(System.in);
		
		String Menu = ScanMenu.next();
		int Price;
		
		switch(Menu)
		{
			case "����������":
			case "īǪġ��":
			case "ī���":
					Price=3500;
					break;
			case "�Ƹ޸�ī��":
					Price=2000;
					break;
			default :
				System.out.println("���� �޴��Դϴ�. �غ��Ҳ���.");
				Price=0;
		}
		if(Price!=0)
		{
			System.out.println("���� : "+ Price);
		}
		ScanMenu.close();
	}
}
