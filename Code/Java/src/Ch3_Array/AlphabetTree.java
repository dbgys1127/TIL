package Ch3_Array;

import java.util.Scanner;

public class AlphabetTree {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("소문자 알파벳 하나를 입력하시오 >> ");
		String s = scanner.next();
		char c = s.charAt(0);
		for(int i=(int)c;i>96;i--) {
			int k=97;
			for(int j=i;j>96;j--) {			
				System.out.print((char)k);
				k++;
			}
			System.out.println();
		}
		scanner.close();
	}
}
