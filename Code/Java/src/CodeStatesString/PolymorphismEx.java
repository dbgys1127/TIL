package CodeStatesString;

public class PolymorphismEx {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.buyCoffe(new Americano());
        customer.buyCoffe(new CaffeLatte());
        System.out.println("현재 잔액 >>" + customer.money);
    }
}
    class Coffe{
        int price;
        public Coffe(int price){
            this.price=price;
        }
    }
    class Customer{
        int money = 50000;

        void buyCoffe(Coffe coffe){
            if(coffe.price>money){
                System.out.println("돈이 없습니다.");
                return;
            }
            money=money-coffe.price;
            System.out.println(coffe+"를 구매했습니다.");
        }
    }
    class Americano extends Coffe{
        public Americano(){
            super(4000);
        }
        public String toString(){return "아메리카노";}
    }

    class CaffeLatte extends Coffe{
        public CaffeLatte(){
            super(5000);
        }
        public String toString(){return "카페라떼";}
    }

