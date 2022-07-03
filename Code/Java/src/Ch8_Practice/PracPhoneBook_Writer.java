package Ch8_Practice;
import java.io.*;

public class PracPhoneBook_Writer {
    public static void main(String[]args){
        FileReader fin;
        int c=0;
        try{
            System.out.println("PracPhoneBook_Reader.txt를 출력합니다.");
            fin = new FileReader("C:\\Users\\kim\\Desktop\\TIL\\Code\\Java\\src\\Ch8_Practice\\Files\\PracPhoneBook_Reader.txt");
            while((c=fin.read())!=-1){
                System.out.print((char)c);
            }
            fin.close();
        }catch (IOException e){
            System.out.println("읽기를 실패했습니다.");
            e.printStackTrace();
        }
    }
}
