package Ch3_Array;
import java.util.InputMismatchException;
import java.util.Scanner;
public class ExerciseException {
	public static void main(String[]args) {
		Scanner ScanNum=new Scanner(System.in);
		System.out.print("���� �μ��� �Է��ϼ��� : ");
		
		try {
			int First = ScanNum.nextInt();
			int Second = ScanNum.nextInt();
			System.out.println(First+" x " +Second+" = "+First*Second);
		}
		catch(InputMismatchException e) {
			System.out.print("������ �Է��ϼ���");
		}
		ScanNum.close();
	}
}
