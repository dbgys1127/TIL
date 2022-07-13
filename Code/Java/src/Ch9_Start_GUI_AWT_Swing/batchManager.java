package Ch9_Start_GUI_AWT_Swing;
import java.awt.*;
import javax.swing.*;
public class batchManager extends JFrame {
    public batchManager(){
        setTitle("test");
        setSize(300,300);
        Container c = getContentPane();
        GridLayout grid = new GridLayout(5,2);
        grid.setHgap(7);
        grid.setVgap(8);
        c.setLayout(grid);
        c.add(new JButton("1st"));
        c.add(new JButton("2st"));
        c.add(new JButton("3st"));
        c.add(new JButton("4st"));
        c.add(new JButton("5st"));
        c.add(new JButton("6st"));
        c.add(new JButton("7st"));
        c.add(new JButton("8st"));
        c.add(new JButton("9st"));
        c.add(new JButton("10st"));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        c.setLayout(null);

    }
    public static void main(String[] args) {
        new batchManager();
    }
}
