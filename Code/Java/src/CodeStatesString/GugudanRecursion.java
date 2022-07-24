package CodeStatesString;

public class GugudanRecursion {
    public void Gugudan(int level, int count){
        if(count>9){
            return;
        }
        System.out.printf("%d x %d = %d\n",level,count,level*count);
        //count++;
        Gugudan(level,++count);
    }

    public static void main(String[] args) {
        GugudanRecursion g = new GugudanRecursion();
        g.Gugudan(2,1);
    }
}
