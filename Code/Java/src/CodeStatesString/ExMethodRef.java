package CodeStatesString;
import java.util.function.IntBinaryOperator;
class Calculator{
    public static int staticMethod(int x, int y){
        return x+y;
    }
    public int instanceMethod(int x, int y){
        return x*y;
    }
}

public class ExMethodRef {
    public static void main(String[] args) throws Exception {
        IntBinaryOperator op;
        op = Calculator::staticMethod;
        System.out.println(op.applyAsInt(3,5));

        Calculator cal = new Calculator();
        op=cal::instanceMethod;
        System.out.println(op.applyAsInt(3,5));
    }
}
