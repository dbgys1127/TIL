package starategypattern;

import starategypattern.behavior.FlyWithWings;
import starategypattern.behavior.Quack;

public class MallardDuck extends Duck {
    public MallardDuck() {
        flyBehavior= new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("저는 물오리입니다.");
    }
}
