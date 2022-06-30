package Ch8_InputOutput;
import java.io.*;
import java.util.*;

public class FileWriterEx {
    public static void main(String[]args){
        Scanner Scan = new Scanner(System.in);
        FileWriter fout = null;
        int c;
        try{
            fout = new FileWriter("C:\\Users\\kim\\Desktop\\TIL\\Code\\Java\\src\\Ch8_InputOutput\\FileWriter.txt");
            while(true){
                String line = Scan.nextLine();
                if(line.length()==0) break;
                fout.write(line,0,line.length());
                fout.write("\r\n",0,2);
            }
            fout.close();
        }catch (IOException e){
            System.out.println("입출력 오류");
        }
        Scan.close();
    }
}
