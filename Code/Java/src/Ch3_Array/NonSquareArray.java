package Ch3_Array;
public class NonSquareArray {
	public static void main(String[] args) {
		int NonSquare[][]=new int[4][];
		NonSquare[0]=new int [3];
		NonSquare[1]=new int [2];
		NonSquare[2]=new int [3];
		NonSquare[3]=new int [2];	
		int sValue=0;
		
		for(int i=0;i<NonSquare.length;i++) {
			sValue=10*(i+1);
			for(int j=0;j<NonSquare[i].length;j++) {
				NonSquare[i][j]=sValue;
				System.out.print(NonSquare[i][j]+" ");
				sValue++;
			}
			System.out.println();
		}		
	}
}
