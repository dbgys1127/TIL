package Ch7_Collect_Generic;
import java.util.*;

public class ExBeauty {
    Scanner Scan = new Scanner(System.in);
    Vector<ExShape> V = new Vector<ExShape>();
    public void run(){
        System.out.println("그랙픽 에디터를 실행합니다.");
        while(true){
            System.out.print("삽입(1), 삭제(2), 모두보기(3), 종료(4) >> ");
            int select = Scan.nextInt();
            if(select==4)break;
            switch (select){
                case 1: Read(); break;
                case 2: Remove(); break;
                case 3: Review(); break;
                default:System.out.println("1~4까지 숫자를 입력하세요.");
            }
        }
    }
    public void Read(){
        ExShape Shape=null;
        System.out.print("Line(1), Rect(2), Circle(3) >> ");
        int select = Scan.nextInt();
        switch (select){
            case 1: Shape=new Line(); break;
            case 2: Shape=new Rect(); break;
            case 3: Shape=new Circle(); break;
            default: System.out.println("1~3까지 숫자를 입력하세요.");
        }
        V.add(Shape);
    }
    public void Remove(){
        System.out.print("삭제할 도형의 위치 >> ");
        int select = Scan.nextInt();
        if(select>V.size()) {System.out.println("삭제할 수 없습니다.");}
        else V.remove(select-1);
    }
    public void Review(){
        for(int j=0;j<V.size();j++){
            V.get(j).paint();
        }
    }
    public static void main(String[]args){
        ExBeauty Game = new ExBeauty();
        Game.run();
    }
}
