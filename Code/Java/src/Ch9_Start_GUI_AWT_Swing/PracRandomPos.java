package Ch9_Start_GUI_AWT_Swing;
import java.awt.*;
import javax.swing.*;
public class PracRandomPos extends JFrame {
    private int x, y;
    public PracRandomPos(){
        setTitle("Random Labels");
        setSize(300,300);
        Container c = getContentPane();
        c.setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        for(int i=0;i<20;i++){
            x = (int)(Math.random()*50+200);
            y = (int)(Math.random()*50+200);
            JLabel j = new JLabel((int)(Math.random()*100)+"");
            //j.setSize(10,10);
            //j.setLocation(x,y);
            j.setBounds(x,y,5,5);
            j.setOpaque(true);
            j.setBackground(Color.BLUE);

            c.add(j);
        }
    }
    public static void main(String[] args) {
        new PracRandomPos();
    }
}
