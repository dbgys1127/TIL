package Ch13_Thread;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class FlagForcedExitThread implements Runnable{
    private Container contentPane;
    private boolean flag = false;

    public FlagForcedExitThread(Container contentPane){
        this.contentPane=contentPane;
    }
    public void finish(){
        flag = true;
    }
    public void run() {
        while (true) {
            int x = ((int) (Math.random() * contentPane.getWidth()));
            int y = ((int) (Math.random() * contentPane.getHeight()));
            JLabel label = new JLabel("java");
            label.setSize(80, 30);
            label.setLocation(x, y);
            contentPane.add(label);
            contentPane.repaint();
            try {
                Thread.sleep(300);
                if (flag == true) {
                    contentPane.removeAll();
                    label = new JLabel("finish");
                    label.setSize(80, 30);
                    label.setLocation(100, 100);

                    label.setForeground(Color.RED);
                    contentPane.add(label);
                    contentPane.repaint();
                    return;
                }
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}

public class ExFlagForcedExit extends JFrame {

    public ExFlagForcedExit(){
        setTitle("Flag finish ex");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);
        FlagForcedExitThread ru = new FlagForcedExitThread(c);
        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                ru.finish();
            }
        });
        setSize(300,200);
        setVisible(true);
        Thread th = new Thread(ru);
        th.start();
    }
    public static void main(String[] args) {
        new ExFlagForcedExit();
    }
}
