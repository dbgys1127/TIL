package polymorphism;

class Product1{
    int price;
    int bonusPoint;

    public Product1(int price) {
        this.price = price;
        bonusPoint = (int)(price/10.0);
    }
}

class Tv1 extends Product1 {

    public Tv1() {
        super(100);
    }

    @Override
    public String toString() {
        return "Tv";
    }
}

class Computer1 extends Product1 {
    public Computer1() {
        super(200);
    }

    @Override
    public String toString() {
        return "Computer";
    }
}
class Audio1 extends Product1 {
    public Audio1() {
        super(50);
    }

    @Override
    public String toString() {
        return "Audio";
    }
}

class Buyer1 {
    int money = 1000;
    int bonusPoint = 0;
    Product1[] item = new Product1[10];
    int i = 0;
    void buy(Product1 p) {
        if (money < p.price) {
            System.out.println("잔액이 부족합니다");
            return;
        }
        money-=p.price;
        bonusPoint+=p.bonusPoint;
        item[i++]=p;
        System.out.println(p+" 구매완료");
    }
    void summary() {
        int sum =0;
        String itemList = "";

        for (int i = 0; i < item.length; i++) {
            if(item[i]==null) break;
            sum += item[i].price;
            itemList += item[i] + ", ";
        }
        System.out.println("구입하신 총액 : "+sum);
        System.out.println("구입 제품 : "+itemList);
        System.out.println("잔액 : "+money);
        System.out.println("보너스 점수 : "+bonusPoint);
    }
}

public class PolyArgumentTest2 {
    public static void main(String[] args) {
        Buyer1 b = new Buyer1();
        
        b.buy(new Tv1());
        b.buy(new Computer1());
        b.buy(new Audio1());
        b.summary();

    }
}
