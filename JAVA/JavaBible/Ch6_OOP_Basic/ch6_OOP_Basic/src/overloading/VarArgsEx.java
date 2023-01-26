package overloading;

/**
 * 가변인자를 쓸때 주의해야할 것
 * 1. 가변인자 외에 일반 인자가 있다면 가장 뒤에 가변인자를 시그니쳐에 쓴다.
 * 2. 바로 앞선 일반 인자와 가변인자의 타입이 달라야 한다.
 */
public class VarArgsEx {
    public static void main(String[] args) {
        String[] strArr = {"100", "200", "300"};
        System.out.println(concatenate(8, "100", "200", "300"));
        System.out.println(concatenate(8, strArr));
        System.out.println(concatenate(8, new String[]{"1","2","3"}));
        System.out.println("["+concatenate(8, new String[0])+"]");
        System.out.println("["+concatenate(8)+"]");

    }

    static String concatenate(int delim, String... args) {
        String result = "";
        for (String str : args) {
            result += str + delim;
        }
        return result;
    }
    static String concatenate(String... args) {
        return concatenate(8, args);
    }
}
