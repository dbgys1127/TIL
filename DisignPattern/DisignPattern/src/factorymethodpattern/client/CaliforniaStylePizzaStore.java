package factorymethodpattern.client;

import factorymethodpattern.obj.CaliforniaCheesePizza;
import factorymethodpattern.obj.ChicagoStyleCheesePizza;
import factorymethodpattern.obj.Pizza;

public class CaliforniaStylePizzaStore extends PizzaStore{
    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new CaliforniaCheesePizza();
        } else if (type.equals("pepperoni")) {
            return new CaliforniaCheesePizza();
        } else if (type.equals("clam")) {
            return new CaliforniaCheesePizza();
        } else if (type.equals("veggie")) {
            return new CaliforniaCheesePizza();
        } else {
            return null;
        }
    }
}
