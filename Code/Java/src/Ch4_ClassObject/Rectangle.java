package Ch4_ClassObject;
import java.util.Scanner;

public class Rectangle {
	int width;
	int height;
	public int getArea() {
		return width*height;
	}
	
	public static void main(String[]args) {
		Scanner ScanValue=new Scanner(System.in);
		System.out.print("사각형의 가로 세로를 입력하시오. >> ");
		Rectangle TotalArea;
		TotalArea=new Rectangle();
		
		TotalArea.width=ScanValue.nextInt();
		TotalArea.height=ScanValue.nextInt();
		
		int result=TotalArea.getArea();
		
		System.out.print("사각형 넓이 >> "+result);
		ScanValue.close();
	}
}
