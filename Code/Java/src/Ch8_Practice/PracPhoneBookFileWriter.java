package Ch8_Practice;
import java.util.Scanner;
import java.io.*;

public class PracPhoneBookFileWriter {
    public static void main(String[]args){
        Scanner Scan = new Scanner(System.in);
        FileWriter fout;
        try{
            fout = new FileWriter("C:\\Users\\kim\\Desktop\\TIL\\Code\\Java\\src\\Ch8_Practice\\Files\\PracPhoneBook_Reader.txt");
            System.out.println("전화번호 입력 프로그램입니다.");
            while(true){
                System.out.print("이름 전화번호 >>> ");
                String phone = Scan.nextLine();
                if(phone.equals("그만")) break;
                fout.write(phone+"\r\n");
            }
            System.out.println("PracPhoneBook_Reader.txt에 저장하였습니다.");
            fout.close();
        }catch (IOException e){
            System.out.println("저장 실패!!!");
            e.printStackTrace();
        }
        Scan.close();
    }
}