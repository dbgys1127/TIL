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
				System.out.println("���ڰ� ���������ϴ�. 1���� 100���̿� �־�� ����~!");
				while(true) {
					System.out.print("�Է��� �� : ");
					int What=ScanNum.nextInt();
					if(What==Answer) {
						System.out.println("�����Դϴ�. ��������^^");
						break;
					}
					else if(What<Answer) {
						System.out.println("Up!!!");
					}
					else {
						System.out.println("Down!!!");
					}
				}
				System.out.println("�ѹ� �� �Ͻðڽ��ϱ�? y/n");
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
