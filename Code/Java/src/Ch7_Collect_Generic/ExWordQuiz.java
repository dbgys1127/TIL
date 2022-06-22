package Ch7_Collect_Generic;
import java.util.*;

public class ExWordQuiz {
    private Scanner Scan = new Scanner(System.in);
    private HashMap<String,String> WordHash = new HashMap<>();
    private String [] QuestionArray = {"-1","-1","-1","-1"};
    private int AnswerIndex;
    public ExWordQuiz(){
        WordHash.put("love","사랑");
        WordHash.put("animal","동물");
        WordHash.put("stock","주식");
        WordHash.put("clock","시계");
        WordHash.put("pencil","연필");
        WordHash.put("father","아빠");
        WordHash.put("mother","엄마");
        WordHash.put("book","책");
        WordHash.put("baby","아기");
        WordHash.put("life","인생");
        WordHash.put("eye","눈");
        WordHash.put("car","자동차");
        WordHash.put("ship","배");
        WordHash.put("house","집");
        WordHash.put("mirror","거울");
        WordHash.put("rain","비");
        WordHash.put("sun","태양");
    }
    public int getAnswerIndex(){
        AnswerIndex=(int)(Math.random()*4);
        return AnswerIndex;
    }
    public String getEnglish(){
        ArrayList<String> Keys =new ArrayList<>();
        Set<String> Key = WordHash.keySet();
        Iterator<String> it = Key.iterator();
        for(int i=0;i<WordHash.size();i++){
            Keys.add(it.next());
        }
        Collections.shuffle(Keys);
        return Keys.get(0);
    }
    public String getKorean(String English){
        return WordHash.get(English);
    }
    public boolean Exist(String IncorrectAnswer){
        for(int i=0;i< QuestionArray.length;i++){
            if(QuestionArray[i].equals(IncorrectAnswer)) {
                //System.out.println("-");
                return true;
            }//QuestionArray[i]=IncorrectAnswer;
        }
        return false;
    }
    public void run(){
        System.out.println("*** 영어 단어 테스트 프로그램 입니다. ***");
        while(true){
            System.out.print("단어 테스트 : 1, 단어 추가 : 2, 종료 : 3 >> ");
            try {
                int select = Scan.nextInt();
                if (select == 3) {
                    System.out.println("종료합니다.");
                    break;
                }
                switch (select) {
                    case 1:
                        Quiz();
                        break;
                    case 2:
                        Insert();
                        break;
                }
            }catch (InputMismatchException e){
                Scan.next();
                System.out.println("숫자만 입력하시오.");
            }
        }
    }
    public void Insert(){
        System.out.println("그만을 입력하면 입력이 종료됩니다.");
        while(true){
            System.out.print("영어 한글 입력 >> ");
            String English = Scan.next();
            if(English.equals("그만")) break;
            String Korean = Scan.next();
            WordHash.put(English,Korean);
        }
    }
    public void Quiz(){
        System.out.println("현재 "+WordHash.size()+"개 단어가 있습니다.(종료 버튼 : -1)");
        while(true) {
            String Question = getEnglish();
            String Answer = getKorean(Question);
            System.out.println(Question + "???");
            int n = getAnswerIndex();
            QuestionArray[n] = Answer;
            for (int i = 0; i < QuestionArray.length; i++) {
                String IncorrectAnswer = getKorean(getEnglish());
                if (Exist(IncorrectAnswer)) {
                    //System.out.println(IncorrectAnswer);
                    i--;
                }else {
                    QuestionArray[i] = IncorrectAnswer;
                }
                 if (i==n){
                    QuestionArray[i]=Answer;
                 }
            }
            for(int i=0;i<QuestionArray.length;i++){
                System.out.print("("+(i+1)+")"+QuestionArray[i]+" ");
            }
            System.out.print(":>> ");
            try {
                int select = Scan.nextInt();
                if (select == -1) break;
                String UserAnswer = QuestionArray[select-1];
                if(UserAnswer.equals(Answer)) System.out.println("정답입니다.");
                else System.out.println("오답입니다.");
            }catch (InputMismatchException e){
                Scan.next();
                System.out.println("숫자만 입력하시오.");
            }
        }
    }

    public static void main(String[]args){
        ExWordQuiz Game = new ExWordQuiz();
        Game.run();
    }

}
