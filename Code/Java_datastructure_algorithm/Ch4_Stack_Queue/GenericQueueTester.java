package Ch4_Stack_Queue;
import java.util.Scanner;

public class GenericQueueTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        GenericQueue<String> s = new GenericQueue<>(64);

        while(true){
            System.out.println();
            System.out.printf("data count : %d / %d\n",s.size(),s.getCapacity());
            System.out.print("(1)enque (2)deque (3)peek (4)dump (5)search (0)close");

            int menu = stdIn.nextInt();
            if(menu==0) break;

            String x;
            switch (menu){
                case 1:
                    System.out.print("data : ");
                    x = stdIn.next();
                    try{
                        s.enque(x);
                    }catch (IntQueue.OverflowIntQueueException e){
                        System.out.println("que is full");
                    }
                    break;
                case 2:
                    try{
                        System.out.println("deque : "+s.deque());
                    }catch (IntQueue.EmptyIntQueueException e){
                        System.out.println("que is empty");
                    }
                    break;
                case 3:
                    try{
                        System.out.println("peek : "+s.peek());
                    }catch (IntQueue.EmptyIntQueueException e){
                        System.out.println("que is empty");
                    }
                    break;
                case 4:
                    s.dump();
                    break;
                case 5:
                    System.out.print("search : ");
                    x = stdIn.next();
                    if(s.search(x)!=0)
                        System.out.println(s.search(x));
                    else
                        System.out.println("can't find it!");
            }
        }
    }
}
