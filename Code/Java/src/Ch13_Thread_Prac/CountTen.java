package Ch13_Thread_Prac;
import java.util.Scanner;

class CountTenThread implements Runnable{
    @Override
    public void run() {
        int n = 1;
        while (n < 11) {
            System.out.print(n+" ");
            n++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
        System.out.println("Thread exit");
    }
}

public class CountTen {
    public static void main(String[] args) {
        System.out.print("press any key and enter >> ");
        Scanner scanner = new Scanner(System.in);
        String user = scanner.nextLine();
        Thread th = new Thread(new CountTenThread());
        if(user.length()!=0) {
            System.out.println("Thread Start");
            th.start();
        }
    }
}
