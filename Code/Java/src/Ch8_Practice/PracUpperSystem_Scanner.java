package Ch8_Practice;
import java.io.*;
import java.util.Scanner;

public class PracUpperSystem_Scanner {
    public static void main(String[]args){
        File file = new File("c:\\windows\\system.ini");
        Scanner Scan;
        FileWriter fout;
        try{
            Scan=new Scanner(new FileReader(file));
            fout = new FileWriter("C:\\Users\\kim\\Desktop\\TIL\\Code\\Java\\src\\Ch8_Practice\\Files\\PracUpperSystem_Scanner.txt");
            while(Scan.hasNext()){
                String line = Scan.nextLine();
                line=line.toUpperCase();
                fout.write(line+"\r\n");
                System.out.print(line);
                System.out.println();
            }
            System.out.println("PracUpperSystem_Scanner.txt에 저장했습니다.");
            fout.close();
            Scan.close();
        }catch (IOException e){
            System.out.println("연결 실패");
            e.printStackTrace();
        }
    }
}
