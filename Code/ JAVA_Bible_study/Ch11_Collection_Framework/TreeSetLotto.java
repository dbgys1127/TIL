package Ch11_Collection_Framework;
import java.util.*;
public class TreeSetLotto {
    public static void main(String[] args) {
        Set set = new TreeSet();
        for(int i=0;set.size()<6;i++){
            int num = (int)(Math.random()*45)+1;
            set.add(num);
        }

        // List list = new TreeSet(set);
        // list.sort;
        // TreeSet은 이미 정렬되서 오기때문에 위 처럼 정렬 과정이 필요없다.
        System.out.println(set);
    }
}
