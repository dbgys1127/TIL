package interfacepackage;

class Fighter extends Unit implements Fightable {

    @Override
    public void move(int x, int y) { // interface에서 메서드에는 public abstract가 생략되어 있는데, 자식 메서드는 조상 메서드보다 범위가 같거나 넓어야 한다.
        // 그런데 만약 여기서 public이 생략된다면 default가 되어 자신이 부모보다 범위가 좁으므로 public이 붙는다.

    }

    @Override
    public void attack(Unit unit) {

    }
}

class Unit {
    int currentHP;
    int x;
    int y;
}

interface Fightable extends Movable, Attackable {

}
interface Movable{
    void move(int x, int y);
}
interface Attackable{
    void attack(Unit unit);
}
public class InterfaceTest {
    public static void main(String[] args) {
        Fighter f = new Fighter();
        if (f instanceof Unit) {
            System.out.println("f는 Unit의 자손");
        }
        if (f instanceof Fightable) {
            System.out.println("f는 Fightable 인터페이스를 구현");
        }
        if (f instanceof Movable) {
            System.out.println("f는 Movable 인터페이스를 구현");
        }

        if (f instanceof Attackable) {
            System.out.println("f는 Attackable 인터페이스를 구현");
        }
    }
}
