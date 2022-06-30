package Ch8_InputOutput;
import java.io.*;

public class ExFileOutputStream {
    public static void main(String[]args){
        byte [] b = {3,5};
        try {
            FileOutputStream fout = new FileOutputStream("C:\\Users\\kim\\Desktop\\TIL\\Code\\Java\\src\\Ch8_InputOutput\\FileOutputStreamTest.dat");
            for(int i=0;i<b.length;i++) fout.write(b[i]);
            fout.close();
        }catch(IOException e){
            System.out.println("저장경로를 확인하세요.");
            return;
        }
        System.out.println("저장했습니다.");
    }
}
