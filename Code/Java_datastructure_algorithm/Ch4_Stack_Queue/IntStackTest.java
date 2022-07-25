package Ch4_Stack_Queue;
import java.util.Scanner;
public class IntStackTest {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntStack s = new IntStack(64);

        while(true){
            System.out.println();
            System.out.printf("현재 데이터 개수 : %d / %d\n",s.size(), s.getCapacity());
            System.out.print("(1) 푸시 (2) 팝 (3) 피크 (4) 덤프 (5) clear (6) 스택비었는지 (7)스택이 꽉찾는지 (8)인덱스 검색 (0) 종료 : ");

            int menu = stdIn.nextInt();
            if(menu==0) break;

            int x;
            switch (menu){
                case 1:
                    System.out.print("데이터 : ");
                    x=stdIn.nextInt();
                    try{
                        s.push(x);
                    }catch (IntStack.OverflowIntStackException e){
                        System.out.println("스택이 가득찾습니다.");
                    }
                    break;
                case 2:
                    try{
                        x=s.pop();
                        System.out.println("팝한 데이터 : "+ x);
                    }catch (IntStack.EmptyIntStackException e){
                        System.out.println("스택이 비었습니다.");
                    }
                    break;
                case 3:
                    try{
                        x=s.peek();
                        System.out.println("피크한 데이터 : "+ x);
                    }catch (IntStack.EmptyIntStackException e){
                        System.out.println("스택이 비었습니다.");
                    }
                    break;
                case 4:
                    s.dump();
                    break;
                case 5:
                    s.clear();
                    if(s.isEmpty())
                        System.out.println("스택을 비웠습니다.");
                    break;
                case 6:
                    if(s.isEmpty())
                        System.out.println("스택을 비웠습니다.");
                    else
                        System.out.println("스택이 차있습니다.");
                    break;
                case 7:
                    if(s.isFull())
                        System.out.println("스택을 꽉찾습니다.");
                    else
                        System.out.println("꽉차지 않았습니다.");
                    break;
                case 8:
                    System.out.print("인덱스를 찾을 요소 : ");
                    x=stdIn.nextInt();
                    if(s.indexOf(x)!=-1)
                        System.out.println("검색한 "+x+"의 인덱스 : "+s.indexOf(x));
                    else
                        System.out.println("찾을 수 없습니다.");
                    break;
            }
        }
    }
}
