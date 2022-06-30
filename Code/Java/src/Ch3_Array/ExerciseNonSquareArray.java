package Ch3_Array;

public class ExerciseNonSquareArray {
	public static void main(String[] args) {
		int n [][];
		n=new int[5][];
		n[0]=new int[1];
		n[1]=new int[3];
		n[2]=new int[1];
		n[3]=new int[4];
		n[4]=new int[2];
		for(int i=0;i<n.length;i++) {
			int j=1;
			for(int k=0;k<n[i].length;k++) {
				n[i][k]=j;
				j++;
				System.out.print(n[i][k]+" ");
			}
			System.out.println();
		}
	}
}
