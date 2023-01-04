package starategypattern.behavior;

public class FlyNoWay implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("오리는 날수없다 엄마에게 혼났죠");
    }
}
