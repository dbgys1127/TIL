package Ch7_Collect_Generic;
import java.util.*;

public class ExHashMapScore {
	public static void main(String[]args) {
		HashMap<String,Integer> ScoreMap=new HashMap<>();
		
		ScoreMap.put("김성동", 97);
		ScoreMap.put("황기태", 88);
		ScoreMap.put("김남윤", 98);
		ScoreMap.put("이재문", 70);
		ScoreMap.put("한원선", 99);
		
		System.out.println("요소 개수>> "+ScoreMap.size());
		
		Set<String> keys =ScoreMap.keySet();
		Iterator<String> it = keys.iterator();
		
		while(it.hasNext()) {
			String name = it.next();
			int score = ScoreMap.get(name);
			System.out.println(name+" : "+score);
		}
	}
}
