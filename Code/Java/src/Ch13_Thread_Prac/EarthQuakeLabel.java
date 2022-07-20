package Ch13_Thread_Prac;
import java.awt.*;
import javax.swing.*;

class EarthQuakeLabelThread extends Thread{
    private JLabel label;
    public EarthQuakeLabelThread(JLabel label){
        this.label = label;
    }
    @Override
    public void run(){
        while (true){
            label.setLocation(100,100);
            try{
                sleep(100);
                label.setLocation(90,90);
                sleep(100);
                label.setLocation(110,110);
            }catch (InterruptedException e){
                return;
            }
        }
    }

}

public class EarthQuakeLabel extends JFrame {
    public EarthQuakeLabel(){
        setTitle("vibrate Label");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);

        JLabel label = new JLabel("Vibrate Label");
        label.setSize(80,50);
        c.add(label);

        setSize(200,200);
        setVisible(true);
        EarthQuakeLabelThread th = new EarthQuakeLabelThread(label);

        th.start();
    }
    public static void main(String[] args) {
        new EarthQuakeLabel();
    }
}
