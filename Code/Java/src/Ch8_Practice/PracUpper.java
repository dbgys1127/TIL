package Ch8_Practice;
import java.io.*;

public class PracUpper {
    public static void main(String[]args){
        FileWriter fout;
        FileReader fin;
        try {
            fin=new FileReader("c:\\windows\\system.ini");
            fout=new FileWriter("C:\\Users\\kim\\Desktop\\TIL\\Code\\Java\\src\\Ch8_Practice\\Files\\PracUpperSystem.txt");
            int c=0;
            while((c=fin.read())!=-1){
                if(c>=97&&c<=122){
                    c=Character.toUpperCase(c);
                }
                fout.write(c);
            }
            System.out.println("PracUpperSystem.txt에 저장되었습니다.");
            fin.close();
            fout.close();
        }catch (IOException e){
            System.out.println("출력 실패");
        }
    }
}
