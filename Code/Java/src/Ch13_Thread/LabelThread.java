package Ch13_Thread;
import java.awt.*;
import javax.swing.*;

class ExLabelThread extends Thread{
    private JLabel timerLabel;

    public ExLabelThread(JLabel timerLabel){
        this.timerLabel=timerLabel;
    }
    @Override
    public void run(){
        int n=0;
        while(true){
            timerLabel.setText(Integer.toString(n));
            n++;
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                return;
            }
        }
    }
}

public class LabelThread extends JFrame{
    public LabelThread(){
        setTitle("스레드를 상속받는 타이머 스레드 예제");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JLabel timerLabel = new JLabel();
        timerLabel.setFont(new Font("Gothic",Font.ITALIC,80));
        c.add(timerLabel);

        ExLabelThread lt = new ExLabelThread(timerLabel);

        setSize(300,170);
        setVisible(true);

        lt.start();
    }
    public static void main(String[] args) {
        new LabelThread();
    }
}
