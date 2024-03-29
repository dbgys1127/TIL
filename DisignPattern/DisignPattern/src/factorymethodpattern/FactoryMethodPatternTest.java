package factorymethodpattern;

import factorymethodpattern.client.CaliforniaStylePizzaStore;
import factorymethodpattern.client.ChicagoStylePizzaStore;
import factorymethodpattern.client.NYStylePizzaStore;
import factorymethodpattern.client.PizzaStore;
import factorymethodpattern.obj.Pizza;

public class FactoryMethodPatternTest {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYStylePizzaStore();
        PizzaStore chicagoStore = new ChicagoStylePizzaStore();
        PizzaStore caliStore = new CaliforniaStylePizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("에단이 주문한 피자 : "+pizza.getName());
        System.out.println();
        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("조엘이 주문한 피자 : "+pizza.getName());
        System.out.println();
        pizza = caliStore.orderPizza("clam");
        System.out.println("dbgys이 주문한 피자 : " + pizza.getName());

    }
}
