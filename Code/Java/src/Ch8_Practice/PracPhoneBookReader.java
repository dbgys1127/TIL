package Ch8_Practice;
import java.util.Scanner;
import java.io.*;
public class PracPhoneBookReader {
    public static void main(String[]args){
        byte b[] =new byte[1024];
        try{
            FileInputStream fin = new FileInputStream("C:\\Users\\kim\\Desktop\\TIL\\Code\\Java\\src\\Ch8_Practice\\Files\\pracPhoneBook.txt");
            int n =0, c;
            while((c=fin.read())!=-1){
                b[n]=(byte)c;
                n++;
            }
            for(int i=0;i<b.length;i++){
                System.out.print((char)b[i]);
            }
            fin.close();
        }catch(IOException e){
            System.out.println("읽지 못했습니다.");
            e.printStackTrace();
        }
    }
}
