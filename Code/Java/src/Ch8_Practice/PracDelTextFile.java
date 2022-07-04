package Ch8_Practice;
import java.io.*;

//1. 내가 삭제할 폴더 경로가 연결된 File 객체를 만든다.
//2. 1번에서 만든 객체에 포함된 파일 리스트를 저장을 listFiles() 메서드로 한다.
//3. 파일리스트가 담긴 배열을 for문에 넣어서 int index=s.lastIndexOf(".txt")가 -1인지 아닌지 조건문에 넣어본다.
//4. -1이 아니면, txt파일 이므로 f.delete해서 지운다.
//5. 이때 지운 개수를 카운트 하기위해, int count가 필요하다.
public class PracDelTextFile {
    public static void main(String[] args) {
        System.out.println("Files1 디렉토리 내 .txt 파일을 모두 삭제합니다.");
        File src = new File("C:\\Users\\kim\\Desktop\\TIL\\Code\\Java\\src\\Ch8_Practice\\Files\\Files1");
        File [] srcList = src.listFiles();
        int count=0;
        for(int i=0;i< srcList.length;i++){
            int index=0;
            String s = srcList[i].getName();
            if((index=s.lastIndexOf(".txt"))!=-1){
                System.out.println(s+" 삭제");
                srcList[i].delete();
                count++;
            }
        }
        System.out.println("총 "+count+"개 삭제");
    }
}
