package Ch8_InputOutput;
import java.io.*;

public class FileOutputStreamEx {
    public static void main(String[]args){
        byte b[] = {7,51,3,4,-1,24};

        try{
            FileOutputStream fout = new FileOutputStream("C:\\Users\\kim\\Desktop\\TIL\\Code\\Java\\src\\Ch8_InputOutput\\FileOutputStream.out");
            for(int i=0;i<b.length;i++) fout.write(b[i]);
            fout.close();
        }catch (IOException e){
            System.out.println("저장할 수 없습니다. 경로명을 확인하세요.");
            return;
        }
        System.out.println("저장했습니다. ");
    }
}
