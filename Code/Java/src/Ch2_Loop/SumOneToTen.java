package Ch2_Loop;

public class SumOneToTen 
{
	public static void main(String[] args)
	{
		int sum=0;
		int i;
		for(i=1;i<10;i++)
		{
			sum+=i;
			System.out.print(i+"+");
		}
		sum+=i;
		System.out.print(i+"="+sum);
	}
}
