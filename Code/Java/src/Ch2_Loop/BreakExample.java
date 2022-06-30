package Ch2_Loop;

import java.util.Scanner;

public class BreakExample {
	public static void main(String[] args) {
		Scanner ScanString =new Scanner(System.in);
		
		System.out.println("exit이 입력되면 종료됩니다.");
		
		while(true) {
			System.out.print("<<");
			String Input=ScanString.nextLine();
			//nextLine()으로 할 경우 edit exit이라고 입력하면 전체를 하나로 보기때문에 종료가 안된다.
			//next()로 하면, 공백 마다 한 단위가 되므로 edit exit 하면, /edit/exit 이렇게 보기 때문에 종료가 된다.
			if(Input.equals("exit"))
				break;
		}
		System.out.println("종료됩니다.");
	}
}
