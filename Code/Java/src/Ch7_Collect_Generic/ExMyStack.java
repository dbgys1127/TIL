package Ch7_Collect_Generic;
class Gstack<T>{
	int tos;
	Object[] stack;
	public Gstack() {
		tos=0;
		stack = new Object[10];
	}
	public void push (T item) {
		if(tos==10) return;
			stack[tos]=item;
			tos++;
	}
	public T pop() {
		if(tos==0) 
			return null;
			tos--;
			return (T)stack[tos];
	}
}



public class ExMyStack {
	public static void main(String[]args) {
		Gstack<String> StringStack = new Gstack<String>();
		
		StringStack.push("seoul");
		StringStack.push("busan");
		StringStack.push("LA");
		
		for(int i=0;i<3;i++) {
			System.out.println(StringStack.pop());
		}
		
		Gstack<Integer> IntegerStack = new Gstack<Integer>();
		
		IntegerStack.push(5);
		IntegerStack.push(3);
		IntegerStack.push(1);
		
		for(int i=0;i<3;i++) {
			System.out.println(IntegerStack.pop());
		}
		
	}
}
