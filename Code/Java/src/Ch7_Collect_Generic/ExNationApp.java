package Ch7_Collect_Generic;
import java.util.*;

public class ExNationApp {
    Scanner Scan = new Scanner(System.in);
    Vector<ExNation> V = new Vector<>();
    ExNation<String> EN;
    public ExNationApp(){
        EN=new ExNation<>("한국","서울");
        V.add(EN);
        EN=new ExNation<>("미국","워싱턴");
        V.add(EN);
        EN=new ExNation<>("호주","캔버라");
        V.add(EN);
        EN=new ExNation<>("캐나다","몬트리올");
        V.add(EN);
        EN=new ExNation<>("멕시코","멕시코시티");
        V.add(EN);
        EN=new ExNation<>("아르헨티나","부에노스아이레스");
        V.add(EN);
        EN=new ExNation<>("우크라이나","키이우");
        V.add(EN);
        EN=new ExNation<>("프랑스","파리");
        V.add(EN);
        EN=new ExNation<>("대만","타이페이");
        V.add(EN);
    }
    public void run(){
        System.out.println("*** 수도 맞추기 게임을 시작합니다. ***");
        while(true){
            System.out.print("입력:1, 퀴즈:2, 종료:3 >> ");
            int select = Scan.nextInt();
            if(select==3){System.out.println("종료합니다."); break;}
            switch (select){
                case 1: read(); break;
                case 2: Quiz(); break;
            }
        }
    }
    public void Quiz(){
        while(true){
            int n = (int)(Math.random()*V.size());
            ExNation QuizNation = V.get(n);
            String country = (String)QuizNation.getCountry();
            String capital = (String)QuizNation.getCapital();
            System.out.print(country+" 수도는 ??? ");
            String UserAnswer = Scan.next();
            if(UserAnswer.equals("그만"))break;
            if(UserAnswer.equals(capital)){
                System.out.println("정답!!!");
            }else System.out.println("아닙니다.");
        }
    }
    public void read(){
        System.out.println("현재 "+V.size()+"개 나라와 수도가 입력되어있음.");
        while(true) {
            System.out.print("나라와 수도 입력(현재 : " + (V.size() + 1) + "개) >> ");
            String country = Scan.next();
            if (country.equals("그만")) break;
            String capital = Scan.next();
            if(exist(country)){
                System.out.println(country+" 국가는 이미 있습니다.");
            }else{
                EN=new ExNation<>(country,capital);
                V.add(EN);
            }
        }
    }
    public boolean exist(String c){
        for(int i=0;i<V.size();i++){
            ExNation find = V.get(i);
            String findCountry = (String) find.getCountry();
            if(c.equals(findCountry)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[]args){
        ExNationApp Game = new ExNationApp();
        Game.run();
    }
}
