public class ClassMethodInstanceMethod {
    long a, b;
    long add() {
        return a+b;
    }
    long subtract() {
        return a-b;
    }
    long multiply() {
        return a*b;
    }
    long divide() {
        return a/b;
    }

    static long add(long a, long b) {
        return a + b;
    }
    static long subtract(long a, long b) {
        return a - b;
    }
    static long multiply(long a, long b) {
        return a * b;
    }
    static long divide(long a, long b) {
        return a / b;
    }
}

class ClassMethodInstanceMethodTest {
    public static void main(String[] args) {
        System.out.println(ClassMethodInstanceMethod.add(200L,100L));
        System.out.println(ClassMethodInstanceMethod.subtract(200L,100L));
        System.out.println(ClassMethodInstanceMethod.multiply(200L,100L));
        System.out.println(ClassMethodInstanceMethod.divide(200L,100L));
        ClassMethodInstanceMethod classMethodInstanceMethod = new ClassMethodInstanceMethod();
        classMethodInstanceMethod.a = 200L;
        classMethodInstanceMethod.b = 100L;

        System.out.println(classMethodInstanceMethod.add());
        System.out.println(classMethodInstanceMethod.subtract());
        System.out.println(classMethodInstanceMethod.multiply());
        System.out.println(classMethodInstanceMethod.divide());
    }
}
