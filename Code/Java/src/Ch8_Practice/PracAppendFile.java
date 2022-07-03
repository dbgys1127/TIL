package Ch8_Practice;
import java.util.Scanner;
import java.io.*;
//1. 붙혀넣을 파일 이름을 두개 입력 받는다.
//2. appended.txt 파일을 FileOutputStream NewFout을 생성해서 연결한다.
//3. 첫번째 입력 받은 파일 내용을 배열 a에 저장해둔다.
//4. 두번째 입력 받은 파일 내용을 배열 b에 저장해둔다.
//5. a를 먼저 NewFout.write(a[i]) 한후 b를 똑같이 한다.
public class PracAppendFile {
    public static void main(String[]args){
        Scanner Scan = new Scanner(System.in);
        FileInputStream srcStream=null;
        FileInputStream destStream=null;
        FileOutputStream newFout;
        byte srcBuf[] = new byte[1024];
        byte destBuf[] = new byte[1024];
        int srcOut=0, destOut=0;
        System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");

        System.out.print("첫번째 파일 이름 >> ");
        String src=Scan.nextLine();

        System.out.print("두번째 파일 이름 >> ");
        String dest=Scan.nextLine();

        System.out.println(src+" vs "+dest+" 비교 시작!!!");
        try{
            newFout=new FileOutputStream("C:\\Users\\kim\\Desktop\\TIL\\Code\\Java\\src\\Ch8_Practice\\Files\\appended.txt");
            srcStream = new FileInputStream(src);
            destStream = new FileInputStream(dest);
            srcOut=srcStream.read(srcBuf,0,srcBuf.length);
            destOut=destStream.read(destBuf,0,destBuf.length);
            for(int i=0;i<srcOut;i++) newFout.write(srcBuf[i]);
            for(int i=0;i<destOut;i++) newFout.write(destBuf[i]);
            System.out.println("프로젝트 폴더 밑에 appended.txt 파일에 저장하였습니다.");
        }catch (IOException e){
            System.out.println("연결실패");
            e.printStackTrace();
        }
    }
}
