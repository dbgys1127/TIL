package Ch9_Start_GUI_AWT_Swing;
import java.awt.*;
import javax.swing.*;

public class PracRandomPosVer2 extends JFrame{
    public PracRandomPosVer2(){
        setTitle("여러 개의 패널을 가진 프레임");
        setSize(500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.add(new NorthPa(),BorderLayout.NORTH);
        c.add(new CenterPa(),BorderLayout.CENTER);
        c.add(new SouthPa(),BorderLayout.SOUTH);
        setVisible(true);
    }
    public static void main(String[] args) {
        new PracRandomPosVer2();
    }
}
class NorthPa extends JPanel{
    public NorthPa(){
        setBackground(Color.LIGHT_GRAY);
        setLayout(new GridLayout(1,3));
        JButton [] btn = new JButton[3];
        String [] str = {"열기","닫기","나가기"};
        for(int i=0;i<btn.length;i++){
            btn[i]=new JButton(str[i]);
            btn[i].setBackground(Color.pink);
            add(btn[i]);
        }
    }
}
class CenterPa extends JPanel{
    public CenterPa() {
        setLayout(null);
        for(int i =0;i<20;i++){
            JLabel a = new JLabel();
            a.setSize(10,10);
            a.setLocation((int)(Math.random()*50+400),(int)(Math.random()*50+400));
            a.setBackground(Color.RED);
            a.setOpaque(true);
            add(a);
        }
    }
}
class SouthPa extends JPanel{
    public SouthPa(){
        setBackground(Color.YELLOW);
        setLayout(new GridLayout(1,2));
        add(new JButton("Word Input"));
        JTextField a = new JTextField();
        a.setSize(350,50);
        add(a);
    }
}

