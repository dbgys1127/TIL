package Ch13_Thread;

public class ThreadMain {
    public static void main(String[] args) {
        long id = Thread.currentThread().getId();
        String name = Thread.currentThread().getName();
        int priority = Thread.currentThread().getPriority();

        Thread.State s = Thread.currentThread().getState();

        System.out.println("thread name : "+name);
        System.out.println("thread id : "+id);
        System.out.println("thread priority : "+priority);
        System.out.println("thread state : "+s);
    }
}
