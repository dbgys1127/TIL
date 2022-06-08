import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AlphabetHistogramApp{
	private int [] alpha=new int[26];
	
	public AlphabetHistogramApp(){
		for(int i=0;i<alpha.length;i++) {
			alpha[i]=0;
		}
	}
	public void run() {
		String s=readString();
		makeHistogram(s);
		drawHistogram();
	}
	public void drawHistogram() {
		for(int i=0;i<alpha.length;i++) {
			System.out.print((char)('A'+i));
			int count =0;
			for(int j=0;j<alpha[i];j++) {
				count++;
			}
			System.out.print(count);
			System.out.println();
		}
	}
	public void makeHistogram(String text) {
		String s=text.toString();
		s=s.toUpperCase();
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			if(c>='A'&&c<='Z') {
				int index=c-'A';
				alpha[index]++;
			}
		}
	}
	public String readString() {
		System.out.println("영문장을 입력하고 세미콜론으로 끝내세요.");
		Scanner Scan=new Scanner(System.in);
		StringBuffer sb=new StringBuffer();
		while(true) {
			String line = Scan.nextLine();
			if(line.length()==1&&line.charAt(0)==';') {
				break;
			}
			sb.append(line);
		}
		Scan.close();
		return sb.toString();
	}
	public static void main(String[]args) {
		AlphabetHistogramApp alphabet = new AlphabetHistogramApp();
		alphabet.run();
	}
}