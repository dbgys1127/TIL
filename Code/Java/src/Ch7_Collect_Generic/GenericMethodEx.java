package Ch7_Collect_Generic;

public class GenericMethodEx {
	 public static <T> Gstack<T> revers(Gstack<T> a){
			Gstack<T> s = new Gstack<T>();
			while(true) {
				T tmp;
				tmp=a.pop();
				if(tmp==null)break;
				else s.push(tmp);
			}
			return s;
		  }
	 public static void main(String[]args) {
			Gstack<Double> gs = new Gstack<Double>();
			
			for (int i =0;i<5;i++) {
				gs.push(new Double(i));
			}
			gs=revers(gs);
			for (int i =0;i<5;i++) {
				System.out.println(gs.pop());
			}
	 }
}
