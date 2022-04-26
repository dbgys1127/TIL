package Ch3_Array;

public class IndexOutOfBound {
	public static void main(String[] args) {
		int[] Array=new int [5];
		Array[0]=0;
		try {
			for(int i=0;i<Array.length;i++) {
				Array[i+1]=i+1+Array[i];
				System.out.println("Array["+i+"] = "+Array[i]);
			}
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.print("배열의 크기를 초과하였습니다.");
		}
	}
}
