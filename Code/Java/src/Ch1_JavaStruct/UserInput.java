package Ch1_JavaStruct;

import java.util.Scanner;

public class UserInput {
	public static void main(String[] args) {
		System.out.println("�̸�, ����, ����, ü��, ���� ���θ� ��ĭ���� �и��Ͽ� �Է��ϼ���.");
		Scanner UserKeyInput = new Scanner(System.in);
		
		String name = UserKeyInput.next();
		System.out.println("name : "+name);
		
		String city = UserKeyInput.next();
		System.out.println("city : "+city);
		
		byte age = UserKeyInput.nextByte();
		System.out.println("age : "+age);
		
		float weight = UserKeyInput.nextFloat();
		System.out.println("weight : "+weight);
		
		boolean marry = UserKeyInput.hasNext();
		System.out.println("marry : "+marry);
	}
}


