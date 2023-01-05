package decoratorpattern;

import decoratorpattern.component.Beverage;
import decoratorpattern.component.DarkRoast;
import decoratorpattern.component.Espresso;
import decoratorpattern.decorator.Mocha;
import decoratorpattern.decorator.Whip;

public class StarbuzzCoffee {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription()+" $"+beverage.cost());

        Beverage beverage1 = new DarkRoast();
        beverage1 = new Mocha(beverage1); // 모카 데코레이터가 꾸미는 애는 다크로스트
        beverage1 = new Mocha(beverage1); //모카 데코레이터가 꾸미는 애는 모카
        beverage1 = new Whip(beverage1); // 휘핑 데코레이터가 꾸미는 애느 모카
        System.out.println(beverage1.getDescription()+" $"+beverage1.cost());
    }
}
