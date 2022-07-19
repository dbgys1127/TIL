package Ch13_Thread;
import java.lang.Thread;

class TimerThread extends Thread{
    int i = 0;
    @Override
    public void run(){
        while(i!=60){
            System.out.println(i);
            i++;
            try {
                sleep(1000);
            }catch (InterruptedException e){
                return;
            }
        }
    }
}

public class ExTimeThread {
    public static void main(String[] args) {
        TimerThread th = new TimerThread();
        th.start();
    }
}
