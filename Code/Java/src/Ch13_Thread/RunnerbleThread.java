package Ch13_Thread;

class RunnerbleTimer implements Runnable{
    int n=0;
    public void run(){
        while(true){
            System.out.println(n);
            n++;
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                return;
            }
        }
    }
}

public class RunnerbleThread {
    public static void main(String[] args) {
        Thread th = new Thread(new RunnerbleTimer());
        th.start();
    }
}
