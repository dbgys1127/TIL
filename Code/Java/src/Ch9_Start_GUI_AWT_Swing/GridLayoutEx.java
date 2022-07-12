package Ch9_Start_GUI_AWT_Swing;
import javax.swing.*;
import java.awt.*;

public class GridLayoutEx extends JFrame {
    public GridLayoutEx(){
        setTitle("GridLayout Sample");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        GridLayout grid = new GridLayout(4,2);
        grid.setVgap(5);
        c.setLayout(grid);
        c.add(new JLabel("이름"));
        c.add(new JTextField(""));
        c.add(new JLabel("학번"));
        c.add(new JTextField(""));
        c.add(new JLabel("학과"));
        c.add(new JTextField(""));
        c.add(new JLabel("과목"));
        c.add(new JTextField(""));

        setSize(300,200);
        setVisible(true);

    }
    public static void main(String[] args) {
        new GridLayoutEx();
    }
}
