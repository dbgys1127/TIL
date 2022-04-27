package Ch3_Array;
import java.util.Scanner;
public class MatchClass {
	   public static void main(String[] args) {
		   Scanner ScanCourse=new Scanner(System.in);
		   String Course[]= {"Java","C++","HTML5","컴퓨터구조","안드로이드"};
		   int score[]= {95,88,76,62,55};
		   
		   while(true) {
			   int i=0;
			   System.out.print("과목이름 : ");
			   String InputCourse=ScanCourse.next();
			   if(InputCourse.equals("그만")) {
				   break;
			   }
			   for(i=0;i<Course.length;i++) {
				   if(Course[i].equals(InputCourse)) {
					   int n = score[i];
					   System.out.println(Course[i]+"의 점수 : "+score[i]);
					   break;
				   }
			   }
			   if(i==Course.length) {
				   System.out.println("없습니다.");
			   }
		   }
	   }
}
