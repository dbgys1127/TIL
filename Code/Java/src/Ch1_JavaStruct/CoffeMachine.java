package Ch1_JavaStruct;

import java.util.Scanner;

public class CoffeMachine 
{
	public static void main(String[] args)
	{
		System.out.print("메뉴 고르세요! 에스프레소, 카푸치노, 카페라떼, 아메리카노 : ");
		Scanner ScanMenu = new Scanner(System.in);
		
		String Menu = ScanMenu.next();
		int Price;
		
		switch(Menu)
		{
			case "에스프레소":
			case "카푸치노":
			case "카페라떼":
					Price=3500;
					break;
			case "아메리카노":
					Price=2000;
					break;
			default :
				System.out.println("없는 메뉴입니다. 준비할께요.");
				Price=0;
		}
		if(Price!=0)
		{
			System.out.println("가격 : "+ Price);
		}
		ScanMenu.close();
	}
}
