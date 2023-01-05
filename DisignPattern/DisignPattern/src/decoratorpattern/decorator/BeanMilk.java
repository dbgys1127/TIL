package decoratorpattern.decorator;

import decoratorpattern.component.Beverage;

public class BeanMilk extends CondimentDecorator{

    public BeanMilk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost()+0.15;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+"BeanMilk";
    }
}
