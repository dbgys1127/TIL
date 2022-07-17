package Ch10_Practice;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class getKeyCode extends JFrame {
    JLabel la = new JLabel("Love Java");
    public getKeyCode(){
        setTitle("Left 키로 문자열 교체");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        la.addKeyListener(new maKeyListenr());
        c.add(la);
        setSize(300,200);
        setVisible(true);
        la.setFocusable(true);
        la.requestFocus();
    }
    class maKeyListenr extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            la = (JLabel) e.getSource();

            if(e.getKeyCode()==KeyEvent.VK_LEFT){
                StringBuffer text  = new StringBuffer(la.getText());
                la.setText(text.reverse().toString());
            }

        }
    }
    public static void main(String[] args) {
        new getKeyCode();
    }
}
