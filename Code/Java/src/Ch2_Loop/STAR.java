package Ch2_Loop;

public class STAR {
	public static void main(String[] args) {
		int i=5;
		do {
			int j=0;
			do {
				System.out.print("*");
				j++;
			}while(j<i);
			i--;
			System.out.println();
		}while(i>0);
	}
}
