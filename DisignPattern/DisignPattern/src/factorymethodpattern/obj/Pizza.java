package factorymethodpattern.obj;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
    String name;
    String dough;
    String sauce;
    List<String> toppings = new ArrayList<>();

    public void prepare() {
        System.out.println("피자 이름 : "+name);
        System.out.println("도우 종류 : "+dough);
        System.out.println("소스 종류 : "+sauce);
        System.out.println("첨가된 토핑 : ");
        for(String t : toppings){
            System.out.println(" "+t);
        }
    }
    public void bake() {
        System.out.println("175도에서 25분간 굽기");
    }
    public void cut() {
        System.out.println("8조각 만들기");
    }
    public void box() {
        System.out.println("새해 박스에 담기");
    }

    public String getName() {
        return name;
    }
}
