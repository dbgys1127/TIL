package Ch8_InputOutput;
import java.io.*;
import java.util.Scanner;
public class ExBufferedIO {
    public static void main(String[]args){
        FileReader fin=null;
        int c;
        try{
            fin=new FileReader("c:\\windows\\system.ini");
            BufferedOutputStream out = new BufferedOutputStream(System.out,2048);
            while((c= fin.read())!=-1){
                out.write(c);
            }
            new Scanner(System.in).nextLine();
            out.flush();
            fin.close();
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
