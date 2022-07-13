package Ch9_Start_GUI_AWT_Swing;
import java.awt.*;
import javax.swing.*;
public class PracColorGrid extends JFrame {
    public PracColorGrid(){
        setTitle("4x4 Color Frame");
        setSize(500,500);
        Container c = getContentPane();
        c.setLayout(new GridLayout(4,4));
        for(int i=0;i<16;i++){
            Color [] col = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
                    Color.CYAN, Color.BLUE, Color.MAGENTA,
                    Color.GRAY, Color.PINK, Color.LIGHT_GRAY,
                    Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
                    Color.CYAN, Color.BLUE};
            String text = Integer.toString(i);
            JLabel b = new JLabel(text);
            b.setOpaque(true);
            b.setBackground(col[i]);
            c.add(b);
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new PracColorGrid();
    }
}
