package Ch8_Practice;
import java.util.Scanner;
import java.io.*;

public class PracPhoneBook_WriterStr {
    public static void main(String[]args){
        Scanner Scan = new Scanner(System.in);
        FileWriter fout;
        try{
            System.out.println("전화번호부 입니다.");
            fout=new FileWriter("C:\\Users\\kim\\Desktop\\TIL\\Code\\Java\\src\\Ch8_Practice\\Files\\PracPhoBook.txt");
            while(true){
                System.out.print("이름 전화번호 >> ");
                String phone = Scan.nextLine();
                if(phone.equals("그만")) break;
                fout.write(phone+"\r\n");
            }
            fout.close();
        }catch (IOException e){
            System.out.println("연결실패");
        }
        Scan.close();
    }
}
