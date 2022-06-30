package Ch1_JavaStruct;

//클래스를 선언할때, 접근지정자 class 키워드와 클래스 이름을 선언하고 '{ }' 사이에 변수와 메서드 코드를 작성한다. 
public class JavaStruct{
	public static int sum(int n, int m) {
		return n+m;
	}
	//main은 반드시 public, static, void로 선언 되어야 한다.
	//한 클래스에 두개의 main이 있을 수 없고, 여러 클래스일 경우 실행을 시작할 클래스에만 main을 두면 된다.
	//모든 클래스가 main을 가질 필요 없다.
	public static void main(String[] args) {
		int i = 20;
		int s=sum(i,10);
		char a='?';
		System.out.println(s);//println은 자동 줄바꿈이 된다.
		System.out.print(a);//print는 줄바꿈이 안된다.
		System.out.println("hello");
		
	}
}
