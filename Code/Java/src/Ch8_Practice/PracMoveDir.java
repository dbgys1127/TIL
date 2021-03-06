package Ch8_Practice;

import java.io.File;
import java.util.Scanner;

//1. 루트폴더를 c:\로 한다.
//2. File 객체를 c:와 연결한다.
//3. File [] listFiles()로 리스트를 저장한다.
//4. dir인지 file인지 / 파일 크기 / 파일이나, 디렉토리 명
//5. 이동할 디렉토리 입력 받기
//6. 입력받은 디렉토리 listFiles 객체에 재연결하기
public class PracMoveDir {
    private String maindir = "C:\\";
    private File mainDir = new File(maindir);
    private Scanner Scan = new Scanner(System.in);
    File [] storeDir;
    String userInput;

    PracMoveDir(){
        System.out.println("***** 파일 탐색기입니다. *****");
        storeDir=mainDir.listFiles();
        System.out.println("["+mainDir.getPath()+"]");
        String type = "dir";
        String name = null;
        long size =0;
        for(int i=0;i<storeDir.length;i++){//->POINT2
            if(storeDir[i].isFile()){//->POINT3
                type = "file";
            }
            size = storeDir[i].length();//->POINT4
            name = storeDir[i].getName();//->POINT5
            System.out.println(type+" \t"+size+"바이트\t"+name);
        }
    }

    public  void run(){
        while(true) {
            System.out.print(">> ");
            String userInput = Scan.nextLine();//->POINT6
            String[] renameBox = userInput.split(" ");//->//->POINT7

            if (userInput.equals("그만")) {
                System.out.println("종료합니다.");
                break;
            }

            switch (renameBox[0]) {//->POINT7
                case ".."://->POINT10
                    maindir = maindir.replaceAll(mainDir.getName(), "");
                    break;
                case "rename"://->POINT11
                    File f = new File(mainDir.getPath() + "\\" + renameBox[1]);//->POINT12
                    try {
                        f.renameTo(new File(mainDir.getPath() + "\\" + renameBox[2]));//->POINT13
                        break;
                    }catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("바뀔대상과 바뀔이름을 정확히 입력하세요.");//->POINT14
                    }
                case "mkdir":
                    File mkf = new File(mainDir.getPath() + "\\" + renameBox[1]);//->POINT15
                    if (!mkf.exists()) {//->POINT16
                        mkf.mkdir();//->POINT16
                    }
                    break;
                default:
                    maindir += userInput + "\\";//->POINT9
            }
            mainDir = new File(maindir);//->POINT8
            try{//->POINT17
                storeDir = mainDir.listFiles();
                System.out.println("[" + mainDir.getPath() + "]");
                String type = null;
                String name = null;
                long size = 0;
                for (int i = 0; i < storeDir.length; i++) {
                    if (storeDir[i].isDirectory()) {
                        type = "dir";
                    } else {
                        type = "file";
                    }
                    size = storeDir[i].length();
                    name = storeDir[i].getName();
                    System.out.println(type + " \t" + size + "바이트\t" + name);
                 }
             }catch (NullPointerException e){
                System.out.println("검색어를 다시 입력하시오.");
            }//->POINT18
        }
    }
    public static void main(String[] args) {
        PracMoveDir Game = new PracMoveDir();
        Game.run();
    }
}
