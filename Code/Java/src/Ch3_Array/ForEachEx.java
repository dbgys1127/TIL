package Ch3_Array;

public class ForEachEx {
	enum Week {��,ȭ,��,��,��,��,��}
	public static void main(String[] args) {
		int Num[]= {1,2,3,4,5};
		String Fruit[]= {"���","��","����","����","����"};
		int sum=0;
		
		for(int k:Num) {
			sum+=k;
			System.out.print(k+" ");
		}
		System.out.print(sum);
		System.out.println();
		
		for(String sFruit:Fruit) {
			System.out.print(sFruit+" ");
		}
		System.out.println();
		
		for(Week day:Week.values()) {
			System.out.print(day+" ");
		}
	}
}
