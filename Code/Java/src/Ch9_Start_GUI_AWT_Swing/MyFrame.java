package Ch9_Start_GUI_AWT_Swing;
import java.awt.*;
import javax.swing.*;
public class MyFrame extends JFrame {
    public MyFrame(){
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.setBackground(Color.YELLOW);
        c.add(new JButton("click"));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MyFrame();
    }
}
