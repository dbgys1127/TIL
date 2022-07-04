package Ch8_Practice;
import java.io.*;

public class PracFileCopy {
    public static void main(String[] args) {
        File src = new File("C:\\Users\\kim\\Desktop\\TIL\\Code\\Java\\src\\Ch8_Practice\\Files\\a.jpg");
        File dest = new File("C:\\Users\\kim\\Desktop\\TIL\\Code\\Java\\src\\Ch8_Practice\\Files\\b.jpg");

        FileInputStream srcStream;
        FileOutputStream destStream;

        try{
            System.out.println("a를 b에 복사합니다.");
            System.out.println("10%마다 *을 출력합니다.");
            srcStream=new FileInputStream(src);
            destStream=new FileOutputStream(dest);
            int c =0,b=0;
            double divider= src.length()/10;
            while((c=srcStream.read())!=-1){
                destStream.write((byte)c);
                long d = dest.length();
                if(dest.length()%divider==0){
                    System.out.print("*");
                    b++;
                }
            }
            srcStream.close();
            destStream.close();
        }catch (IOException e){
            System.out.println("복사실패");
        }

    }
}
