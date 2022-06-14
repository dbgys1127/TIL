package app;

public class User {
	private String ID;
	private int start, finish,sub,result;
	public User(String ID) {
		this.ID=ID;
	}
	public String getName() {
		return ID;
	}
	public void setStart(int start) {
		this.start=start;
	}
	public void setfinish(int finish) {
		this.finish=finish;
	}
	public int getSub() {
		if(start<finish) {
			sub=finish-start;
			return sub;
		}
		else {
			sub=60+finish-start;
			return sub;
		}
	}
	public int getResult() {
		result=10-sub;
		return Math.abs(result);
	}
}

