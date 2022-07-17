package Ch10_Practice;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyListenerLeft extends JFrame {

    private String text = "Love Java";
    JLabel la = new JLabel(text);
    public KeyListenerLeft(){
        setTitle("Left키로 문자열 이동");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        la.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e) {
                la = (JLabel) e.getSource();
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    text = text.substring(1) + text.substring(0, 1);
                    la.setText(text);
                }
            }
        });

        c.add(la);
        la.setFocusable(true);
        la.requestFocus();
        setSize(300,200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new KeyListenerLeft();
    }
}
