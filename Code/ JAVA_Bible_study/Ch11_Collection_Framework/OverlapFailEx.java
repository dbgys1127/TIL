package Ch11_Collection_Framework;
import java.util.*;

public class OverlapFailEx {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        set.add("abc");
        set.add("abc");
        //아래 두개는 중복으로 걸러지는 것을 의도 했지만, 객체를 두번 생성한 것이기때문에, 참조변수 주소가 다르기때문에, 중복으로 걸러지지 않는다.
        set.add(new Person("David",10));
        set.add(new Person("David",10));

        System.out.println(set);
    }
}
class Person {
    String name;
    int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String toString(){
        return name +":"+age;
    }
}
