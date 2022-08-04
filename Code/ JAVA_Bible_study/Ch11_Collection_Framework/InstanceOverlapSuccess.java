package Ch11_Collection_Framework;
import java.util.*;
public class InstanceOverlapSuccess {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        set.add(new String("abc"));
        set.add(new String("abc"));
        set.add(new Person2("David",10));
        set.add(new Person2("David",10));

        System.out.println(set);
    }
}

class Person2 {
    String name;
    int age;

    Person2(String name, int age){
        this.name = name;
        this.age = age;
    }
    public boolean equals (Object obj){
        if(obj instanceof Person2){
            //뒤에 들어온 객체의 참조변수를 tmp에 저장
            Person2 tmp = (Person2)obj;
            //앞에 들어온 객체가 저장한 name과 age가 뒤에 들어온 객체를 임시저장한 tmp 참조변수의 name과 age를 비교한다.
            return name.equals(tmp.name) && age ==tmp.age;
        }
        return false;
    }
    public int hashCode(){
        return (name+age).hashCode();
    }
    public String toString(){
        return name +":"+age;
    }
}
