package decoratorpattern.decorator;

import decoratorpattern.component.Beverage;

public abstract class CondimentDecorator extends Beverage {
    Beverage beverage;
    public abstract String getDescription();
}
