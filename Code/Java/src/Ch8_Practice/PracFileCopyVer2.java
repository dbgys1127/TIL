package Ch8_Practice;

import java.io.*;

public class PracFileCopyVer2 {
    public static void main(String[] args) {
        BufferedInputStream srcStream = null;
        BufferedOutputStream destStream = null;
        File srcFile = new File("C:\\Users\\kim\\Desktop\\TIL\\Code\\Java\\src\\Ch8_Practice\\Files\\a.jpg");
        File destFile = new File("C:\\Users\\kim\\Desktop\\TIL\\Code\\Java\\src\\Ch8_Practice\\Files\\b.jpg");
        try {
            srcStream = new BufferedInputStream(new FileInputStream(srcFile)); // ���� �Է� ��Ʈ���� ����
            destStream = new BufferedOutputStream(new FileOutputStream(destFile)); // ���� ��� ��Ʈ���� ����

            long tenPercent = srcFile.length()/10;
            long progress = 0;
            byte [] bytes = new byte[1584];
            int numInput=0;
            while(true){
                numInput = srcStream.read(bytes,0,bytes.length);
                if(numInput==-1){
                    if(progress>0){
                        System.out.print("*");
                    }
                    break;
                }
                if(numInput>0){
                    destStream.write(bytes,0,numInput);
                }
                progress+=numInput;
                if(progress>=tenPercent){
                    System.out.print("*");
                    progress=0;
                }
            }
            srcStream.close();
            destStream.close();
        } catch (IOException e) {
            System.out.println("복사실패");
        }
    }
}
