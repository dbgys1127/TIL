package Ch4_ClassObject;

public class Book {
	String author;
	String title;
	public Book() {
		author="�������丮";
		title="�����";
	}
	
	public Book(String a,String t) {
		author=a;
		title=t;
	}
	
	public static void main(String[] args) {
		Book littleprince;
		littleprince=new Book();
		
		Book lovestory;
		lovestory=new Book("���ڹ̻�","������");
		System.out.println(littleprince.author+"�� "+littleprince.title);
		System.out.println(lovestory.author+"�� "+lovestory.title);
		
	}
}
