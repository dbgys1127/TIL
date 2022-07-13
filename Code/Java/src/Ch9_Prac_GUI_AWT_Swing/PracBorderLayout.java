package Ch9_Prac_GUI_AWT_Swing;

import javax.swing.*;
import java.awt.*;
public class PracBorderLayout extends JFrame {
    public PracBorderLayout(){
        setTitle("BorederLayout Practice");
        setSize(300,200);
        Container c = getContentPane();
        c.setLayout(new BorderLayout(5,7));
        c.add(new JButton("Center"),BorderLayout.CENTER);
        c.add(new JButton("North"),BorderLayout.NORTH);
        c.add(new JButton("South"),BorderLayout.SOUTH);
        c.add(new JButton("West"),BorderLayout.WEST);
        c.add(new JButton("East"),BorderLayout.EAST);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }
    public static void main(String[] args) {
        new PracBorderLayout();
    }
}
