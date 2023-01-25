class Data{ int x; }

public class PrimitiveParamEx {
    public static void main(String[] args) {
        PrimitiveParamEx primitiveParamEx = new PrimitiveParamEx();
        Data d = new Data();
        d.x = 10;
        System.out.println("main d.x = " + d.x);

        primitiveParamEx.change(d.x);
        // 왜 change를 했음에도 d.x가 10일까?
        System.out.println("after change main : "+d.x);
        // 매개변수 x를 변경한 것이기때문이다.
        // 참조변수로 매개변수를 넘기면 read & write가 되지만, 기본형 매개변수는 read만 가능하다

    }

    void change(int x) {
        x = 1000;
        System.out.println("change x = "+"x");
    }
}

class ReferenceParamEx {
    public static void main(String[] args) {
        ReferenceParamEx referenceParamEx = new ReferenceParamEx();
        Data d = new Data();
        d.x = 10;
        System.out.println("main d.x = " + d.x);

        referenceParamEx.change(d);
        // 이번엔 변경이 되었네?
        System.out.println("after change main : "+d.x);
        // 참조변수를 매개변수로 넘겨서 참조변수가 가리키는 인스턴스의 x가 변경되었기 때문이다.
    }

    void change(Data data) {
        data.x = 1000;
        System.out.println("change x = "+data.x);
    }
}
class ReferenceParamEx2 {
    public static void main(String[] args) {
        ReferenceParamEx2 referenceParamEx2 = new ReferenceParamEx2();
        int [] xArr = {10};
        System.out.println("main d.x = " + xArr[0]);
        referenceParamEx2.change(xArr);
        // 배열도 참조 변수 이므로 read & write 가 된다.
        System.out.println("after change main : "+xArr[0]);

    }

    void change(int[] xArr) {
        xArr[0] = 1000;
        System.out.println("change xArr = "+xArr[0]);
    }
}
