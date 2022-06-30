package Ch1_JavaStruct;

import java.util.Scanner;

public class UserInput {
	public static void main(String[] args) {
		System.out.println("이름, 도시, 나이, 체중, 독신 여부를 빈칸으로 분리하여 입력하세요.");
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


