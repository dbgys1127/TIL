package Ch4_ClassObject;

public class OtherBook {
	String author;
	String title;
	
	void show() {
		System.out.println(title+" "+author);
	}
	
	public OtherBook() {
		this("1","");
		System.out.println("������ ȣ���");
	}
	
	public OtherBook(String title) {
		this(title,"���ڹ̻�");
	}
	
	public OtherBook(String title,String author) {
		this.title=title;
		this.author=author;
	}
	
	public static void main(String[] args) {
		OtherBook littleprince=new OtherBook("�����","�������丮");
		OtherBook lovestory=new OtherBook("������");
		OtherBook emptybook=new OtherBook();
		lovestory.show();
		littleprince.show();
		emptybook.show();
	}
}
