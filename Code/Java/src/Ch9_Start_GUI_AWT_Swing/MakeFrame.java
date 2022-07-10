package Ch9_Start_GUI_AWT_Swing;
import javax.swing.*;

public class MakeFrame extends JFrame {
    public MakeFrame(){
        setTitle("300x300 스윙 프레임 만들기");
        setSize(300,300);
        setVisible(true);
    }

    public static void main(String[] args) {
        MakeFrame frame = new MakeFrame();
    }
}
