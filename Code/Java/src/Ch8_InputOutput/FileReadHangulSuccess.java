package Ch8_InputOutput;
import java.io.*;
public class FileReadHangulSuccess {
    public static void main(String[]args){
        InputStreamReader in = null;
        FileInputStream fin = null;
        try{
            fin=new FileInputStream("C:\\Users\\kim\\Desktop\\TIL\\Code\\Java\\src\\Ch8_InputOutput\\hangul.txt");
            in=new InputStreamReader(fin,"US-ASCII");
            int c;

            System.out.println("인코딩 문자 집합은 "+in.getEncoding());
            while((c=in.read())!=-1){
                System.out.print((char)c);
            }
            in.close();
            fin.close();
        }catch (IOException e){
            System.out.println("입출력 오류");
        }
    }
}
