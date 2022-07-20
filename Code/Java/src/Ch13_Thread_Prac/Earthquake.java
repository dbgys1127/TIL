package Ch13_Thread_Prac;
import java.awt.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class EarthquakeThread extends JFrame implements Runnable{
    private JFrame f = new JFrame("vibrate frame");

    @Override
    public void run(){
        while(true) {
            f.setLocation(100, 100);
            f.setDefaultCloseOperation(EXIT_ON_CLOSE);
            Container c = getContentPane();
            f.setVisible(true);
            f.setSize(300, 200);
            try {
                Thread.sleep(100);
                f.setLocation(110, 110);
                Thread.sleep(100);
                f.setLocation(90,90);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
public class Earthquake {
    public static void main(String[] args) {
        EarthquakeThread ru = new EarthquakeThread();
        Thread th = new Thread(ru);
        th.start();
    }
}
