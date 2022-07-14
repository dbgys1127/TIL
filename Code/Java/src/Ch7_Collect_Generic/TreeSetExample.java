package Ch7_Collect_Generic;

import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {

        // TreeSet 생성
        TreeSet<String> workers = new TreeSet<>();

        // TreeSet에 요소 추가
        workers.add("Lee Java");
        workers.add("Park Hacker");
        workers.add("Kim Coding");

        System.out.println(workers);
        System.out.println(workers.first());
        System.out.println(workers.last());
        System.out.println(workers.higher("Lee"));
        System.out.println(workers.subSet("Kim", "Park"));
    }
}
