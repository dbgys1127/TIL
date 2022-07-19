package Ch13_Thread;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyLabel extends JLabel{
    private int barSize = 0;
    private int maxBarSize;

    public MyLabel(int maxBarSize){
        this.maxBarSize=maxBarSize;
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.MAGENTA);
        int width = (int)(((double)(this.getWidth()))/maxBarSize*barSize);
        if(width==0) return;
        g.fillRect(0,0,width, this.getHeight());
    }
    synchronized public void fill(){
        if(barSize==maxBarSize){
            try{
                wait();
            }catch (InterruptedException e){
                return;
            }
        }
        System.out.println("fill : "+barSize);
        barSize++;
        repaint();
        notify();
    }
    synchronized public void consume(){
        if(barSize == 0){
            try{
                wait();
            }catch (InterruptedException e){
                return;
            }
        }
        System.out.println("consume : "+barSize);
        barSize--;
        repaint();
        notify();
    }
}
class ConsumerThread extends Thread{
    private MyLabel bar;
    public ConsumerThread(MyLabel bar){
        this.bar = bar;
    }
    @Override
    public void run(){
        while(true){
            try{
                sleep(200);
                bar.consume();
            }catch (InterruptedException e){
                return;
            }
        }
    }
}

public class TabAndThreadEx extends JFrame {
    private MyLabel bar = new MyLabel(100);

    public TabAndThreadEx(){
        setTitle("아무키나 빠르게 갈기세요");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);
        bar.setBackground(Color.ORANGE);
        bar.setOpaque(true);
        bar.setLocation(20,50);
        bar.setSize(300,20);
        c.add(bar);

        c.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                bar.fill();
            }
        });
        setSize(350,200);
        setVisible(true);

        c.setFocusable(true);
        c.requestFocus();
        ConsumerThread th = new ConsumerThread(bar);
        th.start();
    }

    public static void main(String[] args) {
        new TabAndThreadEx();
    }
}
