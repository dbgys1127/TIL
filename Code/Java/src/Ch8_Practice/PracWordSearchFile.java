package Ch8_Practice;
import java.io.*;
import java.util.*;

public class PracWordSearchFile {

    private String userInput;
    private String word;
    private Scanner srcScan;
    private Scanner userScan=new Scanner(System.in);
    private Vector<String> v =new Vector<>();

    public boolean LinkFile(){
        try{
            System.out.print("대상 파일명 입력>> ");
            userInput = userScan.next();
            srcScan = new Scanner(new FileInputStream(userInput));
            while(srcScan.hasNext()){
                v.add(srcScan.nextLine());
            }
            srcScan.close();
            return true;
        }catch(IOException e){
            System.out.println("연결실패");
            return false;
        }
    }
    public void findWord(){
        while(true){
            boolean found = false;
            System.out.print("검색할 단어나 문장>> ");
            userInput = userScan.next();
            if(userInput.equals("그만")){
                System.out.println("종료합니다.");
                break;
            }
            for(int i=0;i<v.size();i++){
                word=v.get(i);
                if(word.contains(userInput)){
                    System.out.println(i+1+": "+word);
                    found=true;
                }
            }
            if(!found){
                System.out.println("찾을 수 없습니다.");
            }
        }
        userScan.close();
    }

    public void run(){
        System.out.println("전체 경로명이 아닌 파일 이름만 입력할 경우, 파일은 프로젝트 폴더에 있어야 합니다.");
        if(LinkFile()) findWord();
    }

    public static void main(String[] args) {
        PracWordSearchFile Game = new PracWordSearchFile();
        Game.run();
    }
}
