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
		System.out.print("�簢���� ���� ���θ� �Է��Ͻÿ�. >> ");
		Rectangle TotalArea;
		TotalArea=new Rectangle();
		
		TotalArea.width=ScanValue.nextInt();
		TotalArea.height=ScanValue.nextInt();
		
		int result=TotalArea.getArea();
		
		System.out.print("�簢�� ���� >> "+result);
		ScanValue.close();
	}
}
