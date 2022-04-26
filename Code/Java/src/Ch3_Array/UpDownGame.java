package Ch3_Array;

import java.util.Scanner;
import java.util.Random;

public class UpDownGame {
	public static void main(String[] args) {
			Scanner ScanNum=new Scanner(System.in);
			Scanner ScanDoNot = new Scanner(System.in);
			while(true) {
				Random RandomAnswer = new Random();
				int Answer=RandomAnswer.nextInt(100);
				System.out.println("숫자가 정해졌습니다. 1부터 100사이에 있어요 시작~!");
				while(true) {
					System.out.print("입력한 수 : ");
					int What=ScanNum.nextInt();
					if(What==Answer) {
						System.out.println("정답입니다. ㅊㅋㅊㅋ^^");
						break;
					}
					else if(What<Answer) {
						System.out.println("Up!!!");
					}
					else {
						System.out.println("Down!!!");
					}
				}
				System.out.println("한번 더 하시겠습니까? y/n");
				String DoNot=ScanDoNot.next();
				if(DoNot.equals("y")) {
					continue;
				}
				else {
					break;
				}
			}
	}
}
