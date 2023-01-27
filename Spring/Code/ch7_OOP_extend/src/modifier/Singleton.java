package modifier;

public class Singleton {
    private static final Singleton s = new Singleton();
    private Singleton() {

    }

    public static Singleton getInstance() {
        return s;
    }
}

class Test {
    public static void main(String[] args) {
//        Singleton s = new Singleton(); -> 생성자에 private를 걸었기 때문에 접근할 수 없다.
        Singleton s = Singleton.getInstance();
    }
}
