package Ch3_Array;

import java.util.Scanner;

public class CollegeScore {
	public static void main(String[] args) {
		System.out.println("학점을 입력하세요.");
		Scanner ScanScore = new Scanner(System.in);
		float CollegeScore[][]=new float [4][2];
		float Sum=0, Avg;
		int Multiple=0;
		for(int i=0;i<CollegeScore.length;i++) {
			for(int j=0;j<CollegeScore[i].length;j++) {
				System.out.println(i+1+"학년"+j+1+"학기 성적 : ");
				CollegeScore[i][j]=ScanScore.nextFloat();
				Sum+=CollegeScore[i][j];
				Multiple++;
			}
		}
		Avg=Sum/Multiple;
		System.out.print(Avg);
		ScanScore.close();
	}
}
