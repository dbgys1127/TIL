package Ch10_Practice;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyFontSize extends JFrame {
    JLabel la = new JLabel("Love Java");
    public KeyFontSize(){
        setTitle("Love Java");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        c.add(la);
        la.setFont(new Font("Arial", Font.PLAIN, 10));
        la.addKeyListener(new myKeyListener());

        la.setFocusable(true);
        la.requestFocus();
        setSize(300,200);
        setVisible(true);
    }
    class myKeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            la=(JLabel) e.getSource();
            Font f = la.getFont();
            int size = f.getSize();
            if(e.getKeyChar()=='+'){
                la.setFont(new Font("Arial",Font.PLAIN,size+5));
            }else if(e.getKeyChar()=='-'){
                if(size>=5) {
                    la.setFont(new Font("Arial", Font.PLAIN, size - 5));
                }
            }
        }
    }
    public static void main(String[] args) {
        new KeyFontSize();
    }
}
