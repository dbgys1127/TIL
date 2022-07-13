package Ch10_EventProccesor;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class InnerClassListener extends JFrame {
    public InnerClassListener(){
        setTitle("Action 이벤트 리스너 예제");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c =getContentPane();
        c.setLayout(new FlowLayout());
        JButton btn = new JButton("Action");
        btn.addActionListener(new MyActionListener());
        c.add(btn);
        setSize(350,150);
        setVisible(true);
    }
    private class MyActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton) e.getSource();
            if(b.getText().equals("Action"))
                b.setText("액션");
            else
                b.setText("Action");
            setTitle(b.getText());
        }
    }
    public static void main(String[] args) {
        new InnerClassListener();
    }
}
