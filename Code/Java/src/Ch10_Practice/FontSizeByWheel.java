package Ch10_Practice;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FontSizeByWheel extends JFrame {
    JLabel la = new JLabel("Love Java");
    public FontSizeByWheel(){
        setTitle("마우스 휠을 굴려 글자크기 조절");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        la.setFont(new Font("Arial", Font.PLAIN, 10));
        la.addMouseWheelListener(new WheelControl());
        c.add(la);

        setVisible(true);
        setSize(600,400);
    }
    class WheelControl implements MouseWheelListener{
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            la = (JLabel) e.getSource();
            Font f = la.getFont();
            int size = f.getSize();
            int n = e.getWheelRotation();
            if(n<0){
                if(size>=5) {
                    la.setFont(new Font("Arial", Font.PLAIN, size - 5));
                }
            }else{
                la.setFont(new Font("Arial", Font.PLAIN, size + 5));
            }
        }
    }
    public static void main(String[] args) {
        new FontSizeByWheel();
    }
}
