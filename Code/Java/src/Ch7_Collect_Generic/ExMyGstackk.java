package Ch7_Collect_Generic;

public class ExMyGstackk {
    //이 메소드의 타입매개 변수는 T이다.
    //return 타입은 GStackk<T>이다. 즉 GStackk제너릭 클래스의 객체 이다. 이때 매개변수는 제너릭 메서드를
    //호출할때 정해지는 것이지, 제너릭 클래스 참조변수를 선언할때 정해지는 것이 아니다.
    //근데 <T>는 제너릭 클래스 참조변수 선언할때 정한 타입매개변수가 된다.
    //매개변수 타입은 타입은 GStackk<T>이다. 즉 GStackk제너릭 클래스의 객체 이다.
    public static <T> GStackk<T> reverse(GStackk<T> a){
        GStackk<T> s = new GStackk<>();
        while (true){
            T tmp; //제너릭 매서드 타입매개변수이다.
            tmp = a.pop();
            if(tmp==null)
                break;
            else
                s.push(tmp);
        }
        return s;
    }

    public static void main(String[] args) {
        GStackk<Double> gs = new GStackk<>();
        for(int i=0;i<5;i++)
            gs.push(new Double(i));//이때 매개변수는 제너릭 메서드를
        //호출할때 정해지는 것이지, 제너릭 클래스 참조변수를 선언할때 정해지는 것이 아니다.
        //근데 <T>는 제너릭 클래스 참조변수 선언할때 정한 타입매개변수가 된다.
        gs = reverse(gs);//컴파일러는 앞서 gs를 선언할때, 타입을 GStackk<Double>로 정했으므로,
        // 매개변수에 타입을 Double로 인지 할수 있다.

        for(int i=0;i<5;i++){
            System.out.println(gs.pop());
        }
    }
}
