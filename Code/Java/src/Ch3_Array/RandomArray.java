package Ch3_Array;

import java.util.Scanner;

public class RandomArray {
	public static void main(String[]args) {
		System.out.println("���� �??? : ");
		Scanner ScanNum=new Scanner(System.in);
		int How=ScanNum.nextInt();
		int RandomArray[];
		int RandomNum=(int)(Math.random()*100+1);
		RandomArray=new int[How];
		RandomArray[0]=RandomNum;// 1��°
		for(int i=1;i<How;i++) {
			RandomNum=(int)(Math.random()*100+1);
			RandomArray[i]=RandomNum;// 5��°
			for(int j=0;j<i;j++) {
				if(RandomArray[j]==RandomArray[i]) {
					i--;
					break;
				}
				else {
					continue;
				}
			}
		}
		int Mok = How/10;
		int Nam = How%10;
		for(int i=0;i<Mok;i++) {
			for(int j=0;j<10;j++) {
				if(i==0) {
					System.out.print(RandomArray[j]+" ");
				}
				else {
					System.out.print(RandomArray[j+10*i]+" ");
				}
			}
			System.out.println();
		}
		for(int i=How-Nam;i<How;i++) {
			System.out.print(RandomArray[i]+" ");
		}
		ScanNum.close();
	}
}
