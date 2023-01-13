package factorymethodpattern.client;

import factorymethodpattern.obj.ChicagoStyleCheesePizza;
import factorymethodpattern.obj.NYStyleCheesePizza;
import factorymethodpattern.obj.Pizza;

public class ChicagoStylePizzaStore extends PizzaStore{
    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            return new ChicagoStyleCheesePizza();
        } else if (type.equals("clam")) {
            return new ChicagoStyleCheesePizza();
        } else if (type.equals("veggie")) {
            return new ChicagoStyleCheesePizza();
        } else {
            return null;
        }
    }
}
