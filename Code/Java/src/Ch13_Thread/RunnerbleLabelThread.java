package Ch13_Thread;
import java.awt.*;
import javax.swing.*;
class TimerRunnerble implements Runnable{
    private JLabel timerLabel;

    public TimerRunnerble(JLabel timerLabel){
        this.timerLabel=timerLabel;
    }

    public void run(){
        int n = 0;
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

public class RunnerbleLabelThread extends JFrame {
    public RunnerbleLabelThread(){
        setTitle("Runnerble Label Thread");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JLabel timerLabel = new JLabel();
        timerLabel.setFont(new Font("Gothic",Font.ITALIC,80));
        c.add(timerLabel);

        Thread th = new Thread(new TimerRunnerble(timerLabel));



        th.start();
        setSize(300,200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new RunnerbleLabelThread();
    }
}
