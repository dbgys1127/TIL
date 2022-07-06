package Ch8_Practice;
import java.util.*;
import java.io.*;
//1. BufferedReader 생성자를 이용해, word.txt와 연결한다.
//2. Scanner를 BufferedReader와 연결한다.
//3. Vector 객체를 생성한다.
//4. Scanner 객체의 hasNext()메서드가 false를 뱉어낼때까지
//5. Scanner를  nextLine으로 한라인씩 읽어서 Vector에 add한다.
//6. 검색할 단어를 String으로 저장한다.
//7. 저장된 단어를 while문을 만들어 contains 메서드로 참 거짓을 가리고,

public class PracWordSearch {
    public static void main(String[] args) {
        FileReader src;
        Vector<String> V = new Vector<>();
        try {
            src = new FileReader("C:\\Users\\kim\\Desktop\\TIL\\Code\\Java\\src\\Ch8_Practice\\Files\\words.txt");
            System.out.println("프로젝트 폴더밑의 words.txt 파일을 읽었습니다...");
            Scanner Scan = new Scanner(src);
            while (Scan.hasNext()) {
                V.add(Scan.nextLine());
            }
            Scan.close();
            Scanner User = new Scanner(System.in);
            while(true){
                boolean found = false;
                System.out.print("단어 >>");
                String searchWord = User.nextLine();
                if(searchWord.equals("그만")) {
                    System.out.println("종료합니다");
                    break;
                }
                for(int i=0;i<V.size();i++){
                    String word = V.get(i);
                    if(word.length()<searchWord.length()) continue;

                    String frontPart = word.substring(0,searchWord.length());

                    if(searchWord.equals(frontPart)){
                        System.out.println(word);
                        found = true;
                    }
                }
                if(!found) System.out.println("찾는단어가 없습니다.");
            }
            User.close();
            src.close();
        }catch(IOException e){
            System.out.println("연결실패");
        }
    }
}
