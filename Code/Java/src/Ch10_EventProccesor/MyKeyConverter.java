package Ch10_EventProccesor;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MyKeyConverter extends JFrame {
    private JLabel la = new JLabel();
    public MyKeyConverter(){
        setTitle("F1 : Green / % : Yellow");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.addKeyListener(new MaKeyListener());
        c.add(la);
        setSize(300,150);
        setVisible(true);

        c.setFocusable(true);
        c.requestFocus();
    }
    class MaKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            Container c = (Container) e.getSource();

            la.setText(KeyEvent.getKeyText(e.getKeyCode())+"키가 입력됨");
            if(e.getKeyChar()=='%')
                c.setBackground(Color.YELLOW);
            else if(e.getKeyCode()==KeyEvent.VK_F1)
                c.setBackground(Color.GREEN);
        }
    }
    public static void main(String[] args) {
        new MyKeyConverter();
    }
}
