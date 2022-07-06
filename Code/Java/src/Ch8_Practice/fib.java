package Ch8_Practice;

public class fib {
    public static int[] fibonacci(int num) {
        // TODO:
        //0->0,   1->1,    1->2,    2->3,     3->4,      5->5,    8->6,	  13->7,		21->8
        int [] fib = new int [num+1];
        fib[0]=0;
        fib[1]=1;
        if(num==1){
            return fib;
        }
        for(int i=2;i<=num;i++){
            fib[i]=fib[i-1]+fib[i-2];
        }

        // [/0/,/" "/1/,/" "/1/]
        return fib;
    }
    public static void main(String[] args) {
        int []n=fibonacci(10);
        for(int i =0;i<n.length;i++){
            System.out.print(n[i]+" ");
        }
    }
}
