package Ch1_JavaStruct;

import java.util.Scanner;

public class RockPaperScissors 
{

	
	public static void main(String[] args)
	{
		System.out.println("°¡À§, ¹ÙÀ§, º¸ Áß¿¡ ÀÔ·ÂÇÏ¼¼¿ä.");
		
		System.out.print("Ã¶¼ö >> ");
		Scanner ScanChul  = new Scanner(System.in);
		String Chul=ScanChul.nextLine();	
		System.out.print("¿µÈñ >> ");
		Scanner ScanYoung  = new Scanner(System.in);
		String Young=ScanYoung.nextLine();
		
		if(Chul.equals("°¡À§"))
		{
			if(Young.equals("°¡À§"))
			{
				System.out.println("ºñ°å½À´Ï´Ù.");
			}
			else if(Young.equals("¹ÙÀ§"))
			{
				System.out.println("¿µÈñ ½Â");
			}
			else
			{
				System.out.println("Ã¶¼ö ½Â");
			}
		}
		else if(Chul.equals("¹ÙÀ§"))
		{
			if(Young.equals("°¡À§"))
			{
				System.out.println("Ã¶¼ö ½Â");
			}
			else if(Young.equals("¹ÙÀ§"))
			{
				System.out.println("ºñ°å½À´Ï´Ù.");
			}
			else
			{
				System.out.println("¿µÈñ ½Â");
			}
		}
		else
		{
			if(Young.equals("°¡À§"))
			{
				System.out.println("¿µÈñ ½Â");
			}
			else if(Young.equals("¹ÙÀ§"))
			{
				System.out.println("Ã¶¼ö ½Â");
			}
			else
			{
				System.out.println("ºñ°å½À´Ï´Ù.");
			}
		}
		
		ScanChul.close();
		ScanYoung.close();
	}
}
