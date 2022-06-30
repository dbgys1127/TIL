package Ch3_Array;

public class ExNonSquare {
	public static void main(String[] args) {
		int NonSquare[][];
		NonSquare=new int [4][];
		NonSquare[0]=new int[4];
		NonSquare[1]=new int[1];
		NonSquare[2]=new int[1];
		NonSquare[3]=new int[4];
		int Count=0;
		for(int i=0;i<NonSquare.length;i++) {
			for(int j=0;j<NonSquare[i].length;j++) {
				NonSquare[i][j]=Count;
				Count++;
				System.out.print(NonSquare[i][j]+" ");
			}
			System.out.println();
		}
	}
}
