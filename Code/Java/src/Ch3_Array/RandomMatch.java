package Ch3_Array;
import java.util.Random;
public class RandomMatch {
	public static void main(String[]args) {
		int FourFour[][]=new int [4][4];
		int SoloArray[]=new int [10];
		int IndexArray[][]=new int [10][2];
		
		for(int i=0;i<SoloArray.length;i++) {
			int k = (int)(Math.random()*10+1);
			SoloArray[i]=k;
		}
		int Row =(int)(Math.random()*4+0);
		int Vertical=(int)(Math.random()*4+0);
		IndexArray[0][0]= Row;
		IndexArray[0][1]= Vertical;
		for(int i=1;i<10;i++) {
			Row =(int)(Math.random()*4+0);
			Vertical=(int)(Math.random()*4+0);
			IndexArray[i][0]= Row;
			IndexArray[i][1]= Vertical;
			for(int j=0;j<i;j++) {
				if(IndexArray[i][0]==IndexArray[j][0]&&IndexArray[i][1]==IndexArray[j][1]) {
					i--;
					break;
				}
				else {
					continue;
				}
			}
		}
		
		for(int i=0;i<10;i++) {
			int k =(int)(Math.random()*10+0);
				FourFour[IndexArray[i][0]][IndexArray[i][1]]=SoloArray[k];
		}
		
		for(int i=0;i<FourFour.length;i++) {
			for(int j=0;j<FourFour[i].length;j++) {
				System.out.print(FourFour[i][j]+" ");
			}
			System.out.println();
		}
	}
}
