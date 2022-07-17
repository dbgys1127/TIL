package Ch10_Practice;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseDrag extends JFrame {
    public MouseDrag(){
        setTitle("드래깅동안 YELLOW");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.GREEN);
        c.addMouseMotionListener(new maMouseMotionListener());
        c.addMouseListener(new maMouseListener());
        setSize(300,200);
        setVisible(true);
    }
    class maMouseListener extends MouseAdapter{
        @Override
        public void mouseReleased(MouseEvent e) {
            Component c = (Component) e.getSource();
            c.setBackground(Color.GREEN);
        }
    }
    class maMouseMotionListener extends MouseMotionAdapter{
        @Override
        public void mouseDragged(MouseEvent e) {
            Component c = (Component) e.getSource();
            c.setBackground(Color.YELLOW);
        }

    }
    public static void main(String[] args) {
        new MouseDrag();
    }
}
