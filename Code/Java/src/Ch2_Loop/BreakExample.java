package Ch2_Loop;

import java.util.Scanner;

public class BreakExample {
	public static void main(String[] args) {
		Scanner ScanString =new Scanner(System.in);
		
		System.out.println("exit�� �ԷµǸ� ����˴ϴ�.");
		
		while(true) {
			System.out.print("<<");
			String Input=ScanString.nextLine();
			//nextLine()���� �� ��� edit exit�̶�� �Է��ϸ� ��ü�� �ϳ��� ���⶧���� ���ᰡ �ȵȴ�.
			//next()�� �ϸ�, ���� ���� �� ������ �ǹǷ� edit exit �ϸ�, /edit/exit �̷��� ���� ������ ���ᰡ �ȴ�.
			if(Input.equals("exit"))
				break;
		}
		System.out.println("����˴ϴ�.");
	}
}
