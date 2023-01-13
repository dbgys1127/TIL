package factorymethodpattern.obj;

public class ChicagoStyleCheesePizza extends Pizza {
    public ChicagoStyleCheesePizza() {
        name = "시카고 스타일 딥 디쉬 치즈 피자";
        dough = "아주 두꺼운 크러스트 도우";
        sauce = "겁나 매운 소스";

        toppings.add("소고기");
        toppings.add("닭고기");
        toppings.add("돼지고기");
    }

    @Override
    public void cut() {
        System.out.println("네모 모양으로 자르기");
    }
}
