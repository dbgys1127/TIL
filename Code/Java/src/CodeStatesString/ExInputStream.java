package CodeStatesString;
import Ch8_InputOutput.FileInputStreamEx;

import java.io.*;
public class ExInputStream {
    public static void main(String[] args) {
        try{
            FileReader fi = new FileReader("words.txt");
            BufferedReader bufferedInput = new BufferedReader(fi);
            int i =0;
            while((i= bufferedInput.read())!=-1){
                System.out.println((char)i);
            }
            fi.close();
        }catch (IOException e){
            System.out.println("연결실패");
        }
    }
}
