package Ch8_InputOutput;
import java.io.*;

public class BinaryCopyEx {
    public static void main(String[]args){
        File src = new File("c:\\Windows\\Web\\Wallpaper\\Theme1\\img1.jpg");
        File dest = new File("C:\\Users\\kim\\Desktop\\TIL\\Code\\Java\\src\\Ch8_InputOutput\\copyimg.jpg");
        int c;
        try{
            FileInputStream fi = new FileInputStream(src);
            FileOutputStream fo = new FileOutputStream(dest);

            while((c=fi.read())!=-1){
                fo.write((byte)c);
            }
            fi.close();
            fo.close();
            System.out.println(src.getPath()+"를 "+dest.getPath()+"로 복사하였습니다.");
        }catch (IOException e){
            System.out.println("파일 복사 오류");
        }
    }
}
