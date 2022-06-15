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
		v.add(new OPWord("love","���"));
		v.add(new OPWord("animal","����"));
		v.add(new OPWord("stock","�ֽ�"));
		v.add(new OPWord("clock","�ð�"));
		v.add(new OPWord("pencil","����"));
		v.add(new OPWord("father","�ƺ�"));
		v.add(new OPWord("mother","����"));
		v.add(new OPWord("book","å"));
		v.add(new OPWord("baby","�Ʊ�"));
		v.add(new OPWord("life","�λ�"));
		v.add(new OPWord("eye","��"));
		v.add(new OPWord("car","�ڵ���"));
		v.add(new OPWord("ship","��"));
		v.add(new OPWord("house","��"));
		v.add(new OPWord("mirror","�ſ�"));
		v.add(new OPWord("rain","��"));
		v.add(new OPWord("sun","�¾�"));
		
		System.out.println("<��ǰ����> �ܾ��׽�Ʈ�� �����մϴ�. '-1' �Է½� ����˴ϴ�.");
		System.out.println("���� "+v.size()+"�� �ܾ �ֽ��ϴ�.");

		
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
			if(User==-1) {System.out.println("�����մϴ�.");break;}
			if(UserAnswer==G.Ifcorrect()) System.out.println("Great!!!");
			else System.out.println("No �̤�");
		}
	}
}
