package Ch13_Thread_Prac;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class RandomMoveThread extends Thread{
    private Container contentPane;
    public RandomMoveThread(Container contentPane){
        this.contentPane=contentPane;
    }
    public void run() {
        while (true) {
            int x = ((int)(Math.random()*contentPane.getWidth()));
            int y = ((int)(Math.random()*contentPane.getHeight()));
            JLabel label = new JLabel("java");
            label.setSize(80,30);
            label.setLocation(x,y);
            System.out.println("moving");
            contentPane.add(label);
            contentPane.repaint();
            try{
                sleep(500);
            }catch (InterruptedException e){
                return;
            }
        }
    }
}

public class RandomMove extends JFrame {
    public RandomMove(){
        setTitle("every 0.5 second move");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);

        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Thread th =new Thread(new RandomMoveThread(c));
                th.start();
                System.out.println("move");
            }
        });
        setSize(300,200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new RandomMove();
    }
}
