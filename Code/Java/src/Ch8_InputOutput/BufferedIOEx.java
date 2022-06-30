package Ch8_InputOutput;
import java.io.*;
import java.util.Scanner;
public class BufferedIOEx {
    public static void main(String[]args){
        FileReader fin = null;
        int c;
        try{
            fin=new FileReader("C:\\Users\\kim\\Desktop\\TIL\\Code\\Java\\src\\Ch8_InputOutput\\BufferOut.txt");
            BufferedOutputStream out = new BufferedOutputStream(System.out,5);
            while((c=fin.read())!=-1){
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
