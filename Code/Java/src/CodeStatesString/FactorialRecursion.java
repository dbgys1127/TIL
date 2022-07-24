package CodeStatesString;

public class FactorialRecursion {
    public int Factorial(int number){
        if(number<=1){
            return 1;
        }
        return number*Factorial(number-1);
    }
    public  void main(String[] args) {
        FactorialRecursion f = new FactorialRecursion();
        System.out.println(f.Factorial(5));
    }
}
