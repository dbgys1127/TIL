package factorymethodpattern.client;

import factorymethodpattern.obj.NYStyleCheesePizza;
import factorymethodpattern.obj.Pizza;

public class NYStylePizzaStore extends PizzaStore{
    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new NYStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            return new NYStyleCheesePizza();
        } else if (type.equals("clam")) {
            return new NYStyleCheesePizza();
        } else if (type.equals("veggie")) {
            return new NYStyleCheesePizza();
        } else {
            return null;
        }
    }
}
