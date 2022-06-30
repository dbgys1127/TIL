package Ch7_Collect_Generic;
import java.util.*;

public class OPWoedQuiz {
	static String [] a = new String[4];
	private int exist[]= {-1,-1,-1,-1};
	static Scanner Scan = new Scanner(System.in);
	private int answerIndex, answer, incorrect;
	
	public int getAnswerIndex() {
		answerIndex=(int)(Math.random()*17);
		return answerIndex;
	}
	public int getAnswer() {
		answer=(int)(Math.random()*4);
		return answer;
	}
	//**********************//
	public int getIncorrect() {
		while(true) {
			int tmp;
			tmp=(int)(Math.random()*17);
			if(Exist(tmp)) continue;
			else {
				
				if(tmp==answerIndex) continue;
				else {incorrect=tmp;break;}
			}
		}
		return incorrect;
	}
	public int Ifcorrect() {
		return answer;
	}
	//********//
	public boolean Exist(int a) {
		for(int i=0;i<exist.length;i++) {
			if(exist[i]==a) {
				System.out.println("T");
				return true;
			}else exist[i]=a;
		}

		return false;
	}

	public static void main(String[]args) {
		OPWoedQuiz G=new OPWoedQuiz();
		Vector<OPWord> v = new Vector<OPWord>();
		v.add(new OPWord("love","사랑"));
		v.add(new OPWord("animal","동물"));
		v.add(new OPWord("stock","주식"));
		v.add(new OPWord("clock","시계"));
		v.add(new OPWord("pencil","연필"));
		v.add(new OPWord("father","아빠"));
		v.add(new OPWord("mother","엄마"));
		v.add(new OPWord("book","책"));
		v.add(new OPWord("baby","아기"));
		v.add(new OPWord("life","인생"));
		v.add(new OPWord("eye","눈"));
		v.add(new OPWord("car","자동차"));
		v.add(new OPWord("ship","배"));
		v.add(new OPWord("house","집"));
		v.add(new OPWord("mirror","거울"));
		v.add(new OPWord("rain","비"));
		v.add(new OPWord("sun","태양"));
		
		System.out.println("명품영어 단어 테스트를 시작합니다. -1을 입력하면 종료합니다.");
		System.out.println("현재 "+v.size()+"개의 단어가 들어있습니다");

		
		while(true) {
			OPWord ProblemAnswer = v.get(G.getAnswerIndex());
			System.out.println(ProblemAnswer.getKey()+"???");
			ArrayList<String> list = new ArrayList<>(Arrays.asList(a));
			list.clear();
			a=list.toArray(new String[4]);
			a[G.getAnswer()]=ProblemAnswer.getValue();
			for(int i=0;i<a.length;i++) {
				if(a[i]!=null) continue;
				else {
					OPWord incorrectAnswer = v.get(G.getIncorrect());
					a[i]=incorrectAnswer.getValue();
				}
			}
			for(int i=0;i<a.length;i++) {
				System.out.print(i+1+")"+a[i]+" ");
			}
			System.out.print(" :>>>");
			int User = Scan.nextInt();
			int UserAnswer=User-1;
			if(User==-1) {System.out.println("종료합니다..");break;}
			if(UserAnswer==G.Ifcorrect()) System.out.println("Great!!!");
			else System.out.println("No !!");
		}
	}
}
