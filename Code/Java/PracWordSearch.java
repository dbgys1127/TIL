package Ch8_Practice;
import java.sql.SQLOutput;
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

       Vector<String> v = new Vector<>();
       try {
           Scanner scanSrc = new Scanner(new FileInputStream("words.txt"));
           while(scanSrc.hasNext()){
               v.add(scanSrc.nextLine());
           }
           scanSrc.close();
           System.out.println("단어사전을 만들었습니다. 검색해보세요!");
           Scanner userScan = new Scanner(System.in);
           while(true){
               boolean found =false;
               System.out.print("단어 >> ");
               String userInput = userScan.next();
               if(userInput.equals("그만")){
                   System.out.println("사전을 종료합니다.");
                   break;
               }
               for(int i=0;i<v.size();i++){
                   String word = v.get(i);
                   if(word.length()<userInput.length()) continue;
                   String frontWord = word.substring(0,userInput.length());
                   if(frontWord.equals(userInput)){
                       System.out.println(word);
                       found =true;
                   }
               }
               if(!found) System.out.println("찾을 수 없습니다.");
           }
           userScan.close();
       }catch (IOException e){

           System.out.println("연결실패");
           e.printStackTrace();
       }
    }
}
