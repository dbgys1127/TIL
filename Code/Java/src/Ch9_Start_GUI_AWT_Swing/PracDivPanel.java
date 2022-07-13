package Ch9_Start_GUI_AWT_Swing;
import java.awt.*;
import javax.swing.*;
public class PracDivPanel extends JFrame{
    private NorthPanel North=new NorthPanel();
    private CenterPanel Center=new CenterPanel();
    public PracDivPanel(){
        setTitle("Open Challenge 9");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        Container c = getContentPane();
        c.add(North.getPanel(),BorderLayout.NORTH);
        c.add(Center.getPanel(),BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        PracDivPanel Prac = new PracDivPanel();
    }
}
class NorthPanel extends JPanel{
    public NorthPanel(){
        setBackground(Color.LIGHT_GRAY);
    }
    public JPanel getPanel(){
        JPanel c = new JPanel();
        c.setLayout(new FlowLayout());
        c.add(new JButton("Open"));
        c.add(new JButton("Read"));
        c.add(new JButton("Close"));
        return c;
    }
}
class CenterPanel extends JPanel{
    public JPanel getPanel(){
        JLabel [] j = new JLabel[3];
        JPanel c = new JPanel();
        c.setLayout(null);
        String [] name = {"Open","Read","Close"};
        int [] x = {20,250,480};
        int [] y = {480,250,20};
        for(int i =0 ; i<3;i++){
            j[i]=new JLabel(name[i]);
            j[i].setSize(50,100);
            j[i].setLocation(x[i],y[i]);
            c.add(j[i]);
        }
        return c;
    }
}