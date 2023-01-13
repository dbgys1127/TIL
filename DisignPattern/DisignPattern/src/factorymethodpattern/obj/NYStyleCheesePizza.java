package factorymethodpattern.obj;

public class NYStyleCheesePizza extends Pizza{
    public NYStyleCheesePizza() {
        name = "뉴욕 스타일 치즈 피자";
        dough = "씬 크러스트 도우";
        sauce = "마리나라 소스";

        toppings.add("페파로니");
        toppings.add("파인애플");
        toppings.add("새우");
    }
}
