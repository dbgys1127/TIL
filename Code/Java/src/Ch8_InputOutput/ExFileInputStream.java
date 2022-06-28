package Ch8_InputOutput;
import java.io.*;

public class ExFileInputStream {
    public static void main(String[]args){
        byte [] b = new byte[2];
        try {
            FileInputStream fin = new FileInputStream("C:\\Users\\kim\\Desktop\\TIL\\Code\\Java\\src\\Ch8_InputOutput\\FileOutputStreamTest.dat");
            int n = 0, c;
            while ((c = fin.read()) != -1) {
                b[n]=(byte)c;
                n++;
            }
            System.out.println("배열을 출력하겠습니다.");
            for(int i=0;i<b.length;i++){
                System.out.print(b[i]+" ");
            }
            System.out.println();
            fin.close();
        }catch (IOException e){
            System.out.println("경로명을 확인해주세요.");
        }
    }
}
