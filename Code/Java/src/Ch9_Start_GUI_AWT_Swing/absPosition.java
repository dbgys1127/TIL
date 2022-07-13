package Ch9_Start_GUI_AWT_Swing;
import java.awt.*;
import javax.swing.*;
public class absPosition extends JFrame {
    public absPosition(){
        setTitle("absPosition");
        Container c = getContentPane();
        c.setLayout(null);
        JButton button = new JButton("click");
        button.setSize(100,30);
        button.setLocation(50,70);
        JButton button1 = new JButton("cli");
        button1.setSize(100,30);
        button1.setLocation(60,80);
        c.add(button);
        c.add(button1);
        setSize(300,200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new absPosition();
    }
}
