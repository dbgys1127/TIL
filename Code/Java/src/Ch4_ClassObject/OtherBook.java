package Ch4_ClassObject;

public class OtherBook {
	String author;
	String title;
	
	void show() {
		System.out.println(title+" "+author);
	}
	
	public OtherBook() {
		this("1","");
		System.out.println("생성자 호출됨");
	}
	
	public OtherBook(String title) {
		this(title,"작자미상");
	}
	
	public OtherBook(String title,String author) {
		this.title=title;
		this.author=author;
	}
	
	public static void main(String[] args) {
		OtherBook littleprince=new OtherBook("어린왕자","생텍쥐페리");
		OtherBook lovestory=new OtherBook("춘향전");
		OtherBook emptybook=new OtherBook();
		lovestory.show();
		littleprince.show();
		emptybook.show();
	}
}
