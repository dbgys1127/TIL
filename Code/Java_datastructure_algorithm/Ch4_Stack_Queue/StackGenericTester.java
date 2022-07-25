package Ch4_Stack_Queue;
import java.util.Scanner;

public class StackGenericTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        StackGeneric<String> s = new StackGeneric<>(64);

        while(true){
            System.out.printf("현재 데이터 개수 : %d / %d\n",s.size(),s.getCapacity());
            System.out.print("(1)push (2)pop (3)peek (4)showAll (5)searchIndex (6)clear (0)close :");

            int menu = stdIn.nextInt();
            if(menu==0) break;

            String x;

            switch (menu){
                case 1:
                    System.out.print("data : ");
                    x=stdIn.next();
                    try{
                        s.push(x);
                    }catch (StackGeneric.OverflowGstackException e){
                        System.out.println("stack is full");
                    }
                    break;
                case 2:
                    try{
                        System.out.println("pop data : "+s.pop());
                    }catch (StackGeneric.EmptyGstackException e){
                        System.out.println("stack is empty");
                    }
                    break;
                case 3:
                    try{
                        System.out.println("peek data : "+s.peek());
                    }catch (StackGeneric.EmptyGstackException e){
                        System.out.println("stack is empty");
                    }
                    break;
                case 4:
                    s.dump();
                    break;
                case 5:
                    System.out.print("search data : ");
                    x=stdIn.next();
                    int n = s.indexOf(x);
                    if(n!=-1)
                        System.out.println("search result : "+n);
                    else
                        System.out.println("can't find data!");
                    break;
                case 6:
                    s.clear();
                    break;
            }
        }
    }
}
