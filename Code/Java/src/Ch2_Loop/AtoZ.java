package Ch2_Loop;

public class AtoZ 
{
	public static void main(String[] args)
	{
		char Alphabet='a';
		do {
			System.out.print(Alphabet);
			Alphabet++;
		}while(Alphabet<='z');
	}
}
