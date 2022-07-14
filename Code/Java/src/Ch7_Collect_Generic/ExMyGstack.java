package Ch7_Collect_Generic;
class GStackk<T>{
    int tos;
    Object [] stck;
    public GStackk(){
        tos=0;
        stck=new Object[10];
    }
    public void push(T item){
        if(tos==10)
            return;
        stck[tos]=item;
        tos++;
    }
    public T pop() { //여기서 T는 반환타입이 T라는 뜻 즉, return을 T로 하겠다는 뜻. 제너릭 메소드의 타입과는 다르다.
        //여기서는 제너릭 클래스의 타입 매개변수를 반환 하겠다는 것이다.
        if (tos == 0)
            return null;
        tos--;
        return (T) stck[tos];//보낼때는 T 타입으로 보내야하는데 stck 배열은 Object 객체이므로 캐스팅으로 타입 변환 해주는 것이다.
    }
}
public class ExMyGstack {
    public static void main(String[] args) {
        GStackk<String> stringGStackk = new GStackk<>();//String 타입의 제너릭 클래스 객체 생성
        stringGStackk.push("seoul");
        stringGStackk.push("busan");
        stringGStackk.push("LA");
        for(int n=0;n<3;n++)
            System.out.println(stringGStackk.pop());

        GStackk<Integer> integerGStackk = new GStackk<>();
        integerGStackk.push(1);
        integerGStackk.push(3);
        integerGStackk.push(5);

        for(int n=0;n<3;n++)
            System.out.println(integerGStackk.pop());

    }
}
