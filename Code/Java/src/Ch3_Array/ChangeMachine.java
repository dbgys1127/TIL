package Ch3_Array;

import java.util.Scanner;

public class ChangeMachine {
	public static void main(String[] args) {
		System.out.print("��ȯ ��� �ݾ� : ");
		Scanner ScanMoney=new Scanner(System.in);
		int InputMoney=ScanMoney.nextInt();
		int OutMoney[]= {50000,10000,1000,500,100,50,10,1};
		int Change;
		for(int i=0;i<OutMoney.length;i++) {
			Change=InputMoney/OutMoney[i];
			System.out.println(OutMoney[i]+"�� ¥�� : "+Change+"��");
			InputMoney%=OutMoney[i];
		}
		ScanMoney.close();
	}
}
