package Ch8_Practice;
import java.io.*;
//1. c:와 연결된 File 객체 생성
//2. c:에 포함된 파일과 디렉토리 리스트 얻어서 File[] 배열에 담기
//3. 배열에 담긴 파일 및 디렉토리의 크기를 presentSize에 담기,
//4. presentSize가 lagestSize 보다 크면, 둘을 바꾸기.
//5. 다 보고 나서 largestSize 출력
public class PracLargestFile {
    public void largestDir(File dir){
        File[] src = dir.listFiles();
        long presentSize=0;
        long largestSize=src[0].length();
        String presentName=null;
        String largestName=src[0].getName();

        for(int i=1;i<src.length;i++){
            presentSize=src[i].length();
            presentName=src[i].getName();
            if(presentSize>largestSize){
                largestSize=presentSize;
                largestName=presentName;
            }
        }
        System.out.println("가장 큰 파일명 > "+largestName+" 파일 크기 > "+largestSize);
    }
    public static void main(String[]args){
        PracLargestFile Game = new PracLargestFile();
        File src = new File("C:\\");
        Game.largestDir(src);
    }
}
