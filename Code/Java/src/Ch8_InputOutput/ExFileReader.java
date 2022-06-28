package Ch8_InputOutput;
import java.io.*;

public class ExFileReader{
    public static void main(String[]args){
        FileReader fin = null;
        try{
            int c;
            fin = new FileReader("c:\\windows\\system.ini");
            while((c=fin.read())!=-1){
                System.out.print((char)c);
            }
            fin.close();
        }catch (IOException e){
            System.out.println("입출력 오류");
        }
    }
}
