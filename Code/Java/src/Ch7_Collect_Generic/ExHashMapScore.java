package Ch7_Collect_Generic;
import java.util.*;

public class ExHashMapScore {
	public static void main(String[]args) {
		HashMap<String,Integer> ScoreMap=new HashMap<>();
		
		ScoreMap.put("�輺��", 97);
		ScoreMap.put("Ȳ����", 88);
		ScoreMap.put("�賲��", 98);
		ScoreMap.put("���繮", 70);
		ScoreMap.put("�ѿ���", 99);
		
		System.out.println("��� ����>> "+ScoreMap.size());
		
		Set<String> keys =ScoreMap.keySet();
		Iterator<String> it = keys.iterator();
		
		while(it.hasNext()) {
			String name = it.next();
			int score = ScoreMap.get(name);
			System.out.println(name+" : "+score);
		}
	}
}
