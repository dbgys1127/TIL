package Ch4_Stack_Queue;
import java.util.Scanner;

public class SwitchStackTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        SwitchStack s = new SwitchStack(64);

        while (true){
            System.out.println("현재 데이터 개수 : "+
                    "A : " + s.size(SwitchStack.AorB.StackA) + "/" +
                    "B : " + s.size(SwitchStack.AorB.StackB));
            System.out.print("( 1) A 푸시 ( 2) A 팝 ( 3) A 피크 " + "( 4) A 덤프 ( 5) A 검색 ( 6) A 비움\n" +
                    "( 7) B 푸시 ( 8) B 팝 ( 9) B 피크 " + "(10) B 덤프 (11) B 검색 (12) B 비움\n" +
                    "(13)   출력 ( 0) 종료 : ");

            int menu = stdIn.nextInt();
            if(menu==0) break;

            int n, x =0;
            switch (menu){
                case 1:
                    System.out.print("data : ");
                    x=stdIn.nextInt();
                    try {
                        s.push(SwitchStack.AorB.StackA,x);
                    }catch (SwitchStack.OverDoubleHeadException e){
                        System.out.println("stack is full");
                    }
                    break;
                case 2:
                    try{
                        System.out.println("pop data : "+s.pop(SwitchStack.AorB.StackA));
                    }catch (SwitchStack.EmptyDoubleHeadException e){
                        System.out.println("stack is empty");
                    }
                    break;
                case 3:
                    try{
                        System.out.println("peek data : "+s.peek(SwitchStack.AorB.StackA));
                    }catch (SwitchStack.EmptyDoubleHeadException e){
                        System.out.println("stack is empty");
                    }
                    break;
                case 4:
                    s.dump(SwitchStack.AorB.StackA);
                    break;
                case 5:
                    System.out.println("search data : ");
                    x = stdIn.nextInt();
                    n=s.indexOf(SwitchStack.AorB.StackA,x);
                    if(n!=-1){
                        System.out.println("search result : "+n);
                    }else
                        System.out.println("can't find!");
                    break;
                case 6:
                    s.clear(SwitchStack.AorB.StackA);
                    break;
                    // B
                case 7:
                    System.out.print("data : ");
                    x=stdIn.nextInt();
                    try {
                        s.push(SwitchStack.AorB.StackB,x);
                    }catch (SwitchStack.OverDoubleHeadException e){
                        System.out.println("stack is full");
                    }
                    break;
                case 8:
                    try{
                        System.out.println("pop data : "+s.pop(SwitchStack.AorB.StackB));
                    }catch (SwitchStack.EmptyDoubleHeadException e){
                        System.out.println("stack is empty");
                    }
                    break;
                case 9:
                    try{
                        System.out.println("peek data : "+s.peek(SwitchStack.AorB.StackB));
                    }catch (SwitchStack.EmptyDoubleHeadException e){
                        System.out.println("stack is empty");
                    }
                    break;
                case 10:
                    s.dump(SwitchStack.AorB.StackB);
                    break;
                case 11:
                    System.out.println("search data : ");
                    x = stdIn.nextInt();
                    n=s.indexOf(SwitchStack.AorB.StackB,x);
                    if(n!=-1){
                        System.out.println("search result : "+n);
                    }else
                        System.out.println("can't find!");
                    break;
                case 12:
                    s.clear(SwitchStack.AorB.StackB);
                    break;
            }
        }
    }
}
