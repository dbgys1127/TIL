package Ch3_Array;
import java.util.Random;
public class FourFourArray {
	public static void main(String[]args) {
		int FourFour[][]=new int [4][4];
		Random r = new Random();
		
		for(int i=0;i<FourFour.length;i++) {
			for(int j=0;j<FourFour[i].length;j++) {
				int k = r.nextInt(16);
				FourFour[i][j]=k;
				System.out.print(FourFour[i][j]+" ");
			}
			System.out.println();
		}
	}
}
