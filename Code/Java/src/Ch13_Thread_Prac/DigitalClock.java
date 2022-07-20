package Ch13_Thread_Prac;
import java.awt.*;
import java.util.Calendar;
import javax.swing.*;

class DigitalClockThread extends Thread {
    private JLabel label;
    public DigitalClockThread(JLabel label){
        this.label = label;
    }
    @Override
    public void run(){
        while (true){
            Calendar c = Calendar.getInstance();
            String hour = Integer.toString(c.get(Calendar.HOUR_OF_DAY));
            String min = Integer.toString(c.get(Calendar.MINUTE));
            String second = Integer.toString(c.get(Calendar.SECOND));

            String text = String.format("%s : %s : %s",hour,min,second );

            label.setText(text);

            try{
                sleep(1000);
            }catch (InterruptedException e){
                return;
            }
        }
    }
}

public class DigitalClock extends JFrame{
    public DigitalClock(){
        setTitle("Digital clock");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JLabel label = new JLabel();
        label.setFont(new Font("Gothic",Font.ITALIC,80));
        c.add(label);
        DigitalClockThread th = new DigitalClockThread(label);
        setSize(300,200);
        setVisible(true);
        th.start();
    }
    public static void main(String[] args) {
        new DigitalClock();
    }
}
