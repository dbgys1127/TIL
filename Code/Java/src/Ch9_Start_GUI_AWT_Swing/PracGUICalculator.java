package Ch9_Start_GUI_AWT_Swing;
import java.awt.*;
import javax.swing.*;
public class PracGUICalculator extends JFrame {
    public PracGUICalculator(){
        setTitle("계산기 프레임");
        setSize(500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.add(new NorthPan(),BorderLayout.NORTH);
        c.add(new CenterPan(),BorderLayout.CENTER);
        c.add(new SouthPan(),BorderLayout.SOUTH);
        setVisible(true);
    }
    public static void main(String[] args) {
        new PracGUICalculator();
    }
}
class NorthPan extends JPanel{
    public NorthPan(){
        setBackground(Color.LIGHT_GRAY);
        setLayout(new GridLayout(1,2));
        add(new JLabel("수식입력"));
        JTextField a = new JTextField();
        a.setSize(350,50);
        add(a);
    }
}
class CenterPan extends JPanel{
    public CenterPan() {
        setLayout(new GridLayout(4,4));
        String [] str = {"CE","계산","+","-","*","/"};
        JButton [] btn = new JButton[16];
        for (int i=0;i<10;i++){
            String text = Integer.toString(i);
            btn[i]=new JButton(text);
            add(btn[i]);
        }
        for(int i=10;i<16;i++){
            btn[i]=new JButton(str[i-10]);
            add(btn[i]);
        }
        for(int i=0;i<16;i++){
            if(i<12){
                btn[i].setBackground(Color.pink);
                btn[i].setOpaque(true);
            }else{
                btn[i].setBackground(Color.CYAN);
                btn[i].setOpaque(true);
            }
        }
    }
}
class SouthPan extends JPanel{
    public SouthPan(){
        setBackground(Color.YELLOW);
        setLayout(new GridLayout(1,2));
        add(new JLabel("계산결과"));
        JTextField a = new JTextField();
        a.setSize(350,50);
        add(a);
    }
}