package Ch3_Array;

public class RandomAvg {
	public static void main(String[] args) {
		int RandomNum[]=new int[10];
		double Sum=0.0;
		System.out.print("·£´ýÇÑ Á¤¼öµé : ");
		for(int i=0;i<RandomNum.length;i++) {
			RandomNum[i]=(int)(Math.random()*10+1);
			System.out.print(RandomNum[i]+" ");
			Sum+=RandomNum[i];
		}
		System.out.println();
		System.out.println("Æò±ÕÀº : "+Sum/RandomNum.length);
	}
}
