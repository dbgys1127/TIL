package Ch3_Array;
import java.util.Scanner;
public class MatchClass {
	   public static void main(String[] args) {
		   Scanner ScanCourse=new Scanner(System.in);
		   String Course[]= {"Java","C++","HTML5","��ǻ�ͱ���","�ȵ���̵�"};
		   int score[]= {95,88,76,62,55};
		   
		   while(true) {
			   int i=0;
			   System.out.print("�����̸� : ");
			   String InputCourse=ScanCourse.next();
			   if(InputCourse.equals("�׸�")) {
				   break;
			   }
			   for(i=0;i<Course.length;i++) {
				   if(Course[i].equals(InputCourse)) {
					   int n = score[i];
					   System.out.println(Course[i]+"�� ���� : "+score[i]);
					   break;
				   }
			   }
			   if(i==Course.length) {
				   System.out.println("�����ϴ�.");
			   }
		   }
	   }
}
