package Ch10_Practice;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LoveJava extends JFrame {
    JLabel la = new JLabel("올려봐");
    public LoveJava(){
        setTitle("마우스 올렸다 내리기 실습");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        la.setSize(50,20);
        la.addMouseListener(new MaMouseListener());
        c.add(la);
        setSize(300,200);
        setVisible(true);
    }
    class MaMouseListener implements MouseListener{
        @Override
        public void mouseEntered(MouseEvent e) {
            la.setText("Love.Java");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            la.setText("사랑해");
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }
    }
    public static void main(String[] args) {
        new LoveJava();
    }
}
