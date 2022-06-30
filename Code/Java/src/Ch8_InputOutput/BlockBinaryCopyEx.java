package Ch8_InputOutput;
import java.io.*;

public class BlockBinaryCopyEx {
    public static void main(String[]args){
        File src = new File("c:\\Windows\\Web\\Wallpaper\\Theme1\\img1.jpg");
        File dest = new File("C:\\Users\\kim\\Desktop\\TIL\\Code\\Java\\src\\Ch8_InputOutput\\Bfcopyimg.jpg");
        try{
            FileInputStream fi = new FileInputStream(src);
            FileOutputStream fo = new FileOutputStream(dest);
            byte [] buf = new byte[1024*10];
            while(true){
                int n = fi.read(buf);//buf=fi.read();
                fo.write(buf,0,n);
                if(n<buf.length) break;
            }
            fi.close();
            fo.close();
            System.out.println(src.getPath()+"를 "+dest.getPath()+"로 복사하였습니다.");
        }catch (IOException e){
            System.out.println("파일 복사 오류");
        }
    }
}
