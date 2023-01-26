package constructor;

/**
 * 생성자 주의할점
 * 1.1. 개념: 생성자는 인스턴스를 생성하는 것이 아니다. 생성은 new 키워드가 한다.
 * 1.2. 생성자는 인스턴스의 초기속성을 초기화할때 사용한다.
 * 1.3. 생성자의 의의는 같은 클래스라도 어떤 인스턴스를 만들것인가 차이를 낼 수 있는 역할을한다.
 * 2. 생성자 오버로딩 시
 * 2.1.클래스명(){초기화 내용 없음} 형태의 기본생성자는 컴파일러가 기본으로 제공해준다.
 * 2.2. 하지만 클래스명(){구현부} 구현부에 내용을 추가하거나, 클래스명(매개변수){} 형태로 오버로딩한뒤,
 * 기본 생성자를 쓰고 싶다면, 기본 생성자를 반드시 작성해주어야한다.
 */
public class ConstructorTest {
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car("blue");

        System.out.printf("car1 의 색: %s, 기어: %s, 문짝: %d\n",car1.color,car1.gearType,car1.door);
        System.out.printf("car2 의 색: %s, 기어: %s, 문짝: %d\n",car2.color,car2.gearType,car2.door);
    }
}
class Car{
    String color;
    String gearType;
    int door;

    /**
     * this(), this
     * 1. this()
     * 1.1. this()는 생성자끼리 호출할때 사용하며, 본래 생성자를 호출하는 방식인 클래스명()이 아니라 this()로 호출한다.
     * 1.2. 타 생성자를 호출하는 this() 구문은 생성자 안에서 가만 첫줄에 와야한다.
     * 2. this
     * 2.2. 보통 생성자 안에서 매개변수가 클래스에 설계된 변수명으로 전달될때가 많아, 속성을 초기화할때 이름이 겹쳐서 오류가 난다.
     * 2.3. 따라서, this는 참조변수로 자기자신을 가리켜 초기화전 변수를 의미하고, 매개변수는 변경될 내용이다. 사용할때는 this.변수 = 매개변수
     * 2.4. 그런데 this는 인스턴스 메서드에서 인스턴스 변수를 사용할때 생략되어서 그렇지 인스턴스 메서드에서 계속 사용되고 있다는 것을 기억하자.
     * 2.5. 반면 클래스 메서드에서는 사용될 수 없다. 왜냐하면 this는 호출한 자기자신의 참조변수이므로, 클래스 공통의 속성이 아닌 인스턴스 각각의 속성을 관리하는데 쓰이기 때문이다.
     */

    public Car() {
        this("white");
    }

    public Car(String color) {
        this(color, "auto", 4);
    }

    public Car(String color, String gearType, int door) {
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }
}
