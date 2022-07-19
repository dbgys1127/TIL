package Ch13_Thread;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ForcedExitThread extends Thread{
    private JLabel timerLabel;

    public ForcedExitThread(JLabel timerLabel){
        this.timerLabel=timerLabel;
    }
    @Override
    public void run(){
        int n=0;
        while(true){
            timerLabel.setText(Integer.toString(n));
            n++;
            try{
                sleep(1000);
            }catch (InterruptedException e){
                return;
            }
        }
    }
}

public class ForcedExit extends JFrame {
    public ForcedExit(){
        setTitle("ThreadInterrupt 예제");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JLabel timerLabel = new JLabel();
        timerLabel.setFont(new Font("Gothic",Font.ITALIC,80));

        ForcedExitThread th = new ForcedExitThread(timerLabel);
        c.add(timerLabel);

        JButton btn = new JButton("Kill Timer");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                th.interrupt();
                JButton btn = (JButton) e.getSource();
                btn.setEnabled(false);
            }
        });
        c.add(btn);

        setSize(300,170);
        setVisible(true);

        th.start();
    }
    public static void main(String[] args) {
        new ForcedExit();
    }
}
