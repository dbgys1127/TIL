package Ch4_ClassObject;

public class Book {
	String author;
	String title;
	public Book() {
		author="생텍쥐페리";
		title="어린왕자";
	}
	
	public Book(String a,String t) {
		author=a;
		title=t;
	}
	
	public static void main(String[] args) {
		Book littleprince;
		littleprince=new Book();
		
		Book lovestory;
		lovestory=new Book("작자미상","춘향전");
		System.out.println(littleprince.author+"의 "+littleprince.title);
		System.out.println(lovestory.author+"의 "+lovestory.title);
		
	}
}
