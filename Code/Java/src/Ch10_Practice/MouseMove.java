package Ch10_Practice;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseMove extends JFrame {
    JLabel la = new JLabel("Click");
    public MouseMove(){
        setTitle("클릭 연습용 응용프로그램");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(null);
        la.setLocation(100,100);
        la.setSize(50,20);
        c.addMouseListener(new maMouseMover());
        c.add(la);
        setVisible(true);
        setSize(500,500);
    }
    class maMouseMover extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent e) {
            Component a = (Component) e.getSource();
            int x = (int)(Math.random()*400);
            int y = (int)(Math.random()*400);
            la.setLocation(x,y);
        }
    }
    public static void main(String[] args) {
        new MouseMove();
    }
}
