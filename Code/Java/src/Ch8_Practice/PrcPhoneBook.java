package Ch8_Practice;
import java.util.Scanner;
import java.io.*;

//1.전화번호부 안내문
//2.이름과 전화번호를 묻는 문장 출력이 출력됨
//3.이름+공백+전화번호 형태로 기입한다.
//4.'그만'을 기입하면 이름/전화번호 입력이 중단된다.
//5.입력받은 내용을 c:\\temp\\phone.txt 파일에 연결하여 출력한다.

public class PrcPhoneBook {
    public static void main(String[]args){
        Scanner Scan=new Scanner(System.in);
        FileWriter fout;
        try{
            fout=new FileWriter("C:\\Users\\kim\\Desktop\\TIL\\Code\\Java\\src\\Ch8_Practice\\pracPhoneBook");
            System.out.println("전화번호부 입니다.");
            while(true){
                System.out.print("이름 전화번호 >> ");
                String phonebook = Scan.nextLine();
                if(phonebook.equals("그만")) break;
                fout.write(phonebook+"\r\n");

            }
            System.out.println("저장되었습니다.");
            fout.close();
        }catch (IOException e){
            System.out.println("저장되지 않았습니다.");
            e.printStackTrace();
        }
    }
}
