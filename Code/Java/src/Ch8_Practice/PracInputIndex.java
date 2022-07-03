package Ch8_Practice;
import java.io.*;
import java.util.Scanner;

public class PracInputIndex {
    public static void main(String[]args){
        File file = new File("c:\\windows\\system.ini");
        FileWriter fout;
        int c=1;
        try{
            Scanner Scan = new Scanner(new FileReader(file));
            fout = new FileWriter("C:\\Users\\kim\\Desktop\\TIL\\Code\\Java\\src\\Ch8_Practice\\Files\\PracInputIndex.txt");
            while (Scan.hasNext()){
                String line = Scan.nextLine();
                fout.write("   "+c+" : "+line+"\r\n");
                System.out.print("    "+c+" : ");
                System.out.print(line);
                System.out.println();
                c++;
            }
            fout.close();
            System.out.println("PracInputIndex.txt에 출력 성공했습니다.");
            Scan.close();
        }catch (IOException e){
            System.out.println("출력에 실패했습니다.");
            e.printStackTrace();
        }
    }
}
