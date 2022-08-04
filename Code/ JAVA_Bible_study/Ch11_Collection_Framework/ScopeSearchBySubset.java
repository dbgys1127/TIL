package Ch11_Collection_Framework;
import java.util.*;
public class ScopeSearchBySubset {
    public static void main(String[] args) {
        TreeSet set = new TreeSet();

        String from = "b";
        String to = "d";

        set.add("abc"); set.add("alien"); set.add("bat"); set.add("car");
        set.add("Car"); set.add("disc"); set.add("dance"); set.add("dzzz"); set.add("dZZZ");
        set.add("elphant"); set.add("elevator"); set.add("fan"); set.add("flower");

        System.out.println(set);
        System.out.println("range search : from "+from+" to "+to);
        System.out.println("result1 : "+set.subSet(from,to));
        // 끝에 zzz를 붙이는 이유는 to 값도 포함시키기 위함이다.
        System.out.println("result2 : "+set.subSet(from, to+"zzz"));
        // 만약 아래 처럼 CCC를 붙이면, dZZZ는 생략 되는데 그이유는 CCC의 코드값이 더 작기 때문이다.
        //System.out.println("result2 : "+set.subSet(from, to+"CCC"));
    }
}
