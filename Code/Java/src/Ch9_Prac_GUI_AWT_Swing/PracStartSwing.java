package Ch9_Prac_GUI_AWT_Swing;
import javax.swing.*;
public class PracStartSwing extends JFrame {
    public PracStartSwing(){
        setTitle("Let's study Java");
        setSize(400,200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new PracStartSwing();
    }
}
