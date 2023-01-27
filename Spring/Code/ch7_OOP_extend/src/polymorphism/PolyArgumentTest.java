package polymorphism;

class Product{
    int price;
    int bonusPoint;

    public Product(int price) {
        this.price = price;
        bonusPoint = (int)(price/10.0);
    }
}

class Tv extends Product {

    public Tv() {
        super(100);
    }

    @Override
    public String toString() {
        return "Tv";
    }
}

class Computer extends Product {
    public Computer() {
        super(200);
    }

    @Override
    public String toString() {
        return "Computer";
    }
}

class Buyer {
    int money = 1000;
    int bonusPoint = 0;
    void buy(Product p) {
        if (money < p.price) {
            System.out.println("잔액이 부족합니다");
            return;
        }
        money-=p.price;
        bonusPoint+=p.bonusPoint;
        System.out.println(p+" 구매완료");
    }
}

public class PolyArgumentTest {
    public static void main(String[] args) {
        Buyer b = new Buyer();

        b.buy(new Tv());
        b.buy(new Computer());
        System.out.println("잔액 : "+b.money);
        System.out.println("보너스 점수 : "+b.bonusPoint);
    }
}
