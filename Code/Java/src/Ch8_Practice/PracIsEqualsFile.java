package Ch8_Practice;
import java.util.Scanner;
import java.io.*;

public class PracIsEqualsFile {
    public static boolean compareFile(FileInputStream fin1,FileInputStream fin2) throws IOException{
        byte [] fin1Buf = new byte[1024];
        byte [] fin2Buf = new byte[1024];
        int fin1Cout=0, fin2Cout=0;
        while(true){
            fin1Cout=fin1.read(fin1Buf,0,fin1Buf.length);//파일크기
            fin2Cout=fin2.read(fin2Buf,0,fin2Buf.length);//한글자씩을 fin2Buf에 저장한다.

            if(fin1Cout!=fin2Cout) return false;
            if(fin1Cout==-1) break;//다꺼내면 -1이 된다.
            for(int i =0;i<fin1Cout;i++){
                if(fin1Buf[i]!=fin2Buf[i]) return false;
            };
        }
        return true;
    }
    public static void main(String[]args){
        Scanner Scan = new Scanner(System.in);
        FileInputStream fin1=null;
        FileInputStream fin2=null;

        System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");

        System.out.print("첫번째 파일 이름 >> ");
        String file1=Scan.nextLine();

        System.out.print("두번째 파일 이름 >> ");
        String file2=Scan.nextLine();

        System.out.println(file1+" vs "+file2+" 비교 시작!!!");
        try{
            fin1=new FileInputStream(file1);
            fin2=new FileInputStream(file2);

            if(compareFile(fin1,fin2)) System.out.println("같습니다.");
            else System.out.println("다릅니다.");
            if(fin1 != null) fin1.close();
            if(fin2 !=null) fin2.close();

        }catch (IOException e){
            System.out.println("연결 실패");
        }
        Scan.close();
    }
}

