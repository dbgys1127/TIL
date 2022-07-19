package Ch9_Prac_GUI_AWT_Swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PracStartSwing extends JFrame {
    public PracStartSwing(){
        setTitle("Let's study Java");
        setSize(400,200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setContentPane(new GamePanel());

        getContentPane().setFocusable(true);
        getContentPane().requestFocus();
    }
    class GamePanel extends JPanel{
        JLabel [] la = new JLabel[3];
        JLabel result = new JLabel("시작합니다.");
        public GamePanel(){
            setLayout(null);
            for(int i =0;i<la.length;i++){
                la[i] = new JLabel("0");
                la[i].setSize(60,30);
                la[i].setLocation(30+80*i,50);
                la[i].setHorizontalAlignment(JLabel.CENTER);
                la[i].setOpaque(true);
                la[i].setBackground(Color.MAGENTA);
                la[i].setForeground(Color.YELLOW);
                la[i].setFont(new Font("Tahoma",Font.ITALIC,30));
                add(la[i]);
            }
            result.setSize(200,20);
            result.setLocation(100,120);
            add(result);
            addKeyListener(new ma());
            addMouseListener(new mamo());
        }
        class ma extends KeyAdapter{
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    int x1 = (int)(Math.random()*5);
                    la[0].setText(Integer.toString(x1));
                    int x2 = (int)(Math.random()*5);
                    la[1].setText(Integer.toString(x2));
                    int x3 = (int)(Math.random()*5);
                    la[2].setText(Integer.toString(x3));
                    if(x1==x2 &&x1==x3)
                        result.setText("축하");
                    else
                        result.setText("아쉽");
                }
            }
        }
        class mamo extends MouseAdapter{
            @Override
            public void mousePressed(MouseEvent e) {
                Component c = (Component)e.getSource(); // ���콺�� Ŭ���� ������Ʈ
                c.requestFocus(); // ���콺�� Ŭ���� ������Ʈ���� ��Ŀ�� ����
            }
        }
    }
    public static void main(String[] args) {
        new PracStartSwing();
    }
}
