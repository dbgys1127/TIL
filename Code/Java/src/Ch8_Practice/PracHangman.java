package Ch8_Practice;
import java.io.*;
import java.util.*;
//1. File 객체를 words.txt와 연결한다.
//2. FileReader를 File 객체와 연결한 후 Scanner객체와 연결한다.
//3. Vector<String> 객체를 만든다.
//4. Scanner 객체에 nextLine() 메서드로 단어를 불러와서 Vector 객체에 저장한다.

public class PracHangman {

    private File src;
    private Vector<String> v = new Vector<>();
    private Scanner Scan;
    private String originWord=null;
    private Scanner userInput = new Scanner(System.in);
    private String problem;
    private int firstIndex=-1;
    private int secondIndex=-1;
    private int countAnswer=0;
    private char tmp ='0';
    public PracHangman(){
        try {
            src = new File("hangmanwords.txt");
            Scan = new Scanner(new FileInputStream(src));
            while(Scan.hasNext()){
                v.add(Scan.nextLine());
            }
            Scan.close();
        }catch (IOException e){
            System.out.println("단어 소스 연결 실패");
        }
    }
    public String getProblem(){
        originWord=v.get((int)(Math.random()*25143+1));
        firstIndex =(int)(Math.random()*(originWord.length()));
        while(true){
            secondIndex =(int)(Math.random()*(originWord.length()));
            if(firstIndex==secondIndex){
                continue;
            }
            break;
        }
        StringBuffer problem = new StringBuffer(originWord);
        problem.setCharAt(firstIndex,'-');
        problem.setCharAt(secondIndex,'-');
        String proString=problem.toString();
        return proString;
    }
    public boolean isContain(String userInput){

        if((originWord.toUpperCase().charAt(firstIndex)!=userInput.toUpperCase().charAt(0))&&(originWord.toUpperCase().charAt(secondIndex)!=userInput.toUpperCase().charAt(0))){
            return false;
        }
        if(tmp==userInput.charAt(0)&&originWord.toUpperCase().charAt(firstIndex)!=originWord.toUpperCase().charAt(secondIndex)) {
            return false;
        }
        return true;
    }
    public int getIndexAnwser(String userInput){
        char firstdash = originWord.charAt(firstIndex);
        char seconddash = originWord.charAt(secondIndex);
        if((firstdash==userInput.charAt(0))&&(seconddash==userInput.charAt(0))){
            if(countAnswer==1){
                return secondIndex;
            }else{
                return firstIndex;
            }
        }else if(firstdash==userInput.charAt(0)){
            return firstIndex;
        }else{
            return secondIndex;
        }
    }
    public boolean isFinish(){
        System.out.print("계속하시겠습니까?(y/n)");
        String User = userInput.next();
        if(User.equals("n")){
            System.out.println("종료하겠습니다.");
            return true;
        }else{
            return false;
        }
    }
    public void run(){
        System.out.println("지금부터 행맨 게임을 시작합니다.");

        int count=0;

        while(true) {
            problem =getProblem();
            StringBuffer answer = new StringBuffer(problem);
            System.out.println(originWord);
            System.out.println(problem);
            while(true) {
                System.out.print(">> ");
                String User = userInput.next();
                if (!isContain(User)) {
                    count++;
                    if (count == 5) {
                        System.out.println("5번 틀렸습니다. you lose~");
                        System.out.println("답>> " + originWord);
                        count = 0;
                        countAnswer =0;
                        break;
                    }
                    System.out.println(problem);
                    continue;
                }
                answer.setCharAt(getIndexAnwser(User), User.charAt(0));
                tmp = originWord.charAt(getIndexAnwser(User));
                problem = answer.toString();
                countAnswer++;
                System.out.println(problem);
                if (countAnswer == 2) {
                    countAnswer=0;
                    count=0;
                    break;
                }
            }
            if(isFinish()){
                break;
            }
            continue;
        }
    }

    public static void main(String[] args) {
        PracHangman Game = new PracHangman();
        Game.run();
    }
}
