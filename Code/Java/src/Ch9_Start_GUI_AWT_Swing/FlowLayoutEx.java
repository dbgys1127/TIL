package Ch9_Start_GUI_AWT_Swing;
import javax.swing.*;
import java.awt.*;

public class FlowLayoutEx extends JFrame {
    public FlowLayoutEx(){
        setTitle("FlowLayout Sample");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();

        c.setLayout(new FlowLayout(FlowLayout.LEFT,30,40));
        c.add(new JButton("ADD"));
        c.add(new JButton("SUB"));
        c.add(new JButton("MUL"));
        c.add(new JButton("DIV"));
        c.add(new JButton("Calculate"));

        setSize(300,200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new FlowLayoutEx();
    }
}
