package Ch2_Loop;

public class GuGuDan {
	public static void main(String[] args) {
		for(int i=2;i<10;i++) {
			for(int j=1;j<10;j++) {
				System.out.print(i+"x"+j+"="+i*j+'\t');
			}
			System.out.println();
		}
	}
}
