package Ch13_Thread;
import java.awt.*;
import javax.swing.*;

class FlickerThread extends JLabel implements Runnable{
    private long delay;

    public FlickerThread(String text, long delay){
        super(text);
        this.delay=delay;
        setOpaque(true);

        Thread th = new Thread(this);
        th.start();
    }
    @Override
    public void run(){
        int n=0;
        while (true){
            if(n==0) {
                setBackground(Color.YELLOW);
                n=1;
            }
            else {
                setBackground(Color.GREEN);
                n=0;
            }
            try{
                Thread.sleep(delay);
            }catch (InterruptedException e){
                return;
            }
        }
    }
}

public class FlickerLabel extends JFrame {
    public FlickerLabel(){
        setTitle("FlickerLabel");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        FlickerThread fLabel = new FlickerThread("깜박",500);
        JLabel label = new JLabel("no flick");
        FlickerThread fLabel1 = new FlickerThread("여기도 깜박",300);
        c.add(fLabel);
        c.add(label);
        c.add(fLabel1);
        setSize(300,200);
        setVisible(true);


    }
    public static void main(String[] args) {
        new FlickerLabel();
    }
}
