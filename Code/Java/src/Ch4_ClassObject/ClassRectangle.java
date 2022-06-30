package Ch4_ClassObject;
import java.util.Scanner;

public class ClassRectangle {
	int width;
	int height;
	public int getArea() {
		return width*height;
	}
	
	public static void main(String[] args) {
		Scanner ScanValue=new Scanner(System.in);
		System.out.print("가로 세로 값을 입력하시오. >> ");
		ClassRectangle Box;
		Box=new ClassRectangle();
		Box.width=ScanValue.nextInt();
		Box.height=ScanValue.nextInt();
		
		
		System.out.println("박스 크기 >> "+Box.getArea());
		ScanValue.close();
	}
}
