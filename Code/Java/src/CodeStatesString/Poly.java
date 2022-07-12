package CodeStatesString;



class Customer{
    int money =500;
    void buyCoffee(Americano americano) { // 아메리카노 구입
        money = money - americano.price;
    }

    void buyCoffee(CaffeLatte caffeLatte) { // 카페라테 구입
        money = money - caffeLatte.price;
    }
    System.out.println(coffe+"를 구매했습니다.");
}
