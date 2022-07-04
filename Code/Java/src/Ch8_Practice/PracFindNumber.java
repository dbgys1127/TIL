package Ch8_Practice;
import java.util.*;
import java.io.*;
//HashMap 생성부
//1. FileReader를 전화번호부와 연결한다.
//2. 전화번호부를 담을 String 배열을 만든다.
//3. read() 메서드로 전화번호부 한줄씩 읽는다.
//4. HashMap<String,String> 객체를 만들고, String s[]=읽은 스트링.split(" ")를 해서 배열을 만든다.
//5. HashMap에 add(s[0],s[1])한다.
//검색 부
//1. String num=h.get(name)
public class PracFindNumber {
    public static void main(String[] args) {
        File src =new File("C:\\Users\\kim\\Desktop\\TIL\\Code\\Java\\src\\Ch8_Practice\\Files\\Files1\\phone.txt");
        HashMap<String,String> h = new HashMap<>();
        int count =0;
        try{
            Scanner Scan=new Scanner(new FileReader(src));
            while (Scan.hasNext()){
                String line = Scan.nextLine();
                String s[] = line.split(" ");
                h.put(s[0],s[1]);
                count++;
            }
            Scan.close();
        }catch (IOException e){
            System.out.println("파일 연결 실패");
        }
        Scanner ScanName = new Scanner(System.in);
        System.out.println("총 "+count+"개 전화번호가 있습니다.");
        while(true){
            System.out.print("이름 >> ");
            String name = ScanName.nextLine();
            if(name.equals("그만")) break;
            if(h.get(name)==null) System.out.println("찾는 이름이 없습니다.");
            else System.out.println(h.get(name));
        }
    }
}
