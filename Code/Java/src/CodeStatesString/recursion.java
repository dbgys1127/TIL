package CodeStatesString;

public class recursion {
    public void recursion1(){
        System.out.println("this is");
        System.out.println("recursion");
        recursion1();
    }
    public static void main(String[] args) {
        recursion re = new recursion();
        re.recursion1();
    }
}
