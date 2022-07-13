package Ch9_Start_GUI_AWT_Swing;
import javax.swing.*;

public class SwingFrame extends JFrame {
    public SwingFrame(){
        setTitle("hello");
        setSize(200,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }
    public static void main(String[] args) {
        SwingFrame Frame = new SwingFrame();
    }
}
