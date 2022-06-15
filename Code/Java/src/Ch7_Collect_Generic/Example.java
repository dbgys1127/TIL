package Ch7_Collect_Generic;

class JGenClass<T> {
    public T take(T s[], int index) {
        if (index > s.length) {
            System.out.println("ÀÎµ¦½º°¡ ¹üÀ§¸¦ ¹þ¾î³µ½À´Ï´Ù.");
            return null;
        }
        return s[index];
    }
}
public class Example {
    public static void main(String[] args) {
    	JGenClass<String> str = new JGenClass<>();
        String [] text = { "Hello", "Java", "World" };
        System.out.println(str.take(text, 1)); 
        JGenClass<Integer> Int = new JGenClass<>();
        Integer [] n = { 0,1,2,3,4,5 }; 
        System.out.println(Int.take(n, 1)); 
    }
}
