package Ch9_Prac_GUI_AWT_Swing;
import java.awt.*;
import javax.swing.*;
public class PracGrid extends JFrame {
    public PracGrid(){
        setTitle("Ten Color Buttons Frame");
        setSize(600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container c=getContentPane();
        c.setLayout(new GridLayout(1,10));

        for(int i=0; i<10; i++) {
            Color[] col= {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
                    Color.CYAN, Color.BLUE, Color.MAGENTA,
                    Color.GRAY, Color.PINK, Color.LIGHT_GRAY};
            String text=Integer.toString(i);
            JLabel b=new JLabel(text);
            b.setBackground(col[i]);
            b.setOpaque(true);
            c.add(b);
        }
        setVisible(true);

    }
    public static void main(String[] args) {
        new PracGrid();
    }
}
