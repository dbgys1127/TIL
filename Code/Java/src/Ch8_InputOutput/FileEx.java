package Ch8_InputOutput;
import java.io.File;

public class FileEx {

    public static void listDirectory(File dir){
        System.out.println("C:\\Users\\kim\\Desktop\\TIL\\Code\\Java\\src\\Ch8_InputOutput\\java_sampleEx 의 서브 리스트입니다.");
        File[] subfiles=dir.listFiles();
        for(int i=0;i<subfiles.length;i++){
            File f = subfiles[i];
            long t = f.lastModified();
            System.out.print(f.getName()+" ");
            if(f.isDirectory())System.out.print("디렉터리"+"\t");
            else if(f.isFile())System.out.print("파일"+"\t");
            System.out.print("파일 크기: "+f.length()+"\t");
            System.out.printf("수정한 시간: %tb %td %ta %tT\n",t,t,t,t);


        }
    }

    public static void main(String[]args){
        File f1 = new File("c:\\windows\\system.ini");
        System.out.println(f1.getPath()+", "+f1.getParent()+", "+f1.getName());
        if(f1.isFile())System.out.println(f1.getPath()+"은 파일입니다.");
        else if(f1.isDirectory())System.out.println(f1.getPath()+"은 디렉토리입니다.");

        File f2 = new File("C:\\Users\\kim\\Desktop\\TIL\\Code\\Java\\src\\Ch8_InputOutput\\java_sampleEx");
        if(!f2.exists()){
            f2.mkdir();
        }
        listDirectory(new File("C:\\Users\\kim\\Desktop\\TIL\\Code\\Java\\src\\Ch8_InputOutput\\"));
        f2.renameTo(new File("C:\\Users\\kim\\Desktop\\TIL\\Code\\Java\\src\\Ch8_InputOutput\\javasampleEx"));
        listDirectory(new File("C:\\Users\\kim\\Desktop\\TIL\\Code\\Java\\src\\Ch8_InputOutput\\"));
    }
}
