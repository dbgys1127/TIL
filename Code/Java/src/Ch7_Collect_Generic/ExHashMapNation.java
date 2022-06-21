package Ch7_Collect_Generic;
import java.util.*;

public class ExHashMapNation {
    Scanner Scan = new Scanner(System.in);
    HashMap<String,String> H = new HashMap<>();
    public ExHashMapNation(){
        H.put("한국","서울");
        H.put("미국","워싱턴");
        H.put("호주","캔버라");
        H.put("캐나다","몬트리올");
        H.put("멕시코","멕시코시티");
        H.put("아르헨티나","부에노스아이레스");
        H.put("우크라이나","키이우");
        H.put("프랑스","파리");
        H.put("대만","타이페이");
    }
    public void run(){
        System.out.println("*** 수도 맞추기 게임을 시작합니다. ***");
        while(true){
            System.out.print("입력:1, 퀴즈:2, 종료:3 >> ");
            int select = Scan.nextInt();
            if(select==3){System.out.println("종료합니다."); break;}
            switch (select){
                case 1: Read(); break;
                case 2: Quiz(); break;
            }
        }
    }
    public void Quiz(){
        while(true){
            Set<String> Keys = H.keySet();
            Iterator<String>it=Keys.iterator();
            String country = it.next();
            String capital = H.get(country);
            System.out.print(country+" 수도는 ??? ");
            String UserAnswer = Scan.next();
            if(UserAnswer.equals("그만"))break;
            if(UserAnswer.equals(capital)){
                System.out.println("정답!!!");
            }else System.out.println("아닙니다.");
        }
    }
    public void Read(){
        System.out.println("현재 "+H.size()+"개 나라와 수도가 입력되어있음.");
        while(true){
            System.out.print("나라와 수도 입력(현재 : " + (H.size() + 1) + "개) >> ");
            String country = Scan.next();
            if (country.equals("그만")) break;
            String capital = Scan.next();
            if(exist(country)){
                System.out.println(country+" 국가는 이미 있습니다.");
            }else{
                H.put(country,capital);
            }
        }
    }
    public boolean exist(String c){
        String country=H.get(c);
        if(country==null){
                return true;
            }
        return false;
    }
    public static void main(String[]args){
        ExHashMapNation Game = new ExHashMapNation();
        Game.run();
    }
}
