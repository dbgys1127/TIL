package Ch9_Start_GUI_AWT_Swing;
import javax.swing.*;
import java.awt.*;

public class MakeFrameWithThreeButton extends JFrame {
    public MakeFrameWithThreeButton(){
        setTitle("ContentPane과 JFrame");// 프레임 타이틀 달기
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 프레임 윈도우를 닫으면, 프로그램 종료하도록 설정

        Container contentPane = getContentPane();// 컨텐트 팬을 알아낸다.
        contentPane.setBackground(Color.ORANGE);// 컨텐트 팬의 배경색을 오렌지색으로 변경
        contentPane.setLayout(new FlowLayout());// 컨텐트팬에 FlowLayout 배치관리자 달기

        contentPane.add(new JButton("OK")); //버튼을 컨텐트 팩에 넣기
        contentPane.add(new JButton("Cancel"));
        contentPane.add(new JButton("Ignore"));

        setSize(300,150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MakeFrameWithThreeButton();
    }
}
