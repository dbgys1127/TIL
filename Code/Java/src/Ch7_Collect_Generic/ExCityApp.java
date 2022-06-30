package Ch7_Collect_Generic;
import java.util.*;

public class ExCityApp {
    Scanner Scan=new Scanner(System.in);
    HashMap<String,ExCity> H =new HashMap<>();
    public void read(){
        System.out.println("도시, 경도, 위도를 입력하세요.");
        for(int i =0; i<4;i++){
            System.out.print(">> ");
            String str = Scan.nextLine();
            StringTokenizer st=new StringTokenizer(str,",");
            String city = st.nextToken().trim();
            String longitude = st.nextToken().trim();
            String latitude = st.nextToken().trim();
            ExCity City = new ExCity(longitude,latitude);
            H.put(city,City);
        }
    }
    public void writeAll(){
        Set<String> Keys = H.keySet();
        Iterator<String> it = Keys.iterator();
        while(it.hasNext()){
            String Key = it.next();
            ExCity City = H.get(Key);
            System.out.println(Key+" "+City.getLongitude()+" "+City.getLatitude());
        }
    }
    public void findCity(){
        while(true){
            System.out.print("도시 이름 >> ");
            String find = Scan.next();
            ExCity City = H.get(find);
            if(find.equals("그만")){System.out.println("종료합니다."); break;}
            if(City==null) System.out.println(find+" 도시는 없습니다.");
            else{
                System.out.println(find+" "+City.getLongitude()+" "+City.getLatitude());
            }
        }
    }
    public void run(){
        read();
        System.out.println("--------------");
        writeAll();
        System.out.println("--------------");
        findCity();
        Scan.close();
    }

    public static void main(String[]args){
        ExCityApp Game = new ExCityApp();
        Game.run();
    }
}
