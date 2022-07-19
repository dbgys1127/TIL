package CodeStatesString;

public class LamdaEx {
    public static void main(String[] args) {
//        Object obj = new Object(){
//            int sum(int num1, int num2){
//                return num1+num2;
//            }
//        };
        ExampleFunction ex = Integer::sum;
        System.out.println(ex.sum(10,15));
    }
}
@FunctionalInterface
interface ExampleFunction{
    public abstract int sum(int num1, int num2);
}
