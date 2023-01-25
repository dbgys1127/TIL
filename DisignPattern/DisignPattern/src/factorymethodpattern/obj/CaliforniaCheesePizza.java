package factorymethodpattern.obj;

public class CaliforniaCheesePizza extends Pizza{
    public CaliforniaCheesePizza() {
        name = "캘리포니아 스타일 딥 디쉬 치즈 피자";
        dough = "아주 두꺼운 크러스트 도우";
        sauce = "겁나 매운 소스";

        toppings.add("소고기");
        toppings.add("닭고기");
        toppings.add("돼지고기");
        toppings.add("양고기");
        toppings.add("새우");
    }

    @Override
    public void cut() {
        System.out.println("사선 모양으로 자르기");
    }
}
