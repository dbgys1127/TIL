package Ch7_Collect_Generic;
import java.util.*;

public class ExUserPointApp {
    Scanner Scan = new Scanner(System.in);
    HashMap<String,Integer> H = new HashMap<>();
    String name;
    public void read(){
        while(true){
            System.out.print("이름과 포인트 입력 >> ");
            String str = Scan.nextLine();
            StringTokenizer st = new StringTokenizer(str," ");
            name = st.nextToken().trim();
            int Point = Integer.parseInt(st.nextToken().trim());
            if(name.equals("그만")) {System.out.println("종료합니다."); break;}
            if(repeat(H)){
                Point=H.get(name)+Point;
                H.remove(name);
                H.put(name,Point);
            }else{
                H.put(name,Point);
            }
            writeAll();
        }
    }
    public boolean repeat(HashMap<String,Integer>H){
        Set<String> Keys = H.keySet();
        Iterator<String> it = Keys.iterator();
        while(it.hasNext()){
            String UserName = it.next();
            if(name.equals(UserName)){
               return true;
            }
        }
        return false;
    }
    public void writeAll(){
        Set<String> Keys = H.keySet();
        Iterator<String> it = Keys.iterator();
        while(it.hasNext()){
            String UserName = it.next();
            int UserPoint = H.get(UserName);
            System.out.print("("+UserName+","+UserPoint+")");
        }
        System.out.println();
    }
    public void run(){
        System.out.println("*** 포인트 관리 프로그램입니다 ***");
        read();
    }
    public static void main(String[]args){
        ExUserPointApp Game = new ExUserPointApp();
        Game.run();

    }
}
